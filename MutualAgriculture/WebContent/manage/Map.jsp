<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!--<meta name="viewport" content="initial-scale=1.0,use-scalable=no">-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=mcc568Fn4O4pF5ldXtFOs8ILbQGPG1jl"></script>
         <!--<script src="http://api.map.baidu.com/components?ak=mcc568Fn4O4pF5ldXtFOs8ILbQGPG1jl&v=1.0"></script>-->
        <script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>        
        <script type="text/javascript" src="http://api.map.baidu.com/library/GeoUtils/1.2/src/GeoUtils_min.js">   </script>
        <link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
    <title> 互农地图</title>
    <link rel="shortcut icon" href="img/icon_web_mini.png" type=""/>
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
	  <!-- Font Awesome -->
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
	  <!-- Ionicons -->
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
	  <!-- Theme style -->
	  <link rel="stylesheet" href="css/dist/AdminLTE.min.css">
	  <link rel="stylesheet" href="css/dist/skin/skin-green-light.min.css">
	
	  <!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	  <![endif]-->
	  <style type="text/css">
	  	#suggestId{
	  		background-color: #33B87B;
	  		border: 0;
	  		color: white;
	  	}
	  	.baidu-maps label {max-width: none;}
	  	body,html,#allmap{width: 100%;height: 96.5%;overflow: hidden;margin: 0;}
	  	
	  </style>
</head>

<body class="hold-transition skin-green-light layout-top-nav">
  <header class="main-header">
	<nav class="navbar navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <a href="index.jsp" class="navbar-brand"><b>互农</b><small>综合管理平台</small></a>
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
            <i class="fa fa-bars"></i>
          </button>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
          <ul class="nav navbar-nav">
<!--             <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
 -->            <li><a href="#myHint" role="button"  data-toggle="modal" onCLick="addPoint()">添加标注点</a></li>
 				<li><a href="#myHint2" role="button" data-toggle="modal" onClick="addComputerAreaResult()">计算面积</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">功能选择 <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="javascript:clearMark()" >重置<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li class="divider"></li>
                <li><a href="javascript:addWeatherLayer()" >天气<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li><a href="javascript:addPestLayer()" >虫害<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li><a href="javascript:addDiseaseLayer()" >病害<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li class="divider"></li>
                <li><a href="javascript:addFarmerLayer()" >农民<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li><a href="javascript:addMachineLayer()" >农机<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li><a href="javascript:addCropLayer()" onclick="addZoneLayer()">农作物<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li class="divider"></li>
                <li><a href="javascript:addTaskLayer()" >任务<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li><a href="javascript:addQuestionLayer()" >提问<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li class="divider"></li>
                <li><a href="javascript:addZoneLayer()" >分区<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li><a href="javascript:addAffectAreasLayer()">受灾区<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li><a href="javascript:addFuelLayer()" >加油点<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li><a href="javascript:addRepairLayer()" >维修点<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
                <li><a href="javascript:addCenterLayer()" >服务中心点<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
              	 <li><a href="javascript:addBlockLayer()" >分块<span class="pull-right-container"><i class="fa fa-check pull-right" style="line-height: 20px; color: green; display: none;"></i></span></a></li>
              </ul>
            </li>
          </ul>
           
          <form class="navbar-form navbar-left" role="search">
            <div class="form-group" id="">
              <input type="text" class="form-control" id="suggestId" placeholder="搜索" size="20" style="width:200px;">
              <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:200px;height:auto; display:none; z-index:99999; top: 20px;"></div>
<!--               <input type="button" id="computerArea" value="计算面积" onclick="addComputerAreaResult()" >
 -->            </div>
          </form>
        </div>
        <!-- /.navbar-collapse -->
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
          <ul class="nav navbar-nav">
            <!-- User Account Menu -->
            <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <img src="img/admin.png" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">${currentAdmin.realname }</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="img/admin.png" class="img-circle" alt="User Image">

                <!-- <p>
                  Alexander Pierce - Web Developer
                  <small>Member since Nov. 2012</small>
                </p> -->
                <p>
                  ${currentAdmin.realname }
                </p>
              </li>
              <!-- Menu Body -->
              
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">设置</a>
                </div>
                <div class="pull-right">
                  <a href="../adminServlet?op=logout" class="btn btn-default btn-flat">退出登录</a>
                </div>
              </li>
            </ul>
            <li class="dropdown messages-menu">
            <!-- Menu toggle button -->
            <a href="index.jsp">
              <i class="fa fa-rotate-left">&nbsp;&nbsp;返回首页</i>
            </a>
          </li>
          </ul>
          
        </div>
        <!-- /.navbar-custom-menu -->
        
      </div>
      <!-- /.container-fluid -->
    </nav>
	</header>
     <div id="allmap" class="baidu-maps"></div>
	
	<!-- hint html -->
	<jsp:include page="hint1.html"></jsp:include>
	<jsp:include page="hint2.html"></jsp:include>
	
	<!-- 初始化地图界面的四个js 文件 -->
    <script type="text/javascript" src="js/bigMap/mapInit.js"></script>
    <script type="text/javascript" src="js/bigMap/search.js"></script>
    <script type="text/javascript" src="js/bigMap/location.js"></script>
    <script type="text/javascript" src="js/bigMap/mapType.js"></script>
	
	<!-- 操作显示各个功能层的js 文件 -->
    <script type="text/javascript" src="js/bigMap/weatherLayer.js"></script>
    <script type="text/javascript" src="js/bigMap/pestLayer.js"></script>
    <script type="text/javascript" src="js/bigMap/cropLayer.js"></script>
    <script type="text/javascript" src="js/bigMap/diseaseLayer.js"></script>
    <script type="text/javascript" src="js/bigMap/farmerLayer.js"></script>
    <script type="text/javascript" src="js/bigMap/machineLayer.js"></script>
    <script type="text/javascript" src="js/bigMap/questionLayer.js"></script>
    <script type="text/javascript" src="js/bigMap/taskLayer.js"></script>
    <script type="text/javascript" src="js/bigMap/zoneLayer.js"></script>
    <script type="text/javascript" src="js/bigMap/affectedAreasLayer.js"></script>
    <script type="text/javascript" src="js/bigMap/zoneLayer.js" ></script>
    <script type="text/javascript" src="js/bigMap/fuelLayer.js" ></script>
	<script type="text/javascript" src="js/bigMap/repairLayer.js" ></script>
	<script type="text/javascript" src="js/bigMap/centerLayer.js" ></script>
	<script type="text/javascript" src="js/bigMap/computerArea.js"></script>
	<script type="text/javascript" src="js/bigMap/blockLayer.js"></script>
	<!-- 统筹控制地图各个功能层块的调度显示js文件 -->
    <!--<script type="text/javascript" src="js/bigMap/layerControl.js"></script>-->

	<script src="js/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- date-range-picker -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
	<!-- bootstrap datepicker -->
	<script src="js/plugins/datepicker/bootstrap-datepicker.js"></script>
	<!-- InputMask -->
	<script src="js/plugins/input-mask/jquery.inputmask.js"></script>
	<script src="js/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script src="js/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script src="js/bootstrap/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="js/dist/app.min.js"></script>
	<script type="text/javascript">
		$(".dropdown-menu > li").click(function () {
			$(".dropdown-menu > li").find("i").each(function () {
				$(this).hide();
			})
			$(this).find("i").show();
		})
		
		function clearMark() {
			map.clearOverlays();
			pts = [];
			checkOpenAddPoint = false;
			map.removeEventListener("rightclick",showInfo);
		}
	</script>
</body>
</html>
