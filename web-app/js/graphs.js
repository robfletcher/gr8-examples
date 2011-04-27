$(function() {
    if (Modernizr.canvas) {

        var PALETTE = ['#ECD078', '#D95B43', '#C02942', '#542437', '#53777A', '#69D2E7', '#A7DBD8', '#E0E4CC', '#F38630', '#FA6900', '#FE4365', '#FC9D9A', '#F9CDAD', '#C8C8A9', '#83AF9B', '#556270', '#4ECDC4', '#C7F464', '#FF6B6B', '#C44D58'];

        $('#twitter-clients').hide().visualize({
            type: 'pie',
            width: 500,
            height: 500
        });

        $('#twitter-users').hide().visualize({
            width: 800,
            height: 300,
            colors: PALETTE
        });
        
    }
});
