# MCSA-SQL-SERVER-2016-Preparation

## Three levels
1. MTA (Microsoft Technology Associate): Basic Information Technology
2. MCSA (Microsoft Certified Solutions Associate): Professional level, intermediate skillset
3. MCSE (Microsoft Certified Solutions Expert): The globally recognized standard for IT Professionals

## MCSA: SQL 2016 Database Development
1. Validate your skills in building and implementing database across organizations
    1. Querying Data with T-SQL (70-761)
    2. Developing SQL Database (70-762)

## MCSA: SQL 2016 Database Administration
1. Validate your skills with database installation, maintenance, configuration, and provisioning tasks.
    1. Administering a SQL Database Infrastructure (70-764)
    2. Provisioning SQL Database (70-765)

## MCSA: SQL 2016 Business Intelligence Development
1. Validate your extract, transform, and load (ETL) and data warehouse skills and implementing business intelligence solutions
    1. Implementing a SQL Data Warehouse (70-767)
    2. Developing SQL Data Models (70-768)

## Database Structure and Purpose
1. OLTP: Online Transaction Processing
    1. Database structure makes data inserts, updates, and deletes very efficient
    2. Reading from database becomes less efficient over time
2. OLAP: Online Analytical Processing, i.e: Data Warehouse
    1. Database structure makes reading data from database very efficient
    2. Data inserts are not efficient
3. Most Databases begin as OLTP
    1. Created to collect, manage, and provide access to data
    2. Effiencies slowly change as the database grows
        1. Indexes make using the select query to retrieve data more efficient
        2. Indexes make insert, update, and delete queries less efficient
        3. Especially data-reporting and aggregation
    3. Database administrators and designers have a challenge
        1. Balance the number of indexes with the usefulness of the indexes to keep the data useful for both query types
        2. At some point, this becomes impossible
        3. The solution is to maintain a copy of the data in a different database structure that makes retrieving data efficient
            1. The OLAP is born
4. Statement Types:
    1. DDL: Data definition language
        1. Statement that are used to create and modify the database, tables, and other objects
        2. Including: Create, Alter, Drop, Trancate, etc
    2. DML: Data Manipulation language
        1. Select, Insert, Update, and Delete

## Select Statements
1. The SELECT statement consists of six main parts: SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY
2. Multi-part naming:
    1. SQL Server data is organized in hierarchical containers
        1. Server: can contain multiple instances and databases in each server
        2. Database: can contain multiple objects
        3. Schemas: container for objects
        4. Objects (tables, stored procedures, etc.)
    2. We can point to a specific object in T-SQL using dotted notation:
        '''
            SELECT * FROM <server>.<database>.<schema>.<object>
        '''
3. LIKE and IN wildcards:
    1. %: any string of zero or more characters
    2. _: any single character
    3. []: any single character within the specified range
    4. [\^]: any single character not within the specified range
4. INTERSECT and EXCEPT:
    1. INTERSECT: returns distinct rows for values that are found in both left query and right query
    2. EXCEPT: returns distinct rows for values that are found in left query but not found in right query
5. Paging Results
    1. The size of query's result set can be hundreds, or even more, and navigating through this data can become a chanllenge, and the ability to move through the results set a few rows at a time is helpful
    2. T-SQL provides two functionalities to provide paging: **OFFSET**, and **FETCH**
        1. FETCH: Limits the number of rows that are returned from the result set
        2. OFFSET: Sets the number of rows to skip before returning the number of rows set using FETCH
        3. The **ORDER BY** clause is required when using FETCH and OFFSET
## Table Relationships
1. Normalization is the term that is used to describe the process of separating data into multiple, related tables.
    1. Makes concurrent connections more efficient
    2. Makes table management more efficient
    3. Makes data storage more efficient
2. Primary key and foreign key
3. Join: inner join, outer join, cross join
    1. inner join, the default type
    2. outer join: left join, right join, full join
    3. cross join: each row from the left table is combined with all rows from the right table
4. Table aliasing: usually 4 letters or less

## Built-in functions: MAX, MIN, AVE, SUM, etc
1. T-SQL provides two main tools for data aggregation 
    1. Functions: built-in and user defined
    2. GROUP BY: performs aggregations at the row level in a result set
2. GROUPING SETS: defines multiple grouping sets in the same query.
3. Grouping function indicates a specified column in a GROUP BY clause is aggregated or not, it returns 1 for aggregation or 0 for not aggregated in the result set.

## Graphical Query Tool: can be used to build query and visualize query structure

## Modifying Data:
1. INSERT
2. INSERT SELECT statement: data values retrieved by the SELECT statement must match the column list of the INSERT statement
3. SELECT INTO: creates a new table in the default filegroup and inserts the resulting rows from the query into the new table
    1. Create a new table 
    2. Indexes, constraints, and triggers defined in the source table are not transferred to the new table
4. Update: is processed as a DELETE, INSERT by SQL Server, all columns in the row are affected by the UPDATE statement
5. Delete and Truncate

## Programming objects in T-SQL
1. Stored procedure: input, output
    1. Reduced network traffic
    2. High performance
    3. Strong security: must have permission
    4. Easier maintenance 
2. Variable table
3. CTE
4. User defined functions:
    1. Scalar functions are often executed once for every row in a result set
    2. Table-valued function: returns a table as a result set, and the returned table can be referenced in the FROM clause of a T-SQL statement, while a stored procedure cannot be referenced in the FROM statement
5. Dynamic Data Masking: 
    1. Protects data during presentation as part of a T-SQL result set
    2. Does not require resources to perform encryption/decryption
    3. is applied at the column level when the table is created
        1. Users with SELECT permissions on a table will see masked data, and granting the UNMASK permission to a user allows them to see the data unmasked
        2. Can be defined using four rule types: default, email, random, custom
            1. Default: all data is automatically masked based on the data type of the field
            2. Email: Exposes the first letter of an email address and the constant suffix ".com": aXXX@XXX.com
            3. Random: used on any numeric type to apply masking within a specified range
            4. Custom: exposes the first and last letters and adds a custom masking in the middle 

## Subqueries (Outer query (main), inner query (sub) )
1. Scalar subquery
2. Multi-valued subquery
3. Table-valued subquery
4. Non-correlated subqueries executed the subquery once and the resulting values are used by the WHERE clause of the outer query
5. Correlated subqueries: the subquery depends on the outer query for its values
    1. is a repeating subquery
    2. is executed repeatedly, once for each row that might be selected by the outer query