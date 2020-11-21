<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2>Sign-up for Jingle</h2>
<form:form method="POST" action="handleRegister" modelAttribute="user">
	<table>
		<tr>
			<td><form:label path="credentials.username">Username</form:label></td>
			<td><form:input path="credentials.username"
					placeholder="Username" /></td>
		</tr>
		<tr>
			<td><form:label path="credentials.password">Password</form:label></td>
			<td><form:input path="credentials.password"
					placeholder="Password" type="password" /></td>
		</tr>
		<tr>
			<td><form:label path="firstName">First Name</form:label></td>
			<td><form:input path="firstName" placeholder="First" /></td>
		</tr>
		<tr>
			<td><form:label path="lastName">Last Name</form:label></td>
			<td><form:input path="lastName" placeholder="Last" /></td>
		</tr>
		<tr>
			<td><form:label path="email">Email</form:label></td>
			<td><form:input path="email" placeholder="email@email.com" /></td>
		</tr>
		<tr>
			<td><form:label path="phone">Phone Number</form:label></td>
			<td><form:input path="phone" placeholder="1234567890" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input class="main-button" type="submit" value="Submit" /></td>
		</tr>
		<tr>
			<td></td>
			<td><form:errors path="*" /></td>
		</tr>
	</table>
</form:form>

Already have an account?
<a href="../user/login">Sign in</a>