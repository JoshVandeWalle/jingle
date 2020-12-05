<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2>Are you sure you would like to delete your song, ${song.title}?</h2>
<form:form method="POST" action="handleDelete" modelAttribute="song">
	<form:input type="hidden" path="id" value="${song.id}" />
	<button type="submit" class="btn btn-danger">Yes</button>
</form:form>

<form:form method="GET" action="uploads">
	<button type="submit" class="btn btn-danger">No</button>
</form:form>