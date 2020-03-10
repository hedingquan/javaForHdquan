package com.hdquan.shiro.authorization;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class AuthorizationTest {
	
	//角色授权、资源授权测试
	
	@Test
	public void testAuthorization()
	{
		//创建securityManager工程
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-permission.ini");
		SecurityManager securityManager = factory.getInstance();
		//将securityManager设置到系统运行环境，和spring后将securityManager配置spring容器中，一般单例管理
		SecurityUtils.setSecurityManager(securityManager);;
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","123");
		
		//执行认证
			try {
				subject.login(token);
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("认证状态："+subject.isAuthenticated());
			//认证通过后执行授权
			//基于角色的授权
			//hasRole传入角色的标识符
			boolean ishasRole = subject.hasRole("role1");
			//hasAllRoles是否拥有多个角色,Arrays.asList可以添加多个String类型
			boolean hasAllRoles=subject.hasAllRoles(Arrays.asList("role1","role2","role3"));
			
			//使用check方法进行授权，如果授权不通过会抛出异常
			subject.checkRole("role1");
			
			System.out.println("单个角色判断"+ishasRole);
			System.out.println("多个角色判断"+hasAllRoles);
		
			//基于资源的授权
			//isPermitted传入权限标识符
			boolean ispermitted = subject.isPermitted("user:create:1");
			System.out.println("单个权限判断"+ispermitted);
			
			boolean isPermittedAll=subject.isPermittedAll("user:create:1","user:update");
			System.out.println("多个权限判断"+isPermittedAll);
			
			//使用Permission方法进行授权，如果授权不通过会抛出异常
			subject.checkPermission("user:create:1");
	}
	
	
	//自定义realm进行资源授权测试
	@Test
	public void testAuthorizationCustomRealm()
	{
		//创建securityManager工程
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		//将securityManager设置到系统运行环境，和spring后将securityManager配置spring容器中，一般单例管理
		SecurityUtils.setSecurityManager(securityManager);;
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","1");
		
		//执行认证
			try {
				subject.login(token);
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("认证状态："+subject.isAuthenticated());

			
			
			//基于资源的授权，只要调用ispermitted方法，就会调用CustomRealm从数据库查询正确权限数据
			//isPermitted传入权限标识符，判断user:create:1是否在CustomRealm查询到的权限之内
			boolean ispermitted = subject.isPermitted("user:create:1");
			System.out.println("单个权限判断"+ispermitted);
			
			boolean isPermittedAll=subject.isPermittedAll("user:create:1","user:update");
			System.out.println("多个权限判断"+isPermittedAll);
			
			//使用Permission方法进行授权，如果授权不通过会抛出异常
			subject.checkPermission("items:add:1");
	}
}
