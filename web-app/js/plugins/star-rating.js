(function($) {

	$.fn.starRatingInput = function() {
		var form = $(this);
		var radios = form.find(':radio');
		
		// create the elements representing the stars
		var starContainer = $('<div class="star-rating"></div>');
		for (var i = 1; i <= 5; i++) {
			var radio = radios.filter('[value=' + i + ']');
			var star = $('<a href="#">' + i + '</a>');
			star.appendTo(starContainer);
			// the star and the radio update each other so bind them together using data
			star.data('radio', radio);
			radio.data('star', star);
		}
		
		// when the user clicks on one of the stars update the associated radio and submit the form
		var stars = starContainer.find('a');
		stars.click(function() {
			$(this).data('radio').attr('checked', 'checked').change();
			form.submit();
			return false;
		});
		
		// when the user mouses over one of the stars highlight it and all the stars to its left
		stars.mouseenter(function() {
			$(this).prevAll().andSelf().addClass('hovered');
			$(this).nextAll().removeClass('hovered');
		});
		stars.mouseleave(function() {
			$(this).siblings().andSelf().removeClass('hovered');
		});
		
		// whenever the radios change state the stars need to update accordingly
		radios.bind('change', function() {
			var radio = radios.filter(':checked');
			if (radio.size() > 0) {
				var star = radio.data('star');
				star.prevAll().andSelf().addClass('on');
				star.nextAll().removeClass('on');
			}
		});
		
		// the form should submit via AJAX instead of as a regular form submission
		form.submit(function() {
			$.post(form.attr('action'), form.serialize());
			return false;
		});

		// insert the stars into the DOM and hide the original form controls
		form.children().hide();
		starContainer.appendTo(form);

		// trigger a change event on the radios so the initial star state is correct
		radios.change();
	};

	$.fn.starRating = function() {
		var container = $(this);
		var score = Math.round(parseFloat(container.text()));

		// create the elements representing the stars
		var starContainer = $('<div class="star-rating"></div>');
		for (var i = 1; i <= 5; i++) {
			var star = $('<span class="star">' + i + '</span>');
			if (i <= score) {
				star.addClass('on');
			}
			star.appendTo(starContainer);
		}

		container.replaceWith(starContainer);
	}
	
})(jQuery);