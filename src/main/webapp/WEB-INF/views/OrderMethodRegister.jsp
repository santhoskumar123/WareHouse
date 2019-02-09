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
				<h2>Welcome to OrderMethod register page</h2>
			</div>
			<div class="card-body">
				<form:form action="insert" method="POST"
					modelAttribute="orderMethod">

					<div class="row">
						<div class="col-4">
							<label for="orderMode">ORDER MODE</label>
						</div>
						<div class="col-6">
							<form:radiobutton path="orderMode" value="SALE" />
							Sale
							<form:radiobutton path="orderMode" value="PURCHASE" />
							Purchase
							<form:errors path="orderMode" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="orderCode">ORDER CODE</label>
						</div>
						<div class="col-6">
							<form:input path="orderCode" />
							<form:errors path="orderCode" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="exeType">EXE TYPE</label>
						</div>
						<div class="col-6">
							<form:select path="exeType">
								<form:option value="">--select--</form:option>
								<form:option value="FIFO">FIFO</form:option>
								<form:option value="LIFO">LIFO</form:option>
								<form:option value="FCFO">FCFO</form:option>
								<form:option value="FEFO">FEFO</form:option>
							</form:select>
							<form:errors path="exeType" cssClass="text-danger"/>
						</div>
						<form:errors path="exeType" cssClass="text-danger"/>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="orderAccept">ORDER ACCEPT</label>
						</div>
						<div class="row-6">
							<form:checkbox path="orderAccept" value="MULTI-SELECT" />MULTI-SELECT
							<form:checkbox path="OrderAccept" value="ACCEPT RETURN" />ACCEPT RETURN
							<form:checkbox path="OrderAccept" value="Service Extend" />Service Extend
							<form:errors path="orderAccept" cssClass="text-danger"/>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<label for="orderDsc">ORDER DSC</label>
						</div>
						<div class="col-6">
							<form:textarea path="orderDsc" />
							<form:errors path="orderDsc" cssClass="text-danger"/>
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
	
	<a href="all" >ViewAll</a>
</body>
</html>