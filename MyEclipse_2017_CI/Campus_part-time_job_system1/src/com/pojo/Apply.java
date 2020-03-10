package com.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Apply {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int apply_id;
	private String work_id;
	private String user_id;
	private String apply_state;

	public int getApply_id() {
		return apply_id;
	}
	public void setApply_id(int apply_id) {
		this.apply_id = apply_id;
	}
	public String getWork_id() {
		return work_id;
	}
	public void setWork_id(String work_id) {
		this.work_id = work_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getApply_state() {
		return apply_state;
	}
	public void setApply_state(String apply_state) {
		this.apply_state = apply_state;
	}
	@Override
	public String toString() {
		return "Apply [apply_id=" + apply_id + ", work_id=" + work_id + ", user_id=" + user_id + ", apply_state="
				+ apply_state + "]";
	}
	
}
