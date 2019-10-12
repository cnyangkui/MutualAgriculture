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

<link rel="stylesheet" href="depend/bootstrap-fileinput-master/css/fileinput.min.css">
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
				<li><a href="farmer.jsp">农机</a></li>
				<li class="active">详情</li>
			</ol>
		</section>
		<br /> <br />

		<!-- Horizontal Form -->
		<div class="box box-success">
			<div class="box-header with-border">
				<h3 class="box-title">农机信息</h3>
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
								<th style="width: 80px"><label>拥有者姓名</label></th>
								<td style="width: 150px">
									<select id="select1" class="js-example-basic-single" style="width: 90%">
										<c:forEach var="item" items="${allMachinerOwner }">
											<option value="${item.ownerId }">${item.name } ${item.phone } </option>
										</c:forEach>
									</select>
								</td>
								<th style="width: 80px"><label>拥有者手机号</label></th>
								<td style="width: 150px" id="phone"></td>
							</tr>
							<tr>
								<th style="width: 80px"><label>农机类型</label></th>
								<td style="width: 150px">
									<select id="select2" class="js-example-basic-single" style="width: 90%">
										<option value="收获机械">收获机械</option>
										<option value="耕种机械">耕种机械</option>
										<option value="排灌机械">排灌机械</option>
										<option value="动力传送机械">动力传送机械</option>
										<option value="种植施肥机械">种植施肥机械</option>
										<option value="植保机械">植保机械</option>
										<option value="粮油机械">粮油机械</option>
										<option value="果蔬机械">果蔬机械</option>
										<option value="饲料机械">饲料机械</option>
									</select>
								</td>
								<th><label>品牌</label></th>
								<td><a href="#" id="brand"></a></td>
							</tr>
							<tr>
								<th><label>机牌号</label></th>
								<td><a href="#" id="plate"></a></td>
								<th><label>工作效率</label></th>
								<td><a href="#" id="efficiency"></a></td>
							</tr>
							<tr>
								<th><label>马力</label></th>
								<td><a href="#" id="horsepower"></a></td>
								<th><label>报废时间</label></th>
								<td><a href="#" id="overdate"></a></td>
							</tr>
						</tbody>
						</table>
						<label class="control-label">选择图片</label>
						<form id="myform" action="../bMachineServlet?op=uploadImage" method="post" enctype="multipart/form-data">
                        	<input id="uploadImg" name="uploadImg" type="file" class="file" multiple data-show-upload="false" data-show-caption="true" data-allowed-file-extensions='["jpg", "png","gif","jpeg"]'>
						</form>
						<br>
						<button type="button" class="btn btn-success" id="confirmAdd-btn">确定</button>
						<button type="button" class="btn btn-default" id="cancelAdd-btn">取消</button>
			      </div>
			    </div>
				<table id="table" data-toolbar="#toolbar">
					<thead>
						<tr>
							<th data-field="state" data-checkbox="true"></th>
							<th data-field="machineId" data-sortable="true">编号</th>
							<th data-field="name" data-sortable="true">拥有者姓名</th>
							<th data-field="plate" data-sortable="true">机牌号</th>
							<th data-field="type" data-sortable="true">类型</th>
							<th data-field="brand" data-sortable="true">品牌</th>
							<th data-field="efficiency" data-sortable="true">工作效率</th>
							<th data-field="horsepower" data-sortable="true">马力</th>
							<th data-field="time" data-sortable="true">报废时间</th>
							<th data-field="action" data-formatter="actionFormatter" data-events="actionEvents" data-width="65">操作</th>
						</tr>
					</thead>
					<tbody>
                       	<c:forEach items="${allMachine }" var="item">
                        	<tr>
                        		<td data-field="state" data-checkbox="true"></td>
	                        	<td>${item.machineId }</td>
	                            <td>${item.machineowner.name }</td>
	                            <td>${item.plate }</td>
	                            <td>${item.type }</td>
	                            <td>${item.brand }</td>
	                            <td>${item.efficiency }</td>
	                            <td>${item.horsepower }</td>
	                            <td><fmt:formatDate value="${item.overdate }" pattern="yyyy-MM-dd"/></td>
	                            <td data-field="action" data-formatter="actionFormatter" data-events="actionEvents"></td>
                        	</tr>
                       	</c:forEach>
					</tbody>
				</table>

			</div>
			<!-- /.box-body -->

		</div>
		
			<!-- 图表 -->
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">农机数量统计</h3>
					</div>
					<div class="panel-body">
						<div id="machinenum_chart1" style="height: 350px;"></div>
					</div>
				</div>
			</div>
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
	<script src="depend/select2/select2.min.js"></script>
	<script src="depend/bootstrap-fileinput-master/js/fileinput.min.js"></script>
	<script src="depend/bootstrap-fileinput-master/js/zh.js"></script>
	<script src="depend/echarts/echarts.common.min.js"></script>
	<script src="depend/select2/select2.min.js"></script>
	<script>
		
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
				sortName: 'machineId',
				sortOrder: 'desc',
				formatLoadingMessage: function() {
					return '<img src="img/loading_spinner.gif"/>'
				}
			});
			
			//农机数量统计
			$.post("../bMachineServlet", {
				op : "getMachineNum"
			}, function(data) {
				var name = [];
				var value = [];
				for (var i = 0; i < data.length; i++) {
					name[i] = data[i].type;
					value[i] = parseInt(data[i].num);
				}
				createChart1(name, value);
			}, "json");
			
		
		
			<!--以上为农机数量统计-->
			
		
			$("#select1").select2();
			//$("#select1").val("${currentMachine.machineowner.ownerId }").trigger("change");
			$("#select1").select2('val',' ');
			$("#select2").select2();
			$("#select2").select2('val',' ');
		});
		
		function dashboard() {
			parent.location.reload();
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
				var machineId = row.machineId;
				location.href= "../bMachineServlet?op=detail&machineId="+machineId;
			},
			'click .remove' : function(e, value, row, index) {
				//alert('You click remove icon, row: ' + JSON.stringify(row));
				//console.log(value, row, index);
				var machineId = row.machineId;
				var result= confirm("确认删除？","确认","取消");
	    		if(result==true){
	    			$.post("../bMachineServlet", {op:"delete", machineId:machineId}, function(data) {
	    	        	if(data == 1) {
	    	        		alert("删除成功");
	    	        		location.href = "../bMachineServlet?op=searchAll";
	    	        	} else {
	    	        		alert("删除失败");
	    	        	}
	    	        });
	    		}else{
	    			return;
	    		}
			}
		};
		
		$("#select1").on("select2:select", function (e) {
			var text = $("#select1").select2('data')[0]['text'];
			var phone = text.split(' ')[1];
			$("#phone").text(phone);
			var ownerId = $("#select1").val();
		});
		$("#select2").on("select2:select", function (e) {
			var value = $("#select2").val();
		});
		
		$('#brand').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$('#plate').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$('#efficiency').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$('#horsepower').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$('#overdate').editable({
			type : 'text',
			validate : function(value) {
				if (value == '') {
					return '不能为空';
				}
			}
		});
		$("#cancelAdd-btn").click(function() {
			$("#select1").select2('val',' ');
			$("#select2").select2('val',' ');
	        $("#brand").editable('setValue', null).removeClass('editable-unsaved');
			$("#plate").editable('setValue', null).removeClass('editable-unsaved');
			$("#efficiency").editable('setValue', null).removeClass('editable-unsaved');
			$("#horsepower").editable('setValue', null).removeClass('editable-unsaved');
			$("#overdate").editable('setValue', null).removeClass('editable-unsaved');
			$("#phone").val('');
	        $("#collapseOne").collapse('hide');
		});	
		$("#confirmAdd-btn").click(function() {
			var ownerId = $("#select1").val();
			var type = $("#select2").val();
			var brand = $("#brand").editable('getValue', true);
			var plate = $("#plate").editable('getValue', true);
			var efficiency = $("#efficiency").editable('getValue', true);
			var horsepower = $("#horsepower").editable('getValue', true);
			var overdate = $("#overdate").editable('getValue', true);
			if(ownerId == null || type == null || efficiency==null || brand == null || plate == null || horsepower == null || overdate== null) {
				alert("请完成信息");
				return;
			}
			$.post("../bMachineServlet?op=add", {ownerId:ownerId, type:type, plate:plate,
		    	brand:brand, efficiency:efficiency,horsepower:horsepower, overdate:overdate}, function(data) {
		    	if(data == 1) {
		    		alert("添加成功");
		    		$("#myform").submit();
		    	} else {
		    		alert("添加失败");
		    	}
		    });
			
			
			
			$("#select1").select2('val',' ');
			$("#select2").select2('val',' ');
	        $("#brand").editable('setValue', null).removeClass('editable-unsaved');
			$("#plate").editable('setValue', null).removeClass('editable-unsaved');
			$("#efficiency").editable('setValue', null).removeClass('editable-unsaved');
			$("#horsepower").editable('setValue', null).removeClass('editable-unsaved');
			$("#overdate").editable('setValue', null).removeClass('editable-unsaved');
			$("#phone").val('');
	        $("#collapseOne").collapse('hide');
	   	});
	function createChart1(name,value){
			
			//图表生成
			var dom = document.getElementById("machinenum_chart1");
			var myChart = echarts.init(dom);

			option = {
			    color: ['#3398DB'],
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis : [
			        {
			            type : 'category',
			            data : name,
			            axisTick: {
			                alignWithLabel: true
			            }
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'直接访问',
			            type:'bar',
			            barWidth: '60%',
			            data:value
			        }
			    ]
			};

			if (option && typeof option === "object") {
				myChart.setOption(option, true);
			}
		}
	</script>

</body>
</html>