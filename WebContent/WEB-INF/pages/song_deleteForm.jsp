<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2>Are you sure you would like to delete your song, ${song.title}?</h2>
<form:form method="POST" action="handleDelete" modelAttribute="song">
	<form:input type="hidden" path="id" value="${song.id}" />
	<form:input type="hidden" path="title" value="${song.title}" />
	<form:input type="hidden" path="artist" value="${song.artist}" />
	<form:input type="hidden" path="album" value="${song.album}" />
	<form:input type="hidden" path="year" value="${song.year}" />
	<form:input type="hidden" path="length" value="${song.length}" />
	<form:input type="hidden" path="genre" value="${song.genre}" />
	<form:input type="hidden" path="users_id" value="${song.users_id}" />
	<input class="main-button" type="submit" value="Yes" />
</form:form>

<form:form method="GET" action="uploads">
	<input class="main-button" type="submit" value="No" />
</form:form>