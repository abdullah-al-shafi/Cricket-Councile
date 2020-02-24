<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShowAll Country</title>
</head>
<body>
  
	<table>
		<tr>
			<th>ID</th>
			<th>Country Name</th>
		</tr>
		<c:forEach items="${countries }" var="country">
			<tr>
				<th>${ country.countryId }</th>
				<th>${ country.countryName }</th>
				<th><a href="edit?countryId=${country.countryId}">Edit</a></th>
				<th><a href="delete?countryId=${country.countryId}">Delete</a></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>