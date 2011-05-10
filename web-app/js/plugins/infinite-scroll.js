(function($) {

	$.fn.infiniteScroll = function(itemSelector) {
		var container = $(this);
		
		var busy = false;
		var nextPage = $(this).find('a.next').attr('href');
		
		function fetchNextPage() {
			if (!busy) {
				busy = true;
				container.append('<div class="loading">Loading...</div>');
				$.get(nextPage, function(data) {
					container.find('.loading').remove();
					
					var elements = $(data).find(itemSelector);
					if (elements.length > 0) {
						container.append(elements);
						nextPage = $(data).find('a.next').attr('href');
					} else {
						container.append('<div class="end" lang="fr">fin!</div>');
						$(window).unbind('scroll', scrollHandler);
					}
					busy = false;
				});
			}
		};

		function scrollHandler(event) {
			var threshold = 100;
			if ($(window).scrollTop() > ($(document).height() - $(window).height()) - threshold) {
				fetchNextPage();
			}
		}

		container.find('.pagination').remove();
		$(window).bind('scroll', scrollHandler);
	};
	
})(jQuery);