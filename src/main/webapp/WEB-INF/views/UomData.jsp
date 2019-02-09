<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Uom Data Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">

		<div class="card">


			<div class="card-header bg-primary text-white">
				<h2>WELCOME TO UOM DATA PAGE</h2>
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

							<tr class="thead-dark">
								<th>ID</th>
								<th>UTYPE</th>
								<!-- <th>UMODEL</th> -->
								<!-- <th>UDES</th> -->
								<th colspan=5>OPERATIONS</th>
							</tr>
							<c:forEach items="${list}" var="u">
								<tr>
									<td><c:out value="${u.id}"></c:out></td>
									<td><c:out value="${u.uomType}"></c:out></td>
									<%-- <td><c:out value="${u.uomModel}"></c:out></td> --%>
									<%-- <td><c:out value="${u.uomDes}"></c:out></td> --%>
									<td><a href="delete?uid=${u.id}"><img
											src="../resources/images/delete.png" height="20" width="20" /></a></td>
									<td><a href="view?uid=${u.id}"><img
											src="../resources/images/view.png" height="20" width="20" /></a></td>
									<td><a href="editOne?uid=${u.id}"><img
											src="../resources/images/edit.png" height="20" width="20" /></a></td>
									<td><a href="exportExcelOne?id=${u.id}"><img
											src="../resources/images/excel.png" height="20" width="20" /></a></td>
									<td><a href="exportPdfOne?id=${u.id}"><img
											src="../resources/images/pdf.png" height="20" width="20" /></a></td>


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