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
//Filter������ʲô�������������У������Ҫ����һЩ�ļ�
//@WebFilter("/*")
public class UrlFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		//js css ͼƬ ����
		HttpServletRequest request=(HttpServletRequest)req;
		String uri = request.getRequestURI();
		if(uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith(".html")||uri.endsWith(".jpg")||uri.endsWith(".png")||uri.endsWith(".gif"))
		{
			filterChain.doFilter(req, res);//����������ļ��Ļ��ͷ���
		}
		else
		{
			if(uri.equals("/rbac/login")||uri.equals("/rbac/login.jsp"))//��������login(index.jsp)����㲻���أ�����
			{
				filterChain.doFilter(req, res);
			}
			else//����
			{
				HttpSession session = request.getSession();
				//��¼��֤
				//obj��ʾuser
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
					//���url��Ҫ��Ҫ����Ȩ�޿���
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
						//��¼�û��Ը�uri���з���Ȩ��
						if(isRight)
						{
							filterChain.doFilter(req, res);
						}
						else
						{
							//���session�е����ݸ���������loginҳ��ʱsession�ڵ�user��allurl��Ҫ�����
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
				else//û�е�½
				{
					((HttpServletResponse)res).sendRedirect("/rbac/login.jsp");
					
				}
			}
		}
	}
	
}
