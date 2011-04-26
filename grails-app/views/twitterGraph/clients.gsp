<!doctype html>
<html>
	<head>
		<g:if test="${!request.xhr}"><meta name="layout" content="main"></g:if>
		<title>Twitter Results for '${q}'</title>
		<r:use module="twitter"/>
	</head>

	<body>

		<table id="twitter-clients">
			<caption>Twitter clients</caption>
			<thead>
				<tr>
					<th scope="col">Client</th>
					<th scope="col">Tweets</th>
				</tr>
			</thead>
			<tbody>
				<g:each in="${clients}">
					<tr>
						<th scope="row">${it.key}</th>
						<td>${it.value}</td>
					</tr>
				</g:each>
			</tbody>
		</table>

	</body>
</html>