<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADCWA Final Project</title>
</head>
<body>
<h2>Delete Loan</h2>
<form:form modelAttribute="loan">
  <table>
    <tr>
      <td>Loan ID: <form:input path="lid"></form:input></td>
      </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Delete"/>
      </td>
    </tr>
  </table>
</form:form>
<td><a href="/">Home</a></td>
<td><a href="/showBooks">List Books</a></td>
<td><a href="/showCustomers">List Customers</a></td>
<td><a href="/showLoans">List Loans</a></td>
<td><a href="/newLoan">New Loan</a></td>
</body>
</html>