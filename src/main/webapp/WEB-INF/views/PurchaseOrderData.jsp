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

				<h2>Welcome to PurchaseOrder data page!!!</h2>
			</div>
			<!-- card header end -->

			<a href="excelExp">Export Excel</a> | <a href="pdfExp">Export PDF</a>
			<a href="excelExport">ExcelExport</a>
			<div class="card-body">

				<c:choose>
					<c:when test="${empty list }">
						<h4>No Data Found</h4>
					</c:when>
					<c:otherwise>

						<table class="table table-bordered table-hover">
							<tr class=thead-dark>
								<th>ID</th>
								<th>ORDER CODE</th>
								<th>SHIPMENT MODE</th>
								<!-- <th>VENDOR</th> -->
								<!-- <th>REF NUM</th> -->
								<!-- <th>QUALTYCHECK</th> -->
								<!-- <th>ORDER STATUS</th> -->
								<!-- <th>ORDER DSC</th> -->
								<th colspan=5>OPERATIONS</th>
							</tr>

							<c:forEach items="${list}" var="po">
								<tr>
									<td><c:out value="${po.orderId}"></c:out></td>
									<td><c:out value="${po.orderCode}"></c:out></td>
									<td><c:out value="${po.shipmentMode}"></c:out></td>
									<%-- <td><c:out value="${po.refNum}"></c:out></td> --%>
									<%-- <td><c:out value="${po.qualityCheck}"></c:out></td> --%>
									<%-- <td><c:out value="${po.orderStatus}"></c:out></td> --%>
									<%-- <td><c:out value="${po.orderDsc}"></c:out></td> --%>
									<td><a href="delete?oid=${po.orderId}"><img
											src="../resources/images/delete.png" height="20" width="20" /></a>
									<td><a href="view?oid=${po.orderId}"><img
											src="../resources/images/view.png" height="20" width="20" /></a>
									<td><a href="editOne?oid=${po.orderId}"><img
											src="../resources/images/edit.png" height="20" width="20" /></a>
									<td><a href="exportExcelOne?id=${po.orderId}"> <img
											src="../resources/images/excel.png" height="20" width="20" />
									</a></td>
									<td><a href="exportPdfOne?id=${po.orderId }"> <img
											src="../resources/images/pdf.png" height="20" width="20" />
									</a></td>
								</tr>
							</c:forEach>

						</table>
					</c:otherwise>

				</c:choose>
			</div>
			<!-- card body class end -->
			<c:if test="${message != null}">
				<div class="card-footer bg-danger text-white">${message}</div>
			</c:if>

		</div>
	</div>
	
</body>
</html>