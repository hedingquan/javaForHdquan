package com.hdquan.service;

import java.util.List;

import com.hdquan.pojo.flower;
/*
 * ��ʾ������Ϣ
 */
public interface FlowerService {
	List<flower> show();
	int add(flower flower);
}
