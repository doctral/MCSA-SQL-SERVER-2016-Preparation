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
