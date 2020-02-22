<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Team</title>
</head>
<body>

	<h1>Add New Team</h1>

	<form:form action="${pageContext.request.contextPath }/team/add"
		modelAttribute="team">
		<div class="form-group">
			<label>Team Name</label>
			<form:input path="teamName"></form:input>
		</div>

		<br>


		<div class="form-group">
			<label>Select a country</label>
			<form:select class="form-control" path="countryId">
				<form:options items="${countries}" itemLabel="countryName"
					itemValue="countryId"></form:options>
			</form:select>
		</div>

		<br>
		<input type="submit" name="submit" value="Add Team">
	</form:form>

</body>
</html>