<!doctype html>
<html>
	<head>
		<g:if test="${!request.xhr}"><meta name="layout" content="main"></g:if>
		<title>Twitter Results for '${q}'</title>
		<r:use module="graphs"/>
		<r:script disposition="head">
			$(function() {
				if (Modernizr.canvas) {
					$('#twitter-users').visualize({
						width: 800,
						height: 300
					});
				}
			});
		</r:script>
	</head>

	<body>

		<table id="twitter-users">
			<caption>Twitter users</caption>
			<thead>
				<tr>
					<td></td>
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