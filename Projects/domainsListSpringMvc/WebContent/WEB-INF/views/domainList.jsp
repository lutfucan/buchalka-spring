<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listing domains</title>
<style type="text/css">
	table, tr, td, th {
		border-style: solid;
		border-width : 1px;
		margin : 5px;
		padding : 5px;
		color: blue;
	}
</style>
</head>
<body>
	<h1>Listing domains</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Registrar</th>
			<th>Registered Date</th>
			<th>Expiration Date</th>
			<th>Minimum Price</th>
			<th>Preferred Price</th>
			<th>Status</th>
			<th>Comment</th>
		</tr>
		<c:forEach var="row" items="${orgList}">
			<tr>
				<td>${row.domainName}</td>
				<td>${row.registrar}</td>
				<td>${row.regDate}</td>
				<td>${row.expDate}</td>
				<td>${row.minPrice}</td>
				<td>${row.prefferedPrice}</td>
				<td>${row.status}</td>
				<td>${row.comment}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>