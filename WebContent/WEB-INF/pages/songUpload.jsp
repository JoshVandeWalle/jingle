<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2>Upload your song</h2>
<form:form method="POST" action="handleUpload" modelAttribute="song">
	<table>
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