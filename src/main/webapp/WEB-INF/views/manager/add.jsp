
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Manager</title>
    
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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
    <h2>Add Manager page</h2>

    <form:form action="${pageContext.request.contextPath}/manager/add" modelAttribute="manager">
        <label>Name: </label>
        <form:input path="name"/></br></br>

        <label>Date of Birth</label>
        <form:input path="dob"/></br></br>

        <label>Phone: </label>
        <form:input path="phone"/></br></br>

        <form:select path="teamId" items="${team_list}" itemValue="teamId" itemLabel="teamName"/>

        <input type="submit" name="submit" value="submit"/>
    </form:form>
</body>
</html>
