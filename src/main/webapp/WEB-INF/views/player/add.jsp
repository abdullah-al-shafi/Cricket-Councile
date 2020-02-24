
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Add Player</title>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
  $( function() {
    $( "#dob" ).datepicker({
    	inline: true,
    	formate:'yyyy, mm, dd'
    });
  } );
  </script>

</head>
<body>
	<h2>Add New Player</h2>

	<form:form action="${pageContext.request.contextPath}/player/add"
		modelAttribute="player">
		
		<label>First Name: </label>
		<form:input path="firstName" />
		<a>(User name)</a>
		<br>
		<br>

		<label>Last Name: </label>
		<form:input path="lastName" />
		<br>
		<br>

		<label>Date of Birth</label>
		<form:input path="dob" />
		<br>
		<br>

		<label>Playing Role</label>
		<form:radiobuttons path="playingRole" items="${playingRole_list}"></form:radiobuttons>

		<br>
		<br>
		<input type="submit" name="submit" value="submit" />
	</form:form>
</body>
</html>
