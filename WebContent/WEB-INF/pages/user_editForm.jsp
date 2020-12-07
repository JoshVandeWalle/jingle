<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2>Edit Your Profile</h2>
<form:form method="POST" action="handleEdit" modelAttribute="user" class="w-25">
	<form:input path="id" type="hidden" value="${user.id}" />
	<form:input path="credentials.id" type="hidden" value="${user.credentials.id}" />
	<div class="form-group row">
		<form:label path="credentials.username" class="col-sm-2 col-form-label">Username</form:label>
		<div class="col-sm-10">
			<form:input path="credentials.username" type="text" class="form-control" value="${user.credentials.username}"/>
		</div>
	</div>
	<div class="form-group row">
		<form:label path="credentials.password" class="col-sm-2 col-form-label">Password</form:label>
		<div class="col-sm-10">
			<form:input path="credentials.password" type="password" class="form-control" value="${user.credentials.password}"/>
		</div>
	</div>
	<div class="form-group row">
		<form:label path="firstName" class="col-sm-2 col-form-label">First Name</form:label>
		<div class="col-sm-10">
			<form:input path="firstName" type="text" class="form-control" value="${user.firstName}"/>
		</div>
	</div>
	<div class="form-group row">
		<form:label path="lastName" class="col-sm-2 col-form-label">Last Name</form:label>
		<div class="col-sm-10">
			<form:input path="lastName" type="text" class="form-control" value="${user.lastName}"/>
		</div>
	</div>
	<div class="form-group row">
		<form:label path="email" class="col-sm-2 col-form-label">Email</form:label>
		<div class="col-sm-10">
			<form:input path="email" type="email" class="form-control" value="${user.email}"/>
		</div>
	</div>
	<div class="form-group row">
		<form:label path="phone" class="col-sm-2 col-form-label">Phone Number</form:label>
		<div class="col-sm-10">
			<form:input path="phone" type="number" class="form-control" value="${user.phone}"/>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-10 offset-sm-2">
			<form:errors path="*" />
		</div>
	</div>
	<div class="justify-content-center">
		<button type="submit" class="btn btn-danger">Submit</button>
	</div>
</form:form>

<form:form method="GET" action="profile" modelAttribute="user">
	<form:input type="hidden" path="id" value="${user.id}" />
	<button type="submit" class="btn btn-danger">Cancel</button>
</form:form>