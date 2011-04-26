<!doctype html>
<html>
	<head>
		<g:if test="${!request.xhr}"><meta name="layout" content="main"></g:if>
		<title>Twitter Results for '${q}'</title>
		<r:use module="twitter"/>
	</head>

	<body>

		<table id="twitter-users">
			<caption>Twitter users</caption>
			<thead>
				<tr>
					<th scope="col">User</th>
					<th scope="col">Tweets</th>
				</tr>
			</thead>
			<tbody>
				<g:each in="${users}">
					<tr>
						<th scope="row">
							<a href="http://twitter.com/#!/${it.key.name}" rel="nofollow" class="profile">
								<img src="${it.key.image}" alt="${it.key.name}">
								<span class="name">@${it.key.name}</span>
							</a>
						</th>
						<td>${it.value}</td>
					</tr>
				</g:each>
			</tbody>
		</table>

	</body>
</html>