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
