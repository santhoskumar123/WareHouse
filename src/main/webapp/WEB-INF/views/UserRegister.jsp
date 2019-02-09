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
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">

				<h2>Welcome to UserRegister page</h2>
			</div>
			<form:form action="insert" method="POST" modelAttribute="user">
				<div class="card-body">
					<div class="row">
						<div class="col-4">
							<label for="userName">ORDER MODE</label>
						</div>
						<div class="col-6">
							<form:input path="userName" />
							<form:errors path="userName" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="userEmail">USER EMAIL</label>
						</div>
						<div class="col-6">
							<form:input path="userEmail" />
							<form:errors path="userEmail" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="mobile">MOBILE</label>
						</div>
						<div class="col-6">
					<form:input path="mobile" />
					<form:errors path="mobile" cssClass="text-danger" />
					</div></div>
					Password:
					<form:password path="userPwd" />
					<form:errors path="userPwd" cssClass="text-danger" />
					Roles:
					<form:checkbox path="roles" value="ADMIN" />
					Admin Roles:
					<form:checkbox path="roles" value="ADDUSER" />
					AddUser
					<form:errors path="roles" cssClass="text-danger" />
					<input type="submit" value="Register" />


				</div>
			</form:form>
			<!-- card body end -->
			<c:if test="${message != null }">
				<div class="card-footer bg-success text-white">${message}</div>
			</c:if>

		</div>
		<!-- card end -->
	</div>
	<!-- container end -->
	<br />
	<a href="all">ViewAll</a>



</body>
</html>