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
	<h2>Welcome to UserEdit page</h2>
	<form:form action="update" method="POST" modelAttribute="user">
	Name:<form:input path="userName"/>
	Email:<form:input path="userEmail"/>
	Mobile:<form:input path="mobile"/>
	Password:<form:password path="userPwd"/>
	Roles:<form:checkbox path="roles" value="ADMIN"/>Admin
	Roles:<form:checkbox path="roles" value="ADDUSER"/>AddUser
	<input type="submit" value="Update"/>
	
	
	
	
	
	</form:form>
</body>
</html>