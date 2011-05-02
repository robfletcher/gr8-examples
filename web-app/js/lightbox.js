$(function() {
	$('#add-to-basket form').submit(function() {
		var form = $(this);
		$.facebox(function() { 
			$.post(form.attr('action'), form.serialize(), function(data) {
				$.facebox(data);
			});
		});
		return false;
	});
});