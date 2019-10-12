/**
 * Created by Jiang on 2016/10/19.、
 * 农机图层
 */
function addMachineLayer(){
	
		map.clearOverlays();   
	    var json;
	    var marker = new Array();
	    var url = "../bMachineServlet?op=mapSearchAll";
		$.post(url,function getData(data){
			if(data==0){
				alert("查询出错");
			}else{
				 //alert(data);
				 json = JSON.parse(data);
				 for(var i=0;i<json.length;i++)
				 { 	 
					 	var workstate = json[i].workstate==1?"工作中":"闲置中";
					 	var state = json[i].state==1?"正常":"不正常";
					   //农机显示信息
						var content = '<div style="margin:0;line-height:20px;padding:2px;">'+
										'<img src="../'+json[i].picture+'" alt="" style="float:right;zoom:1;overflow:hidden;width:100px;height:100px;margin-left:3px;"/>' +
										'牌号：'+json[i].plate+' 类型：'+json[i].type+
										'<br/>马力：'+json[i].horsepower+' 品牌:'+json[i].brand+
										'<br/>工作状态：'+workstate+'  农机状态:'+state+
								 		'<br/>拥有者姓名：'+json[i].machineowner.name+
								 		'<br/>电话：'+json[i].machineowner.phone+
									  '</div>';
					
					 addMarker(json[i].machineowner.address,i,content);
				 }
			}
			 
		});
		
		var myIcon = new BMap.Icon("img/logoMarker/machine.png", new BMap.Size(36,36),
		        {anchor:new BMap.Size(18,36),infoWindowAnchor: new BMap.Size(18, 0)} );	
		
		function addMarker(address,i,content){
			// 创建地址解析器实例
			var myGeo = new BMap.Geocoder();
			myGeo.getPoint(address, function(point){
				if (point){		
						//创建检索信息窗口对象
						var searchInfoWindow = null;
						searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
						title  : "农机",      //标题
						width  : 290,             //宽度
						height : 130,              //高度
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
						})
						map.addOverlay(marker[i]); //在地图中添加marker
					}
				else{
					alert("您选择地址没有解析到结果!");
				}
			}, "湖南省");
		}
	}
		
