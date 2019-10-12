/**
 * 维修点层
 */

function addRepairLayer(){
	
map.clearOverlays();
    
    var json;
    var marker = new Array();
    var url = "../serviceStaionServlet?op=MapSearchAll";
	$.post(url,{},function getData(data){
		
		if(data==0){
			alert("查询出错");
		}else{
			//alert(data);
			 json = JSON.parse(data);
			 for(var i=0;i<json.length;i++)
			 { 
				 //循环数据 json[i]//获取数据操作 
				 //alert(json[i].langitude+" "+json[i].latitude);
				 var pointa = new BMap.Point(json[i].longitude,json[i].latitude);
				 var label = new BMap.Label("维修点负责人:"+json[i].spname+" 电话:"+json[i].sptel,{offset:new BMap.Size(20,-10)});	
				 addMarker(pointa,i,label);
			 }
		}
		 
	});
	
	
	var myIcon = new BMap.Icon("img/logoMarker/repair.png", new BMap.Size(36,36),
	        {anchor:new BMap.Size(18,36),infoWindowAnchor: new BMap.Size(18, 0)} );
		
	function addMarker(point,i,label){
		
		marker[i] = new BMap.Marker(point,{icon:myIcon, enableDragging: false,
            raiseOnDrag: true}); //创建marker对象
	
		map.addOverlay(marker[i]); //在地图中添加marker
		marker[i].setLabel(label);
	}
	

}