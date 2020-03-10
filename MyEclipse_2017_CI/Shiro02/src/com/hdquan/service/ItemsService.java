package com.hdquan.service;

import java.util.List;

import com.hdquan.pojo.Items;
import com.hdquan.pojo.ItemsCustom;

public interface ItemsService {
	//��Ʒ��ѯ�б�
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//������Ʒid��ѯ��Ʒ��Ϣ
	public ItemsCustom finItemsById(int id);
	//������Ʒ��Ϣ,id���޸���Ʒ��id���ڶ���Ϊ�޸���Ʒ����Ϣ---��ѭ��һְ�𣬽�ҵ�����ϸ������Ҫʹ�ð�װ���ͣ���map��
	public void updateItems(Integer id,ItemsCustom itemsCustom);
}
