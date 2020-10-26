<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h2>Sign in to Jingle</h2>
<form:form method="POST" action="handleLogin" modelAttribute="credentials">
		<table>
		<tr><td><form:label path="username">User Name</form:label></td><td><form:input path="username"/><form:errors path="username"/></td></tr>
			<tr><td><form:label path="password">Password</form:label></td><td><form:input path="password"/><form:errors path="password"/></td></tr>
			<tr><td></td><td><input class="main-button" type="submit" value="Submit" /></td></tr>
			<tr><td></td><td><form:errors path="*"/></td></tr>
		</table>
	</form:form>
	New to Jingle? <a href="../user/register">Sign up.</a>