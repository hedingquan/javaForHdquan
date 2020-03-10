package com.hdquan.shiro.realm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

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

import com.hdquan.MD5.CaptchaToken;
import com.hdquan.pojo.Permission;
import com.hdquan.pojo.ProvisionalAuthorization;
import com.hdquan.pojo.Role;
import com.hdquan.pojo.User;
import com.hdquan.service.PermissionService;
import com.hdquan.service.ProvisionalAuthorizationService;
import com.hdquan.service.RoleService;
import com.hdquan.service.UserService;



public class PermissionRealm extends AuthorizingRealm{

	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomRealm customRealm;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ProvisionalAuthorizationService provisionalAuthorizationService;
	
	public void setName(String name) {
		super.setName("PermissionRealm");
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("进入临时授权");
		String usercode = (String) getAvailablePrincipal(principalCollection);
		SimpleAuthorizationInfo info = (SimpleAuthorizationInfo)customRealm.doGetAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
		ProvisionalAuthorization provisionalAuthorization = provisionalAuthorizationService.getRole(usercode);
		if(provisionalAuthorization!=null){
			String recoveryTime = provisionalAuthorization.getRecoveryTime();
			String timeStr1=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));   
			if(recoveryTime.compareTo(timeStr1)<0)
			{
			String roleid = provisionalAuthorization.getRoleid();
			Role role = roleService.getRole(roleid);
			for(Permission permission:role.getPermission())
			{
				String name = permission.getName();
				info.addRole(roleid);
				info.addStringPermission(name);
			}
			}
		}
	/*		User user = userService.queryByNameAndPwd(userName);
		 Set<Role> roles1 = user.getRoles();//用户所拥有角色
		 UserGroup userGroup = user.getUserGroup();
		 Set<Role> roles2 = userGroup.getRoles();//所在用户组拥有角色
			Set<String> handleMappings=new HashSet<String>();
		for(Role role1:roles1){
			for(Role role2:roles2){
				if(role1.getRoleId().equals(role2.getRoleId())){
					if(role1.getPermission().getRejection_attribute()){		
						for(String handleMapping:permissionroles){
								if(handleMapping.equals(role2.getPermission().getName())){
								}else{
									handleMappings.add(role2.getPermission().getName());
									((SimpleAuthorizationInfo) info).setStringPermissions(handleMappings);
								}
							}
					}
				}
			}
		}*/
		return info;
		}
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		  CaptchaToken captchaToken = (CaptchaToken) token;
		    String userCode = (String)captchaToken.getPrincipal();
		    User user = userService.queryByNameAndPwd(userCode);
		    if(user==null)
		    {
		    	return null;
		    }
		    String salt="hdquan";
		    SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(userCode, user.getUsername(), ByteSource.Util.bytes(salt), this.getName());
			return simpleAuthenticationInfo;
	}
}
