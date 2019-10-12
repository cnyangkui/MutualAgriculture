/**
 * 
 */
/* 验证 */
function check(div, input, data) {
	div = "#"+div;
	input = "#"+input;
	$(div).removeClass("has-feedback has-success has-error");
	$(div+" i").remove(".form-control-feedback");
	if(data == 1) {
		$(div).addClass("has-feedback has-success");
		$(input).after("<i style='display: block;', class='form-control-feedback glyphicon glyphicon glyphicon-ok'></i>")
	} else {
		$(div).addClass("has-feedback has-error");
		$(input).after("<i style='display: block;', class='form-control-feedback glyphicon glyphicon glyphicon-remove'></i>")
	
	}
}