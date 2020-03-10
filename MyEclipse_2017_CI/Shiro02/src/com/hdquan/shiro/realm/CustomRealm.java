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

	//注入service
	@Autowired
//	private SysService sysService;
	private MenuService menuService;

	public void setName(String name) {
		super.setName("CustomRealm");
	}
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
			String userCode=(String) token.getPrincipal();
//		根据用户名userCode查询出信息
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
		
//		先使用静态代码实现
		//根据用户id取菜单
		//通过service取出菜单
//		List<Syspermisson> menus=null;
//		menus=sysService.findMenuListByUserId("hdquan");
//		将用户菜单设置到User
//		user.setMenus(menus);
		
		
	SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(userCode, password, ByteSource.Util.bytes(salt), this.getName());
//	将变动好的user(即用户的身份信息)代替userCode
//	SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(user, password, ByteSource.Util.bytes(salt), this.getName());
		return simpleAuthenticationInfo;
	}
	
	
	
	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	
		String userCode = (String) principals.getPrimaryPrincipal();
//	Principal已经变成user了。	User user = (user) principals.getPrimaryPrincipal();
		List<String> permissions=new ArrayList<String>();
		permissions.add("user:create");
		permissions.add("items:add");
		
//		从数据库中获取权限数据
//		List<Syspermission> permissionList=null;
//		permissionList=sysService.findPermissionListByUserId(user.getUserid());
//		List<String> permissions=new ArrayList<String>();单独定义一个集合
//		if(permissionList!null)
//		{
			
//			for(SysPermission sysPermission:permissionList)
//				{
//			将数据库中的权限标签符放入集合
//					permissions.add(sysPermission.getpercode);
//				}	
//		}
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}

//	清除缓存
		public void clearCache()
		{
			PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
			super.clearCache(principals);
		}
}
