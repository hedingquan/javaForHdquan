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
	
	//��ɫ��Ȩ����Դ��Ȩ����
	
	@Test
	public void testAuthorization()
	{
		//����securityManager����
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-permission.ini");
		SecurityManager securityManager = factory.getInstance();
		//��securityManager���õ�ϵͳ���л�������spring��securityManager����spring�����У�һ�㵥������
		SecurityUtils.setSecurityManager(securityManager);;
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","123");
		
		//ִ����֤
			try {
				subject.login(token);
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("��֤״̬��"+subject.isAuthenticated());
			//��֤ͨ����ִ����Ȩ
			//���ڽ�ɫ����Ȩ
			//hasRole�����ɫ�ı�ʶ��
			boolean ishasRole = subject.hasRole("role1");
			//hasAllRoles�Ƿ�ӵ�ж����ɫ,Arrays.asList������Ӷ��String����
			boolean hasAllRoles=subject.hasAllRoles(Arrays.asList("role1","role2","role3"));
			
			//ʹ��check����������Ȩ�������Ȩ��ͨ�����׳��쳣
			subject.checkRole("role1");
			
			System.out.println("������ɫ�ж�"+ishasRole);
			System.out.println("�����ɫ�ж�"+hasAllRoles);
		
			//������Դ����Ȩ
			//isPermitted����Ȩ�ޱ�ʶ��
			boolean ispermitted = subject.isPermitted("user:create:1");
			System.out.println("����Ȩ���ж�"+ispermitted);
			
			boolean isPermittedAll=subject.isPermittedAll("user:create:1","user:update");
			System.out.println("���Ȩ���ж�"+isPermittedAll);
			
			//ʹ��Permission����������Ȩ�������Ȩ��ͨ�����׳��쳣
			subject.checkPermission("user:create:1");
	}
	
	
	//�Զ���realm������Դ��Ȩ����
	@Test
	public void testAuthorizationCustomRealm()
	{
		//����securityManager����
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro-realm.ini");
		SecurityManager securityManager = factory.getInstance();
		//��securityManager���õ�ϵͳ���л�������spring��securityManager����spring�����У�һ�㵥������
		SecurityUtils.setSecurityManager(securityManager);;
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","1");
		
		//ִ����֤
			try {
				subject.login(token);
			} catch (AuthenticationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("��֤״̬��"+subject.isAuthenticated());

			
			
			//������Դ����Ȩ��ֻҪ����ispermitted�������ͻ����CustomRealm�����ݿ��ѯ��ȷȨ������
			//isPermitted����Ȩ�ޱ�ʶ�����ж�user:create:1�Ƿ���CustomRealm��ѯ����Ȩ��֮��
			boolean ispermitted = subject.isPermitted("user:create:1");
			System.out.println("����Ȩ���ж�"+ispermitted);
			
			boolean isPermittedAll=subject.isPermittedAll("user:create:1","user:update");
			System.out.println("���Ȩ���ж�"+isPermittedAll);
			
			//ʹ��Permission����������Ȩ�������Ȩ��ͨ�����׳��쳣
			subject.checkPermission("items:add:1");
	}
}
