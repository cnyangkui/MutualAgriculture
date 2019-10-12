$('#b1').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#e1').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#x1').editable({
	type : 'text',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#b2').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#e2').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#x2').editable({
	type : 'text',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#b3').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#e3').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#x3').editable({
	type : 'text',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#b4').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#e4').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#x4').editable({
	type : 'text',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#b5').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#e5').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#x5').editable({
	type : 'text',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#b6').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#e6').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#x6').editable({
	type : 'text',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#b7').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#e7').editable({
	type : 'text',
	placeholder: 'MM-dd',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});
$('#x7').editable({
	type : 'text',
	validate : function(value) {
		if (value == '') {
			return '不能为空';
		}
	}
});

function reloadPlan() {
	var b1 = $("#b1").editable('getValue', true);
	var e1 = $("#e1").editable('getValue', true);
	var x1 = $("#x1").editable('getValue', true);
	var b2 = $("#b2").editable('getValue', true);
	var e2 = $("#e2").editable('getValue', true);
	var x2 = $("#x2").editable('getValue', true);
	var b3 = $("#b3").editable('getValue', true);
	var e3 = $("#e3").editable('getValue', true);
	var x3 = $("#x3").editable('getValue', true);
	var b4 = $("#b4").editable('getValue', true);
	var e4 = $("#e4").editable('getValue', true);
	var x4 = $("#x4").editable('getValue', true);
	var b5 = $("#b5").editable('getValue', true);
	var e5 = $("#e5").editable('getValue', true);
	var x5 = $("#x5").editable('getValue', true);
	var b6 = $("#b6").editable('getValue', true);
	var e6 = $("#e6").editable('getValue', true);
	var x6 = $("#x6").editable('getValue', true);
	var b7 = $("#b7").editable('getValue', true);
	var e7 = $("#e7").editable('getValue', true);
	var x7 = $("#x7").editable('getValue', true);
	
	$.post("../aiPlanningServlet?op=reloadPlan",{
		b1:b1,e1:e1,x1:x1,
		b2:b2,e2:e2,x2:x2,
		b3:b3,e3:e3,x3:x3,
		b4:b4,e4:e4,x4:x4,
		b5:b5,e5:e5,x5:x5,
		b6:b6,e6:e6,x6:x6,
		b7:b7,e7:e7,x7:x7,
	}, function(data) {
		if(data == 1) {
			alert("规划成功");
			location.href = "calendar.html";
		} else {
			alert("规划失败");
		}
	});
}

function cancel() {
	$("#b1").editable('setValue', null).removeClass('editable-unsaved');
	$("#e1").editable('setValue', null).removeClass('editable-unsaved');
	$("#x1").editable('setValue', null).removeClass('editable-unsaved');
	$("#b2").editable('setValue', null).removeClass('editable-unsaved');
	$("#e2").editable('setValue', null).removeClass('editable-unsaved');
	$("#x2").editable('setValue', null).removeClass('editable-unsaved');
	$("#b3").editable('setValue', null).removeClass('editable-unsaved');
	$("#e3").editable('setValue', null).removeClass('editable-unsaved');
	$("#x3").editable('setValue', null).removeClass('editable-unsaved');
	$("#b4").editable('setValue', null).removeClass('editable-unsaved');
	$("#e4").editable('setValue', null).removeClass('editable-unsaved');
	$("#x4").editable('setValue', null).removeClass('editable-unsaved');
	$("#b5").editable('setValue', null).removeClass('editable-unsaved');
	$("#e5").editable('setValue', null).removeClass('editable-unsaved');
	$("#x5").editable('setValue', null).removeClass('editable-unsaved');
	$("#b6").editable('setValue', null).removeClass('editable-unsaved');
	$("#e6").editable('setValue', null).removeClass('editable-unsaved');
	$("#x6").editable('setValue', null).removeClass('editable-unsaved');
	$("#b7").editable('setValue', null).removeClass('editable-unsaved');
	$("#e7").editable('setValue', null).removeClass('editable-unsaved');
	$("#x7").editable('setValue', null).removeClass('editable-unsaved');
}

$.post("../aiPlanningServlet?op=getPlanStandard", function(data) {
	data = eval(data);
	for(var i=0; i<data.length; i++) {
		$("#b"+(i+1)).editable('setValue', data[i].begin);
		$("#e"+(i+1)).editable('setValue', data[i].end);
		$("#x"+(i+1)).editable('setValue', data[i].efficiency);
	}
});
