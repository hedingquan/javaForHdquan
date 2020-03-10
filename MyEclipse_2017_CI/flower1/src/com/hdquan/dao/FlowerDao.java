	package com.hdquan.dao;

	import java.util.List;

	import com.hdquan.pojo.flower;

	public interface FlowerDao{
		List<flower> selAll();	
		public int insFlower(flower flower);
	}

