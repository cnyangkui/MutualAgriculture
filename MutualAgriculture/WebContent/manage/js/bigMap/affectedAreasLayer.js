/**
 * Created by Jiang on 2016/10/19.
 * 农田受灾区
 */

function addAffectAreasLayer(){
    	
	map.clearOverlays();
	var url = "../pestZoneServlet?op=MapSearchAffectedArea";
	var json;
	var ply=[];
	var myIcon = new BMap.Icon("img/logoMarker/location.png", new BMap.Size(36,36),
	        {anchor:new BMap.Size(18,36),infoWindowAnchor: new BMap.Size(18, 0)} );
	$.post(url,{},function getData(data){
		//alert(data);
		json = JSON.parse(data);
//		alert(json.length+" ,"+json[0].pointList.length);
		for(var j=0;j<json.length;j++){
		
			var pts =[];
			//绘出边界点
			for(var i=0;i<json[j].pointList.length-1;i++){
				
				var pt = new BMap.Point(json[j].pointList[i].x,json[j].pointList[i].y);
				pts.push(pt);
			}
			var pt1 = new BMap.Point(json[j].pointList[0].x,json[j].pointList[0].y)
			var marker = new BMap.Marker(pt1,{icon:myIcon, enableDragging: false,
	            raiseOnDrag: true});
			   ply[j] = new BMap.Polygon(pts);    
	            var area = BMapLib.GeoUtils.getPolygonArea(ply[j]);
	            var mu = area.toFixed(2)*0.0015;

	            	 var label = new BMap.Label("共" + area.toFixed(2) + "平方米, 共有 "+mu+"亩",{offset:new BMap.Size(20,-10)})	
	            	 map.addOverlay(marker);
	            	 marker.setLabel(label);

	            //演示：将面添加到地图上    
	            //map.clearOverlays();
	            map.addOverlay(ply[j]); 
		}
	});
	
	
	
}