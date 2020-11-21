<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2>Edit Your Song</h2>
<form:form method="POST" action="handleEdit" modelAttribute="song">
	<table>
		<form:input type="hidden" path="id" value="${song.id}" />
		<tr>
			<td><form:label path="title">Title</form:label></td>
			<td><form:input path="title" placeholder="Title" /></td>
		</tr>
		<tr>
			<td><form:label path="artist">Artist</form:label></td>
			<td><form:input path="artist" placeholder="Artist" /></td>
		</tr>
		<tr>
			<td><form:label path="album">Album</form:label></td>
			<td><form:input path="album" placeholder="Album" /></td>
		</tr>
		<tr>
			<td><form:label path="year">Year</form:label></td>
			<td><form:input path="year" placeholder="2020" /></td>
		</tr>
		<tr>
			<td><form:label path="length">Length</form:label></td>
			<td><form:input path="length" placeholder="00:00" /></td>
		</tr>
		<tr>
			<td><form:label path="genre">Genre</form:label></td>
			<td><form:input path="genre" placeholder="Genre" /></td>
		</tr>
		<form:input type="hidden" path="users_id" value="${song.users_id}" />
		<tr>
			<td></td>
			<td><form:errors path="*" /></td>
		</tr>
	</table>
	<input class="main-button" type="submit" value="Submit" />
</form:form>
<form:form method="GET" action="uploads">
	<input class="main-button" type="submit" value="Cancel" />
</form:form>