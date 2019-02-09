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
	<h2>Welcome to edit page!!!</h2>
	<form:form action="update" method="POST" modelAttribute="whUserType">
	<pre>
	Id:<form:input path="id" readOnly="true"/>
	User Type:<form:radiobutton path="userType" value="VENDOR"/>VENDOR
			<form:radiobutton path="userType" value="CUSTOMER"/>CUSTOMER
	User Code:<form:input path="userCode" readOnly="true"/>
	User For:<form:input path="userFor"/>
	User Email:<form:input path="userEmail"/>
	User Contact:<form:input path="userContact"/>
	User Id Type:<form:input path="userIdType"/>
	If Other:<form:input path="ifOther"/>
	Id Number:<form:input path="idNumber"/>
	<input type="submit" value="update"/>
	
	</pre>
	
	</form:form>
</body>
</html>