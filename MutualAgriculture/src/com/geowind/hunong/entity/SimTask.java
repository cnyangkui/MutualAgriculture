package com.geowind.hunong.entity;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import com.geowind.hunong.jpa.Task;
import com.geowind.hunong.util.ServerIpUtil;
import com.google.gson.annotations.Expose;

public class SimTask {
	
	//任务编号
	@Expose
	private int tid;
    //农机手
	@Expose
    private String muser;
    //块编号
	@Expose
    private int bid;
	//块名
	@Expose
	private String bname;
    //工作量
	@Expose
    private String workload;
    //农机编号
	@Expose
    private String mid;
    //作业类型
	@Expose
    private String  type;
    //日期
	@Expose
    private Date date;
    //状态
	@Expose
    private String state;
    //农田分区名
	@Expose
    private String zonename;
    //块面积
	@Expose
    private double barea;
    //块地址
	@Expose
    private String address;
    //经度
	@Expose
    private double longitude;
    //纬度
	@Expose
    private double latitude;
    //农田照片
	@Expose
    private String pic;
    //作物类型
	@Expose
    private String croptype;
    //农机类型
	@Expose
    private String mstyle;
    //备注
	@Expose
    private String note;
    
	
	
	
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getMuser() {
		return muser;
	}
	public void setMuser(String muser) {
		this.muser = muser;
	}
	public String getWorkload() {
		return workload;
	}
	public void setWorkload(String workload) {
		this.workload = workload;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getZonename() {
		return zonename;
	}
	public void setZonename(String zonename) {
		this.zonename = zonename;
	}
	public double getBarea() {
		return barea;
	}
	public void setBarea(double barea) {
		this.barea = barea;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getCroptype() {
		return croptype;
	}
	public void setCroptype(String croptype) {
		this.croptype = croptype;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public void setFpicPath(String fpic) {
		this.pic = "http://115.159.125.122:8080/MutualAgriculture/"+ fpic;
		System.out.println("address:"+this.pic);
	}
	public String getMstyle() {
		return mstyle;
	}
	public void setMstyle(String mstyle) {
		this.mstyle = mstyle;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
    
	
	public SimTask fromTask(Task task) {
		if(task == null) {
			return null;
		} else {
			SimTask simTask = new SimTask();
			simTask.setTid(task.getTaskId());
			simTask.setMuser(task.getUser().getUsername());
			simTask.setBid(task.getBlock().getBid());
			simTask.setBname(task.getBlock().getBname());
			simTask.setWorkload(String.valueOf(task.getWorkload()));
			simTask.setMid(task.getMachine().getPlate());
			simTask.setType(task.getType());
			simTask.setDate(task.getWorkdate());
			simTask.setState(String.valueOf(task.getFinished()));
			simTask.setZonename(task.getBlock().getZone().getZonename());
			simTask.setBarea(task.getBlock().getArea());
			simTask.setAddress(task.getBlock().getAddress());
			simTask.setLongitude(task.getBlock().getLongitude());
			simTask.setLatitude(task.getBlock().getLatitude());
			simTask.setFpicPath(task.getBlock().getPicture());
			simTask.setCroptype(task.getBlock().getZone().getType());
			simTask.setMstyle(task.getMachine().getType());
			simTask.setNote(task.getDescr());
			return simTask;
		}
	}
	@Override
	public String toString() {
		return "SimTask [tid=" + tid + ", muser=" + muser + ", bid=" + bid + ", bname=" + bname + ", workload="
				+ workload + ", mid=" + mid + ", type=" + type + ", date=" + date + ", state=" + state + ", zonename="
				+ zonename + ", barea=" + barea + ", address=" + address + ", longitude=" + longitude + ", latitude="
				+ latitude + ", pic=" + pic + ", croptype=" + croptype + ", mstyle=" + mstyle + ", note=" + note + "]";
	}
	
	
}