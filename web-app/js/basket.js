$(function() {
	
	function clearBasket() {
		$.post($(this).attr('action'), function(data) {
			$('#facebox .content').html(data);
		});
		return false;
	}
	
	$('#add-to-basket form').submit(function() {
		var form = $(this);
		$.facebox(function() { 
			$.post(form.attr('action'), form.serialize(), function(data) {
				$.facebox(data);
				$('form.clear-basket').submit(clearBasket);
			});
		});
		return false;
	});
});