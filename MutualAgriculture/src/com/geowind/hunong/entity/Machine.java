package com.geowind.hunong.entity;

import java.util.Date;

/**
 * Created by Kui on 2016/7/20.
 */
public class Machine {
    //编号
    private int no;
    //牌号
    private String plate;
    //类型
    private String style;
    //品牌
    private String brand;
    //马力
    private int hp;
    //使用年限
    private Date retirementDate;
    //实物图
    private String picUrl;
    //拥有者编号
    private int ono;
    //状态
    private int state;
    //工作状态
    private int workState;

    public Machine(String no) {
    }


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Date getRetirementDate() {
        return retirementDate;
    }

    public void setRetirementDate(Date retirementDate) {
        this.retirementDate = retirementDate;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getOno() {
        return ono;
    }

    public void setOno(int ono) {
        this.ono = ono;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getWorkState() {
        return workState;
    }

    public void setWorkState(int workState) {
        this.workState = workState;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "no=" + no +
                ", plate='" + plate + '\'' +
                ", style='" + style + '\'' +
                ", brand='" + brand + '\'' +
                ", hp=" + hp +
                ", retirementDate=" + retirementDate +
                ", picUrl='" + picUrl + '\'' +
                ", ono=" + ono +
                ", state=" + state +
                ", workState=" + workState +
                '}';
    }
}
