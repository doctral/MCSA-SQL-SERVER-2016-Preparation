-- correlated subquery: the subquery depends on its outer query for its value
SELECT p.BusinessEntityID, FirstName + ' '+LastName Salesperson FROM Person.Person p
	WHERE EXISTS
	(SELECT s.SalesPersonID FROM Sales.SalesOrderHeader s
		WHERE TotalDue > 150000 
		AND p.BusinessEntityID = s.SalesPersonID)