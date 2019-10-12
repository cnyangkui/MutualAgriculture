<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" scope="page" />
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
<link rel="stylesheet" href="depend/select2/select2.min.css">


<link href="depend/bootstrap3-editable/css/bootstrap-editable.css"
	rel="stylesheet" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="depend/bootstrap-table/bootstrap-table.css">
<link rel="stylesheet" href="depend/bootstrap-fileinput-master/css/fileinput.min.css">
<link href="depend/loading/loading.css" rel="stylesheet" type="text/css" />

<title>Document</title>
<style type="text/css">
.ml10 {
	margin-left: 10px;
}

.node {
    cursor: pointer;
  }

  .overlay{
      background-color:#EEE;
  }
   
  .node circle {
    fill: #fff;
    stroke: steelblue;
    stroke-width: 1.5px;
  }
   
  .node text {
    font-size:10px; 
    font-family:sans-serif;
  }
   
  .link {
    fill: none;
    stroke: #ccc;
    stroke-width: 1.5px;
  }

  .templink {
    fill: none;
    stroke: red;
    stroke-width: 3px;
  }

  .ghostCircle.show{
      display:block;
  }

  .ghostCircle, .activeDrag .ghostCircle{
       display: none;
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
				<li><a href="farmer.jsp">片区</a></li>
				<li class="active">详情</li>
			</ol>
		</section>
		<br /> <br />

		<!-- Horizontal Form -->
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title">分区信息</h3>
			</div>

			<div class="box-body">
				<div id="toolbar" class="btn-group">
					<button type="button" class="btn btn-default"
						data-toggle="collapse" data-target="#collapseOne"
						aria-expanded="false" aria-controls="collapseOne">
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
									<th style="width: 80px"><label>分区名</label></th>
									<td style="width: 150px"><a href="#" id="zonename"></a></td>
									<th style="width: 80px"><label>面积</label></th>
									<td style="width: 150px"><a href="#" id="area"></a></td>
								</tr>
								<tr>
									<th><label>作物类型</label></th>
									<td><a href="#" id="type"></a></td>
									<th><label>地址</label></th>
									<td><a href="#" id="address"></a></td>
								</tr>
							</tbody>
						</table>
						<button type="button" class="btn btn-success" id="confirmAdd-btn">确定</button>
						<button type="button" class="btn btn-default" id="cancelAdd-btn">取消</button>
					</div>
				</div>
				<table id="table1" data-toolbar="#toolbar">
					<thead>
						<tr>
							<th data-field="state" data-checkbox="true"></th>
							<th data-field="zoneId" data-sortable="true">编号</th>
							<th data-field="zonename" data-sortable="true">分区名</th>
							<th data-field="area" data-sortable="true">面积</th>
							<th data-field="type" data-sortable="true">作物类型</th>
							<th data-field="address" data-sortable="true">地址</th>
							<th data-field="action" data-formatter="actionFormatter"
								data-events="actionEvents" data-width="65">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allZone }" var="item">
							<tr>
								<td data-field="state" data-checkbox="true"></td>
								<td>${item.zoneId }</td>
								<td>${item.zonename }</td>
								<td>${item.area }</td>
								<td>${item.type }</td>
								<td>${item.address }</td>
								<td data-field="action" data-formatter="actionFormatter"
									data-events="actionEvents"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<!-- /.box-body -->

		</div>



		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title">分片信息</h3>
			</div>

			<div class="box-body">
				<div id="toolbar2" class="btn-group">
					<button type="button" class="btn btn-default"
						data-toggle="collapse" data-target="#collapseOne2"
						aria-expanded="false" aria-controls="collapseOne2">
						<i class="glyphicon glyphicon-plus"></i>
					</button>
					<button type="button" class="btn btn-default">
						<i class="glyphicon glyphicon-heart"></i>
					</button>
					<button type="button" class="btn btn-default">
						<i class="glyphicon glyphicon-trash"></i>
					</button>
				</div>
				<div id="collapseOne2" class="accordion-body collapse">
					<div class="accordion-inner">
						<table class="table table-bordered table-striped">
							<tbody>
								<tr>
									<th style="width: 80px"><label>分片名</label></th>
									<td style="width: 150px"><a href="#" id="bname"></a></td>
									<th><label>面积</label></th>
									<td><a href="#" id="area2"></a></td>
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
									<td style="width: 150px" id="type2"></td>
								</tr>
								<tr>
									<td colspan="4">
										<a href="#myModal" role="button" class="btn btn-success" data-toggle="modal" onclick="showModal()">修改地址及经纬度</a>
									</td>
								</tr>
								<tr>
									<th><label>经纬度</label></th>
									<td><a href="#" id="jingweidu"></a></td>
									<th><label>地址</label></th>
									<td><a href="#" id="address2"></a></td>
								</tr>
							</tbody>
						</table>
						<label class="control-label">选择图片</label>
						<form id="myform" action="../blockServlet?op=uploadImage" method="post" enctype="multipart/form-data">
                        	<input id="uploadImg" name="uploadImg" type="file" class="file" multiple data-show-upload="false" data-show-caption="true" data-allowed-file-extensions='["jpg", "png","gif","jpeg"]'>
						</form>
						<br>
						<button type="button" class="btn btn-success" id="confirmAdd-btn2">确定</button>
						<button type="button" class="btn btn-default" id="cancelAdd-btn2">取消</button>
					</div>
				</div>
				<table id="table2" data-toolbar="#toolbar2">
					<thead>
						<tr>
							<th data-field="state" data-checkbox="true"></th>
							<th data-field="bid" data-sortable="true">编号</th>
							<th data-field="bname" data-sortable="true">分片名</th>
							<th data-field="zoneId" data-sortable="true">所属区号</th>
							<th data-field="area" data-sortable="true">面积</th>
							<th data-field="address" data-sortable="true">地址</th>
							<th data-field="jingweidu" data-sortable="true">经纬度</th>
							<th data-field="action" data-formatter="actionFormatter"
								data-events="actionEvents2" data-width="65">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${allBlock }" var="item">
							<tr>
								<td data-field="state" data-checkbox="true"></td>
								<td>${item.bid }</td>
								<td>${item.bname }</td>
								<td>${item.zone.zonename }</td>
								<td>${item.area }</td>
								<td>${item.address }</td>
								<td>${item.longitude }, ${item.latitude }</td>
								<td data-field="action" data-formatter="actionFormatter"
									data-events="actionEvents2"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<!-- /.box-body -->

		</div>

		<!-- 图表 -->
		<div class="row">
			<div class="col-md-6">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">分区面积</h3>
					</div>
					<div class="panel-body">
						<div id="zone_chart1" style="height: 350px;"></div>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">作物类型</h3>
					</div>
					<div class="panel-body">
						<div id="zone_chart2" style="height: 350px;"></div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">级别树状图展示</h3>
					</div>
					<div class="panel-body">
						<div id="tree-container" style="height: 600px;"></div>
					</div>
				</div>
			</div>
		</div>


	</div>
	
	<jsp:include page="smallmap2.html"></jsp:include>

	<!-- 二叉树 -->
	<script src="http://d3js.org/d3.v3.min.js"></script>
	<!-- <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script> -->
	<script src="js/dndTree.js"></script>
	<!-- 二叉数 -->
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

	<script src="depend/echarts/echarts.common.min.js"></script>
	<script src="depend/select2/select2.min.js"></script>
	<script src="depend/bootstrap-fileinput-master/js/fileinput.min.js"></script>
	<script>
	//地图数据提交
	function submitChange() {
		var coordinate = $.trim($("#coordinate").val());
		var _address = $.trim($("#_address").val());
		$("#jingweidu").editable('setValue', coordinate)
		$("#address2").editable('setValue', _address)
		$('#myModal').modal('hide');
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
				//alert('You click edit icon, row: ' + JSON.stringify(row));
				//console.log(value, row, index);
				var zoneId = row.zoneId;
				location.href = "../bZoneServlet?op=detail&zoneId=" + zoneId;
			},
			'click .remove' : function(e, value, row, index) {
				//alert('You click remove icon, row: ' + JSON.stringify(row));
				//console.log(value, row, index);
				var zoneId = row.zoneId;
				var result = confirm("确认删除？", "确认", "取消");
				if (result == true) {
					$.post("../bZoneServlet", {
						op : "delete",
						zoneId : zoneId
					}, function(data) {
						if (data == 1) {
							alert("删除成功");
							$.post("../bZoneServlet", {
								op : "getAllData"
							}, function(data) {
								data = eval("(" + data + ")");
								for (var i = 0; i < data.length; i++) {
									data[i].state = '';
									data[i].action = '';
								}
								$("#table").bootstrapTable('load', data);
							});
						} else {
							alert("删除失败");
						}
					});
				} else {
					return;
				}
			}
		};

		window.actionEvents2 = {
			'click .edit' : function(e, value, row, index) {
				//alert('You click edit icon, row: ' + JSON.stringify(row));
				//console.log(value, row, index);
				var bid = row.bid;
				location.href = "../blockServlet?op=detail&bid=" + bid;
			},
			'click .remove' : function(e, value, row, index) {
				//alert('You click remove icon, row: ' + JSON.stringify(row));
				//console.log(value, row, index);
				var bid = row.bid;
				var result = confirm("确认删除？", "确认", "取消");
				if (result == true) {
					$.post("../blockServlet", {
						op : "delete",
						bid : bid
					}, function(data) {
						if (data == 1) {
							alert("删除成功");
							$.post("../blockServlet", {
								op : "getAllBlockData"
							}, function(data) {
								data = eval("(" + data + ")");
								for (var i = 0; i < data.length; i++) {
									data[i].state = '';
									data[i].action = '';
								}
								$("#table2").bootstrapTable('load', data);
							});
						} else {
							alert("删除失败");
						}
					});
				} else {
					return;
				}
			}
		};

		$(function() {
			$("#loading").fadeOut("slow");  
			$('#table1').bootstrapTable({
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
				sortName : 'zoneId',
				sortOrder : 'desc'
			});
			$('#table2').bootstrapTable({
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
				sortName : 'bid',
				sortOrder : 'desc'
			});
			//生成面积图表
			$.post("../bZoneServlet", {
				op : "getZoneArea"
			}, function(data) {
				var name = [];
				var value = [];
				for (var i = 0; i < data.length; i++) {
					name[i] = data[i].name;
					value[i] = parseInt(data[i].value);
				}
				createChart1(name, value);
			}, "json");
			//生成作物类型图表
			$.post("../bZoneServlet", {
				op : "getCropType"
			}, function(data) {
				var name = [];
				for (var i = 0; i < data.length; i++) {
					name[i] = data[i].name;
				}
				createChart2(name, data);
			}, "json");
			
			 //生成二叉数json数据
			$.post("../treeServlet", {
				op : "getTreeJson"
			}, function(data) {
			}, "json");
			 
			$("#select1").select2();
			$("#select1").select2('val', ' ');
		});
		function dashboard() {
			parent.location.reload();
		}

		$("#select1").on("select2:select", function (e) {
			var value = $("#select1").val();
			var type = value.split(' ')[1];
			var zoneId = value.split(' ')[0];
			$("#type2").text(type);
		});

		$('#zonename').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$('#bname').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$('#area').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$('#area2').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$('#type').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$('#address').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$('#address2').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$('#jingweidu').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$("#cancelAdd-btn").click(
				function() {
					$("#zonename").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#area").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#type").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#address").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#collapseOne").collapse('hide');
				});
		$("#confirmAdd-btn").click(
				function() {
					var zonename = $("#zonename").editable('getValue', true);
					var area = $("#area").editable('getValue', true);
					var type = $("#type").editable('getValue', true);
					var address = $("#address").editable('getValue', true);
					if (zonename == null || area == null || type == null
							|| address == null) {
						alert("请完成信息");
						return;
					}
					$.post("../bZoneServlet", {
						op : "add",
						zonename : zonename,
						area : area,
						type : type,
						address : address
					}, function(data) {
						if (data == 1) {
							alert("添加成功");
							$.post("../bZoneServlet", {
								op : "getAllData"
							}, function(data) {
								data = eval("(" + data + ")");
								for (var i = 0; i < data.length; i++) {
									data[i].state = '';
									data[i].action = '';
								}
								$("#table1").bootstrapTable('load', data);
							});
						} else {
							alert("添加失败");
						} 
					});
					$("#zonename").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#area").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#type").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#address").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#collapseOne").collapse('hide');
				});

		$("#cancelAdd-btn2").click(
				function() {
					$("#select1").select2('val', ' ');
					$("#bname").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#area2").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#address2").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#jingweidu").editable('setValue', null).removeClass(
					'editable-unsaved');
					$("#collapseOne2").collapse('hide');
				});
		$("#confirmAdd-btn2").click(
				function() {
					var zoneId = $("#select1").val().split(' ')[0];
					var bname = $("#bname").editable('getValue', true);
					var area = $("#area2").editable('getValue', true);
					var address = $("#address2").editable('getValue', true);
					var jingweidu = $("#jingweidu").editable('getValue', true);
					if (bname == null || area == null || zoneId == null
							|| address == null || jingweidu==null) {
						alert("请完成信息");
						return;
					}
					$.post("../blockServlet", {
						op : "addBlock",
						bname : bname,
						area : area,
						zoneId : zoneId,
						address : address,
						jingweidu: jingweidu
					}, function(data) {
						/* if (data == 1) {
							alert("添加成功");
							$.post("../blockServlet", {
								op : "getAllBlockData"
							}, function(data) {
								data = eval("(" + data + ")");
								for (var i = 0; i < data.length; i++) {
									data[i].state = '';
									data[i].action = '';
								}
								$("#table2").bootstrapTable('load', data);
							});
						} else {
							alert("添加失败");
						} */
						if(data == 1) {
				    		alert("添加成功");
				    		$("#myform").submit();
				    	} else {
				    		alert("添加失败");
				    	}
					});
					$("#select1").select2('val', ' ');
					$("#bname").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#area2").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#address2").editable('setValue', null).removeClass(
							'editable-unsaved');
					$("#collapseOne2").collapse('hide');
				});

		function createChart1(name, value) {
			//图表生成
			var dom = document.getElementById("zone_chart1");
			var myChart = echarts.init(dom);
			var app = {};
			option = null;
			app.title = '坐标轴刻度与标签对齐';

			option = {
				color : [ '#3398DB' ],
				tooltip : {
					trigger : 'axis',
					axisPointer : { // 坐标轴指示器，坐标轴触发有效
						type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},
				xAxis : [ {
					type : 'category',
					data : name,
					axisTick : {
						alignWithLabel : true
					}
				} ],
				yAxis : [ {
					type : 'value'
				} ],
				series : [ {
					name : '直接访问',
					type : 'bar',
					barWidth : '60%',
					data : value
				} ]
			};
			if (option && typeof option === "object") {
				myChart.setOption(option, true);
			}
		}

		function createChart2(name, value) {

			var dom = document.getElementById("zone_chart2");
			var myChart = echarts.init(dom);
			var app = {};
			option = null;
			app.title = '分区面积';

			option = {
				title : {
					text : '作物类型面积比例图',
					//subtext: '纯属虚构',
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					left : 'left',
					data : name
				},
				series : [ {
					name : '访问来源',
					type : 'pie',
					radius : '55%',
					center : [ '50%', '60%' ],
					data : value,
					itemStyle : {
						emphasis : {
							shadowBlur : 10,
							shadowOffsetX : 0,
							shadowColor : 'rgba(0, 0, 0, 0.5)'
						}
					}
				} ]
			};
			if (option && typeof option === "object") {
				myChart.setOption(option, true);
			}

		}
	</script>

</body>
</html>