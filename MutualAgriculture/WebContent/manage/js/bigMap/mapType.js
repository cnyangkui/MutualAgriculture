/**
 * Created by Administrator on 2016/10/5.
 */
var mapType1 = new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP]});
var mapType2 = new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_LEFT});

var overView = new BMap.OverviewMapControl();
var overViewOpen = new BMap.OverviewMapControl({isOpen:true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT});
//添加地图类型和缩略图
//function add_control(){
    //map.addControl(mapType1);          //2D图，卫星图
    map.addControl(mapType2);          //左上角，默认地图控件
    map.setCurrentCity("衡阳");        //由于有3D图，需要设置城市哦
    map.addControl(overView);          //添加默认缩略地图控件
    map.addControl(overViewOpen);      //右下角，打开
//}






