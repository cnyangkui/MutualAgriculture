<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.geowind.hunong.jpa.Block"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	Block block = (Block)request.getSession().getAttribute("currentBlock");
	if(block != null) {
		String images = block.getPicture();
		if(images != null) {
			String[] pic = images.split(",");
			for(int i=0; i<pic.length; i++) {
				pic[i] = "../../../"+pic[i];
				System.out.println(pic[i]);
			}
			List<String> picList = Arrays.asList(pic);
			pageContext.setAttribute("picList", picList);
		}
	}
%>
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
<link rel="stylesheet" href="depend/select2/select2.min.css">
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
				<li><a href="farmer.jsp">农机主</a></li>
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
								<td style="width: 150px" rowspan="7">
									<div id="carousel-example-generic" class="carousel slide"
										data-ride="carousel">
										<!-- Indicators -->
										<ol class="carousel-indicators">
											<li data-target="#carousel-example-generic" data-slide-to="0"
												class="active"></li>
											<li data-target="#carousel-example-generic" data-slide-to="1"></li>
											<li data-target="#carousel-example-generic" data-slide-to="2"></li>
										</ol>

										<!-- Wrapper for slides -->
										<div class="carousel-inner" role="listbox">
										
										<c:forEach items="${picList}" var="item"> 
											<div class="item">
												<img src="${item}" alt="无图片" width="100%"
													height="180">
											</div>
										</c:forEach>
										
										</div>

										<!-- Controls -->
										<a class="left carousel-control"
											href="#carousel-example-generic" role="button"
											data-slide="prev"> <span
											class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
											<span class="sr-only">Previous</span>
										</a> <a class="right carousel-control"
											href="#carousel-example-generic" role="button"
											data-slide="next"> <span
											class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
											<span class="sr-only">Next</span>
										</a>
									</div>
								</td>
								<th style="width: 80px"><label>编号</label></th>
								<td style="width: 150px">${currentBlock.bid }</td>
								<th style="width: 80px"><label>分片名</label></th>
								<td style="width: 150px"><a href="#" id="bname">${currentBlock.bname }</a></td>
							</tr>
							<tr>
								<th style="width: 80px"><label>所属分区名</label></th>
								<td style="width: 150px">
									<select id="select1" class="js-example-basic-single" style="width: 90%">
										<c:forEach var="item" items="${allZone }">
											<option value="${item.zoneId } ${item.type }">${item.zonename }</option>
										</c:forEach>
									</select>
								</td>
								<th style="width: 80px"><label>作物类型</label></th>
								<td style="width: 150px" id="type"></td>
							</tr>
							<tr>
								<th><label>面积</label></th>
								<td><a href="#" id="area">${currentBlock.area }</a></td>
							</tr>
							<tr>
								<td colspan="4">
									<a href="#myModal" role="button" class="btn btn-success" data-toggle="modal" onclick="showModal()">修改地址及经纬度</a>
								</td>
							</tr>
							<tr>
								<th><label>经纬度</label></th>
								<td><a href="#" id="jingweidu">${currentBlock.longitude }, ${currentBlock.latitude }</a></td>
								<th><label>地址</label></th>
								<td><a href="#" id="address">${currentBlock.address }</a></td>
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
				<h3 class="box-title">农田信息</h3>
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
							<th data-field="farmlandId" data-sortable="true">农田编号</th>
							<th data-field="realname" data-sortable="true">拥有者姓名</th>
							<th data-field="jingweidu" data-sortable="true">经纬度</th>
							<th data-field="address" data-sortable="true">地址</th>
							<th data-field="type" data-sortable="true">作物类型</th>
							<th data-field="area" data-sortable="true">面积</th>
							<th data-field="action" data-formatter="actionFormatter" data-events="actionEvents" data-width="65">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${currentBlock.farmlands }">
							<tr>
								<td data-field="state" data-checkbox="true"></td>
								<td>${item.farmlandId }</td>
								<td>${item.user.realname }</td>
								<td>${item.longitude }, ${item.latitude }</td>
								<td>${item.address }</td>
								<td>${item.block.zone.type }</td>
								<td>${item.area }</td>
								<td data-field="action" data-formatter="actionFormatter" data-events="actionEvents"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<!-- /.box-body -->

		</div>
	</div>
	<jsp:include page="smallmap2.html"></jsp:include>
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
	<script src="depend/select2/select2.min.js"></script>
	<script>
	function submitChange() {
		var coordinate = $.trim($("#coordinate").val());
		var _address = $.trim($("#_address").val());
		$("#jingweidu").editable('setValue', coordinate)
		$("#address").editable('setValue', _address)
		$('#myModal').modal('hide');
		$.post('../blockServlet', {
			op : 'editeOne',
			pk : '${currentBlock.bid }',
			item : "jingweidu",
			value : coordinate
		});
		$.post('../blockServlet', {
			op : 'editeOne',
			pk : '${currentBlock.bid }',
			item : "address",
			value : _address
		});
	}
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
			$("#select1").select2();
			$("#select1").val("${currentBlock.zone.zoneId } ${currentBlock.zone.type }").trigger("change");
			$(".carousel-inner .item:first").addClass("active");
			var value = $("#select1").val();
			var type = value.split(' ')[1];
			$("#type").text(type);
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
				sortName: 'bid',
				sortOrder: 'desc'
			});
		});
		$("#select1").on("select2:select", function (e) {
			var value = $("#select1").val();
			var type = value.split(' ')[1];
			var zoneId = value.split(' ')[0];
			$("#type").text(type);
			$.post('../blockServlet', {
				op : 'editeOne',
				pk : '${currentBlock.bid }',
				item : "zoneId",
				value : zoneId
			});
		});

		$('#bname').editable({
			type : 'text',
			url: function (params) { 
		        return $.post('../blockServlet', { 
		            op: 'editeOne',
		            pk: '${currentBlock.bid }',
		            item:"bname",
		            value:params.value
		        }); 
		    },
		    validate: function (value) { 
		        if (value == '') { 
		            return '不能为空'; 
		        } 
		    }
		});
		
		$('#area').editable({
			type : 'text',
			url: function (params) { 
		        return $.post('../blockServlet', { 
		            op: 'editeOne',
		            pk: '${currentBlock.bid }',
		            item:"area",
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
		        return $.post('../blockServlet', { 
		            op: 'editeOne',
		            pk: '${currentBlock.bid }',
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
		$('#jingweidu').editable({
			type : 'text',
			url: function (params) { 
		        return $.post('../blockServlet', { 
		            op: 'editeOne',
		            pk: '${currentBlock.bid }',
		            item:"jingweidu",
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