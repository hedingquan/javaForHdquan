package com.hdquan.pojo;

public class SysPermission implements java.io.Serializable{
	private Long id;
	private String name;
	private String type;
	private String url;
	private String percode;
	private Long parentid;
	private String parentids;
	private String sortString;
	private String available;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPercode() {
		return percode;
	}
	public void setPercode(String percode) {
		this.percode = percode;
	}
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	public String getParentids() {
		return parentids;
	}
	public void setParentids(String parentids) {
		this.parentids = parentids;
	}
	public String getSortString() {
		return sortString;
	}
	public void setSortString(String sortString) {
		this.sortString = sortString;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
}
