<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Browse All Songs</h2>
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
			<tr>
				<form:form id="${song.id}" method="GET" action="song" modelAttribute="viewSong">
					<form:input type="hidden" path="id" value="${song.id}" />
				</form:form>
				<td><c:out value="${song.title}" /></td>
				<td onclick=goToSong(${song.id})><c:out value="${song.artist}" /></td>
				<td onclick=goToSong(${song.id})><c:out value="${song.album}" /></td>
				<td onclick=goToSong(${song.id})><c:out value="${song.year}" /></td>
				<td onclick=goToSong(${song.id})><c:out value="${song.length}" /></td>
				<td onclick=goToSong(${song.id})><c:out value="${song.genre}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	$(document).ready(function() {
		$('#songs').DataTable( {
		    responsive: true
		} );
	});
	
	function goToSong(id) {
		$("#" + id).submit();
	}
</script>