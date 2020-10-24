<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<script>
		function goToUpload() {
			window.location.href = "../song/handleDisplayUploadPage";
		}
	</script>
	<table>
		<tr><th>Title</th><th>Artist</th><th>Album</th><th>Year</th><th>Length</th><th>Genre</th></tr>
			<c:forEach var="item" items="${list}">
				<tr><td><c:out value="${item.title}"/></td><td><c:out value="${item.artist}"/></td><td><c:out value="${item.album}"/></td>
				<td><c:out value="${item.year}"/></td><td><c:out value="${item.length}"/></td><td><c:out value="${item.genre}"/></td></tr>
			</c:forEach>
	</table>
	<input class="main-button" type="button" onclick=goToUpload() value="Add" />
	