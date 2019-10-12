package com.geowind.hunong.entity;

/**
 * Created by Kui on 2016/7/20.
 */
public class FarmResource {

    //编号
    private int no;
    //类型
    private String style;
    //品名
    private String name;
    //单价
    private double price;
    //功效
    private String func;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    @Override
    public String toString() {
        return "FarmResource{" +
                "no=" + no +
                ", style='" + style + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", func='" + func + '\'' +
                '}';
    }
}
