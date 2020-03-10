package com.hdquan.pojo;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*private String user_Number;
	private String user_Name;
	private boolean Landing;
	private Date Recent_landing_time;
	private String Host_Address;ַ
	private String Host_name;
	private String name;
	private String password;
*/
	@Id
	@GeneratedValue(generator = "user")
	@GenericGenerator(name = "user", strategy = "assigned")
	private String userid;//�û�id(����)
	private String realName;
	private String sex;
	private String birthday;
	private String job;
	private String pincodes;//���֤
	private String telephone;
	private String fixedPhone;
	private String eMail;
	private String qq;
	private String msn;
	private String postalAddress;
	private String postalCode;
	
	@ManyToOne(cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	private Department department;
	
	@ManyToMany(fetch=FetchType.EAGER,cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Role> roles=new HashSet<Role>();
	
	@ManyToOne(cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE})
	private UserGroup userGroup;
	
	private String usercode;
	private String username;
//	private List<Permission> menus;//�˵�
//	private List<Permission> permissions;//Ȩ��
	
	
	
	public String getUsercode() {
		return usercode;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFixedPhone() {
		return fixedPhone;
	}
	public void setFixedPhone(String fixedPhone) {
		this.fixedPhone = fixedPhone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPincodes() {
		return pincodes;
	}
	public void setPincodes(String pincodes) {
		this.pincodes = pincodes;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public String getPostalAddress() {
		return postalAddress;
	}
	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
