使用springmvc拦截器实现登录验证
1.把页面放入到WEB-INF中
		1.1 放入WEB-INF中必须通过控制器转发到页面
		1.2	springmvc拦截器拦截的是控制器，不能拦截JSP
		
2.通过拦截器拦截全部控制器，需要在拦截器内部放行login控制器