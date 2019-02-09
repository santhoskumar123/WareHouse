<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OrderMethod data</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>

	<div class="container">

		<div class="card">
			<div class="card-header bg-primary text-white">

				<h2>Welcome to order method data page!!!</h2>
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
								<th>MODE</th>
								<th>CODE</th>
								<!-- <th>EXETYPE</th> -->
								<!-- <th>ORDERACCEPT</th> -->
								<!-- <th>ORDERDSC</th> -->
								<th colspan=5>OPERATIONS</th>
							</tr>

							<c:forEach items="${list}" var="om">
								<tr>
									<td><c:out value="${om.id}"></c:out></td>
									<td><c:out value="${om.orderMode}"></c:out></td>
									<td><c:out value="${om.orderCode}"></c:out></td>
									<%-- <td><c:out value="${om.exeType}"></c:out></td> --%>
									<%-- <td><c:out value="${om.orderAccept}"></c:out></td> --%>
									<%-- <td><c:out value="${om.orderDsc}"></c:out></td> --%>
									<td><a href="delete?oid=${om.id}"><img
											src="../resources/images/delete.png" height="20" width="20" /></a>
									<td><a href="view?oid=${om.id}"><img
											src="../resources/images/view.png" height="20" width="20" /></a>
									<td><a href="editOne?oid=${om.id}"><img
											src="../resources/images/edit.png" height="20" width="20" /></a>
									<td><a href="exportExcelOne?id=${om.id }"> <img
											src="../resources/images/excel.png" height="20" width="20" />
									</a></td>
									<td><a href="exportPdfOne?id=${om.id }"> <img
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