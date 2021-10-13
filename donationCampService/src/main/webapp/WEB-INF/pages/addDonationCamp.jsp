
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
<h1>Enter Donation Camp Details:</h1>
<div>
<form:form action="/addDonationCamp" modelAttribute="command" method="post">
<div>
<label for="">CampNameId</label>
<form:input path="regNumber"/>
<form:errors path="regNumber" cssStyle="color:#ff0000;" />
</div>
<div>
<label for="">DonationCampName</label>
<form:input path="donationCampName"/>
<form:errors path="donationCampName" cssStyle="color:#ff0000;" />
</div>
<div>
<label for="">Location</label>
<form:input path="location" />
</div>
<div>
<label for="">Date</label>
<form:input type="date" path="date" />
</div>
<div>
<input type="submit" value="Add">
</div>
</form:form>
</div>
</body>
</html>

