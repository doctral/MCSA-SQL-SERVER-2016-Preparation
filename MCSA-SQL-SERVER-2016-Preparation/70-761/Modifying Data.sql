-- cross join
SELECT P.Name, pr.ProductReviewID FROM Production.Product AS P
	CROSS JOIN Production.ProductReview as pr

--BUILD-IN functions
SELECT ProductID, sum(UnitPrice) [sum] FROM Sales.SalesOrderDetail 
	group by ProductID order by sum

SELECT ProductID, sum(LineTotal) [sum] FROM Sales.SalesOrderDetail
	where LineTotal > 2000
	GROUP BY ProductID
	HAVING SUM(LineTotal) > 20000
	order by sum 

select ProductID, sum(LineTotal) as Total from Sales.SalesOrderDetail as sod
	GROUP BY
		GROUPING SETS ((ProductID),
						(CarrierTrackingNumber),
						()
						)
		ORDER BY ProductID

---- INSERT SELECT
CREATE TABLE InsertSelectExample(
	ID INT IDENTITY PRIMARY KEY,
	FirstName VARCHAR(25) NOT NULL,
	LastName VARCHAR(25) NOT NULL,
	EmailAddress VARCHAR(50)
)

INSERT INTO InsertSelectExample
	SELECT p.FirstName, p.LastName, e.EmailAddress FROM Person.Person AS p
	JOIN Person.EmailAddress AS e
		ON p.BusinessEntityID = e.BusinessEntityID

-- SELECT INTO 

SELECT p.FirstName, p.LastName, e.EmailAddress
	INTO EmailList --New Table
	FROM Person.Person AS p
	JOIN Person.EmailAddress AS e
		ON p.BusinessEntityID = e.BusinessEntityID	