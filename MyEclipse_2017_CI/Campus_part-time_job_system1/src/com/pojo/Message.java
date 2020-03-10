package com.pojo;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Message {

	private String welcome;
	private List<String> usernames;
	private String content;
	
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setContent(String name,String msg) {
		this.content = name+""+new Date().toLocaleString()+":<br/>"
				+msg+"<br/>";
	}
	
	public String getWelcome() {
		return welcome;
	}
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	public List<String> getUsernames() {
		return usernames;
	}
	public void setUsernames(List<String> usernames) {
		this.usernames = usernames;
	}
	public String toJson()
	{
		ObjectMapper om=new ObjectMapper();
		StringWriter sw=new StringWriter();
		try {
			JsonGenerator jg=new JsonFactory().createJsonGenerator(sw);
			om.writeValue(jg, this);
			jg.close();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sw.toString();
	}
}
