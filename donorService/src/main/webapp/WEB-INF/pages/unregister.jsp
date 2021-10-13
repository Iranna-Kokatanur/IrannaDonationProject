
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
<h1>Unregister</h1><br>
<div>
<form:form action="/Unregister" modelAttribute="data" method="delete">
<div>
<label for="">RegNumber</label>
<form:input path="regNumber"/>
</div>
<div>
<input type="submit" value="Add">
</div>
</form:form>
</div>
</body>
</html>

