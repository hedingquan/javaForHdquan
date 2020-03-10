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

	
	
	//设置realm的名称
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName("CustomRealm");
	}

	//用于认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//token是用户输入的
		//第一步 从token中取出身份信息
		String userCode=(String) token.getPrincipal();
		//第二部：根据用户输入的userCode从数据库查询
		//.......
		//如果查询不到返回null
		//数据库中用户账号是zhangsan
//		if(!userCode.equals("zhangsan"))
//		{
//			
//			return null;
//		}
		//模拟从数据库查询到密码,这里是散列后的值
//		String password="1c4d234e3d8307ba8c4c5bd62f8f2fc5";
		String password="1";
		//从数据获取salt
		String salt="hdquan";
		
		
		//如果查询到返回认证信息AuthenticationInfo
//		SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(userCode, password,this.getName());
		//第三个参数为ByteSource类型的，所以用ByteSource内的方法可以传入String类型的数值
		SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(userCode, password, ByteSource.Util.bytes(salt), this.getName());
		
		return simpleAuthenticationInfo;
	}
//用于授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	
		//从principals获取主身份信息
		//将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中的身份信息userCode）
		String userCode = (String) principals.getPrimaryPrincipal();
		//根据身份信息获取权限信息
		//连接数据库。。。。
		//模拟从数据库获取数据
		List<String> permissions=new ArrayList<String>();
		permissions.add("user:create");//用户的创建
		permissions.add("items:add");//商品添加权限
		
		
		//查到权限数据，返回---SimpleAuthorizationInfo授权信息(要包括上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
		//将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}

}
