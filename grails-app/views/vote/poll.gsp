<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>${poll.question}</title>
	</head>
	<body>
		<g:form action="cast">
			<input type="hidden" name="id" value="${poll.id}">
			<fieldset>
				<legend>${poll.question}</legend>
				<ol>
					<g:each var="answer" in="${poll.answers}" status="i">
						<li>
							<label><input type="radio" name="answer" value="${i}">${answer}</label>
						</li>
					</g:each>
				</ol>
				<button type="submit">Vote</button>
			</fieldset>
		</g:form>
	</body>
</html>
