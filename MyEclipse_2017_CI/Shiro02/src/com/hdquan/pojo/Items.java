package com.hdquan.pojo;

import java.util.Date;

public class Items {
private Integer id;
private String name;
private Float price;
private String prive;
private Date createtime;
private String detail;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Float getPrice() {
	return price;
}
public void setPrice(Float price) {
	this.price = price;
}
public String getPrive() {
	return prive;
}
public void setPrive(String prive) {
	this.prive = prive;
}
public Date getCreatetime() {
	return createtime;
}
public void setCreatetime(Date createtime) {
	this.createtime = createtime;
}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}

}
