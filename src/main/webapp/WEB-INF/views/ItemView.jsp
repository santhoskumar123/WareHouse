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
				<h3>welcome to Item view page</h3>
			</div>
			<!-- card header end -->
			<div class="card-body">
				<table class="table table-bordered table-hover">
					<tr class=thead-dark>
						<td>ID</td>
						<td>${i.itemId}</td>
					</tr>
					
					<tr>
						<td>ITEM CODE</td>
						<td>${i.itemCode}</td>
					</tr>
					<tr>
						<td>ITEM LEN</td>
						<td>${i.itemLen}</td>
					</tr>
					<tr>
						<td>ITEM WIDTH</td>
						<td>${i.itemWidth}</td>
					</tr>
					<tr>
						<td>ITEM HEIGHT</td>
						<td>${i.itemHeight}</td>
					</tr>
					<tr>
						<td>BASE COST</td>
						<td>${i.baseCost}</td>
					</tr>
					<tr>
						<td>BASE CURRENCY</td>
						<td>${i.baseCurrency}</td>
					</tr>
					<tr>
						<td>ITEM DSC</td>
						<td>${i.itemDsc}</td>
					</tr>
				</table>
			</div>
			<!-- card body class end -->
		</div><!-- card  end -->
	</div><!-- card container end -->
	
</body>
</html>