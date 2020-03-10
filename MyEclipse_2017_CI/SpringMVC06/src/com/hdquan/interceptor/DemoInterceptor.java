package com.hdquan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor{
	
	//�ڽ��������֮ǰִ��
	//�������ֵΪfalse����ֹ���������
	//���ƴ���
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		System.out.println("handler��"+handler);
		//handler��ʾ���ص����ĸ��������������統����demo��demo4��ʱ�򣬾���ʾ����com.hdquan.controller.DemoController.demo()�ĸ÷���
		System.out.println("preHandle");
//		if(����ʧ�ܵĻ�����ת������ҳ����ȥ){
//		response.sendRedirect("");
//		return	false;
//		}
		return true;
	}
	
	//������ִ����ɣ����뵽jsp֮ǰִ��
	//��־��¼
	//���дʹ���
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			
			System.out.println("��"+modelAndView.getViewName()+"��ת");
			System.out.println("model��ֵ"+modelAndView.getModel().get("model"));
			String word = modelAndView.getModel().get("model").toString();
			String newWord = word.replace("���", "**");
			modelAndView.getModel().put("model",newWord);
//			modelAndView.getModel().put("model","�޸ĺ������");
			System.out.println("postHandle");
		}	
		//jspִ����ɺ�ִ��
		//��¼ִ�й����г��ֵ��쳣
		//���԰��쳣��¼����־��
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
		System.out.println("afterCompletion"+ex.getMessage());
		}
}
