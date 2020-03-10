package com.hdquan.shiro.realm;


import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.hdquan.MD5.CaptchaToken;


public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{

	
    @Override
	public void setLoginUrl(String loginUrl) {
    	String OverrideloginUrl="/login.action";
		super.setLoginUrl(OverrideloginUrl);
	}

	@Override
    protected AuthenticationToken createToken(String username, String password, ServletRequest request, ServletResponse response) {

        String captchaCode = request.getParameter("captchaCode");
       boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
        return new CaptchaToken(username, password, rememberMe, host,captchaCode);
    }
}
