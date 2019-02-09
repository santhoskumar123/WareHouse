<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to UOM edit page</h2>
	<form:form action="update" method="POST" modelAttribute="uom">
	<pre>
	Id:<form:input path="id"/>
	Uom Type:<form:select path="uomType">
			 <form:option value="">--select--</form:option>
			 <form:option value="PACKING">Packing</form:option>
			 <form:option value="NoPACKING">NoPacking</form:option>
			 <form:option value="--NA--">--Na--</form:option>
			 
			 </form:select>
	Uom Model:<form:input path="uomModel"/>
	Description:<form:textarea path="uomDes"/>
	<input type="submit" value="Update"/>
	</pre>
	</form:form>
</body>
</html>