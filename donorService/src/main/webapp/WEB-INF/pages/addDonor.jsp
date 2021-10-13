
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Donor</title>
</head>
<body>
<h1>Donor Registration:</h1><br>
<div>
<form:form action="/addDonor" modelAttribute="command" method="post">
<div>
<label for="">RegNumber</label>
<form:input path="regNumber"/>
<form:errors path="regNumber" cssStyle="color:#ff0000;" />
</div>
<div>
<label for="">BloodGroup</label>
<form:input path="bloodGroup"/>
</div>
<div>
<label for="">RegLocation</label>
<form:input path="regLocation"/>
</div>
<div>
<label for="">FirstName</label>
<form:input path="firstName"/>
</div>
<div>
<label for="">LastName</label>
<form:input path="lastName"/>
</div>
<div>
<label for="">RegDate</label>
<form:input type="date" path="regDate" />
</div>
<div>
<label for="">BloodDonatedDate</label>
<form:input type="date" path="bloodDonatedDate" />
</div>
<div>
<label for="">PhoneNumber</label>
<form:input path="phoneNumber"/>
</div>
<div>
<input type="submit" value="Add">
</div>
</form:form>
</div>
</body>
</html>

