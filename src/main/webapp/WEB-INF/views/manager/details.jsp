<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet"
          href="${pageContext.request.contextPath }/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>

	<form:form action="${pageContext.request.contextPath }/manager/details"
		modelAttribute="manager">
		
<div class="container">
	<div class="row">
		<div class="col-md-offset-2 col-md-8 col-lg-offset-3 col-lg-6">
    	 <div class="well profile">
            <div class="col-sm-12">
                <div class="col-xs-12 col-sm-8">
                    <h2>${manager.user.username}</h2>
                    <p><strong>DOB: </strong> ${manager.dob} </p>
                    <p><strong>Phone Number: </strong> ${manager.phone} </p>
                    <p><strong>Team: </strong>
                        <span class="tags">${manager.team.teamName}</span> 
                    </p>
                    <p><strong>Country: </strong>
                        <span class="tags">${manager.team.country.countryName}</span> 
                    </p>
                </div>             
                
            </div>
            
            <div class="col-xs-12 divider text-center">
                <div class="col-xs-12 col-sm-4 emphasis">
                                        
                    
                    <button class="btn btn-success btn-block" type="submit" formaction="edit?managerId=${manager.managerId}"> Edit Manager </button>
                </div>
                <div class="col-xs-12 col-sm-4 emphasis">
                                        
                    
                    <button class="btn btn-info btn-block" type="submit" formaction="delete?managerId=${manager.managerId}"> Delete Manager </button>
                </div>
                
            </div>            
    	 </div>                 
		</div>
	</div>
</div>
		
	</form:form>




</body>
</html>