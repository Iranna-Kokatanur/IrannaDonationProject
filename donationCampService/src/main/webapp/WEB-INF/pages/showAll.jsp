<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DonationCamp</title>
<style>
   h1{
      text-align:center;
   }
 
   table{
     border:1px solid black;
     margin-left:auto;
     margin-right:auto;
     border-collapse: collapse;
   }
   tr,td,th{
     border:0.5px solid blue;
   }


</style>
</head>
<body>
<h1>Donation Camps:</h1>
<br>
<br>
<table>
<tr>
<td>CampNameId</td>
<td>CampName</td>
<td>Location</td>
<td>DateOfHeld</td>
</tr>
<c:forEach items="${data}" var="eachItem">
<tr>
<td>${eachItem.regNumber}</td>
<td>${eachItem.donationCampName}</td>
<td>${eachItem.location }</td>
<td>${eachItem.date}</td>
</tr>
</c:forEach>
</table>
</body>
</html>