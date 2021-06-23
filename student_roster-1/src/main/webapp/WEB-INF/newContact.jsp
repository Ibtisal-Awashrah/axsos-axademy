<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>New Contact</h1>

	<form:form action="/contacts/new" method="POST" modelAttribute="contact">
		<div>
			<form:select path="student">
				<c:forEach items="${stu}" var="p">
					<form:option value="${ p.id }">${ p.firstName } ${ p.lastName }</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div>
			<form:label path="address">Address</form:label>
			<form:errors path="address" />
			<form:input path="address" />
		</div>
		<div>
			<form:label path="city">City</form:label>
			<form:errors path="city" />
			<form:input path="city" />
		</div>
		<div>
			<form:label path="state">State</form:label>
			<form:errors path="state" />
			<form:input path="state" />
		</div>
		<button>Add Contact</button>
</form:form>
</body>
</html>