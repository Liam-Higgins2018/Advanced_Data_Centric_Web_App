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
<h1>New Loan</h1>
<form:form modelAttribute="loan">
  <table>
    <tr>
      <td>Customer ID:</td>
      <td><form:input path="cust"></form:input></td>
      <td><form:errors path="cust"></form:errors></td>
      </tr>
      <tr>
       <td>Book ID:</td>
       <td><form:input path="book"></form:input></td>
       <td><form:errors path="book"></form:errors></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Loan Book"/>
      </td>
    </tr>
  </table>
</form:form>
   <td><a href="/">Home</a></td>
  <td><a href="/showBooks">List Book</a></td>
  <td><a href="/showCustomers">List Customers</a></td>
  <td><a href="/showLoans">List Loan</a></td>
</body>
</html>