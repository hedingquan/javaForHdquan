package com.hdquan.service;

import java.util.List;

import com.hdquan.pojo.Url;

public interface UrlService {
	List<Url> selByRid(int rid);
	List<Url> showAll();
}
