<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Edit Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h2>Welcome to Item Edit page</h2>
			</div>
			<div class="card-body">
				<form:form action="insert" method="POST" modelAttribute="item">


					<div class="row">
						<div class="col-4">
							<label for="itemCode">ITEM CODE</label>
						</div>
						<div class="col-6">
							<form:input path="itemCode" />
							<form:errors path="itemCode" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="itemLen">ITEM LEN</label>
						</div>
						<div class="col-6">
							<form:input path="itemLen" />
							<form:errors path="itemLen" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="itemWidth">ITEM WIDTH</label>
						</div>
						<div class="col-6">
							<form:input path="itemWidth" />
							<form:errors path="itemWidth" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="itemHeight">ITEM HEIGHT</label>
						</div>
						<div class="col-6">
							<form:input path="itemHeight" />
							<form:errors path="itemHeight" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="baseCost">BASE COST</label>
						</div>
						<div class="col-6">
							<form:input path="baseCost" />
							<form:errors path="baseCost" cssClass="text-danger" />
						</div>
					</div>
					
					
					<div class="row">
						<div class="col-4">
							<label for="baseCurrency">BASE CURRENCY</label>
						</div>
						<div class="col-6">
							<form:select path="baseCurrency">
								<form:option value="">--select--</form:option>
								<form:option value="INR">INR</form:option>
								<form:option value="USD">USD</form:option>
								<form:option value="AUS">AUS</form:option>
								<form:option value="EUR">EUR</form:option>
							</form:select>
							<form:errors path="baseCurrency" cssClass="text-danger" />
						</div>
					</div>
						<div class="row">
						<div class="col-4">
							<label for="itemDsc">ITEM DSC</label>
						</div>
						<div class="col-6">
							<form:textarea path="itemDsc" />
							<form:errors path="itemDsc" cssClass="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col-6">
							<input class="btn btn-primary" type="submit" value="update" />
						</div>
					</div>
				</form:form>
			</div>
			<!-- card body end -->
			
		</div>
		<!-- card end -->
	</div>
	<!-- container end -->

</body>
</html>