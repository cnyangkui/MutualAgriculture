<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>互农综合管理平台</title>
  <link rel="shortcut icon" href="img/icon_web_mini.png" type=""/>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
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
	#back_to_top{
	    position: fixed;
	    display: none;
	    bottom: 100px;
	    right: 100px;
	    z-index: 30;
	}
</style>
</head>

<body class="hold-transition skin-green-light sidebar-mini ">
<a name="top"></a>
<a href="#top" id="back_to_top"><img width="40px" src="img/back_to_top.png"></a>
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header" style="position:fixed;z-index=1;width:100%">

    <!-- Logo -->
    <a href="index.jsp" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b><img alt="" height="42px" src="img/icon_web.png"></b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>互农</b><small>综合管理平台</small></span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
            <!-- Menu toggle button -->
            <a href="Map.jsp">
              <i class="fa fa-map-o">&nbsp;&nbsp;地图</i>
            </a>
          </li>
          <!-- /.messages-menu -->

          
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
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar" style="position:fixed;z-index=1">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="img/admin.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${currentAdmin.realname }</p>
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
        </div>
      </div>

      <!-- search form (Optional) -->
      <form action="#" method="get" class="sidebar-form">
        <div class="input-group">
          <input type="text" name="q" class="form-control" placeholder="搜索...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
      </form>
      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
        <li class="header">管理栏目</li>
        <!-- Optionally, you can add icons to the links -->
        <li class="single"><a href="javascript:showpage(this,'calendar.html')"><i class="fa fa-book"></i> <span>智能调度</span></a></li>
        <li class="treeview">
          <a href="#"><i class="fa fa-users"></i> <span>人员管理</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="javascript:showpage(this,'../bUserServlet?op=searchAll&type=v_farmer')"><i class="fa fa-circle-o"></i> 种粮大户</a></li>
            <li><a href="javascript:showpage(this,'../bUserServlet?op=searchAll&type=v_machiner')"><i class="fa fa-circle-o"></i> 农机手</a></li>
            <li><a href="javascript:showpage(this,'../bMachineOwnerServlet?op=searchAll')"><i class="fa fa-circle-o"></i> 农机拥有者</a></li>
          </ul>
        </li>
        <li class="single"><a href="javascript:showpage(this,'../bZoneServlet?op=searchAll')"><i class="fa fa-th"></i> <span>区片管理</span></a></li>
        <li class="single"><a href="javascript:showpage(this,'../bFarmlandServlet?op=searchAll')"><i class="fa fa-th-large"></i> <span>农田管理</span></a></li>
        <li class="single"><a href="javascript:showpage(this,'../bMachineServlet?op=searchAll')"><i class="fa fa-truck"></i> <span>农机管理</span></a></li>
        <li class="single"><a href="javascript:showpage(this,'../taskServlet?op=listTask')"><i class="fa fa-tasks"></i> <span>任务管理</span></a></li>
        <!-- <li class="treeview">
	        <a href="#"><i class="fa fa-tasks"></i> <span>任务管理</span>
	          <span class="pull-right-container">
	              <i class="fa fa-angle-left pull-right"></i>
	            </span>
	        </a>
          <ul class="treeview-menu">
            <li><a href="javascript:showpage(this,'publishtask.jsp')"><i class="fa fa-circle-o"></i> 发布任务</a></li>
            <li><a href="javascript:showpage(this,'../taskServlet?op=tasking')"><i class="fa fa-circle-o"></i> 正在进行</a></li>
            <li><a href="javascript:showpage(this,'../taskServlet?op=tasked')"><i class="fa fa-circle-o"></i> 历史任务</a></li>
          </ul>
        </li> -->
        <li class="treeview">
         <a href="#"><i class="fa fa-user-md"></i> <span>咨询中心</span>
          <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
          <ul class="treeview-menu">
            <li><a href="javascript:showpage(this,'../consultServlet?op=consulting')"><i class="fa fa-circle-o"></i> 待解决</a></li>
            <li><a href="javascript:showpage(this,'../consultServlet?op=consulted')"><i class="fa fa-circle-o"></i> 已解决</a></li>
          </ul>
        </li>
        <!-- <li><a href="#"><i class="fa fa-book"></i> <span>文库中心</span></a></li> -->
       	<li class="treeview">
       	 <a href="#"><i class="fa fa-medkit"></i> <span>病虫防治</span>
          <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
        </a>
          <ul class="treeview-menu">
            <!-- <li><a href="javascript:showpage(this,'')"><i class="fa fa-circle-o"></i> 病虫图鉴</a></li> -->
            <li><a href="javascript:showpage(this,'../pestlibServlet?op=searchAll')"><i class="fa fa-circle-o"></i> 病虫图鉴</a></li>
            <li><a href="javascript:showpage(this,'../pestQuestionServlet?op=question')"><i class="fa fa-circle-o"></i> 人工识别</a></li>
          </ul>
        </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="margin-top:35px;">
    <!-- Content Header (Page header) -->
    <!-- <section class="content-header">

    <!-- Main content -->
    <section class="content" >
        <!-- Your Page Content Here -->
        <iframe id="rightMain" src="calendar.html" scrolling="no" onload="changeFrameHeight()" frameborder="0" width="100%" height="500px" allowtransparency="true"></iframe>
		
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <!-- <div class="pull-right hidden-xs">
      Anything you want
    </div> -->
    <strong>Copyright &copy; 2016 <a href="http://www.geowind.cn" style="color: green;" target="_Blank">geowind</a>.</strong> All rights reserved.
    <!-- Default to the left -->
  </footer>

</div>
<!-- ./wrapper -->


<!-- jQuery 2.2.3 -->
<script src="js/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="js/bootstrap/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="js/dist/app.min.js"></script>
<script type="text/javascript">
	function showpage(obj,page){
	    $("#rightMain").attr("src",page);
	}
	
	function changeFrameHeight() {
		var mainheight = $("#rightMain").contents().find("body").height() + 30;
	    if(mainheight < 500){
	    	mainheight = 500;
		}
	    $("#rightMain").height(mainheight);
	    //console.log(mainheight)
	} 
	
	window.setInterval("changeFrameHeight()", 200);

	$(".sidebar-menu .single").click(function () {
		$(".active").removeClass("active");
		$(this).addClass("active");
	})
	
	$(".sidebar-menu .treeview li").click(function () {
		$(this).parent().children().each(function () {
			$(this).removeClass("active");
		})
		$(this).addClass("active");
	})
	
	$(window).scroll(function () {
		        var scrollHeight = $(parent.window).scrollTop();
		        if (scrollHeight > 500){
		            $("#back_to_top").fadeIn(300);
		        } else {
		            $("#back_to_top").fadeOut(300);
		        }
		    });
         	// 当点击跳转链接后，回到页面顶部位置
            $("#back_to_top").click(function(){
                $('body, html').animate({scrollTop:0}, 1000);
                return false;
            });
            function dashboard() {
        		parent.location.reload();
            }
	
</script>
</body>
</html>
