package com.hdquan.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class User {
	/*private String user_Number;
	private String user_Name;
	private boolean Landing;//�Ƿ��ѵ�½
	private Date Recent_landing_time;//����ĵ�½ʱ��
	private String Host_Address;//��¼��������ַ
	private String Host_name;//��¼��������
	private String name;
	private String password;
*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userNumber;
	private String realName;
	private String job;
	private String PINCodes;//���֤
	private int telephone;
	private int fixedPhone;
	private String eMail;
	private String QQ;
	private String MSN;
	@ManyToOne(cascade=CascadeType.ALL)
	private Department department;
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Role> roles=new HashSet<Role>();
	@ManyToOne(cascade=CascadeType.ALL)
	private UserGroup userGroup;
	

	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
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
	public String getPINCodes() {
		return PINCodes;
	}
	public void setPINCodes(String pINCodes) {
		PINCodes = pINCodes;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public int getFixedPhone() {
		return fixedPhone;
	}
	public void setFixedPhone(int fixedPhone) {
		this.fixedPhone = fixedPhone;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getMSN() {
		return MSN;
	}
	public void setMSN(String mSN) {
		MSN = mSN;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
}
