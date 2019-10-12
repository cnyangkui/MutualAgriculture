package com.geowind.hunong.entity;

/**
 * Created by Jiang on 2016/7/20.
 */
public class FRTrader {
    //农资商编号
    private int no;
    //农资商电话号码
    private String phone;
    //农资商姓名
    private String name;
    //农资商信誉
    private String credit;
    //农资商地址
    private String address;

    //无参构造函数
    public FRTrader(){

    }

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

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "FRTrader{" +
                "no=" + no +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", credit='" + credit + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
