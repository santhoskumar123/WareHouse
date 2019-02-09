<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to OrderMethod Edit page</h2>
	<form:form action="update" method="POST" modelAttribute="orderMethod">
	<pre>
		Id:<form:input path="id" readOnly="true"/>		
		Order Mode:
			<form:radiobutton path="orderMode" value="SALE"/>Sale
			<form:radiobutton path="orderMode" value="PURCHASE"/>Purchase
		Order Code:<form:input path="orderCode" readOnly="true"/>
		Execute Type:<form:select path="exeType">
			<form:option value="">--select--</form:option>
			<form:option value="FIFO">FIFO</form:option>
			<form:option value="LIFO">LIFO</form:option>
			<form:option value="FCFO">FCFO</form:option>
			<form:option value="FEFO">FEFO</form:option>
		</form:select>
		Order Accept:
			<form:checkbox path="orderAccept" value="MULTI-SELECT"/>Multi-Select
			<form:checkbox path="OrderAccept" value="ACCEPT RETURN"/>Accept Return
			<form:checkbox path="OrderAccept" value="Service Extend"/>Service Extend
		Description:<form:textarea path="orderDsc"/>
		<input type="submit" value="Update"/>
					
	</pre>
	</form:form>
	${message}
	<br/>
	
</body>
</html>