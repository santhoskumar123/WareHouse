<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome To Uom Data View Page</h2>
	<table border=1>
		<tr>
			<td>ID</td>
			<td>${u.id}</td>
		</tr>
		<tr>
			<td>UTYPE</td>
			<td>${u.uomType}</td>
		</tr>
		<tr>
			<td>UMODEL</td>
			<td>${u.uomModel}</td>
		</tr>
		<tr>
			<td>UDES</td>
			<td>${u.uomDes}</td>
		</tr>
	</table>
	<a href="all"><img src="../resources/images/back.png" height="30" width="30"/></a>
</body>
</html>