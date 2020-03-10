package com.hdquan.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor{
	
	//在进入控制器之前执行
	//如果返回值为false，阻止进入控制器
	//控制代码
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		System.out.println("handler："+handler);
		//handler表示拦截的是哪个控制器方法，如当请求demo或demo4的时候，就显示的是com.hdquan.controller.DemoController.demo()的该方法
		System.out.println("preHandle");
//		if(访问失败的话，跳转到其他页面中去){
//		response.sendRedirect("");
//		return	false;
//		}
		return true;
	}
	
	//控制器执行完成，进入到jsp之前执行
	//日志记录
	//敏感词过滤
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
				ModelAndView modelAndView) throws Exception {
			
			System.out.println("往"+modelAndView.getViewName()+"跳转");
			System.out.println("model的值"+modelAndView.getModel().get("model"));
			String word = modelAndView.getModel().get("model").toString();
			String newWord = word.replace("祖国", "**");
			modelAndView.getModel().put("model",newWord);
//			modelAndView.getModel().put("model","修改后的内容");
			System.out.println("postHandle");
		}	
		//jsp执行完成后执行
		//记录执行过程中出现的异常
		//可以把异常记录到日志中
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
		System.out.println("afterCompletion"+ex.getMessage());
		}
}
