<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" scope="page"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="shortcut icon" href="img/icon_web_mini.png" type="" />
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet" href="css/plugins/datatables/dataTables.bootstrap.css">
<!-- Theme style -->
<link rel="stylesheet" href="css/dist/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
	folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="css/dist/skin/skin-green-light.min.css">
<!-- bootstrap datepicker -->
<link rel="stylesheet" href="css/plugins/datepicker/datepicker3.css">

<link href="depend/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="depend/bootstrap-table/bootstrap-table.css">
<link href="depend/loading/loading.css" rel="stylesheet" type="text/css" />
<title>Document</title>
<style type="text/css">

.ml10 {
	margin-left: 10px;
}
</style>
</head>
<body style="background-color: #ECF0F5">
<!-- 等待加载 -->
<div id="loading">
	<div id="loading-center">
		<div id="loading-center-absolute">
			<div class="object" id="object_one"></div>
			<div class="object" id="object_two"></div>
			<div class="object" id="object_three"></div>
			<div class="object" id="object_four"></div>
		</div>
	</div>
</div>
	<div class="container" style="width: 100%;">
		<section class="content-header">
			<ol class="breadcrumb">
				<li><a href="javascript:dashboard()"><i
						class="fa fa-dashboard"></i> 仪表盘</a></li>
				<li><a href="farmer.jsp">农机拥有者</a></li>
				<li class="active">详情</li>
			</ol>
		</section>
		<br /> <br />

		<!-- Horizontal Form -->
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title">农机拥有者信息</h3>
			</div>

			<div class="box-body">
				<div id="toolbar" class="btn-group">
					<button type="button" class="btn btn-default" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
						<i class="glyphicon glyphicon-plus"></i>
					</button>
					<button type="button" class="btn btn-default">
						<i class="glyphicon glyphicon-heart"></i>
					</button>
					<button type="button" class="btn btn-default">
						<i class="glyphicon glyphicon-trash"></i>
					</button>
				</div>
				<div id="collapseOne" class="accordion-body collapse">
			      <div class="accordion-inner">
			      		<table class="table table-bordered table-striped">
							<tbody>
								<tr>
									<th style="width: 80px"><label>姓名</label></th>
									<td style="width: 150px"><a href="#" id="name"></a></td>
									<th style="width: 80px"><label>性别</label></th>
									<td style="width: 150px"><a href="#" id="sex"></a></td>
								</tr>
								<tr>
									<th><label>出生日期</label></th>
									<td><a href="#" id="date"></a></td>
									<th><label>手机号</label></th>
									<td><a href="#" id="phone"></a></td>
								</tr>
								<tr>
									<th><label>家庭地址</label></th>
									<td colspan="6"><a href="#" id="address"></a></td>
								</tr>
							</tbody>
						</table>
						<button type="button" class="btn btn-success" id="confirmAdd-btn">确定</button>
						<button type="button" class="btn btn-default" id="cancelAdd-btn">取消</button>
			      </div>
			    </div>
				<table id="table" data-toolbar="#toolbar">
					<thead>
						<tr>
							<th data-field="state" data-checkbox="true"></th>
							<th data-field="ownerId" data-sortable="true">编号</th>
							<th data-field="name" data-sortable="true">姓名</th>
							<th data-field="sex" data-sortable="true">性别</th>
							<th data-field="age" data-sortable="true">年龄</th>
							<th data-field="phone" data-sortable="true">手机</th>
							<th data-field="address" data-sortable="true">地址</th>
							<th data-field="action" data-formatter="actionFormatter" data-events="actionEvents" data-width="65">操作</th>
						</tr>
					</thead>
					<tbody>
                        <c:forEach items="${allMachinerOwner }" var="item">
                            <tr>
                            	<td data-field="state" data-checkbox="true"></td>
                            	<td>${item.ownerId }</td>
	                            <td>${item.name }</td>
	                            <td>${item.sex }</td>
	                            <td>${pageScope.now.year - item.birthday.year}</td>
	                            <td>${item.phone }</td>
	                            <td>${item.address }</td>
	                            <td data-field="action" data-formatter="actionFormatter" data-events="actionEvents"></td>
	                        </tr>
                        </c:forEach>
					</tbody>
				</table>
			</div>
			<!-- /.box-body -->

		</div>


	</div>
	<script src="js/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script src="js/bootstrap/bootstrap.min.js"></script>
	<!-- date-range-picker -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
	<!-- bootstrap datepicker -->
	<script src="js/plugins/datepicker/bootstrap-datepicker.js"></script>
	<!-- InputMask -->
	<script src="js/plugins/input-mask/jquery.inputmask.js"></script>
	<script src="js/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script src="js/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script src="depend/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="depend/bootstrap-table/bootstrap-table.min.js"></script>

	<!-- Latest compiled and minified Locales -->
	<script src="depend/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
	<script>
		function actionFormatter(value, row, index) {
			return [
					'<a class="edit ml10" href="javascript:void(0)" title="编辑">',
					'<i class="glyphicon glyphicon-edit"></i>',
					'</a>',
					'<a class="remove ml10" href="javascript:void(0)" title="删除">',
					'<i class="glyphicon glyphicon-remove"></i>', '</a>' ]
					.join('');
		}

		window.actionEvents = {
			'click .edit' : function(e, value, row, index) {
				//alert('You click edit icon, row: ' + JSON.stringify(row));
				//console.log(value, row, index);
				var ownerId = row.ownerId;
				location.href= "../bMachineOwnerServlet?op=detail&ownerId="+ownerId;
			},
			'click .remove' : function(e, value, row, index) {
				//alert('You click remove icon, row: ' + JSON.stringify(row));
				//console.log(value, row, index);
				var ownerId = row.ownerId;
				var result= confirm("确认删除？","确认","取消");
	    		if(result==true){
	    			$.post("../bMachineOwnerServlet", {op:"delete", ownerId:ownerId}, function(data) {
	    	        	if(data == 1) {
	    	        		alert("删除成功");
	    	        		$.post("../bMachineOwnerServlet", {op:"getAllData"}, function(data) {
	    	        			data = eval("("+ data +")");
	    	        			for(var i=0; i<data.length; i++) {
	    	        				data[i].state = '';
	    	        				data[i].action = '';
	    	        			}
	    	        			$("#table").bootstrapTable('load', data);
	    	        		});
	    	        	} else {
	    	        		alert("删除失败");
	    	        	}
	    	        });
	    		}else{
	    			return;
	    		}
			}
		};
		$(function() {
			$("#loading").fadeOut("slow");  
			$('#table').bootstrapTable({
				pagination : true,
				pageNumber : 1,
				pageSize : 5,
				pageList : [ 5, 10, 20, 50 ],
				search : true,
				height : 380,
				showRefresh : true,
				showToggle : true,
				showColumns : true,
				clickToSelect : true,
				sortName: 'ownerId',
				sortOrder: 'desc',
				formatLoadingMessage: function() {
					return '<img src="img/loading_spinner.gif"/>'
				}
			});
			//$('.collapse').collapse();
		});
		function dashboard() {
			parent.location.reload();
	    }
		$('#name').editable({
			type : 'text',
		    validate: function (value) { 
		        if (value == '') { 
		            return '不能为空'; 
		        } 
		    }
		});
		$('#sex').editable({
			type : 'select',
			source : [ {
				value : '男',
				text : '男'
			}, {
				value : '女',
				text : '女'
			} ],
		});
		$('#date').editable({
			type : 'text',
			placeholder: 'yyyy-MM-dd',
		    validate: function (value) { 
		        if (value == '') { 
		            return '不能为空'; 
		        } 
		    }
		});
		$('#phone').editable({
			type : 'text',
		    validate: function (value) { 
		        if (value == '') { 
		            return '不能为空'; 
		        } 
		    }
		});
		$('#address').editable({
			type : 'text',
		    validate: function (value) { 
		        if (value == '') { 
		            return '不能为空'; 
		        } 
		    }
		});
		$("#cancelAdd-btn").click(function() {
			$("#name").editable('setValue', null).removeClass('editable-unsaved');
			$("#sex").editable('setValue', null).removeClass('editable-unsaved');
			$("#date").editable('setValue', null).removeClass('editable-unsaved');
			$("#phone").editable('setValue', null).removeClass('editable-unsaved');
			$("#address").editable('setValue', null).removeClass('editable-unsaved');
			$("#collapseOne").collapse('hide');
		});	
		$("#confirmAdd-btn").click(function() {
			var name = $("#name").editable('getValue', true);
			var sex = $("#sex").editable('getValue', true);
			var birthday = $("#date").editable('getValue', true);
			var phone = $("#phone").editable('getValue', true);
			var address = $("#address").editable('getValue', true);
			if(name == null || sex== null || birthday == null || phone == null || address == null) {
				alert("请完成信息");
				return;
			}
			alert(name+" "+sex+" "+birthday+" "+phone+" "+address);
	        $.post("../bMachineOwnerServlet", {op:"add", name:name, sex:sex, address:address, phone:phone, birthday:birthday}, function(data) {
	        	if(data == 1) {
	        		alert("添加成功");
	        		$.post("../bMachineOwnerServlet", {op:"getAllData"}, function(data) {
	        			data = eval("("+ data +")");
	        			for(var i=0; i<data.length; i++) {
	        				data[i].state = '';
	        				data[i].action = '';
	        			}
	        			$("#table").bootstrapTable('load', data);
	        		});
	        	} else {
	        		alert("添加失败");
	        	}
	        });
	        $("#name").editable('setValue', null).removeClass('editable-unsaved');
			$("#sex").editable('setValue', null).removeClass('editable-unsaved');
			$("#date").editable('setValue', null).removeClass('editable-unsaved');
			$("#phone").editable('setValue', null).removeClass('editable-unsaved');
			$("#address").editable('setValue', null).removeClass('editable-unsaved');
	        $("#collapseOne").collapse('hide');
	   	});
			
	</script>

</body>
</html>