<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<c:choose>
		<c:when test="${sessionUser != null}">
			<p>Welcome ${sessionUser.firstName}, this is the home page.</p>
		</c:when>
		<c:otherwise>
			<p>Welcome, this is the home page.</p>
		</c:otherwise>
	</c:choose>
</div>