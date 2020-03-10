package com.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Work {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int work_id;
	private String	user_id;
	private String	work_title;
	private Integer work_time;
	private Integer work_money;
	private String	work_place;
	private String work_content;
	private String work_description;
	private Integer work_state;
	private Integer work_number;
	
	public String getWork_description() {
		return work_description;
	}
	public void setWork_description(String work_description) {
		this.work_description = work_description;
	}
	public int getWork_id() {
		return work_id;
	}
	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getWork_title() {
		return work_title;
	}
	public void setWork_title(String work_title) {
		this.work_title = work_title;
	}
	public Integer getWork_time() {
		return work_time;
	}
	public void setWork_time(Integer work_time) {
		this.work_time = work_time;
	}
	public Integer getWork_money() {
		return work_money;
	}
	public void setWork_money(Integer work_money) {
		this.work_money = work_money;
	}
	public String getWork_place() {
		return work_place;
	}
	public void setWork_place(String work_place) {
		this.work_place = work_place;
	}
	public String getWork_content() {
		return work_content;
	}
	public void setWork_content(String work_content) {
		this.work_content = work_content;
	}
	public Integer getWork_state() {
		return work_state;
	}
	public void setWork_state(Integer work_state) {
		this.work_state = work_state;
	}
	public Integer getWork_number() {
		return work_number;
	}
	public void setWork_number(Integer work_number) {
		this.work_number = work_number;
	}
	@Override
	public String toString() {
		return "Work [work_id=" + work_id + ", user_id=" + user_id + ", work_title=" + work_title + ", work_time="
				+ work_time + ", work_money=" + work_money + ", work_place=" + work_place + ", work_content="
				+ work_content + ", work_description=" + work_description + ", work_state=" + work_state
				+ ", work_number=" + work_number + "]";
	}
}
