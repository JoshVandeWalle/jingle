<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Browse Songs</h2>
<script>
	function goToUpload() {
		window.location.href = "../song/handleDisplayUploadPage";
	}
</script>
<table>
	<tr>
		<th></th>
		<th>Title</th>
		<th>Artist</th>
		<th>Album</th>
		<th>Year</th>
		<th>Length</th>
		<th>Genre</th>
	</tr>
	<c:forEach var="song" items="${songs}">
		<tr>
			<td><form:form method="POST" action="song"
					modelAttribute="viewSong">
					<form:input type="hidden" path="id" value="${song.id}" />
					<form:input type="hidden" path="title" value="${song.title}" />
					<form:input type="hidden" path="artist" value="${song.artist}" />
					<form:input type="hidden" path="album" value="${song.album}" />
					<form:input type="hidden" path="year" value="${song.year}" />
					<form:input type="hidden" path="length" value="${song.length}" />
					<form:input type="hidden" path="genre" value="${song.genre}" />
					<form:input type="hidden" path="users_id" value="${song.users_id}" />
					<input class="main-button" type="submit" value="View" />
				</form:form></td>
			<td><c:out value="${song.title}" /></td>
			<td><c:out value="${song.artist}" /></td>
			<td><c:out value="${song.album}" /></td>
			<td><c:out value="${song.year}" /></td>
			<td><c:out value="${song.length}" /></td>
			<td><c:out value="${song.genre}" /></td>
		</tr>
	</c:forEach>
</table>
<input class="main-button" type="button" onclick=goToUpload()
	value="Add" />
