$(function() {
	var averageRatingContainer = $('#average-rating');
	averageRatingContainer.starRating();
	
	$('form.rating').starRatingInput().bind('ratingupdate', function(event, value) {
		averageRatingContainer.starRating('update', value);
	});
});