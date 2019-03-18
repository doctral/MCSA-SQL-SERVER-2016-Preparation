SELECT * FROM Person.Person

SELECT FirstName, LastName FROM Person.Person WHERE LastName = 'Adams' AND FirstName = 'Alex'

-- COLUMN Aliasing 
SELECT FirstName AS [FIRST NAME], LastName AS [LAST NAME] FROM Person.Person WHERE LastName = 'Adams' AND FirstName = 'Alex'

SELECT FirstName 'FIRST NAME', LastName 'LAST NAME' FROM Person.Person WHERE LastName = 'Adams' AND FirstName = 'Alex'

SELECT FirstName [FIRST NAME], LastName [LAST NAME] FROM Person.Person WHERE LastName = 'Adams' AND FirstName = 'Alex'

-- Using Distinct
SELECT DISTINCT FirstName, LastName FROM Person.Person

-- Ordering results
SELECT FirstName, LastName FROM Person.Person ORDER BY LastName DESC, FirstName ASC

-- Concatenation
SELECT FirstName + ' ' + LastName [FULL NAME] FROM Person.Person ORDER BY LastName DESC, FirstName ASC

SELECT CONCAT(FirstName, ' ', LastName, ' ', CONVERT(VARCHAR(5), EmailPromotion) ) FROM Person.Person

-- LIKE & IN
SELECT  LastName + ' ' + FirstName [Full Name] FROM Person.Person WHERE LastName LIKE 'A%'

SELECT  LastName + ' ' + FirstName [Full Name] FROM Person.Person WHERE LastName LIKE '[abc]%'

SELECT  LastName + ' ' + FirstName [Full Name] FROM Person.Person WHERE LastName IN ('Adams', 'Jones') AND FirstName LIKE '[abc]%[cde]'

-- UNION

--INTERSECT AND EXCEPT
SELECT ProductID FROM Production.Product
	INTERSECT SELECT ProductID FROM Production.WorkOrder

SELECT ProductID FROM Production.Product
	EXCEPT SELECT ProductID FROM Production.WorkOrder

-- FETCH and OFFSET
-- skip the first 30 rows and return the next 15 rows
SELECT ProductID, Name, ProductNumber, ListPrice FROM Production.Product
	ORDER BY NAME ASC
	OFFSET 30 ROWS 
	FETCH NEXT 15 ROWS ONLY

-- CASE EXPRESSION
SELECT ProductID, Name, 
	CASE DaysToManufacture
		WHEN '0' THEN 'Immediate'
		WHEN '1' THEN 'Two Business days'
		WHEN '2' THEN 'Three Business days'
		ELSE 'Verified holidays'
	END 
	AS Availability
	FROM Production.Product

SELECT ProductID, Name, 
	CASE
		WHEN DaysToManufacture = '0' THEN 'Immediate'
		WHEN DaysToManufacture = '1' THEN 'Two Business days'
		WHEN DaysToManufacture = '2' THEN 'Three Business days'
		ELSE 'Verified holidays'
	END 
	AS Availability
	FROM Production.Product