/**
 * Created by Jiang on 2016/10/19.
 * 天气标注图层
 */
// var marker2 = new BMap.Marker();
var weatherDetail;
function addWeatherLayer(){
		map.clearOverlays();
 	  	var zonejson;
 	  	var weatherjson;
 	  	var marker = new Array();
    	 var weatherurl="../weatherServlet";
    	 var zoneurl ="../bZoneServlet?op=MapSearchAll";
    	 $.post(zoneurl,{},function getWeather(data){
    		 if(data==0){
    			 alert("查询失败");
    		 }else{
    			
    			 zonejson = JSON.parse(data);
    			 
    		 }
    	 })
    	 
    	 $.post(weatherurl,{},function(data){
    		 if(data==0){
    			 alert("查询为空");
    		 }else{
	    			 weatherjson = JSON.parse(data);
    			 for(var i = 0;i<zonejson.length;i++)
    			 {
    				 //alert(zonejson[i].address);
    				 addWeatherMarker(zonejson[i].address,i);
    			 }
    		 }
    	 });
    	 
    	 function addWeatherMarker(address,i){
    			var myIcon = new BMap.Icon("img/weatherMarker/a_"+weatherjson[0].first1, new BMap.Size(70,65),
    			        {anchor:new BMap.Size(70,65),infoWindowAnchor: new BMap.Size(35, 0)} );
    			var content = '<div style="margin:0;line-height:20px;padding:2px;">' +
							    '<img src="img/weatherMarker/'+weatherjson[0].second1+'" alt="" style="float:right;zoom:1;overflow:hidden;width:100px;height:100px;margin-left:3px;"/>' +
							    '区号：'+zonejson[i].zonename +
							    '<br/>天气详情：'+weatherjson[0].detail+
							    '</div>';
    	   				
    			// 创建地址解析器实例
    			var myGeo = new BMap.Geocoder();
    			myGeo.getPoint(address, function(point){
    				if (point){		
    						//创建检索信息窗口对象
    						var searchInfoWindow = null;
    						searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
    						title  : "天气详情",      //标题
    						width  : 300,             //宽度
    						height : 210,              //高度
    						panel  : "panel",         //检索结果面板
    						enableAutoPan : true,     //自动平移
    						searchTypes   :[
    						BMAPLIB_TAB_SEARCH,   //周边检索
    						BMAPLIB_TAB_TO_HERE,  //到这里去
    						//BMAPLIB_TAB_FROM_HERE //从这里出发
    						]
    						});
    						marker[i]= new BMap.Marker(point,{icon:myIcon, enableDragging: false,
    				            raiseOnDrag: true}); //创建marker对象
    						marker[i].addEventListener("click", function(e){
    							searchInfoWindow.open(marker[i]);
    						});
    						map.addOverlay(marker[i]); //在地图中添加marker
    						
    					}
    				else{
    					alert("您选择地址没有解析到结果!");
    				}
    			}, "湖南省");
    		 
    	 }

    
    

}


