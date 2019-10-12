package com.geowind.hunong.entity;

/**
 * 农机主
 * Created by Kui on 2016/7/20.
 */
public class MachineOwner {

    //编号
    private int no;
    //手机号
    private String phone;
    //姓名
    private String name;
    //地址
    private String address;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "MachineOwner{" +
                "no=" + no +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
