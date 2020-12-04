<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2>Login</h2>
<form:form method="POST" action="handleLogin" modelAttribute="credentials" class="w-25">
	<div class="form-group row">
		<form:label path="username" class="col-sm-2 col-form-label">Username</form:label>
		<div class="col-sm-10">
			<form:input path="username" type="text" class="form-control" placeholder="Username" />
		</div>
	</div>
	<div class="form-group row">
		<form:label path="password" class="col-sm-2 col-form-label">Password</form:label>
		<div class="col-sm-10">
			<form:input path="password" type="password" class="form-control" placeholder="Password" />
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-10 offset-sm-2">
			<form:errors path="*" />
		</div>
	</div>
	<div class="justify-content-center">
		<button type="submit" class="btn btn-danger">Sign in</button>
	</div>
</form:form>

New to Jingle?
<a href="../user/register">Sign up</a>