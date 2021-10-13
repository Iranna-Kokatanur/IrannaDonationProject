
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DonationDetails</title><br>
</head>
<body>
<h1>Enter Camp Name:</h1>
<div>
<form:form action="/campName" modelAttribute="data" method="get">
<div>
<label for="">CampName</label>
<form:input path="donationCampName"/>
</div>
<div>
<input type="submit" value="Add">
</div>
</form:form>
</div>
</body>
</html>

