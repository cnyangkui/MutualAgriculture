package com.geowind.hunong.entity;

/**
 * 订单项实体
 * Created by Jiang 2016/7/20.
 */
public class OrderItem {
    //订单项编号
    private int no;
    //农资编号
    private int rno;
    //数量
    private int num;
    //订单总价
    private double totalPrice;
    //订单号
    private String orderNo;

    //无参构造函数
    public OrderItem(){

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "no=" + no +
                ", rno=" + rno +
                ", num=" + num +
                ", totalPrice=" + totalPrice +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}
