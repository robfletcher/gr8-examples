<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Your Basket</title>
	</head>
	<body>
		<table>
			<tfoot>
				<td colspan="2"></td>
				<td>${total}</td>
			</tfoot>
			<tbody>
				<g:each var="line" in="${basket}">
					<tr>
						<td>${line.key}</td>
						<td>${line.value}</td>
						<td><g:formatNumber number="${line.value * line.key.price}" type="currency" currencyCode="GBP" /></td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</body>
</html>