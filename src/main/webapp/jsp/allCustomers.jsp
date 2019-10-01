<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<meta charset="ISO-8859-1">
<title>ADCWA Final Project</title>
</head>
<body>
<h1>List of Customers</h1>
 <c:forEach items="${customers}" var="customer">
<h2>${customer.cId} ${customer.cName}</h2>
<p>Loan Period = ${customer.loanPeriod} days</p>
<b>${customer.cName}'s Loans</b>
<table>
<tr>
   <th>Loan ID</th>
   <th>Book ID</th>
   <th>Title</th>
   <th>Author</th>
  </tr>
  <tr>
    <c:forEach items="${customer.loans}" 
                 var="customerLoan">
      <tr> 
        <td>${customerLoan.lid}</td>
        <td>${customerLoan.book.bid}</td>
        <td>${customerLoan.book.title}</td>
        <td>${customerLoan.book.author}</td>
      </tr>
      </c:forEach>
  </tr>
</table>
</c:forEach>
<td><a href="/">Home</a></td>
<td><a href="/showBooks">List Books</a></td>
<td><a href="/showCustomers">List Customers</a></td>
<td><a href="/showLoans">List Loans</a></td>
<td><a href="/logout">Logout</a></td>
</body>
</html>