package com.geowind.hunong.entity;

/**
 * 农田分区
 * Created by Kui on 2016/7/20.
 */
public class FarmlandZone {

    //编号
    private int no;
    //面积
    private String area;
    //作物类型
    private String cropStyle;
    //地址
    private String address;
    //服务中心编号
    private String centerId;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCropStyle() {
        return cropStyle;
    }

    public void setCropStyle(String cropStyle) {
        this.cropStyle = cropStyle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    @Override
    public String toString() {
        return "FarmlandZone{" +
                "no=" + no +
                ", area='" + area + '\'' +
                ", cropStyle='" + cropStyle + '\'' +
                ", address='" + address + '\'' +
                ", centerId='" + centerId + '\'' +
                '}';
    }
}

