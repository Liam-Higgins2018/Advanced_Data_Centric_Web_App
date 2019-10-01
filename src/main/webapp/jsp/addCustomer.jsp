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
<h1>Add New Customer</h1>
<form:form modelAttribute="customer">
  <table>
    <tr>
      <td>Cust Name:</td>
      <td><form:input path="cName"></form:input></td>
      <td><form:errors path="cName"></form:errors></td>
      </tr>
      <tr>
       <td>Loan Period (days):</td>
       <td><form:input path="loanPeriod"></form:input></td>
       <td><form:errors path="loanPeriod"></form:errors></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Add"/>
      </td>
    </tr>
  </table>
</form:form>
  <td><a href="/">Home</a></td>
  <td><a href="/addBook">Add Book</a></td>
  <td><a href="/addCustomer">Add Customers</a></td>
  <td><a href="/newLoan">New Loan</a></td>
</body>
</html>