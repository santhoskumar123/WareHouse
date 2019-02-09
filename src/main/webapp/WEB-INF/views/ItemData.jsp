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

				<h2>Welcome to Item data page!!!</h2>
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
								<th>ITEM CODE</th>
								<th>ITEM LEN</th>
								<!-- <th>ITEM WIDTH</th> -->
								<!-- <th>ITEM HEIGHT</th> -->
								<!-- <th>BASE COST</th> -->
								<!-- <th>BASE CURRENCY</th> -->
								<!-- <th>ITEM DSC</th> -->
								<th colspan=5>OPERATIONS</th>
							</tr>

							<c:forEach items="${list}" var="i">
								<tr>
									<td><c:out value="${i.itemId}"></c:out></td>
									<td><c:out value="${i.itemCode}"></c:out></td>
									<td><c:out value="${i.itemLen}"></c:out></td>
									<%-- <td><c:out value="${i.itemWidth}"></c:out></td> --%>
									<%-- <td><c:out value="${i.itemHeight}"></c:out></td> --%>
									<%-- <td><c:out value="${i.baseCost}"></c:out></td> --%>
									<%-- <td><c:out value="${i.baseCurrency}"></c:out></td> --%>
									<%-- <td><c:out value="${i.itemDsc}"></c:out></td> --%>
									<td><a href="delete?oid=${i.itemId}"><img
											src="../resources/images/delete.png" height="20" width="20" /></a>
									<td><a href="view?oid=${i.itemId}"><img
											src="../resources/images/view.png" height="20" width="20" /></a>
									<td><a href="editOne?oid=${i.itemId}"><img
											src="../resources/images/edit.png" height="20" width="20" /></a>
									<td><a href="exportExcelOne?id=${i.itemId}"> <img
											src="../resources/images/excel.png" height="20" width="20" />
									</a></td>
									<td><a href="exportPdfOne?id=${i.itemId }"> <img
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