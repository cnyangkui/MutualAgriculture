<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!--<meta name="viewport" content="initial-scale=1.0,use-scalable=no">-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">

    <style type="text/css">
        body,html,#allmap{width: 100%;height: 95%;overflow: hidden;margin: 0;font-family: "微软雅黑";}
    </style>
	
	<script src="js/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=mcc568Fn4O4pF5ldXtFOs8ILbQGPG1jl"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />
    <title>地图使用测试</title>
</head>
<body>

<div>
    <!-- 经纬度：<input type="text" name="showGeography" id="show" value=""> -->
    搜索:<input type="text" id="suggestId" size="20" value="" style="width:150px;">
    <div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
    <button class="btn btn-primary" id="btn" onclick="farmlandOK()">选择</button>
</div>

<div id="allmap"></div>

<!-- 初始化地图界面的四个js 文件 -->
<script type="text/javascript" src="js/map/search.js"></script>
<script type="text/javascript" src="js/map/location.js"></script> -->
<script type="text/javascript" src="js/map/map.js"></script>

<!--标记农田信息-->
<script type="text/javascript" src="js/map/clickmark.js"></script>


<!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<!-- bootstrap datepicker -->
<script src="js/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- InputMask -->
<script src="js/plugins/input-mask/jquery.inputmask.js"></script>
<script src="js/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="js/plugins/input-mask/jquery.inputmask.extensions.js"></script>

</body>