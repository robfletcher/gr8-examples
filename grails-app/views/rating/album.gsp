<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>${album.title}</title>
		<r:use modules="forms,lightbox,basket"/>
	</head>
	<body>

		<article id="album">
			<r:img uri="${album.cover.toString()}" alt="${album}" class="large-cover"/>
			<hgroup>
				<h1 class="title">${album.title}</h1>
				<h2 class="artist">${album.artist}</h2>
			</hgroup>
			
			<section id="add-to-basket">
				<span class="price"><g:formatNumber number="${album.price}" type="currency" currencyCode="GBP" /></span>
				<g:form controller="basket" action="add">
					<input type="hidden" name="id" value="${album.id}">
					<button type="submit">Add to basket</button>
				</g:form>
			</section>

			<section id="average-rating">
				<h3>Average rating:</h3>
				<div class="rating">${album.averageRating}</div>
			</section>

			<section id="your-rating">
				<h3>Your rating:</h3>
				<g:form action="rate" class="rating">
					<input type="hidden" name="id" value="${album.id}">
					<g:radioGroup name="score" values="${1..5}" labels="${1..5}" value="${rating?.score}">
						<label><span class="num">${it.label}</span>${it.radio}</label>
					</g:radioGroup>
					<input type="submit" value="Rate">
				</g:form>
			</section>

			<ol class="tracks">
				<g:each in="${album.tracks}">
					<li>${it}</li>
				</g:each>
			</ol>
		</article>

		<aside id="related">
			<header><h1>People who bought <em>${album.title}</em> also bought&hellip;</h1></header>
			<ul>
				<g:each var="relatedAlbum" in="${related}">
					<li>
						<g:link action="album" id="${relatedAlbum.id}">
							<article class="album">
								<r:img uri="${relatedAlbum.cover?.toString()}" alt="${relatedAlbum.title} by ${relatedAlbum.artist}" class="small-cover"/>
								<hgroup>
									<h1 class="title">${relatedAlbum.title}</h1>
									<h2 class="artist">${relatedAlbum.artist}</h2>
								</hgroup>
							</article>
						</g:link>
					</li>
				</g:each>
			</ul>
		</aside>

	</body>
</html>