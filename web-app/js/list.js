$(function() {
	if (Modernizr.history) {
		$('#album-list').ajaxify();
	}
});