package com.hdquan.shiro.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class AuthenticationTest {
	@Test
	public void testCustomRealm()
	{
		//创建securityManager工厂,通过ini配置文件创建SecurityManager工厂
			Factory<SecurityManager> factory =new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		//创建securityManager
			SecurityManager securityManager=factory.getInstance();
		//将securityManager设置当前的运行的环境中
				SecurityUtils.setSecurityManager(securityManager);
		//从SecurityUtils里边创建一个Subject
				Subject subject=SecurityUtils.getSubject();
		//在认证提交前准备token（令牌）
				//这里的账号和密码将来是由用户输入进去的
			UsernamePasswordToken token=new UsernamePasswordToken("zhangsan", "1");
				//执行认证提交
				try {
					subject.login(token);
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//是否认证通过
			boolean isAuthenticated = subject.isAuthenticated();
			System.out.println("是否认证通过："+isAuthenticated);
			
			//退出操作
			subject.logout();
			//是否认证通过
			isAuthenticated = subject.isAuthenticated();
			System.out.println("是否认证通过："+isAuthenticated);
		
	}
	
	//自定义realm实现散列值匹配
	@Test
	public void testCustomRealmMd5()
	{
		//创建securityManager工厂,通过ini配置文件创建SecurityManager工厂
			Factory<SecurityManager> factory =new IniSecurityManagerFactory("classpath:shiro-realm-md5.ini");
		//创建securityManager
			SecurityManager securityManager=factory.getInstance();
		//将securityManager设置当前的运行的环境中
				SecurityUtils.setSecurityManager(securityManager);
		//从SecurityUtils里边创建一个Subject
				Subject subject=SecurityUtils.getSubject();
		//在认证提交前准备token（令牌）
				//这里的账号和密码将来是由用户输入进去的
			UsernamePasswordToken token=new UsernamePasswordToken("zhangsan", "1");
				//执行认证提交
				try {
					subject.login(token);
//					subject.hasRole("role1");
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//是否认证通过
			boolean isAuthenticated = subject.isAuthenticated();
			System.out.println("是否认证通过："+isAuthenticated);
			
		
	}
}
