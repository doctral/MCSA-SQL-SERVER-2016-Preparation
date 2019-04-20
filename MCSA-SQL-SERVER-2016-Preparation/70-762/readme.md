# 70-762

## Database creation
1. There are a number of options involved in creating a database, the four basic options are:
    1. Data file locations: every database has at least two files
        1. The primary file stores data
        2. The transaction log stores data modifications
        3. Place the transaction log files on a separat physical disk, if possible
    2. Database size
    3. Filegrowth:
        1. Auto-grouwth can create operational issues
    4. Filegroups
        1. Every database has a primary filegroup
        2. Secondary data files can be placed in these filegroups
2. Data integrity is a major concern when creating and managing database tables
3. Tables in different schemas can have the same name the the same database
    1. Database objects are owned by schemas
    2. Permissions can be set at the schema level
    3. Objects can be easily moved from one schema to another
4. ALTER TABLE: SSMS creates a new table, inserts the data from the original table, then drops the old table and renames the new table to match the old table
5. In SQL Server, we can address data integrity at three levels:
    1. Domain integrity: refers to the values in each column, including data types, and constraints
    2. Entity integrity: requires that all rows in the table be unique by using primary key and unique constraints
    3. Referential integrity: maintains relationships between tables by using foreign keys on one table related to the primary key or unique key of another table
6. Constraints: primary key, unique, foreign key, check, default
    1. Unique keys can also reference unique constraints

## Database Design
1. Filegroups: provide the ability to manage data files more efficiently
    1. Align specific database objects with specific data files
    2. Every database has one filegroup by default, **primary filegroup**, which contains the data files and any database object that is created and not placed in a specified filegroup.
    3. Using multiple filegroups: reduce disk contention by placing certain files or objects on separate physical disks
    4. Each database can have a maximum of 32767 filegroups
    5. Using disk technologies like SAN or RAID diminishes the need for filegroups
2. Table Partitions: divide tables horizontally into sections by rows
    1. Using the partition column or key column
    2. Queries that contains a WHERE clause based on the partition columns can access only the relevant partition.
        1. It ignores the other partitions, called partition elimination
        2. It greatly improves query performance
    3. Maintenance operations can target specific partitions
        1. Compress data in one or more partitions
        2. Rebuild one or more partitions of an index
3. Temporal Tables in SQL 2016: system-versioned temporal table, and it keeps a full hostory of data changes
    1. Audit all data changes
    2. Perform data forensics
    3. Calculate trends over time
    4. Maintain a slowly changing dimension
    5. Recover from accidental data changes or application errors.
4. In-Memory Tables: for improved performance in OLTP environments, and fast, inexpensive memory
    1. Using keyword **MEMORY_OPTIMIZED** on the CREATE TABLE statement
    2. A memory-optimized table has representation of itself in active memory, and secondary copy on the disk
    3. Must estimate and provide adequate available memory capacity
    4. Steps to create a memory-optimized table:
        1. Create an optimized filegroup by including CONTAINS MEMORY_OPTIMIZED_DATA during the creation of the filegroup
            1. Only one memory-optimized filegroup per database
        2. Create a memory-optimized table that include the **WITH (MEMORY_OPTIMIZED=ON)** clause in the CREATE TABLE statement
        3. Create natively compiled stored procedures
        4. Use the natively compiled stored procs to populate the table and modify the data

## Index: Clustered and Nonclustered
### Clustered Index
1. A clustered index causes the rows in a table to be **physically** stored in a certain order, based on the columns that make up the clustered index
2. A table that does not have a clustered index is called a **heap**, and the data is not stored in any particular order
3. There can be only one clustered index on a table, and most table should have a clustered index
4. A clustered index works great on these columns:
    1. Columns that are often accessed sequentially
    2. Columns that contain a lot of distinct values
    3. Columns that are queries based on ranges of values
    4. Columns that are frequently used to join or group result sets
5. The maximum key size for a clustered index is 900 bytes

