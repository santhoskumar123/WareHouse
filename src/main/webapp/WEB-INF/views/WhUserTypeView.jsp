<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to view page!!!</h2>
	<table border=1>
		<tr>
			<td>ID</td>
			<td>${wut.id}</td>
		</tr>
		<tr>
			<td>UserType</td>
			<td>${wut.userType}</td>
		</tr>
		
		<tr>
			<td>UserCode</td>
			<td>${wut.userCode}</td>
		</tr>
		
		<tr>
			<td>UserFor</td>
			<td>${wut.userFor}</td>
		</tr>
		
		<tr>
			<td>UserEmail</td>
			<td>${wut.userEmail}</td>
		</tr>
		
		<tr>
			<td>UserContact</td>
			<td>${wut.userContact}</td>
		</tr>
		
		<tr>
			<td>UserIdType</td>
			<td>${wut.userIdType}</td>
		</tr>
		
		<tr>
			<td>IfOther</td>
			<td>${wut.ifOther}</td>
		</tr>
		
		<tr>
			<td>Number</td>
			<td>${wut.idNumber}</td>
		</tr>
		
	</table>
</body>
</html>