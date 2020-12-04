<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2>Registration</h2>
<form:form method="POST" action="handleRegister" modelAttribute="user" class="w-50">
	<div class="form-group row">
		<form:label path="credentials.username" class="col-sm-2 col-form-label">Username</form:label>
		<div class="col-sm-10">
			<form:input path="credentials.username" type="text" class="form-control" placeholder="Username" />
		</div>
	</div>
	<div class="form-group row">
		<form:label path="credentials.password" class="col-sm-2 col-form-label">Password</form:label>
		<div class="col-sm-10">
			<form:input path="credentials.password" type="password" class="form-control" placeholder="Password" />
		</div>
	</div>
	<div class="form-group row">
		<form:label path="firstName" class="col-sm-2 col-form-label">First Name</form:label>
		<div class="col-sm-10">
			<form:input path="firstName" type="text" class="form-control" placeholder="First Name" />
		</div>
	</div>
	<div class="form-group row">
		<form:label path="lastName" class="col-sm-2 col-form-label">Last Name</form:label>
		<div class="col-sm-10">
			<form:input path="lastName" type="text" class="form-control" placeholder="Last Name" />
		</div>
	</div>
	<div class="form-group row">
		<form:label path="email" class="col-sm-2 col-form-label">Email</form:label>
		<div class="col-sm-10">
			<form:input path="email" type="email" class="form-control" placeholder="email@email.com" />
		</div>
	</div>
	<div class="form-group row">
		<form:label path="phone" class="col-sm-2 col-form-label">Phone Number</form:label>
		<div class="col-sm-10">
			<form:input path="phone" type="number" class="form-control" placeholder="1234567890" />
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-10 offset-sm-2">
			<form:errors path="*" />
		</div>
	</div>
	<div class="justify-content-center">
		<button type="submit" class="btn btn-danger">Sign up</button>
	</div>
</form:form>

Already have an account?
<a href="../user/login">Sign in</a>