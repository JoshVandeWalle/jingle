<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2>Edit Your Song</h2>
<form:form method="POST" action="handleEdit" modelAttribute="song" class="w-25">
	<form:input path="id" type="hidden" value="${song.id}" />
	<div class="form-group row">
		<form:label path="title" class="col-sm-2 col-form-label">Title</form:label>
		<div class="col-sm-10">
			<form:input path="title" type="text" class="form-control" placeholder="Title" />
		</div>
	</div>
	<div class="form-group row">
		<form:label path="artist" class="col-sm-2 col-form-label">Artist</form:label>
		<div class="col-sm-10">
			<form:input path="artist" type="text" class="form-control" placeholder="Artist" />
		</div>
	</div>
	<div class="form-group row">
		<form:label path="album" class="col-sm-2 col-form-label">Album</form:label>
		<div class="col-sm-10">
			<form:input path="album" type="text" class="form-control" placeholder="Album" />
		</div>
	</div>
	<div class="form-group row">
		<form:label path="year" class="col-sm-2 col-form-label">Year</form:label>
		<div class="col-sm-10">
			<form:input path="year" type="number" class="form-control" placeholder="2020" />
		</div>
	</div>
	<div class="form-group row">
		<form:label path="length" class="col-sm-2 col-form-label">Length</form:label>
		<div class="col-sm-10">
			<form:input path="length" type="text" class="form-control" placeholder="00:00" />
		</div>
	</div>
	<div class="form-group row">
		<form:label path="genre" class="col-sm-2 col-form-label">Genre</form:label>
		<div class="col-sm-10">
			<form:input path="genre" type="text" class="form-control" placeholder="Genre" />
		</div>
	</div>
	<form:input path="users_id" type="hidden" value="${song.users_id}" />
	<div class="form-group row">
		<div class="col-sm-10 offset-sm-2">
			<form:errors path="*" />
		</div>
	</div>
	<div class="justify-content-center">
		<button type="submit" class="btn btn-danger">Submit</button>
	</div>
</form:form>

<form:form method="POST" action="song" modelAttribute="song">
	<form:input type="hidden" path="id" value="${song.id}" />
	<form:input type="hidden" path="title" value="${song.title}" />
	<form:input type="hidden" path="artist" value="${song.artist}" />
	<form:input type="hidden" path="album" value="${song.album}" />
	<form:input type="hidden" path="year" value="${song.year}" />
	<form:input type="hidden" path="length" value="${song.length}" />
	<form:input type="hidden" path="genre" value="${song.genre}" />
	<form:input type="hidden" path="users_id" value="${song.users_id}" />
	<button type="submit" class="btn btn-danger">Cancel</button>
</form:form>