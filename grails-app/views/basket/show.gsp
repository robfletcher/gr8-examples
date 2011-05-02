<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Your Basket</title>
		<r:use module="basket"/>
	</head>
	<body>
		<section class="your-basket">
			<g:render template="basket" bean="${basket}" var="basket"/>
		</section>
	</body>
</html>