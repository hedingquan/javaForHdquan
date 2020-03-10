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

	//��¼�ύ��ַ����applicationContext-shiro.xml�����õ�loginUrlһ��
	@RequestMapping("login")
	public String login(HttpServletRequest req) throws Exception{
		
//		�����¼ʧ�ܴ�req�л�ȡ��֤�쳣��Ϣ,shiroLoginFailure����shiro�쳣���ȫ�޶���
		String shiroLoginFailure = (String) req.getAttribute("shiroLoginFailure");
		
//		����shiro���ص��쳣��·���жϣ��׳�ָ���쳣��Ϣ
		if(shiroLoginFailure!=null)
		{
			if(UnknownAccountException.class.getName().equals(shiroLoginFailure))
			{
				throw new CacheException("�˺Ų�����");
//				throw new CustomException("�˺Ų�����");
			}
			else if(IncorrectCredentialsException.class.getName().equals(shiroLoginFailure))
			{
//				throw new CustomException("�û���/�������");
			}
			else if("randomCodeError".equals(shiroLoginFailure))
			{
//				throw new CustomException("��֤����");
			}
			else 
			{
				throw new Exception();//�������쳣����������δ֪����
			}
		}
		//�˷����������¼�ɹ�����֤�ɹ���,shiro��֤�ɹ����Զ���ת����һ������·��
		//��¼ʧ�ܻ���loginҳ��
		return "login";
	}
	
/*	@ResponseBody(�˷�����Ϊ�˸�ǰ�˷������ݵ�ע��)
	@RequestMapping(params="login")//�˺ź������Զ�ע�뵽User��
	public Json login(User user,HttpSession session,HttpServletRequest request)
	{
		Json j=new Json();
		User u=userService.login(user);
		if(u!=null)
		{
			j.setSuccess(true);
			j.setMsg("��¼�ɹ�");
			u.setIP(IPUtil.getIPAdr(request));
			sessionInfo.sessionInfo=new SessionIo();
			sessionInfo.setUser(u);
			session.setAttribute(ResourceUtil.getSessionInfoName, sessionInfo);
			j.setObj(u);
		}else
		{
			j.setMsg("�û������������");
		}
		return j;
	}
	
	{"success":false,"msg":�û������������}
	*/
}
