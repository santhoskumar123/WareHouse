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

				<h2>Welcome to Wh User Type Register page</h2>
			</div>
			<div class="card-body">

				<form:form action="insert" method="POST" modelAttribute="whUserType">
					<%-- Id:<form:input path="id"/> --%>
					<div class="row">
						<div class="col-4">
							<label for="userType">USER TYPE</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="userType" value="VENDOR" />
							VENDOR
							<form:radiobutton path="userType" value="CUSTOMER" />
							CUSTOMER
							<form:errors path="userType" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">

							<label for="userCode">USER CODE</label>
						</div>
						<div class="col-6">
							<form:input path="userCode" />
							<form:errors path="userCode" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">

							<label for="userFor">USER FOR</label>
						</div>
						<div class="col-6">

							<form:input path="userFor" />
							<form:errors path="userFor" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">

							<label for="userEmail">USER EMAIL</label>
						</div>
						<div class="col-6">

							<form:input path="userEmail" />
							<form:errors path="userEmail" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">

							<label for="userContact">USER CONTACT</label>
						</div>
						<div class="col-6">

							<form:input path="userContact" />
							<form:errors path="userContact" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">

							<label for="userIdType">USER ID TYPE</label>
						</div>
						<div class="col-6">

							<form:input path="userIdType" />
							<form:errors path="userIdType" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="ifOther">IF OTHER</label>
						</div>
						<div class="col-6">

							<form:input path="ifOther" />
							<form:errors path="ifOther" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">

							<label for="idNumber">ID NUMBER</label>
						</div>
						<div class="col-6">

							<form:input path="idNumber" />
							<form:errors path="idNumber" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<input type="submit" value="register" />
						</div>
					</div>
				</form:form>
			</div>
			<!-- card body end -->
			<c:if test="${message != null }">
				<div class="card-footer bg-success text-white">${message}</div>
			</c:if>

		</div>
		<!-- card end -->
	</div>
	<!-- container end -->

	<a href="all">ViewAll</a> ${message}
</body>
</html>