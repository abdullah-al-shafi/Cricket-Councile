<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShowAll Team</title>
</head>
<body>
  

  <h1>Show all Team</h1><br>
  
	<table>
		<tr>
			<th>Country</th>
			<th>Team Name</th>
		</tr>
		<c:forEach items="${team_list }" var="team">
			<tr>
				<th>${ team.country.countryName}</th>
				<th>${ team.teamName }</th>
				<th><a href="edit?temId=${team.teamId}">Edit</a></th>
				<th><a href="delete?teamId=${team.teamId}">Delete</a></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>