<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<div class="card-header bg-primary text-white">
				<h3>welcome to PurchaseOrder view page</h3>
			</div>
			<!-- card header end -->
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr class=thead-dark>
						<td>ORDER ID</td>
						<td>${po.orderId}</td>
					</tr>
					
					<tr>
						<td>ORDER CODE</td>
						<td>${po.orderCode}</td>
					</tr>
					<tr>
						<td>SHIPMENT MODE</td>
						<td>${po.shipmentMode}</td>
					</tr>
					<tr>
						<td>VENDOR</td>
						<td>${po.vendor}</td>
					</tr>
					<tr>
						<td>REF NUM</td>
						<td>${po.refNum}</td>
					</tr>
					<tr>
						<td>QUALITYCHECK</td>
						<td>${po.qualityCheck}</td>
					</tr>
					<tr>
						<td>ORDER STATUS</td>
						<td>${po.orderStatus}</td>
					</tr>
					<tr>
						<td>ORDER DSC</td>
						<td>${po.orderDsc}</td>
					</tr>
				</table>
			</div>
			<!-- card body class end -->
		</div><!-- card  end -->
	</div><!-- card container end -->
	
</body>
</html>