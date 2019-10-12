package com.geowind.hunong.entity;

/**
 * 服务中心
 * Created by Kui on 2016/7/20.
 */
public class ServiceCenter {

    //编号
    private int no;
    //地址
    private String address;
    //级别
    private String level;
    //名称
    private String name;
    //负责人
    private String principal;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "ServiceCenter{" +
                "no=" + no +
                ", address='" + address + '\'' +
                ", level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", principal='" + principal + '\'' +
                '}';
    }
}
