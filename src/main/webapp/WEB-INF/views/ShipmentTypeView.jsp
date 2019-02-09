<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to Shipment Type View Page</h2>
	<table border=1>
		<tr>
			<td>ID</td>
			<td>${st.id}</td>
		</tr>
		<tr>
			<td>MODE</td>
			<td>${st.shipmentMode}</td>
		</tr>
		<tr>
			<td>CODE</td>
			<td>${st.shipmentCode}</td>
		</tr>
		<tr>
			<td>ENABLED</td>
			<td>${st.enableShipment}</td>
		</tr>
		<tr>
			<td>GRADE</td>
			<td>${st.shipmentGrade}</td>
		</tr>
		<tr>
			<td>NOTE</td>
			<td>${st.shipDesc}</td>
		</tr>
	</table>
	<a href="all"><img src="../resources/images/back.png" height="30" width="30"/></a>
</body>
</html>