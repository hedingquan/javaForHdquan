package com.hdquan.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.hdquan.pojo.User;
import com.hdquan.service.MenuService;

public class CustomRealm extends AuthorizingRealm{

	//ע��service
	@Autowired
//	private SysService sysService;
	private MenuService menuService;

	public void setName(String name) {
		super.setName("CustomRealm");
	}
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
			String userCode=(String) token.getPrincipal();
//		�����û���userCode��ѯ����Ϣ
//		SysUser sysUser=sysService.findSysUserByUserCode(userCode);
//			if(sysUser=null)
//			{
//				return null;
//			}
//			String password=sysUser.getPassword();
		
		String password="1";
		String salt="hdquan";
		
		User user=new User();
		user.setUsercode("hdquan");
		user.setId("hdquan");
		
//		��ʹ�þ�̬����ʵ��
		//�����û�idȡ�˵�
		//ͨ��serviceȡ���˵�
//		List<Syspermisson> menus=null;
//		menus=sysService.findMenuListByUserId("hdquan");
//		���û��˵����õ�User
//		user.setMenus(menus);
		
		
	SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(userCode, password, ByteSource.Util.bytes(salt), this.getName());
//	���䶯�õ�user(���û��������Ϣ)����userCode
//	SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(user, password, ByteSource.Util.bytes(salt), this.getName());
		return simpleAuthenticationInfo;
	}
	
	
	
	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	
		String userCode = (String) principals.getPrimaryPrincipal();
//	Principal�Ѿ����user�ˡ�	User user = (user) principals.getPrimaryPrincipal();
		List<String> permissions=new ArrayList<String>();
		permissions.add("user:create");
		permissions.add("items:add");
		
//		�����ݿ��л�ȡȨ������
//		List<Syspermission> permissionList=null;
//		permissionList=sysService.findPermissionListByUserId(user.getUserid());
//		List<String> permissions=new ArrayList<String>();��������һ������
//		if(permissionList!null)
//		{
			
//			for(SysPermission sysPermission:permissionList)
//				{
//			�����ݿ��е�Ȩ�ޱ�ǩ�����뼯��
//					permissions.add(sysPermission.getpercode);
//				}	
//		}
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}

//	�������
		public void clearCache()
		{
			PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
			super.clearCache(principals);
		}
}
