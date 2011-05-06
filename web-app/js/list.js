$(function() {
	if (Modernizr.history) {
		$('#album-list').ajaxify().live('list:loading', function() {
			$(this).hide('slide');
		}).live('list:complete', function() {
			$(this).show('slide');
		});
	}
});