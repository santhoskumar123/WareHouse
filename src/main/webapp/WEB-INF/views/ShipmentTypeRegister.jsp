<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment type register</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info text-white">
				<h2>welcome to shipmentType registration page</h2>
			</div>
			<div class="card-body">
				<!-- body start -->
				<form:form action="insert" method="POST"
					modelAttribute="shipmentType">
					<div class="row">
						<div class="col-4">
							<label for="shipmentMode">SHIPMENT MODE</label>
						</div>
						<div class="col-6">

							<form:select path="shipmentMode">
								<form:option value="shipmentMode">--select--</form:option>
								<form:option value="AIR">Air</form:option>
								<form:option value="TRUCK">Truck</form:option>
								<form:option value="SHIP">Ship</form:option>
								<form:option value="TRAIN">Train</form:option>

							</form:select>
							<form:errors path="shipmentMode" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipmentCode">SHIPMENT CODE</label>
						</div>
						<div class="col-6">
							<form:input path="shipmentCode" />
							<form:errors path="shipmentCode" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="enableShipment">ENABLE SHIPMENT</label>
						</div>
						<div class="col-6">
							<form:select path="enableShipment">
								<form:option value="">--select--</form:option>
								<form:option value="YES">Yes</form:option>
								<form:option value="NO">No</form:option>
							</form:select>
							<form:errors path="enableShipment" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipmentGrade">SHIPMENT GRADE</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="shipmentGrade" value="A" />
							A
							<form:radiobutton path="shipmentGrade" value="B" />
							B
							<form:radiobutton path="shipmentGrade" value="C" />
							C
							<form:errors path="shipmentGrade" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="shipDesc">SHIP DESC</label>
						</div>
						<div class="col-6">
							<form:textarea path="shipDesc" />
							<form:errors path="shipDesc" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<input type="submit" value="Create Shipment" />
						</div>
					</div>

				</form:form>
			</div>
			<!-- card body end -->
			<c:if test="${message != null}">
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