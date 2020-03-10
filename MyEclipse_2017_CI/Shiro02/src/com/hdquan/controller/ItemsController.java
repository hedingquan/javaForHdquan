package com.hdquan.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hdquan.pojo.ItemsCustom;
import com.hdquan.service.ItemsService;


@Controller
//定义url的根路径，访问时根路径+方法的url
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;

	@RequestMapping("/queryItems")
	//使用注解式授权方法
	@RequiresPermissions("item:query")
	public ModelAndView queyItems(HttpServletRequest req)throws Exception
	{
		System.out.println(req.getParameter("id"));
		//调用service查询商品列表
		List<ItemsCustom> itemsList=itemsService.findItemsList(null);
		ModelAndView  modelAndView=new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		//指定逻辑视图名
		modelAndView.setViewName("itemsList");
	return modelAndView;
	}
	//根据商品id查看商品信息rest接口
	//@RequestMapping中指定restful方式的url的参数，参数需要用{}包起来
//	@PathVariable将url中的{}包起参数和形参进行绑定
	@RequestMapping("/viewItems/{id}")
	public @ResponseBody ItemsCustom viewItems(@PathVariable("id") Integer id) throws Exception
	{
		//调用service查询商品
		ItemsCustom itemsCustom=(ItemsCustom) itemsServiceimpl.findItemsList(id);
		return itemsCustom;
	}
	//商品修改页面显示
//	//（1）
//	@RequestMapping(value="/editItems",method=RequestMethod.GET)
//	@RequiresPermissions("item:update")//执行此方法需要item:update这个权限
//	public ModelAndView editItems(Model model,Integer id)throws Exception
//	{
//		ModelAndView  modelAndView=new ModelAndView();
//		//将id传到页面
//		model.addAttribute("id",id);
//		//调用service查询商品信息
////		ItemsCustom itemsCustom=itemsService.findItemById(id);
////	将模型数据传到jsp,即是jsp文件中的value="${item.id}"---item
//		//		modelAndView.addObject("item", itemsCustom);
//		//指定逻辑视图名
//		modelAndView.setViewName("editItems");
//		return modelAndView;
//	}
	
//	//（2）方法返回字符串，字符串就是逻辑视图名，Model作用是将数据填充到request域，在页面展示
//	@RequestMapping(value="/editItems",method=RequestMethod.GET)
//	@RequiresPermissions("item:update")//执行此方法需要item:update这个权限
//	public String editItems(Model model)throws Exception
//	{
//		ItemsCustom itemsCustom=itemsService.findItemById(1);
//		model.addAttribute("item", itemsCustom);
//		
//		return "editItems";
//	}
	
	//（3）方法返回void
	@RequestMapping(value="/editItems",method=RequestMethod.GET)
	@RequiresPermissions("item:update")//执行此方法需要item:update这个权限
	public void editItems(HttpServletRequest request,HttpServletResponse resonse)throws Exception
	{
		ItemsCustom itemsCustom=itemsService.findItemById(1);
		request.setAttribute("item", itemsCustom);
		//注意如果使用了request转向页面，这里指定页面的完整路径
		request.getRequestDispatcher("/WEB-INF/jsp/editItem.jsp").forward(request, resonse);

	}
	
	
//	jsp中：<td><a href="${pageContext.request.contextPath }/items/editItem.jsp?id=${item.id}">修改</td>
//商品修改提交
	//itemsQueryVo是包装类型的pojo
//	在@Validated中定义使用ValidGroup1组下达的检验
	@RequestMapping("/editItemSubmit")
//	public String ediItemSubmit(Integer id,ItemsCustom itemsCustom,ItemsQueryVo itemsQueryVo)throw Exception
	@RequiresPermissions("item:update")
	public String editItemSubmit(Model model,Integer id,@Validated(value={ValidGroup1.class}) @ModelAttribute(value="itemsCustom") ItemsCustom itemsCustom,BindingResult bindingResult,
//			上传图片
			MultipartFile pictureFile
			)
		{
//		输出检验错误信息
//		如果参数绑定时有错
		if(bindingResult.hasErrors())
		{
//			获取错误
			List<ObjectError> errors= bindingResult.getAllErrors();
//			准备在页面输出errors，页面jstl遍历
			model.addAttribute("errors", errors);

		}
	}
}
