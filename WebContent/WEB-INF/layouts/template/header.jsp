<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<ul>
		<c:choose>
		<c:when test="${sessionUser != null}">
		<li class='welcome-msg'>Welcome to Jingle</li>
		<li><a href='../user/login'>Sign Out</a></li>
		<li><a href='../song/'>Songs</a></li>
		<li><a href='../user/home'>Home</a></li></c:when>
		
		
		<c:otherwise>
		<li class='welcome-msg'>Welcome to Jingle</li>
		<li><a href='../user/register'>Sign up</a></li>
		<li><a href='../user/login'>Sign in</a></li></c:otherwise>
		</c:choose>
		
		
		
		
		<!-- <li class="welcome-msg">Welcome to Jingle</li>
		<li><a href="../user/login">Sign Out</a></li>
		<li><a href="../song/">Songs</a></li>
		<li><a href="../user/home">Home</a></li> -->
	</ul>

