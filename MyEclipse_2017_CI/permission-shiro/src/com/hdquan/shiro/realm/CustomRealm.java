package com.hdquan.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomRealm extends AuthorizingRealm{

	
	
	//����realm������
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName("CustomRealm");
	}

	//������֤
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//token���û������
		//��һ�� ��token��ȡ�������Ϣ
		String userCode=(String) token.getPrincipal();
		//�ڶ����������û������userCode�����ݿ��ѯ
		//.......
		//�����ѯ��������null
		//���ݿ����û��˺���zhangsan
//		if(!userCode.equals("zhangsan"))
//		{
//			
//			return null;
//		}
		//ģ������ݿ��ѯ������,������ɢ�к��ֵ
//		String password="1c4d234e3d8307ba8c4c5bd62f8f2fc5";
		String password="1";
		//�����ݻ�ȡsalt
		String salt="hdquan";
		
		
		//�����ѯ��������֤��ϢAuthenticationInfo
//		SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(userCode, password,this.getName());
		//����������ΪByteSource���͵ģ�������ByteSource�ڵķ������Դ���String���͵���ֵ
		SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(userCode, password, ByteSource.Util.bytes(salt), this.getName());
		
		return simpleAuthenticationInfo;
	}
//������Ȩ
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	
		//��principals��ȡ�������Ϣ
		//��getPrimaryPrincipal��������ֵתΪ��ʵ������ͣ����ϱߵ�doGetAuthenticationInfo��֤ͨ����䵽SimpleAuthenticationInfo�е������ϢuserCode��
		String userCode = (String) principals.getPrimaryPrincipal();
		//���������Ϣ��ȡȨ����Ϣ
		//�������ݿ⡣������
		//ģ������ݿ��ȡ����
		List<String> permissions=new ArrayList<String>();
		permissions.add("user:create");//�û��Ĵ���
		permissions.add("items:add");//��Ʒ���Ȩ��
		
		
		//�鵽Ȩ�����ݣ�����---SimpleAuthorizationInfo��Ȩ��Ϣ(Ҫ�����ϱߵ�permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		//���ϱ߲�ѯ����Ȩ��Ϣ��䵽simpleAuthorizationInfo������
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}

}
