--Dynamic Data Masking
ALTER TABLE Person.EmailAddress
	ALTER COLUMN EmailAddress ADD MASKED WITH (FUNCTION = 'email()')

CREATE USER Alice WITHOUT LOGIN;
GRANT SELECT ON Person.EmailAddress TO Alice  

EXECUTE AS USER='Alice'

SELECT * FROM Person.EmailAddress

REVERT