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

				<h2>Welcome to Data Page</h2>
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
								<th>UserType</th>
								<!-- <th>UserCode</th> -->
								<!-- <th>UserFor</th> -->
								<!-- <th>UserEmail</th> -->
								<!-- <th>UserContact</th> -->
								<!-- <th>UserIdType</th> -->
								<!-- <th>IfOther</th> -->
								<!-- <th>Number</th> -->
								<th colspan=5>OPERATIONS</th>
							</tr>
							<c:forEach items="${list}" var="wut">
								<tr>
									<td><c:out value="${wut.id}"></c:out></td>
									<td><c:out value="${wut.userType}"></c:out></td>
									<%-- <td><c:out value="${wut.userCode}"></c:out></td> --%>
									<%-- <td><c:out value="${wut.userFor}"></c:out></td> --%>
									<%-- <td><c:out value="${wut.userEmail}"></c:out></td> --%>
									<%-- <td><c:out value="${wut.userContact}"></c:out></td> --%>
									<%-- <td><c:out value="${wut.userIdType}"></c:out></td> --%>
									<%-- <td><c:out value="${wut.ifOther}"></c:out></td> --%>
									<%-- <td><c:out value="${wut.idNumber}"></c:out></td>  --%>

									<td><a href="delete?uid=${wut.id}"><img
											src="../resources/images/delete.png" height="20" width="20" /></a>
									<td><a href="view?uid=${wut.id}"><img
											src="../resources/images/view.png" height="20" width="20" /></a>
									<td><a href="edit?uid=${wut.id}"><img
											src="../resources/images/edit.png" height="20" width="20" /></a>
									<td><a href="exportExcelOne?id=${wh.id}"> <img
											src="../resources/images/excel.png" height="20" width="20" /></a></td>
									<td><a href="exportPdfOne?id=${wh.id}"> <img
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