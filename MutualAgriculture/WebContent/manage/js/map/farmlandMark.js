/**
 * Created by Jiang on 2016/10/19.
 * 农田信息标注显示
 */
    var json;
    var markera = new Array();
    //url:请求获得农田list数据的url地址
    var url = "../bFarmlandServlet?op=getFarmlands";
    
    /**
    * 向数据库发送请求数据
     * url : 表示请求的url地址
     * data:表示后台返回的农田List类型数据
    */
    $.post(url,{},function getData(data){
        json = eval("(" + data + ")");
        for(var i=0;i<json.length;i++)
        {
            //循环数据 json[i]//获取数据操作
            //获得经纬度生成piont点
             var point = new BMap.Point(json[i].longitude,json[i].latitude);
            //添加标注和标签显示农田信息
            addMarker(point,new BMap.Label("农田显示数据："+json[i].address,{offset:new BMap.Size(20,-10)}));
        }
    });

	// 编写自定义函数,创建标注
	function addMarker(point,label){
		var marker = new BMap.Marker(point);
		map.addOverlay(marker);
		marker.setLabel(label);
	}