### Nonclustered Index
1. A separate index structure that is independent of the actual storage order of the data rows
2. Nonclustered indexes can slow down data modifications
    1. The indexed information is created in an index structure in the order of the index
    2. Pointers are used to locate the actual data row so other data column info can be retrieved
3. Nonclustered indexes work well:
    1. for queries that do not return large result sets
    2. columns that are frequently used in the WHERE clause
    3. Columns that have many distinct values
4. Covered Index: a composite nonclustered index that include all columns being retrieved in a critical query, so that the index doesn't have to follow the pointers back to the actual data rows to retrieve data, and it can return the result set directly from the index
5. Columnstore indexes: group and store data for required columns, and it joins the required columns to form the index
    1. Very efficient because most columns have similar values in each row
    2. Query performance is improved due to the smaller in-memory foorprint
    3. Excellent for data warehouse fact tables and large dimension tables, also called real-time operational analytics

### Index Management
1. SQL Server database engine performs automatic maintenance when inserts, updates, or deletes occur
2. Manual Intervention:
    1. repairing index fragmentation is accomplished by periodically reorganizing or rebuilding the indexes
    2. The need to reorganize or rebuild is based on the amount of fragmentation that exists
3. Detecting fragmentation: using system function **sys.dm_dm_index_physical_stats** returns size and fragmentation information for tables and views
    1. less than 10%: no defragmentation is required
    2. 10%-30%: the index should be reorganized 
    3. above 30%: the index should be rebuilt
4. Rebuilding and reorganizing index: using T-SQL or SSMS UI

## View: a virtual table that as the result set of a query
1. Main benifits:
    1. Controlling access to data: permissions do not have to be granted to the underlying table, only to the view
    2. Simplifying data structure
    3. Focusing on specific data
    4. Data abstraction: a view can be updated to present data in a consistent, familiar structure, even though underlying tables may change
2. Updateable Views: data modifications can be performed to a view under specific conditions
    1. Data modifications must only reference columns from a single base table
    2. Columns being modified cannot be the result of an aggregate function
    3. INSTEAD OF triggers can be created on a view and used to perform data modifications and avoid the limitations of updateable views
3. Indexed Views: Indexes can be created on views and provide certain benefits

## Transaction
1. Help ensure data integrity
2. ACID: Atomicity, Consistency, Isolation, and Durability
3. Implicity transaction: all individual statement are treated as transactions, and SQL Server automatically commits the transaction as soon as the statement successfully completes.
    1. **Implicit transactions** setting is off by default
    2. If the option is **on**, all transactions must be manually committed or rolled back, and uncommitted transactions are removed from the transaction log when the SQL Server is restarted
4. Explicity Transactions: the start and end of the transaction are explicitly defined in the T-SQL code
5. Every SQL Server database has Transaction log, all data modifications are written to the transaction log as part of a transaction.
6. Savepoints: provide the ability to control the scope of a transaction rollback
    1. Savepoints are useful in situations where errors are unlikely to occur
    2. Updates and rollbacks are expensive operations
    3. A savepoints is created using the **SAVE TRANSACTION** statement, and with **ROLLBACK TRANSACTION <savepoint>**, it rolls the transaction back to the savepoint, instead of rolling back to the start of the transaction.

## Stored Procedures
1. Benefits:
    1. Reduced network traffic
    2. Compiled once and executed the same later
    3. Stronger security: must have permission to exec a proc
    4. Improved performance
2. Table-valued parameters in Stored Procedures
3. Return Status: whenever a stored procedure is executed, SQL Server automatically generated a status code, 0 indicates success, and other code indicates a system error
4. Natively compiled stored procedures: compiled at creation, can be executed directly by CPU.

## Triggers: a special kind of stored procedure
1. Triggers can operate cross-database
    1. Can reference objects outside the current database
2. Instead of triggers
3. After triggers

## Functions
1. Scalar Functions
2. Table-valued functions