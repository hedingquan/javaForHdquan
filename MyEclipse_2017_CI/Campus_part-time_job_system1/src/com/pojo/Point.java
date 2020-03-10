package com.pojo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Point {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int point_id;
	private String user_id1;
	private String user_id2;
	private String point_time;
	private Integer point_score;

	public int getPoint_id() {
		return point_id;
	}
	public void setPoint_id(int point_id) {
		this.point_id = point_id;
	}
	public String getUser_id1() {
		return user_id1;
	}
	public void setUser_id1(String user_id1) {
		this.user_id1 = user_id1;
	}
	public String getUser_id2() {
		return user_id2;
	}
	public void setUser_id2(String user_id2) {
		this.user_id2 = user_id2;
	}

	public String getPoint_time() {
		return point_time;
	}
	public void setPoint_time(String string) {
		this.point_time = string;
	}
	public Integer getPoint_score() {
		return point_score;
	}
	public void setPoint_score(Integer point_score) {
		this.point_score = point_score;
	}
	@Override
	public String toString() {
		return "Point [point_id=" + point_id + ", user_id1=" + user_id1 + ", user_id2=" + user_id2 + ", point_time="
				+ point_time + ", point_score=" + point_score + "]";
	}
	
}
