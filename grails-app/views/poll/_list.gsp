<ul>
	<g:each var="poll" in="${polls}">
		<li>
			<g:link action="show" id="${poll.id}">${poll.question}</g:link>
			<span class="votes">${gr8.examples.Vote.countByPoll(poll)} votes</span>
		</li>
	</g:each>
</ul>
