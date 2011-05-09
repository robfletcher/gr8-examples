<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Album List</title>
		<r:use module="list"/>
	</head>
	<body>
		
		<section id="album-list">
			
			<table>
				<col class="cover">
				<col class="title">
				<col class="artist">
				<thead>
					<tr>
						<td></td>
						<g:sortableColumn property="title" title="Title"/>
						<g:sortableColumn property="artist" title="Artist"/>
					</tr>
				</thead>
				<tbody>
					<g:each var="album" in="${albums}">
						<tr>
							<td>
								<g:link controller="rating" action="album" id="${album.id}">
									<r:img uri="${album.cover?.toString()}" alt="${album}" class="small-cover"/>
								</g:link>
							</td>
							<td>${album.title}</td>
							<td>${album.artist}</td>
						</tr>
					</g:each>
				</tbody>
			</table>
			
			<nav class="pagination">
				<g:paginate total="${total}"/>
			</nav>
			
		</section>
		
	</body>
</html>
