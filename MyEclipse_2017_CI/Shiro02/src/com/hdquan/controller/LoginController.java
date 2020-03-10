package com.hdquan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.cache.CacheException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hdquan.pojo.Json;
import com.hdquan.pojo.User;

public class LoginController {

	//登录提交地址，和applicationContext-shiro.xml中配置的loginUrl一致
	@RequestMapping("login")
	public String login(HttpServletRequest req) throws Exception{
		
//		如果登录失败从req中获取认证异常信息,shiroLoginFailure就是shiro异常类的全限定名
		String shiroLoginFailure = (String) req.getAttribute("shiroLoginFailure");
		
//		根据shiro返回的异常类路径判断，抛出指定异常信息
		if(shiroLoginFailure!=null)
		{
			if(UnknownAccountException.class.getName().equals(shiroLoginFailure))
			{
				throw new CacheException("账号不存在");
//				throw new CustomException("账号不存在");
			}
			else if(IncorrectCredentialsException.class.getName().equals(shiroLoginFailure))
			{
//				throw new CustomException("用户名/密码错误");
			}
			else if("randomCodeError".equals(shiroLoginFailure))
			{
//				throw new CustomException("验证错误");
			}
			else 
			{
				throw new Exception();//最终在异常处理器生成未知错误
			}
		}
		//此方法不处理登录成功（认证成功）,shiro认证成功会自动跳转到上一个请求路径
		//登录失败还到login页面
		return "login";
	}
	
/*	@ResponseBody(此方法是为了给前端发送数据的注解)
	@RequestMapping(params="login")//账号和密码自动注入到User中
	public Json login(User user,HttpSession session,HttpServletRequest request)
	{
		Json j=new Json();
		User u=userService.login(user);
		if(u!=null)
		{
			j.setSuccess(true);
			j.setMsg("登录成功");
			u.setIP(IPUtil.getIPAdr(request));
			sessionInfo.sessionInfo=new SessionIo();
			sessionInfo.setUser(u);
			session.setAttribute(ResourceUtil.getSessionInfoName, sessionInfo);
			j.setObj(u);
		}else
		{
			j.setMsg("用户名或密码错误");
		}
		return j;
	}
	
	{"success":false,"msg":用户名或密码错误}
	*/
}
