<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Country</title>
</head>
<body>

	<h1>Edit Country</h1>

	<form:form action="${pageContext.request.contextPath }/country/edit"
		modelAttribute="country">
		
		<form:input path="countryId" value="${countryId}" hidden="hidden" />
		<form:input path="countryName" value="${countryName}" />
		<br>

		<input type="submit" name="submit" value="Edit Country">
	</form:form>

</body>
</html>