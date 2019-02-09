<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

				<h2>Welcome To ShipmentType Data Page</h2>
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
								<th>MODE</th>
								<th>CODE</th>
								<!-- <th>ENABLE</th> -->
								<!-- <th>GRADE</th> -->
								<!-- <th>NOTE</th> -->
								<th colspan=4>OPERATIONS</th>
							</tr>

							<c:forEach items="${list}" var="st">
								<tr>
									<td><c:out value="${st.id}"></c:out></td>
									<td><c:out value="${st.shipmentMode}"></c:out></td>
									<td><c:out value="${st.shipmentCode}"></c:out></td>
									<%-- <td><c:out value="${st.enableShipment}"></c:out></td> --%>
									<%-- <td><c:out value="${st.shipmentGrade}"></c:out></td> --%>
									<%-- <td><c:out value="${st.shipDesc}"></c:out></td> --%>
									<td><a href="delete?sid=${st.id}"><img
											src="../resources/images/delete.png" height="20" width="20" /></a></td>
									<td><a href="view?sid=${st.id}"><img
											src="../resources/images/view.png" height="20" width="20" /></a></td>
									<td><a href="editOne?sid=${st.id}"><img
											src="../resources/images/edit.png" height="20" width="20" /></a></td>
									<td><a href="exportExcelOne?sid=${st.id }"> <img
											src="../resources/images/excel.png" height="20" width="20" />
									</a></td>
									<td><a href="exportPdfOne?sid=${st.id }"> <img
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