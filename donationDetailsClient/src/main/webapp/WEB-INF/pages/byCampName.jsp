<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DonationDetails</title>
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
<h1>CampName:${CampName}</h1>
<table>
<tr>
<td>RegNumber</td>
<td>FirstName</td>
<td>lastName</td>
<td>BloodGroup</td>
<td>BloodDonatedDate</td>
<td>RegDate</td>
<td>RegLocation</td>
<td>DonationCampName</td>
<td>CampNameId</td>
<td>PhoneNumber</td>
</tr>
<c:forEach items="${data}" var="eachItem">
<tr>
<td>${eachItem.regNumber}</td>
<td>${eachItem.firstName }</td>
<td>${eachItem.lastName }</td>
<td>${eachItem.bloodGroup}</td>
<td>${eachItem.bloodDonatedDate}</td>
<td>${eachItem.regDate}</td>
<td>${eachItem.regLocation }</td>
<td>${eachItem.donationCampName }</td>
<td>${eachItem.campNameId }</td>
<td>${eachItem.phoneNumber}</td>
</tr>
</c:forEach>
</table>
</body>
</html>