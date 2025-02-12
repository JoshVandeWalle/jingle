<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:choose>
	<c:when test="${user.id == sessionData.users_id}">
		<h2>My Profile</h2>
	</c:when>
	<c:otherwise>
		<h2>${user.credentials.username}'s Profile</h2>
	</c:otherwise>
</c:choose>
<div class="page-content page-container" id="page-content">
	<div class="padding">
		<div class="row container d-flex justify-content-center">
			<div class="col-xl-6 col-md-12">
				<div class="card user-card-full">
					<div class="row m-l-0 m-r-0">
						<div class="col-sm-4 bg-c-lite-green user-profile">
							<div class="card-block text-center text-white">
								<div class="m-b-25">
									<img src="https://img.icons8.com/bubbles/100/000000/user.png" class="img-radius" alt="User-Profile-Image">
								</div>
								<h6 class="f-w-600">${user.firstName} ${user.lastName}</h6>
								<c:choose>
									<c:when test="${user.credentials.role != 0}">
										<p>Administrator</p>
									</c:when>
									<c:otherwise>
										<p>User</p>
									</c:otherwise>
								</c:choose>
								<i class=" mdi mdi-square-edit-outline feather icon-edit m-t-10 f-16"></i>
							</div>
						</div>
						<div class="col-sm-8">
							<div class="card-block">
								<h6 class="m-b-20 p-b-5 b-b-default f-w-600">Username</h6>
								<p class="m-b-20 p-b-5 justify-content-center f-w-600">${user.credentials.username}</p>
								<h6 class="m-b-20 p-b-5 b-b-default f-w-600">Email</h6>
								<p class="m-b-20 p-b-5 justify-content-center f-w-600">${user.email}</p>
								<h6 class="m-b-20 p-b-5 b-b-default f-w-600">Phone</h6>
								<p class="m-b-20 p-b-5 justify-content-center f-w-600">${user.phone}</p>
								<%-- <h6 class="m-b-20 p-b-5 b-b-default f-w-600">Information</h6>
								<div class="row">
									<div class="col-sm-6">
										<p class="m-b-10 f-w-600">Email</p>
										<h6 class="text-muted f-w-400">${user.email}</h6>
									</div>
									<div class="col-sm-6">
										<p class="m-b-10 f-w-600">Phone</p>
										<h6 class="text-muted f-w-400">${user.phone}</h6>
									</div>
								</div>
								<h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Projects</h6>
								<div class="row">
									<div class="col-sm-6">
										<p class="m-b-10 f-w-600">Recent</p>
										<h6 class="text-muted f-w-400">Sam Disuja</h6>
									</div>
									<div class="col-sm-6">
										<p class="m-b-10 f-w-600">Most Viewed</p>
										<h6 class="text-muted f-w-400">Dinoter husainm</h6>
									</div>
								</div> --%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:choose>
	<c:when test="${user.id == sessionData.users_id}">
		<form:form method="GET" action="edit" modelAttribute="user">
			<form:input type="hidden" path="id" value="${user.id}" />
			<button type="submit" class="btn btn-danger">Edit</button>
		</form:form>
	</c:when>
	<c:otherwise>
		<form:form method="GET" action="../song/browse">
			<button type="submit" class="btn btn-danger">Back</button>
		</form:form>
	</c:otherwise>
</c:choose>