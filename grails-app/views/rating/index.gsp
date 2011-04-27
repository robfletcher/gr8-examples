<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>${album}</title>
		<r:use module="forms"/>
	</head>
	<body>

		<article id="album">
			<r:img uri="${album.cover.toString()}" alt="${album}" class="large-cover"/>
			<hgroup>
				<h1 class="title">${album.title}</h1>
				<h2 class="artist">${album.artist}</h2>
			</hgroup>
			<ol class="tracks">
				<g:each in="${album.tracks}">
					<li>${it}</li>
				</g:each>
			</ol>

			<g:form action="rate" class="rating">
				<fieldset>
					<legend>Rating:</legend>
					<input type="hidden" name="id" value="${album.id}">
					<g:radioGroup name="rating" values="${1..5}" labels="${1..5}">
						<label><span class="num">${it.label}</span>${it.radio}</label>
					</g:radioGroup>
				</fieldset>
			</g:form>
		</article>

		<aside id="related">
			<header><h1>People who bought <em>${album}</em> also bought&hellip;</h1></header>
			<ul>
				<g:each in="${related}">
					<li>
						<article class="album">
							<r:img uri="${it.cover.toString()}" alt="${it.title} by ${it.artist}" class="small-cover"/>
							<hgroup>
								<h1 class="title">${it.title}</h1>
								<h2 class="artist">${it.artist}</h2>
							</hgroup>
						</article>
					</li>
				</g:each>
			</ul>
		</aside>

	</body>
</html>