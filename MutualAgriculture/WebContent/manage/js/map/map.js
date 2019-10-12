/**
 * Created by Administrator on 2016/10/5.
 */
// 百度地图API功能，初始化地图
//var map = new BMap.Map("allmap");
var map = new BMap.Map("allmap",{mapType: BMAP_HYBRID_MAP}); 
map.enableScrollWheelZoom(true);  //开启鼠标滚轮缩放

var point = new BMap.Point(112.613455, 27.026652);
map.centerAndZoom(point,16);

var geoc = new BMap.Geocoder();

//定位跳转到当地地图
//var mark;//当前定位标注
//var geolocation = new BMap.Geolocation();
//geolocation.getCurrentPosition(function(r){
//    if(this.getStatus() == BMAP_STATUS_SUCCESS){
//        mark = new BMap.Marker(r.point);
//        map.addOverlay(mark);
//        map.panTo(r.point);
//
//    }
//    else {
//        alert('failed'+this.getStatus());
//    }
//},{enableHighAccuracy: true})

/**
 * 显示详细地址和经纬度
 * @param e
 */
function showInfo(e){
        // alert("经纬度为："+e.point.lng+", "+e.point.lat);
        document.getElementById("coordinate").setAttribute("value",e.point.lng+", "+e.point.lat);
        var pt = e.point;
        var point = new BMap.Point(e.point.lng,e.point.lat);
        geoc.getLocation(pt, function(rs){
        var addComp = rs.addressComponents;
        //alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
         document.getElementById("_address").setAttribute("value",addComp.province  + addComp.city +
                                                addComp.district  + addComp.street + addComp.streetNumber);
    });
        var marker = new BMap.Marker(point);
        map.addOverlay(marker);
     
}
//点击地图获取经纬度和地址
map.addEventListener("click",showInfo);



//初始化地图组件
// 添加带有定位的导航控件
var navigationControl = new BMap.NavigationControl({
    // 靠左上角位置
    anchor: BMAP_ANCHOR_TOP_RIGHT,
    // LARGE类型
    type: BMAP_NAVIGATION_CONTROL_SMALL,
    // 启用显示定位
    enableGeolocation: true
});
map.addControl(navigationControl);
// 添加定位控件
var geolocationControl = new BMap.GeolocationControl();
geolocationControl.addEventListener("locationSuccess", function(e){
    // 定位成功事件
    var address = '';
    address += e.addressComponent.province;
    address += e.addressComponent.city;
    address += e.addressComponent.district;
    address += e.addressComponent.street;
    address += e.addressComponent.streetNumber;
    alert("当前定位地址为：" + address);
});
geolocationControl.addEventListener("locationError",function(e){
    // 定位失败事件
    alert(e.message);
});
map.addControl(geolocationControl);



/**
 * Created by Administrator on 2016/10/5.
 */

map.addControl(new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_LEFT}));   //添加地图类型控件
//var tileLayer = new BMap.TileLayer();
//var mapType = new BMap.MapType("myType",tileLayer);
//map.setMapType(mapType.BMAP_SATELLITE_MAP);





/**
 * Created by Jiang on 2016/10/5.
 */
// 百度地图API功能
function G(id) {
    return document.getElementById(id);
}

var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
    {"input" : "suggestId"
        ,"location" : map
    });


ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
    var str = "";
    var _value = e.fromitem.value;
    var value = "";
    if (e.fromitem.index > -1) {
        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    }
    str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

    value = "";
    if (e.toitem.index > -1) {
        _value = e.toitem.value;
        value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    }
    str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
    G("searchResultPanel").innerHTML = str;
});

var myValue;
ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
    var _value = e.item.value;
    myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
    G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

    setPlace();
});


function setPlace(){
    //map.clearOverlays();    //清除地图上所有覆盖物
    function myFun(){
        var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
        map.centerAndZoom(pp, 18);
        
        mark = new BMap.Marker(pp);
        map.addOverlay(mark);    //添加标注
    }
    var local = new BMap.LocalSearch(map, { //智能搜索
        onSearchComplete: myFun
    });
    local.search(myValue);
}







