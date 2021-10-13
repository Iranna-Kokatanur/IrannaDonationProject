
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor</title>
</head>
<body>
<h1>Camp Details By Location</h1><br>
<div>
<form:form action="/location" modelAttribute="data" method="get">
<div>
<label for="">Location</label>
<form:input path="regLocation"/>
</div>
<div>
<input type="submit" value="Add">
</div>
</form:form>
</div>
</body>
</html>

