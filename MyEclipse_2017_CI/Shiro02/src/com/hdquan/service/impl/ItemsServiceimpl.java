package com.hdquan.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.hdquan.pojo.Items;
import com.hdquan.pojo.ItemsCustom;
import com.hdquan.service.ItemsQueryVo;
import com.hdquan.service.ItemsService;

public class ItemsServiceimpl implements ItemsService{


	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
		// TODO Auto-generated method stub
		return ItemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom finItemsById(int id) {
		Items items=itemsMapper.selectByPrimaryKey(id);
		ItemsCustom ItemsCustom=new ItemsCustom();
		//将items的属性拷贝到itemsCustom，只要他们的属性相同即可
		BeanUtils.copyProperties(items, ItemsCustom);
		return ItemsCustom;
	}

	@Override
	public void updateItems(Integer id,ItemsCustom itemsCustom) {
		// TODO Auto-generated method stub
		if(id==null)
		{
			//抛出异常，提示调用接口的用户，id不能为空
		}
		itemsMapper.updateByPrimaryKey(itemsCustom);
	}
	
}
