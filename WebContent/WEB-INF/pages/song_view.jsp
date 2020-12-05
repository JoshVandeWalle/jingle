<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>View Song</h2>
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

<form:form method="GET" action="browse">
	<button type="submit" class="btn btn-danger">Back</button>
</form:form>

<script>
	$(document).ready(function() {
		$('#song').DataTable();
	});
</script>