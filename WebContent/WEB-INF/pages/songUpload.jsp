<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h2>Add your song!</h2>
<form:form method="POST" action="handleUpload" modelAttribute="song">
		<table>
		<tr><td><form:label path="title">Title</form:label></td><td><form:input path="title"/><form:errors path="title"/></td></tr>
			<tr><td><form:label path="artist">Artist</form:label></td><td><form:input type="text" path="artist"/><form:errors path="artist"/></td></tr>
			<tr><td><form:label path="album">Album</form:label></td><td><form:input path="album"/><form:errors path="album"/></td></tr>
			<tr><td><form:label path="year">Year</form:label></td><td><form:input path="year"/><form:errors path="year"/></td></tr>
			<tr><td><form:label path="length">Length</form:label></td><td><form:input path="length"/><form:errors path="length"/></td></tr>
			<tr><td><form:label path="genre">Genre</form:label></td><td><form:input path="genre"/><form:errors path="genre"/></td></tr>
			<tr><td></td><td><input class="main-button" type="submit" value="Submit" /></td></tr>
			<tr><td></td><td><form:errors path="*"/></td></tr>
		</table>
	</form:form>