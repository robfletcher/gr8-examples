<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>${poll.question}</title>
		<r:use modules="polls"/>
	</head>
	<body>
		<table class="poll-results">
			<caption>${poll.question}</caption>
			<thead>
				<tr>
					<td></td>
					<th scope="col">Votes</th>
				</tr>
			</thead>
			<tbody>
				<g:each var="answer" in="${poll.answers}" status="i">
					<tr>
						<th scope="row">${answer}</th>
						<td class="votes">${gr8.examples.Vote.countByPollAndAnswer(poll, i)}</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</body>
</html>