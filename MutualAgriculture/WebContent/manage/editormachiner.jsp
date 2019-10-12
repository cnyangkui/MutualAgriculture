<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="css/plugins/datatables/dataTables.bootstrap.css">
<!-- Theme style -->
<link rel="stylesheet" href="css/dist/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
	folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="css/dist/skin/skin-green-light.min.css">
<!-- bootstrap datepicker -->
<link rel="stylesheet" href="css/plugins/datepicker/datepicker3.css">


<link href="depend/bootstrap3-editable/css/bootstrap-editable.css"
	rel="stylesheet" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="depend/bootstrap-table/bootstrap-table.css">
<link href="depend/loading/loading.css" rel="stylesheet" type="text/css" />

<title>Document</title>
<style type="text/css">
#userInfo_left {
	float: left;
	width: 40%;
	height: 320px;
}

#userInfo_right {
	float: right;
	width: 60%;
	height: 320px;
}

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
				<li><a href="farmer.jsp">种粮大户</a></li>
				<li class="active">详情</li>
			</ol>
		</section>
		<br /> <br />

		<form class="form-horizontal">

			<!-- Horizontal Form -->
			<div class="box box-success">
				<div class="box-header with-border">
					<h3 class="box-title">基本信息</h3>
				</div>

				<div class="box-body">

					<table class="table table-bordered">
						<tbody>
							<tr>
								<td style="width: 180px" rowspan="6"><img id="stuImg"
									src="img/avatar.png" alt="无图片" width="120" height="160"></td>
								<th style="width: 80px"><label>用户名</label></th>
								<td style="width: 150px">${currentMachiner.username }</td>
								<th style="width: 80px"><label>姓名</label></th>
								<td style="width: 150px"><a href="#" id="realname">${currentMachiner.realname }</a></td>
								<th style="width: 80px"><label>性别</label></th>
								<td style="width: 150px"><a href="#" id="sex">${currentMachiner.sex }</a></td>
							</tr>
							<tr>
								<th><label>出生日期</label></th>
								<td><a href="#" id="date"><fmt:formatDate
											value="${currentMachiner.birthday }" pattern="yyyy-MM-dd" /></a></td>
								<th><label>手机号</label></th>
								<td><a href="#" id="phone">${currentMachiner.phone }</a></td>
								<th><label>信誉</label></th>
								<td><a href="#" id="credit">${currentMachiner.credit }</a></td>
							</tr>
							<tr>
								<th><label>家庭地址</label></th>
								<td colspan="4"><a href="#" id="address">${currentMachiner.address }</a></td>
							</tr>

						</tbody>
					</table>

				</div>
				<!-- /.box-body -->

			</div>



		</form>

		<!-- Horizontal Form -->
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title">任务信息</h3>
			</div>

			<div class="box-body">
				<div id="toolbar" class="btn-group">
					<button type="button" class="btn btn-default">
						<i class="glyphicon glyphicon-plus"></i>
					</button>
					<button type="button" class="btn btn-default">
						<i class="glyphicon glyphicon-heart"></i>
					</button>
					<button type="button" class="btn btn-default">
						<i class="glyphicon glyphicon-trash"></i>
					</button>
				</div>
				<table id="table" data-toolbar="#toolbar">
					<thead>
						<tr>
							<th data-field="state" data-checkbox="true"></th>
							<th data-field="taskId" data-sortable="true">任务编号</th>
							<th data-field="zone" data-sortable="true">任务区号</th>
							<th data-field="farmlandId" data-sortable="true">任务片号</th>
							<th data-field="address" data-sortable="true">地址</th>
							<th data-field="plate" data-sortable="true">农机牌号</th>
							<th data-field="worktype" data-sortable="true">作业类型</th>
							<th data-field="time" data-sortable="true">任务时间</th>
							<th data-field="result" data-sortable="true">完成状况</th>
							<th data-field="action" data-formatter="actionFormatter"
								data-events="actionEvents" data-width="65">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${currentMachiner.tasks }">
							<tr>
								<td data-field="state" data-checkbox="true"></td>
								<td>${item.taskId }</td>
								<td>${item.block.zone.zonename }</td>
								<td>${item.block.bname }</td>
								<td>${item.block.address }</td>
								<td>${item.machine.plate }</td>
								<td>${item.type }</td>
								<td><fmt:formatDate value="${item.workdate }"
										pattern="yyyy-MM-dd" />&nbsp;至&nbsp;<fmt:formatDate
										value="${item.finishdate }" pattern="yyyy-MM-dd" />
								</td>
								<td>
									<%-- <c:choose>
										<c:when test="${item.finished eq '0' } ">
											<a href="#">正在进行</a>
									   	</c:when>
									    <c:otherwise>
									    	<a href="#">已经完成</a>${item.finished }
									    </c:otherwise>
								    </c:choose> --%>
								    ${item.finished ==1?"<a style='color:red'>已经完成</a>":"<a href='#'>正在进行</a>"}
								</td>
								<td data-field="action" data-formatter="actionFormatter"
									data-events="actionEvents"></td>
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
				alert('You click edit icon, row: ' + JSON.stringify(row));
				console.log(value, row, index);
			},
			'click .remove' : function(e, value, row, index) {
				alert('You click remove icon, row: ' + JSON.stringify(row));
				console.log(value, row, index);
			}
		};
		$(function() {
			$("#loading").fadeOut("slow");  
			//Datemask dd/mm/yyyy
			$("#datemask").inputmask("yyyy-mm-dd", {
				"placeholder" : "yyyy-mm-dd"
			});
			//Date picker
			$('#datepicker').datepicker({
				autoclose : true
			});
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
				sortName: 'farmlandId',
				sortOrder: 'desc'
			});
		});
		function editInfo() {
			$(".allInfo").removeAttr("disabled");
		}
		function saveInfo() {
			$(".allInfo").attr("disabled", "disabled");
		}
		function returnFarmer() {
			window.location = "farmer.jsp";
		}
		function dashboard() {
			parent.location.reload();
		}

		$('#realname').editable({
			type : 'text',
			url: function (params) { 
		        return $.post('../bUserServlet', { 
		            op: 'editeOne',
		            pk: '${currentMachiner.username }',
		            item:"realname",
		            value:params.value
		        }); 
		    },
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
			url: function (params) { 
		        return $.post('../bUserServlet', { 
		            op: 'editeOne',
		            pk: '${currentMachiner.username }',
		            item:"sex",
		            value:params.value
		        }); 
		    }
		});
		$('#date').editable({
			type : 'text',
			placeholder: 'yyyy-MM-dd',
			url: function (params) { 
		        return $.post('../bUserServlet', { 
		            op: 'editeOne',
		            pk: '${currentMachiner.username }',
		            item:"birthday",
		            value:params.value
		        }); 
		    },
		    validate: function (value) { 
		        if (value == '') { 
		            return '不能为空'; 
		        } 
		    }
		});
		$('#phone').editable({
			type : 'text',
			url: function (params) { 
		        return $.post('../bUserServlet', { 
		            op: 'editeOne',
		            pk: '${currentMachiner.username }',
		            item:"phone",
		            value:params.value
		        }); 
		    },
		    validate: function (value) { 
		        if (value == '') { 
		            return '不能为空'; 
		        } 
		    }
		});
		$('#credit').editable({
			type : 'text',
			url: function (params) { 
		        return $.post('../bUserServlet', { 
		            op: 'editeOne',
		            pk: '${currentMachiner.username }',
		            item:"credit",
		            value:params.value
		        }); 
		    },
		    validate: function (value) { 
		        if (value == '') { 
		            return '不能为空'; 
		        } 
		    }
		});
		$('#address').editable({
			type : 'text',
			url: function (params) { 
		        return $.post('../bUserServlet', { 
		            op: 'editeOne',
		            pk: '${currentMachiner.username }',
		            item:"address",
		            value:params.value
		        }); 
		    },
		    validate: function (value) { 
		        if (value == '') { 
		            return '不能为空'; 
		        } 
		    }
		});
	</script>

</body>
</html>