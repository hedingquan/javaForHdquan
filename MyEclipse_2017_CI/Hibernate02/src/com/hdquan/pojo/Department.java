package com.hdquan.pojo;

import java.util.HashSet;
import java.util.Set;
//һ�Զ�
public class Department {
	private int deptid;
	private String dname;
	private String location;
	//Employees���������һ������
	//***˫��������ȿ���ͨ��A��ѯ��B��Ҳ����ͨ��B��ѯ��A�����ؼ���set������һ��set�����������кܶ��Employee���ֱ�ָ����Ե�Department��������ȫ��Ա������set��������
	private Set<Employee> Employees=new HashSet<Employee>();
	
//	��һ��ά����ϵ
	public void addEmployee(Employee e) 
	{
		this.getEmployees().add(e);
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Set<Employee> getEmployees() {
		return Employees;
	}
	public void setEmployees(Set<Employee> Employee) {
		this.Employees = Employee;
	}
	
}
