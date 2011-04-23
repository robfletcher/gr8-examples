<%@ page import="gr8.examples.Poll" %>
<nav class="pagination">
	<g:set var="previousPoll" value="${Poll.previous(poll).list(max: 1)[0]}"/>
	<g:if test="${previousPoll}">
		<g:link class="previous" action="show" id="${previousPoll.id}">Previous</g:link>
	</g:if>
	<g:set var="nextPoll" value="${Poll.next(poll).list(max: 1)[0]}"/>
	<g:if test="${nextPoll}">
		<g:link class="next" action="show" id="${nextPoll.id}">Next</g:link>
	</g:if>
</nav>
