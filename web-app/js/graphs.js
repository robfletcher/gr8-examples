Raphael.fn.pieChart = function (cx, cy, r, values, labels, stroke) {
    var paper = this,
        rad = Math.PI / 180,
        chart = this.set();
    function sector(cx, cy, r, startAngle, endAngle, params) {
        var x1 = cx + r * Math.cos(-startAngle * rad),
            x2 = cx + r * Math.cos(-endAngle * rad),
            y1 = cy + r * Math.sin(-startAngle * rad),
            y2 = cy + r * Math.sin(-endAngle * rad);
        return paper.path(["M", cx, cy, "L", x1, y1, "A", r, r, 0, +(endAngle - startAngle > 180), 0, x2, y2, "z"]).attr(params);
    }
    var angle = 0,
        total = 0,
        start = 0,
        process = function (j) {
            var value = values[j],
                angleplus = 360 * value / total,
                popangle = angle + (angleplus / 2),
                color = "hsb(" + start + ", 1, .5)",
                ms = 500,
                delta = 30,
                bcolor = "hsb(" + start + ", 1, 1)",
                p = sector(cx, cy, r, angle, angle + angleplus, {gradient: "90-" + bcolor + "-" + color, stroke: stroke, "stroke-width": 3}),
                txt = paper.text(cx, (2 * cy) + 20, labels[j]).attr({fill: bcolor, stroke: "none", opacity: 0, "font-family": 'Fontin-Sans, Arial', "font-size": "20px"});
			p.label = txt;
            angle += angleplus;
            chart.push(p);
            chart.push(txt);
			segments.push(p);
            start += .1;
        };
    for (var i = 0, ii = values.length; i < ii; i++) {
        total += values[i];
    }
    for (var i = 0; i < ii; i++) {
        process(i);
    }
    return chart;
};

var CX = 350;
var CY = 250;

var segments = [];

Raphael.el.big = function() {
	this.animate({scale: [1.15, 1.15, CX, CY]}, 1000, "elastic");
	this.label.animate({opacity: 1}, 500, "elastic");
}
Raphael.el.small = function() {
	this.animate({scale: [1, 1, CX, CY]}, 1000, "elastic");
	this.label.animate({opacity: 0}, 0, "elastic");
}

var currentSegment = 0;
$(function() {
	window.setInterval(function() {
		segments[currentSegment].small();
		if (++currentSegment >= segments.length) {
			currentSegment = 0;
		}
		segments[currentSegment].big();
	}, 1500);
});

(function (raphael) {
    $(function () {
		$('table').after('<div id="holder"></div>');
        var values = [],
            labels = [];
        $("tbody tr").each(function () {
            values.push(parseInt($("td", this).text(), 10));
            labels.push($("th", this).text() + ' (' + $('td', this).text() + ')');
        });
        $("table").hide();
        raphael("holder", CX * 2, (CY * 2) + 40).pieChart(CX, CY, 200, values, labels, "#fff");
    });
})(Raphael.ninja());
