/**
 * 计算面积
 */
var pointArray = new Array();
var pts = [];
var i=0;
var checkOpenAddPoint = false;
function addPoint(){
		if(!checkOpenAddPoint){
				
//			    var content = '点击“添加标注点”后可使用 鼠标右键 按照顺时针或逆时针有序点击地图添加标注点,' +
//								'选择完标注点后点击面板上的 计算面积 即可得出所标注图形构成的面积,' +
//								'点击 ”功能选择“的 重置 即可取消该功能！'
//				alert(content);
				
			
			    checkOpenAddPoint = true;
			    
				map.addEventListener("rightclick",showInfo);
		}
}

function showInfo(e){
    
    pointArray[i] = new BMap.Point(e.point.lng, e.point.lat);

    pts.push(pointArray[i]);
    
    var marker = new BMap.Marker(pointArray[i]);
    map.addOverlay(marker);
    i++; 
	  if(i>1){
			var k = i-1;
			var polyline = new BMap.Polyline(pts, {strokeColor:"blue", strokeWeight:2, strokeOpacity:0.5});   //创建折线
			map.addOverlay(polyline);   //增加折线
		  }  
}




function addComputerAreaResult(){
	if(pts.length<3){
		$("#hinttext").text("请选择至三个标注点！如若没有启用计算面积功能，应先点击 添加标注点 !");
	}else{
		var ply = new BMap.Polygon(pts);    
	    var area = BMapLib.GeoUtils.getPolygonArea(ply);
	    var mu = area.toFixed(2)*0.0015;
	    var areas = area.toFixed(2); 
	    $("#hinttext").text(areas +"平方米, 共有 "+mu+"亩");
	    //演示：将面添加到地图上    
	   // map.clearOverlays();
	    map.addOverlay(ply); 
	    pts=[];
	    i=0;
	}
   
    
}
