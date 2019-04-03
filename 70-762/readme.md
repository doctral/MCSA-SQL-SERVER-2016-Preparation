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