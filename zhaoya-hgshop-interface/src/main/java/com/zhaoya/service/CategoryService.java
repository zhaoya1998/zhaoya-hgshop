package com.zhaoya.service;

import java.util.List;

import com.zhaoya.pojo.Category;


public interface CategoryService {

	List<Category> getTree();

	int add(Category cat);
	
	int update(Category cat);
	
	int delete(int catId);

}
