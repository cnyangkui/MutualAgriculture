<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" href="img/icon_web_mini.png" type=""/>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
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
	<link href="depend/loading/loading.css" rel="stylesheet" type="text/css" />
    <title>Document</title>
</head>
<body class="hold-transition skin-blue sidebar-mini" style="background-color: #ECF0F5">
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
<div class="container" style="width:100%;">
	<br>
	<c:forEach items="${consulted }" var="item">
		<div class="row">
        <div class="col-md-10">
            <!-- Box Comment -->
            <div class="box box-widget">
            <div class="box-header with-border">
              <div class="user-block">
                <img class="img-circle" src=
                <c:if test="${empty item.user.picture}">
					"img/not_pic.jpg"
					</c:if>
					<c:if test="${not empty item.user.picture}">
					"../../${item.user.picture}"
					</c:if>
               alt="User Image">
                <span class="username"><a href="#">${item.user.username }</a></span>
                <span class="description">上传时间：${item.ctime }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;解答时间：${item.atime}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;关键词：${item.keywords }</span>
              </div>
              <!-- /.user-block -->
              <div class="box-tools">
                <button type="button" class="btn btn-box-tool" data-toggle="tooltip" title="Mark as read">
                  <i class="fa fa-circle-o"></i></button>
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
              <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body">
            <!-- 问题描述图片 -->
              <!-- <img class="img-responsive pad" src="../dist/img/photo2.png" alt="Photo"> -->

              <p>${item.ccontent }</p>
              <!-- <span class="pull-right text-muted">n个回复</span> -->
            </div>
            
            <!-- /.box-footer -->
            <div class="box-footer">
                <img class="img-responsive img-circle img-sm" src="img/admin.png" alt="Alt Text">
                <div class="img-push">
                  <p>${item.acontent }</p>
                </div>
            </div>
            <!-- /.box-footer -->
          </div>
            <!-- /.box -->
        </div>
    </div>
	</c:forEach>
	
    
</div>

<!-- jQuery 2.2.3 -->
<script src="js/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="js/bootstrap/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="js/dist/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="js/dist/demo.js"></script>
<!-- page script -->
<script type="text/javascript">
	$(function() {
		$("#loading").fadeOut("slow");  
	});
</script>
</body>
</html>
