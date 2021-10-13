
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DonationCamp</title>
</head>
<body>
<div>
<form:form action="/editDetails" modelAttribute="command" method="put">
<div>
<label for="">CampNameId</label>
<form:input path="regNumber"/>

</div>
<div>
<label for="">DonationCampName</label>
<form:input path="donationCampName"/>

</div>
<div>
<label for="">Location</label>
<form:input path="location" />
</div>
<div>
<input type="submit" value="Add">
</div>
</form:form>
</div>
</body>
</html>

