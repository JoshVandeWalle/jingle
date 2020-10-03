<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h2>Sign-up for Jingle</h2>
<form:form method="POST" action="handleRegister" modelAttribute="user">
		<table>
		<tr><td><form:label path="credentials.username">User Name</form:label></td><td><form:input path="credentials.username"/><form:errors path="credentials.username"/></td></tr>
			<tr><td><form:label path="credentials.password">Password</form:label></td><td><form:input type="password" path="credentials.password"/><form:errors path="credentials.password"/></td></tr>
			<tr><td><form:label path="firstName">First Name</form:label></td><td><form:input path="firstName"/><form:errors path="firstName"/></td></tr>
			<tr><td><form:label path="lastName">Last Name</form:label></td><td><form:input path="lastName"/><form:errors path="lastName"/></td></tr>
			<tr><td><form:label path="email">Email</form:label></td><td><form:input path="email"/><form:errors path="email"/></td></tr>
			<tr><td><form:label path="phone">Phone Number</form:label></td><td><form:input path="phone"/><form:errors path="phone"/></td></tr>
			<tr><td></td><td><input class="main-button" type="submit" value="Submit" /></td></tr>
			<tr><td></td><td><form:errors path="*"/></td></tr>
		</table>
	</form:form>