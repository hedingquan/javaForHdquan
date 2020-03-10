package com.pojo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chat {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String chat_id;
	private String user_id1;
	private String user_id2;
	private Date chat_time;
	private String chat_content;
	public String getChat_id() {
		return chat_id;
	}
	public void setChat_id(String chat_id) {
		this.chat_id = chat_id;
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
	public Date getChat_time() {
		return chat_time;
	}
	public void setChat_time(Date chat_time) {
		this.chat_time = chat_time;
	}
	public String getChat_content() {
		return chat_content;
	}
	public void setChat_content(String chat_content) {
		this.chat_content = chat_content;
	}
	@Override
	public String toString() {
		return "Chat [chat_id=" + chat_id + ", user_id1=" + user_id1 + ", user_id2=" + user_id2 + ", chat_time="
				+ chat_time + ", chat_content=" + chat_content + "]";
	}
	
}
