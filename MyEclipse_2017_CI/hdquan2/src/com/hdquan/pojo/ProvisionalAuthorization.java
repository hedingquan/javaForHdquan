package com.hdquan.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ProvisionalAuthorization {
	@Id
	@GeneratedValue(generator = "user")
	@GenericGenerator(name = "user", strategy = "assigned")
	private String usercode;//用户姓名
	private String roleid;
	private String RecoveryTime;

	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getRecoveryTime() {
		return RecoveryTime;
	}
	public void setRecoveryTime(String recoveryTime) {
		RecoveryTime = recoveryTime;
	}
	
}
