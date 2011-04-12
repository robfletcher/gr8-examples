<!doctype html>
<html>
<head>
	<meta name="layout" content="main">
	<title>Twitter Results for '${q}'</title>
</head>
<body>
	<section class="twitter-search-results">
		<g:each var="result" in="${results}">
			<article class="tweet">
				<header>
					<h3>${result.from_user}</h3>
					<img src="${result.profile_image_url}" class="profile-image">
				</header>
				<p>${result.text}</p>
				<time>${result.created_at}</time>
			</article>
		</g:each>
		<nav class="pagination">
			<g:if test="${page > 1}">
				<g:link params="[page: page - 1, q: q]">Previous</g:link>
			</g:if>
			<g:if test="${results.size() > 0}">
				<g:link params="[page: page + 1, q: q]">Next</g:link>
			</g:if>
		</nav>
	</section>
</body>
</html>