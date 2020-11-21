<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>View My Upload</h2>
<table id="song" class="display">
	<tr>
		<th>Title</th>
		<th>Artist</th>
		<th>Album</th>
		<th>Year</th>
		<th>Length</th>
		<th>Genre</th>
	</tr>
	<tr>
		<td><c:out value="${song.title}" /></td>
		<td><c:out value="${song.artist}" /></td>
		<td><c:out value="${song.album}" /></td>
		<td><c:out value="${song.year}" /></td>
		<td><c:out value="${song.length}" /></td>
		<td><c:out value="${song.genre}" /></td>
	</tr>
</table>

<form:form method="POST" action="edit" modelAttribute="song">
	<form:input type="hidden" path="id" value="${song.id}" />
	<form:input type="hidden" path="title" value="${song.title}" />
	<form:input type="hidden" path="artist" value="${song.artist}" />
	<form:input type="hidden" path="album" value="${song.album}" />
	<form:input type="hidden" path="year" value="${song.year}" />
	<form:input type="hidden" path="length" value="${song.length}" />
	<form:input type="hidden" path="genre" value="${song.genre}" />
	<form:input type="hidden" path="users_id" value="${song.users_id}" />
	<input class="main-button" type="submit" value="Edit" />
</form:form>

<form:form method="POST" action="delete" modelAttribute="song">
	<form:input type="hidden" path="id" value="${song.id}" />
	<form:input type="hidden" path="title" value="${song.title}" />
	<form:input type="hidden" path="artist" value="${song.artist}" />
	<form:input type="hidden" path="album" value="${song.album}" />
	<form:input type="hidden" path="year" value="${song.year}" />
	<form:input type="hidden" path="length" value="${song.length}" />
	<form:input type="hidden" path="genre" value="${song.genre}" />
	<form:input type="hidden" path="users_id" value="${song.users_id}" />
	<input class="main-button" type="submit" value="Delete" />
</form:form>

<form:form method="GET" action="uploads">
	<input class="main-button" type="submit" value="Back" />
</form:form>

<script>
	$(document).ready(function() {
		$('#song').DataTable();
	});
</script>