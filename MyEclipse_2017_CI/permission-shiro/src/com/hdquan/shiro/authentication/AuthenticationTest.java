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
		//����securityManager����,ͨ��ini�����ļ�����SecurityManager����
			Factory<SecurityManager> factory =new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		//����securityManager
			SecurityManager securityManager=factory.getInstance();
		//��securityManager���õ�ǰ�����еĻ�����
				SecurityUtils.setSecurityManager(securityManager);
		//��SecurityUtils��ߴ���һ��Subject
				Subject subject=SecurityUtils.getSubject();
		//����֤�ύǰ׼��token�����ƣ�
				//������˺ź����뽫�������û������ȥ��
			UsernamePasswordToken token=new UsernamePasswordToken("zhangsan", "1");
				//ִ����֤�ύ
				try {
					subject.login(token);
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//�Ƿ���֤ͨ��
			boolean isAuthenticated = subject.isAuthenticated();
			System.out.println("�Ƿ���֤ͨ����"+isAuthenticated);
			
			//�˳�����
			subject.logout();
			//�Ƿ���֤ͨ��
			isAuthenticated = subject.isAuthenticated();
			System.out.println("�Ƿ���֤ͨ����"+isAuthenticated);
		
	}
	
	//�Զ���realmʵ��ɢ��ֵƥ��
	@Test
	public void testCustomRealmMd5()
	{
		//����securityManager����,ͨ��ini�����ļ�����SecurityManager����
			Factory<SecurityManager> factory =new IniSecurityManagerFactory("classpath:shiro-realm-md5.ini");
		//����securityManager
			SecurityManager securityManager=factory.getInstance();
		//��securityManager���õ�ǰ�����еĻ�����
				SecurityUtils.setSecurityManager(securityManager);
		//��SecurityUtils��ߴ���һ��Subject
				Subject subject=SecurityUtils.getSubject();
		//����֤�ύǰ׼��token�����ƣ�
				//������˺ź����뽫�������û������ȥ��
			UsernamePasswordToken token=new UsernamePasswordToken("zhangsan", "1");
				//ִ����֤�ύ
				try {
					subject.login(token);
//					subject.hasRole("role1");
				} catch (AuthenticationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//�Ƿ���֤ͨ��
			boolean isAuthenticated = subject.isAuthenticated();
			System.out.println("�Ƿ���֤ͨ����"+isAuthenticated);
			
		
	}
}
