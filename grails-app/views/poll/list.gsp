<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Poll</title>
		<r:use modules="polls"/>
	</head>
	<body>
		<ul>
			<g:each var="poll" in="${polls}">
				<li>
					<h2>${poll.question}</h2>
					<span class="votes">${gr8.examples.Vote.countByPoll(poll)}</span>
				</li>
			</g:each>
		</ul>
	</body>
</html>
