
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DonationDetails</title>
</head>
<body>
<h1>Enter BloodGroup:</h1><br>
<div>
<form:form action="/eligibility" modelAttribute="data" method="get">
<div>
<label for="">BloodGroup</label>
<form:input path="bloodGroup"/>
</div>
<div>
<input type="submit" value="Add">
</div>
</form:form>
</div>
</body>
</html>

