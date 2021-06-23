<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
</head>
<body>
	<h1>All Students</h1>

	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td><c:out value="${student.firstName}" /></td>
					<td><c:out value="${student.age}" /></td>
					<td><c:out value="${student.contact.address}" /></td>
					<td><c:out value="${student.contact.city}" /></td>
					<td><c:out value="${student.contact.state}" /></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>