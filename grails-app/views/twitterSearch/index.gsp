<!doctype html>
<html>
<head>
	<meta name="layout" content="main">
	<title>Twitter Results for '${query}'</title>
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
	</section>
</body>
</html>