<!-- GLOBAL HEADER -->
<jsp:include page="common/header.jsp" />

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="common/header.jsp" />

<link
	href="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/font-awesome.min.css">

<!-- COURSE COVER IMAGE -->
<img src="${pageContext.request.contextPath }/images/course_cover.jpg"
	height="500px" class="w-100" />


<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">


	<a href="${pageContext.request.contextPath }/logout" role="button"> ${role}(LogOut) </a> 

	<sec:authorize access="hasRole('ADMIN')">

		<div class="row">
			<!-- HOMEWORK COLUMN-->
			<div class="col">
				<h3 class="p-3">Homework</h3>

				<div class="row">
					<div class="col-sm-12">
						<div class="card mb-2">
							<div class="card-body">
								<h4 class="card-title pb-3">Countries</h4>
								<p class="card-text">


									<a class="btn btn-success btn-lg btn-block"
										href="${pageContext.request.contextPath }/country/add"
										role="button">ADD</a> <a
										class="btn btn-primary btn-lg btn-block"
										href="${pageContext.request.contextPath }/country/show-all"
										role="button">SHOW ALL</a>
										<a
										class="btn btn-primary btn-lg btn-block"
										href="${pageContext.request.contextPath }/country/inactive"
										role="button">InActive Country</a>
								</p>

							</div>
						</div>
					</div>

					<div class="col-sm-12">
						<div class="card mb-2">
							<div class="card-body">
								<h4 class="card-title pb-3">Team</h4>
								<p class="card-text">
									<a class="btn btn-success btn-lg btn-block"
										href="${pageContext.request.contextPath }/team/add"
										role="button">ADD TEAM</a> <a
										class="btn btn-primary btn-lg btn-block"
										href="${pageContext.request.contextPath }/team/show"
										role="button">SHOW ALL</a>
								</p>
							</div>
						</div>
					</div>

					<div class="col-sm-12">
						<div class="card mb-2">
							<div class="card-body">
								<h4 class="card-title pb-3">Manager</h4>
								<p class="card-text">
									<a class="btn btn-success btn-lg btn-block"
										href="${pageContext.request.contextPath }/manager/add"
										role="button">ADD Manager</a> <a
										class="btn btn-primary btn-lg btn-block"
										href="${pageContext.request.contextPath }/manager/show-all"
										role="button">SHOW ALL</a>
								</p>
							</div>
						</div>
					</div>


				</div>

			</div>





		</div>

	</sec:authorize>

	<sec:authorize access="hasRole('MANAGER')">

		<form:form modelAttribute="manager">

			<div class="container">
				<div class="row">
					<div class="col-md-offset-2 col-md-8 col-lg-offset-3 col-lg-6">
						<div class="well profile">
							<div class="col-sm-12">
								<div class="col-xs-12 col-sm-8">
									<h2>${manager.user.username}</h2>
									<p>
										<strong>DOB: </strong> ${manager.dob}
									</p>
									<p>
										<strong>Phone Number: </strong> ${manager.phone}
									</p>
									<p>
										<strong>Team: </strong> <span class="tags">${manager.team.teamName}</span>
									</p>
									<p>
										<strong>Country: </strong> <span class="tags">${manager.team.country.countryName}</span>
									</p>
								</div>

							</div>


						</div>
					</div>
				</div>
			</div>

		</form:form>

		<div class="col-sm-12">
			<div class="card mb-2">
				<div class="card-body">
					<h4 class="card-title pb-3">Player</h4>
					<p class="card-text">
						<a class="btn btn-success btn-lg btn-block"
							href="${pageContext.request.contextPath }/player/add"
							role="button">ADD Player</a> <a
							class="btn btn-primary btn-lg btn-block"
							href="${pageContext.request.contextPath }/player/show-all"
							role="button">SHOW ALL</a>
							<a
							class="btn btn-primary btn-lg btn-block"
							href="${pageContext.request.contextPath }/search-page"
							role="button">SEARCH PLAYER</a>
					</p>
				</div>
			</div>
		</div>




	</sec:authorize>



</div>

<!-- GLOBAL FOOTER -->
<jsp:include page="common/footer.jsp" />
