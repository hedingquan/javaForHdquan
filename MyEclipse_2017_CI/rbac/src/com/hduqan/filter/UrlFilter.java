package com.hduqan.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hdquan.pojo.Url;
import com.hdquan.pojo.Users;
//Filter拦截是什么东西都拦截运行，因此需要放性一些文件
//@WebFilter("/*")
public class UrlFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		//js css 图片 放行
		HttpServletRequest request=(HttpServletRequest)req;
		String uri = request.getRequestURI();
		if(uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith(".html")||uri.endsWith(".jpg")||uri.endsWith(".png")||uri.endsWith(".gif"))
		{
			filterChain.doFilter(req, res);//如果是这是文件的话就放行
		}
		else
		{
			if(uri.equals("/rbac/login")||uri.equals("/rbac/login.jsp"))//控制器的login(index.jsp)请求恒不拦截，放性
			{
				filterChain.doFilter(req, res);
			}
			else//拦截
			{
				HttpSession session = request.getSession();
				//登录验证
				//obj表示user
				Object obj = session.getAttribute("user");
				if(obj!=null)
				{
					List<Url> listUrl =(List<Url>)session.getAttribute("allurl");
					boolean isExists=false;
					for(Url url:listUrl)
					{
						if(url.getName().equals(uri))
						{
							isExists=true;
						}
					}
					//如果url需要需要进行权限控制
					if(isExists)
					{
					Users users=(Users)obj;
					boolean isRight=false;
						for(Url url:users.getUrl())
						{
							if(url.getName().equals(uri))
							{
								isRight=true;
							}
						}
						//登录用户对该uri具有访问权限
						if(isRight)
						{
							filterChain.doFilter(req, res);
						}
						else
						{
							//清除session中的内容跟，当跳回login页面时session内的user和allurl都要清除掉
							session.removeAttribute("user");
							session.removeAttribute("allurl");
							((HttpServletResponse)res).sendRedirect("/rbac/login.jsp");
						}
					}
					else
					{
						filterChain.doFilter(req, res);
					}
				}
				else//没有登陆
				{
					((HttpServletResponse)res).sendRedirect("/rbac/login.jsp");
					
				}
			}
		}
	}
	
}
