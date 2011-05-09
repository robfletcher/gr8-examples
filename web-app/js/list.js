$(function() {
	if (Modernizr.history) {
		$('#album-list').ajaxify().live('list:loading', function() {
			$(this).fadeOut('fast');
		}).live('list:complete', function() {
			var direction = $(this).nextAll().filter('.currentStep').size() > 0 ? 'left' : 'right';
			$(this).fadeIn('fast');
		});
	}
});