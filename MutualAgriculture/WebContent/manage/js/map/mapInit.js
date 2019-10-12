/**
 * Created by Administrator on 2016/10/5.
 */
// 百度地图API功能
var map = new BMap.Map("allmap");
map.enableScrollWheelZoom(true);  //开启鼠标滚轮缩放

var point = new BMap.Point(112.552478,26.923761);
map.centerAndZoom(point,12);

var geoc = new BMap.Geocoder();

//定位跳转到当地地图
var geolocation = new BMap.Geolocation();
geolocation.getCurrentPosition(function(r){
    if(this.getStatus() == BMAP_STATUS_SUCCESS){
        var mk = new BMap.Marker(r.point);
        map.addOverlay(mk);
        map.panTo(r.point);

    }
    else {
        alert('failed'+this.getStatus());
    }
},{enableHighAccuracy: true})


function showInfo(e){
        // alert("经纬度为："+e.point.lng+", "+e.point.lat);
        document.getElementById("coordinate").setAttribute("value",e.point.lng+", "+e.point.lat);
        var pt = e.point;
        geoc.getLocation(pt, function(rs){
        var addComp = rs.addressComponents;
        //alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
         document.getElementById("_address").setAttribute("value",addComp.province  + addComp.city +
                                                addComp.district  + addComp.street + addComp.streetNumber);
    });
}
map.addEventListener("click",showInfo);





