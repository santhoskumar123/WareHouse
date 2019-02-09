<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PurchaseOrder Register Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h2>Welcome to PurchaseOrder register page</h2>
			</div>
			<div class="card-body">
				<form:form action="insert" method="POST" modelAttribute="purchaseOrder">


					<div class="row">
						<div class="col-4">
							<label for="orderCode">ORDER CODE</label>
						</div>
						<div class="col-6">
							<form:input path="orderCode" />
							<form:errors path="orderCode" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipmentMode">SHIPMENT MODE</label>
						</div>
						<div class="col-6">
							<form:select path="shipmentMode">
								<form:option value="">--select--</form:option>
								<form:option value="">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FCFO">FCFO</form:option>
								 <form:option value="FEFO">FEFO</form:option>
							</form:select>
							<form:errors path="shipmentMode" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="vendor">VENDOR</label>
						</div>
						<div class="col-6">
							<form:select path="vendor">
								<form:option value="">--select--</form:option>
								<form:option value="ASDF">ASDF</form:option>
								<form:option value="SUN">SUN</form:option>
							</form:select>
						<form:errors path="vendor" cssClass="text-danger" />
						</div>
					</div>
						
					<div class="row">
						<div class="col-4">
							<label for="refNum">REF NUM</label>
						</div>
						<div class="col-6">
							<form:input path="refNum" />
							<form:errors path="refNum" cssClass="text-danger" />
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="qualityCheck">QUALITY CHECK</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="qualityCheck" value="REQUIRED" />
							Required
							<form:radiobutton path="qualityCheck" value="NOT REQUIRED" />
							NotRequired
							<form:errors path="qualityCheck" cssClass="text-danger"/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-4">
							<label for="orderStatus">ORDER STATUS</label>
						</div>
						<div class="col-6">
							<form:textarea path="orderStatus" />
							<form:errors path="orderStatus" cssClass="text-danger" />
						</div>
						</div>
						<div class="row">
						<div class="col-4">
							<label for="orderDsc">ORDER DSC</label>
						</div>
						<div class="col-6">
							<form:textarea path="orderDsc" />
							<form:errors path="orderDsc" cssClass="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col-6">
							<input class="btn btn-primary" type="submit" value="Register" />
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

	<a href="all">ViewAll</a>
</body>
</html>