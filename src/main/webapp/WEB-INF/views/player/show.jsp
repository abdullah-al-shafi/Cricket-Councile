<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShowAll Player</title>
</head>
<body>
  
  <h1>Team- ${team} Players</h1>
  
	<table>
		<tr>
			<th>User Name</th>
			<th>Player Name</th>
			<th>Player DOB</th>
			<th>Playing Role</th>
		</tr>
		<c:forEach items="${player_list }" var="player">
			<tr>
				<th>${ player.firstName}</th>
				<th>${ player.firstName} ${ player.lastName }</th>
				<th>${ player.dob}</th>
				<th>${ player.playingRole}</th>
				<th><a href="player-edit?palyerId=${player.palyerId}">Edit</a></th>
				<th><a href="player-delete?palyerId=${player.palyerId}">Delete</a></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>