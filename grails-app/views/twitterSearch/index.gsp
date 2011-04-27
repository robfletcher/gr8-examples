<!doctype html>
<html>
<head>
	<g:if test="${!request.xhr}"><meta name="layout" content="main"></g:if>
	<title>Twitter Results for '${q}'</title>
	<r:use module="scroll"/>
</head>
<body>
	<section id="twitter-search-results">
		<g:render template="tweet" collection="${results}"/>
		<nav class="pagination">
			<g:if test="${page > 1}">
				<g:link params="[page: page - 1, q: q]" class="prev">Previous</g:link>
			</g:if>
			<g:if test="${results.size() > 0}">
				<g:link params="[page: page + 1, q: q]" class="next">Next</g:link>
			</g:if>
		</nav>
	</section>
</body>
</html>