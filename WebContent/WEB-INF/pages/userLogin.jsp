<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2>Sign in to Jingle</h2>
<form:form method="POST" action="handleLogin"
	modelAttribute="credentials">
	<table>
		<tr>
			<td><form:label path="username">Username</form:label></td>
			<td><form:input path="username" placeholder="Username" /></td>
		</tr>
		<tr>
			<td><form:label path="password">Password</form:label></td>
			<td><form:input type="password" placeholder="Password"
					path="password" /></td>
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

New to Jingle?
<a href="../user/register">Sign up</a>