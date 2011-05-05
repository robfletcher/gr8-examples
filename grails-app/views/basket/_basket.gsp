<h2>Your basket</h2>

<g:if test="${basket}">

	<table class="basket">
		<thead>
			<tr>
				<th scope="col">Item</th>
				<th scope="col">Amount</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th colspan="2" scope="row">Total</td>
				<td><g:formatNumber number="${total}" type="currency" currencyCode="GBP" /></td>
			</tr>
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
	
	<g:form action="clear" class="clear-basket">
		<button type="submit">Clear</button>
	</g:form>
	
</g:if>
<g:else>
	<p class="basket-empty">Your basket is empty</p>
</g:else>
