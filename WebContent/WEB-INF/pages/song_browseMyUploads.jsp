<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Browse My Uploads</h2>
<table id="songs" class="display">
	<thead>
		<tr>
			<th>Title</th>
			<th>Artist</th>
			<th>Album</th>
			<th>Year</th>
			<th>Length</th>
			<th>Genre</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="song" items="${songs}">
			<tr onclick=goToSong(${song.id})>
				<form:form id="${song.id}" method="POST" action="song" modelAttribute="viewSong">
					<form:input type="hidden" path="id" value="${song.id}" />
				</form:form>
				<td><c:out value="${song.title}" /></td>
				<td><c:out value="${song.artist}" /></td>
				<td><c:out value="${song.album}" /></td>
				<td><c:out value="${song.year}" /></td>
				<td><c:out value="${song.length}" /></td>
				<td><c:out value="${song.genre}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<form:form method="GET" action="upload">
	<button type="submit" class="btn btn-danger">Upload</button>
</form:form>

<script>
	$(document).ready(function() {
		$('#songs').DataTable();
	});
	
	function goToSong(id) {
		$("#" + id).submit();
	}
</script>