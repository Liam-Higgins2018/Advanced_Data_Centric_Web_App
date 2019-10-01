<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADCWA Final Project</title>
</head>
<body>
<h1>List of Books</h1>
<table>
  <tr>
   <th>Book ID</th>
   <th>Title</th>
   <th>Author</th>
  </tr>
  <tr>
    <c:forEach items="${books}" 
                 var="book">
      <tr> 
        <td>${book.bid}</td>
        <td>${book.title}</td>
        <td>${book.author}</td>
      </tr>
    </c:forEach>
  </tr>
</table>
<td><a href="/">Home</a></td>
<td><a href="/addBook">Add Book</a></td>
<td><a href="/showCustomers">List Customers</a></td>
<td><a href="/showLoans">List Loans</a></td>
<td><a href="/logout">Logout</a></td>
</body>
</html>