(function($) {
	/**
	 * AJAX-enables pagination and sorting controls in a table.
	 */
	$.fn.ajaxify = function() {
		var container = this;
		var links = this.find('.pagination a, th.sortable a');
		if (links) {
			// store current table state in history
			history.replaceState({ html: container.html() }, '');

			// decorate list pagination & sorting controls with AJAX
			links.live('click', function() {
				var url = $(this).attr('href');
				container.trigger('list:loading');
				var selector = ' #' + container.attr('id') + ' > *';
				container.load(url + selector, function() {
					container.trigger('list:complete');
					// put the new content into history and update the URL
					history.pushState({ html: container.html() }, '', url);
				});
				return false;
			});

			// handle back button
			window.onpopstate = function(event) {
				// retrieve previous content from history if there is any
				if (event.state) {
					container.trigger('list:loading');
					container.html(event.state.html);
					container.trigger('list:complete');
				}
			};

			this.attr('role', 'liveregion');
		}
		return this;
	};
})(jQuery);