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
				<h3>welcome to view page</h3>
			</div>
			<!-- card header end -->
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr class=thead-dark>
						<td>ID</td>
						<td>${om.id}</td>
					</tr>
					<tr>
						<td>MODE</td>
						<td>${om.orderMode}</td>
					</tr>
					<tr>
						<td>CODE</td>
						<td>${om.orderCode}</td>
					</tr>
					<tr>
						<td>EXETYPE</td>
						<td>${om.exeType}</td>
					</tr>
					<tr>
						<td>ORDERACCEPT</td>
						<td>${om.orderAccept}</td>
					</tr>
					<tr>
						<td>ORDERDSC</td>
						<td>${om.orderDsc}</td>
					</tr>
				</table>
			</div>
			<!-- card body class end -->
		</div><!-- card  end -->
	</div><!-- card container end -->
	
	
</body>
</html>