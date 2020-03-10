package com.hdquan.MD5;


import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.shiro.authc.UsernamePasswordToken;


public class CaptchaToken extends UsernamePasswordToken {
 
    private String captchaCode;
	
    private  String hostAddress;
    
    public CaptchaToken() {
    }
    
    public CaptchaToken(String username, String password,boolean rememberMe,String host, String captchaCode) {
        super(username, password, rememberMe, host);
        try {
			this.hostAddress= InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        this.captchaCode = captchaCode;
    }
 
    public String getCaptchaCode() {
        return captchaCode;
    }
	public void setCaptchaCode(String captchaCode) {
		this.captchaCode = captchaCode;
	}

	public String getHostAddress() {
		return hostAddress;
	}

	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}
}
