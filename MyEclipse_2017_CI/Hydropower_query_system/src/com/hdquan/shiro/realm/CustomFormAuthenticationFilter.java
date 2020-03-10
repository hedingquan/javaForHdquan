package com.hdquan.shiro.realm;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{

	
    @Override
	public void setLoginUrl(String loginUrl) {
    	String OverrideloginUrl="/login.action";
		super.setLoginUrl(OverrideloginUrl);
	}
    
}
