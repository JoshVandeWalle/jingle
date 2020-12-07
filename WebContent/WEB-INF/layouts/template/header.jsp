<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-expand-md navbar-dark bg-danger">
	<a href="../home/" class="navbar-brand"> Jingle</a>
	<button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<c:choose>
			<c:when test="${sessionData != null}">
				<div class="navbar-nav">
					<a href="../home/" class="nav-item nav-link active">Home</a> 
					<a href="../song/browse" class="nav-item nav-link active">Browse</a> 
					<a href="../user/library"class="nav-item nav-link active">Library</a>
					<a href="../song/uploads"class="nav-item nav-link active">My Uploads</a>
				</div>
				<div class="navbar-nav ml-auto">				
					<a href="../user/myProfile" class="nav-item nav-link active">${sessionData.username}</a>
					<a href="" class="nav-item nav-link active">|</a>
					<a href="../user/login" class="nav-item nav-link active">Sign out</a> 
				</div>
			</c:when>
			<c:otherwise>
				<div class="navbar-nav ml-auto">
					<a href="../user/login" class="nav-item nav-link active">Sign in</a> 
					<a href="../user/register" class="nav-item nav-link active">Sign up</a> 
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</nav>

