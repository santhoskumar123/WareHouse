<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to view page</h2>
	<table border=1>
		<tr>
			<th>ID</th>
			<td>${u.userId}</td>
		</tr>
		<tr>
			<th>NAME</th>
			<td>${u.userName}</td>
		</tr>
		
		<tr>
			<th>EMAIL</th>
			<td>${u.userEmail}</td>
		</tr>
		
		<tr>
			<th>MOBILE</th>
			<td>${u.mobile}</td>
		</tr>
		
		<tr>
			<th>PWD</th>
			<td>${u.userPwd}</td>
		</tr>
		<tr>
			<th>ROLES</th>
			<td>${u.roles}</td>
		</tr>
		
		
	
	</table>
</body>
</html>