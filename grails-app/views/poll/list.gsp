<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Pollr: Polls</title>
		<r:use modules="polls"/>
	</head>

	<body>
		<g:render template="list" bean="${polls}" var="polls"/>
		<g:paginate total="${pollCount}"/>
	</body>
</html>
