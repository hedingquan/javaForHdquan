package com.hdquan.pojo;

import java.io.Serializable;
import java.util.Date;

public class ActiveUser implements java.io.Serializable{
	private Serializable id;
	private Date startTimestamp;
	private Object host;
	private Date lastAccessTime;
	private long timeout;
	private Object use;
	
	public Object getUse() {
		return use;
	}
	public void setUse(Object use) {
		this.use = use;
	}
	public Serializable getId() {
		return id;
	}
	public void setId(Serializable id) {
		this.id = id;
	}
	public Date getStartTimestamp() {
		return startTimestamp;
	}
	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}
	
	public Object getHost() {
		return host;
	}
	public void setHost(Object host) {
		this.host = host;
	}
	public Date getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	public long getTimeout() {
		return timeout;
	}
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}
	
	
}
