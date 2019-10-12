<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图鉴</title>
<link rel="shortcut icon" href="img/icon_web_mini.png" type=""/>
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="css/dist/AdminLTE.min.css">
<link rel="stylesheet" href="css/capSlide.css">
<link href="depend/loading/loading.css" rel="stylesheet" type="text/css" />
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
<div class="container" style="width:100%;">
	<section class="content-header">
	      <ol class="breadcrumb">
	        <li><a href="javascript:dashboard()"><i class="fa fa-dashboard"></i> 仪表盘</a></li>
	        <li class="active">病虫图鉴</li>
	      </ol>
	</section>
	<br/>
    <br/>
    	<div style="left:10px;" class="input-group col-sm-6">
          <input type="text" name="q" class="form-control" style="border: 0; background: white; " id="searchContent" placeholder="请输入昆虫名或昆虫科目...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search" class="btn btn-flat" style="background: white;" onclick="search()"><i class="fa fa-search"></i>
                </button>
              </span>
        </div>
        <br/>
<div class="content_capSlide">

  <div style="clear:both;"></div>
  
   <c:forEach items="${pestlib }" var="item">
  	<div class="demo">
	    <div id="capslide_img_cont1" class="ic_container"> <img src="../../${item.pic}" width="auto" height="190" alt=""/>
	      <div class="overlay_capSlide" style="display:none;"></div>
	      <div class="ic_caption">
	        <p class="ic_category">${item.branch }</p>
	        <h3>${item.pestname }</h3>
	        <p class="ic_text"> ${item.info }</p>
	        <p class="ic_text"> 解决方法：${item.method }</p>
	      </div>
	      </div>
  		</div>
  </c:forEach>
  
</div>
</div>
	<script src="js/plugins/jQuery/jquery-2.2.3.min.js" type="text/javascript"></script>
	<script src="js/jquery.capSlide.js" type="text/javascript"></script>
	<script type="text/javascript">
            $(function() {
            	$("#loading").fadeOut("slow");  
                $(".ic_container").capslide({
                    caption_color	: '#000',
                    caption_bgcolor	: '#fff',
                    overlay_bgcolor : '#00A65A',
                    border			: '',
                    showcaption	    : true
                });
            });

            //适配宽度
            var y = 0;
            var count = 0;
			$(".demo").each(function (index) {
				var _y = $(this).position().top;
				if(y == 0){
					y = _y;
				}
				if(_y != y){
					count++;
					y = _y;
				}
				$(this).attr("row_count",count);
			})
			var maxrow = $(".demo").last().attr("row_count");
			var pagewidth = $(".container").width()-30;
			for(var i = 0; i <= maxrow; i++){
				var row = $(".demo[row_count="+i+"]");
				var last = row.last();
				var rowpiccount = 0;
				row.each(function () {
					rowpiccount++;
				})
				var rowwidth = last.position().left - $(".demo").first().position().left + last.width();
				var multiple = (pagewidth-(rowpiccount)*20)/(rowwidth-(rowpiccount)*20);
				row.each(function (index) {
					$(this).find('img').attr("height",Math.floor(190*multiple))
				})
				//console.log(multiple)
			}
			
			
			function search() {
				var content = $("#searchContent").val();
				if(content == undefined || content == "") {
					location.href = "../pestlibServlet?op=searchAll";
					return;
				}
				$.post("../pestlibServlet?op=findPest", {content:content}, function(data) {
					location.reload();
				});
				
			}
    </script>
	
</body>
</html>
