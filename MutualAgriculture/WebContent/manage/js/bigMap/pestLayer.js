/**
 * Created by Jiang on 2016/10/19.
 * 添加虫害图层
 */
function addPestLayer(){
	
   	map.clearOverlays();
    var json;
    var marker = new Array();
    var url = "../pestZoneServlet?op=MapSearchAll";
	$.post(url,{},function getData(data){
		 //alert(data);
		 json = JSON.parse(data);
		 for(var i=0;i<json.length;i++)
		 {
			 var pestType = checkPestType(json[i].ptype);
				 
			var diseaseType = checkDiseaseType(json[i].itype);
			
			var degree = checkServe(json[i].degree)
			 //循环数据 json[i]//获取数据操作 
			 var content =  '<div style="margin:0;line-height:20px;padding:2px;">'+
							//'<img src="" alt="" style="float:right;zoom:1;overflow:hidden;width:100px;height:100px;margin-left:3px;"/>' +
							'病害程度：'+degree+
							'<br/>虫害类型：'+json[i].ptype+
							'<br/>病害类型：'+diseaseType+
							'</div>';
			 addMarker(json[i].zone.address,i,content);
		 }
	});
	
	var myIcon = new BMap.Icon("img/logoMarker/pest.png", new BMap.Size(36,36),
		        {anchor:new BMap.Size(18,36),infoWindowAnchor: new BMap.Size(18, 0)} );
	 // 编写自定义函数,创建标注
    function addMarker(address,i,content){
    	// 创建地址解析器实例
		var myGeo = new BMap.Geocoder();
		myGeo.getPoint(address, function(point){
			if (point){		
					//创建检索信息窗口对象
					var searchInfoWindow = null;
					searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
					title  : "病害",      //标题
					width  : 250,             //宽度
					height : 100,              //高度
					panel  : "panel",         //检索结果面板
					enableAutoPan : true,     //自动平移
					searchTypes   :[
					BMAPLIB_TAB_SEARCH,   //周边检索
					BMAPLIB_TAB_TO_HERE,  //到这里去
					//BMAPLIB_TAB_FROM_HERE //从这里出发
					]
					});
					marker[i]= new BMap.Marker(point,{icon:myIcon, enableDragging: true,
			            raiseOnDrag: true}); //创建marker对象
					marker[i].addEventListener("click", function(e){
						searchInfoWindow.open(marker[i]);
					});
					map.addOverlay(marker[i]); //在地图中添加marker
					marker[i].setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
				}
			else{
				alert("您选择地址没有解析到结果!");
			}
		}, "湖南省");
    }
}


function checkDiseaseType(disease){
	var re = "";

	switch(disease){
		case "1":
			re = "白粉病";
			break;
		case "2":
			{re = "锈病";
			break;}
		case "3":
			re = "炭疽病";
			break;
		case "4":
			re = "叶斑病";
			break;
		case "5":
			re = "花腐病";
			break;
		case "6":
			re = "煤污病";
			break;
		case "7":
			re = "丛枝病";
			break;
		case "8":
			re = "菟丝子病";
			break;
		case "9":
			re = "稻瘟病";
			break;
		case "10":
			re = "纹枯病";
			break;
		default:
				break;
	}
	return re;
}



function checkPestType(pest){
	var re ="";
	switch(pest){
		case "1":
			re = "白粉虱";
			break;
			
		case "2":
			re = "介壳虫";
			break;
			
		case "3":
			re = "稻飞虱";
			break;
			
		case "4":
			re = "蚜虫";
			break;
			
		case "5":
			re = "棉红蜘蛛";
			break;
			
		case "6":
			re = "卷叶蛾";
			break;
			
		case "7":
			re = "蓟马";
			break;
			
		case "8":
			re = "天牛";
			break;
			
		case "9":
			re = "吊丝虫";
			break;
			
		case "10":
			re = "烟青虫";
			break;
			
		case "11":
			re = "地老虎";
			break;
		case "12":
			re = "水稻螟虫";
			break;
		case "13":
			re = "稻赤斑黑沫蝉 ";
			break;
		default:
			break;
	}
	return re;
}

function checkServe(serve){
	
	var re = "";
	switch(serve){
	
		case "1":
			re = "严重";
			break;
		case "2":
			re = "普通";
			break;
		case "3":
			re = "轻微";
			break;
	}
	return re;
}


