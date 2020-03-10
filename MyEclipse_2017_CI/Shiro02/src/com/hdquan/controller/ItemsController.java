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
//����url�ĸ�·��������ʱ��·��+������url
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;

	@RequestMapping("/queryItems")
	//ʹ��ע��ʽ��Ȩ����
	@RequiresPermissions("item:query")
	public ModelAndView queyItems(HttpServletRequest req)throws Exception
	{
		System.out.println(req.getParameter("id"));
		//����service��ѯ��Ʒ�б�
		List<ItemsCustom> itemsList=itemsService.findItemsList(null);
		ModelAndView  modelAndView=new ModelAndView();
		modelAndView.addObject("itemsList",itemsList);
		//ָ���߼���ͼ��
		modelAndView.setViewName("itemsList");
	return modelAndView;
	}
	//������Ʒid�鿴��Ʒ��Ϣrest�ӿ�
	//@RequestMapping��ָ��restful��ʽ��url�Ĳ�����������Ҫ��{}������
//	@PathVariable��url�е�{}����������βν��а�
	@RequestMapping("/viewItems/{id}")
	public @ResponseBody ItemsCustom viewItems(@PathVariable("id") Integer id) throws Exception
	{
		//����service��ѯ��Ʒ
		ItemsCustom itemsCustom=(ItemsCustom) itemsServiceimpl.findItemsList(id);
		return itemsCustom;
	}
	//��Ʒ�޸�ҳ����ʾ
//	//��1��
//	@RequestMapping(value="/editItems",method=RequestMethod.GET)
//	@RequiresPermissions("item:update")//ִ�д˷�����Ҫitem:update���Ȩ��
//	public ModelAndView editItems(Model model,Integer id)throws Exception
//	{
//		ModelAndView  modelAndView=new ModelAndView();
//		//��id����ҳ��
//		model.addAttribute("id",id);
//		//����service��ѯ��Ʒ��Ϣ
////		ItemsCustom itemsCustom=itemsService.findItemById(id);
////	��ģ�����ݴ���jsp,����jsp�ļ��е�value="${item.id}"---item
//		//		modelAndView.addObject("item", itemsCustom);
//		//ָ���߼���ͼ��
//		modelAndView.setViewName("editItems");
//		return modelAndView;
//	}
	
//	//��2�����������ַ������ַ��������߼���ͼ����Model�����ǽ�������䵽request����ҳ��չʾ
//	@RequestMapping(value="/editItems",method=RequestMethod.GET)
//	@RequiresPermissions("item:update")//ִ�д˷�����Ҫitem:update���Ȩ��
//	public String editItems(Model model)throws Exception
//	{
//		ItemsCustom itemsCustom=itemsService.findItemById(1);
//		model.addAttribute("item", itemsCustom);
//		
//		return "editItems";
//	}
	
	//��3����������void
	@RequestMapping(value="/editItems",method=RequestMethod.GET)
	@RequiresPermissions("item:update")//ִ�д˷�����Ҫitem:update���Ȩ��
	public void editItems(HttpServletRequest request,HttpServletResponse resonse)throws Exception
	{
		ItemsCustom itemsCustom=itemsService.findItemById(1);
		request.setAttribute("item", itemsCustom);
		//ע�����ʹ����requestת��ҳ�棬����ָ��ҳ�������·��
		request.getRequestDispatcher("/WEB-INF/jsp/editItem.jsp").forward(request, resonse);

	}
	
	
//	jsp�У�<td><a href="${pageContext.request.contextPath }/items/editItem.jsp?id=${item.id}">�޸�</td>
//��Ʒ�޸��ύ
	//itemsQueryVo�ǰ�װ���͵�pojo
//	��@Validated�ж���ʹ��ValidGroup1���´�ļ���
	@RequestMapping("/editItemSubmit")
//	public String ediItemSubmit(Integer id,ItemsCustom itemsCustom,ItemsQueryVo itemsQueryVo)throw Exception
	@RequiresPermissions("item:update")
	public String editItemSubmit(Model model,Integer id,@Validated(value={ValidGroup1.class}) @ModelAttribute(value="itemsCustom") ItemsCustom itemsCustom,BindingResult bindingResult,
//			�ϴ�ͼƬ
			MultipartFile pictureFile
			)
		{
//		������������Ϣ
//		���������ʱ�д�
		if(bindingResult.hasErrors())
		{
//			��ȡ����
			List<ObjectError> errors= bindingResult.getAllErrors();
//			׼����ҳ�����errors��ҳ��jstl����
			model.addAttribute("errors", errors);

		}
	}
}
