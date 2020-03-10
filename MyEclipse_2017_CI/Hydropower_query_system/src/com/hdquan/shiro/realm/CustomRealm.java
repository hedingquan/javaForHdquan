package com.hdquan.shiro.realm;

import java.util.HashSet;
import java.util.Set;

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
import com.hdquan.service.UserService;

public class CustomRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	public void setName(String name) {
		super.setName("CustomRealm");
	}
		@Override
		protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			User user = userService.queryByNameAndPwd((String) getAvailablePrincipal(principalCollection));
			Set<String> permission=new HashSet<String>();
			permission.add(String.valueOf(user.getType()));	
			info.setStringPermissions(permission);
			return info;
		}

		@Override
		protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
			String username = (String)token.getPrincipal();
			User user = userService.queryByNameAndPwd(username);
		    if(user==null)
		    {
		    	return null;
		    }
			return new SimpleAuthenticationInfo(username, user.getPassword(), this.getName());
		}
}
