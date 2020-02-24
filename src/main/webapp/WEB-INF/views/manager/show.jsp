<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShowAll TeamManager</title>
</head>
<body>
  

  <h1>Show all TeamManager</h1><br>
  
	<table>
		<tr>
			<th>Country</th>
			<th>Team Name</th>
			<th>Manager Name</th>
		</tr>
		<c:forEach items="${manager_list }" var="manager">
			<tr>
				<th>${ manager.team.country.countryName}</th>
				<th>${ manager.team.teamName }</th>
				<th>${ manager.user.username }</th>
				<th><a href="details?managerId=${manager.managerId}">Show Details</a></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>