package com.hdquan.shiro.realm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

//�Զ���FormAuthenticationFilter����֤֮ǰʵ����֤��У��
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter{

//	ԭFormAuthenticationFilter����֤����
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
//		�����������֤���У��
//		��session�л�ȡ��ȷ����֤��
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		HttpSession session = httpServletRequest.getSession();
//		ȡ��session����֤��(��ȷ����֤��)
		String validateCode=(String)session.getAttribute("validateCode");
		
//		ȡ��ҳ�����֤��
//		�������֤��session�е���֤����жԱ�
		String randomcode=httpServletRequest.getParameter("randomcode");
		if(randomcode!=null&&validateCode!=null)
		{
		if(!randomcode.equals(validateCode))
		{
//			���ʧ�ܣ���ʧ����Ϣͨ��shiroLoginFailure���õ�request��
			httpServletRequest.setAttribute("shiroLoginFailure", "randomCodeError");
//			�ܾ����ʣ�����У���˺ź�����
			return true;
		}
		}
		return super.onAccessDenied(request, response);
	}

	
}
