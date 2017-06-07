<nav class="navbar navbar-inverse">
	<a class="navbar-brand" href="#">1412281</a>
	<ul class="nav navbar-nav navbar-left">
		<li><a href="<c:url value='/product' />">List product</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li><a href="<c:url value="/user-details" />">${loggedinuser}</a></li>
		<li><a href="<c:url value="/logout" />">Logout </a></li>

	</ul>
</nav>