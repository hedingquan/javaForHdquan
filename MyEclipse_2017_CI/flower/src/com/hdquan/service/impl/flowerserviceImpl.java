package com.hdquan.service.impl;

import java.util.List;

import com.hdquan.dao.FlowerDao;
import com.hdquan.dao.impl.flowerDaoImpl;
import com.hdquan.pojo.flower;
import com.hdquan.service.FlowerService;

public class flowerserviceImpl implements FlowerService{
	private FlowerDao flowerDao=new flowerDaoImpl();//����Ƶ��ʹ�õĺܶ������������ȫ�ֵı���...private:ֻ�ܱ���ʹ�ã�����������ʹ�á�
	@Override
	public List<flower> show() {
		return flowerDao.selAll();
	}
	@Override
	public int add(flower flower) {
		return FlowerDao.insFlower(flower);
	}

}