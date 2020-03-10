	package com.hdquan.dao;

	import java.util.List;

	import com.hdquan.pojo.flower;

	/*
	 * ��ѯȫ������ctrl+shift+o ����
	 */
	public interface FlowerDao{
		List<flower> selAll();
		
		
		static int insFlower(flower flower) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

