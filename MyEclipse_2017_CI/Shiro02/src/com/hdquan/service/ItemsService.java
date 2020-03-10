package com.hdquan.service;

import java.util.List;

import com.hdquan.pojo.Items;
import com.hdquan.pojo.ItemsCustom;

public interface ItemsService {
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据商品id查询商品信息
	public ItemsCustom finItemsById(int id);
	//更新商品信息,id：修改商品的id，第二个为修改商品的信息---遵循单一职责，将业务参数细化（不要使用包装类型，如map）
	public void updateItems(Integer id,ItemsCustom itemsCustom);
}
