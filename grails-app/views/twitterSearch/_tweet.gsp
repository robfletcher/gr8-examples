<article class="tweet" data-tweet-id="${it.id}">
	<header>
		<h3>@${it.from_user}</h3>
		<img src="${it.profile_image_url}" class="profile-image">
	</header>
	<p>${it.text}</p>
	<time>${it.created_at}</time>
</article>
