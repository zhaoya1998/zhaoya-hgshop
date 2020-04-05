package com.zhaoya.dao;

import java.util.List;

import com.zhaoya.pojo.Category;

public interface CategoryDao {

	// 根据父id获取列表
	List<Category> listByParentId(int pid);

	// 添加
	int add(Category cat);

	// 修改
	int update(Category cat);

	// 删除
	int delete(int catId);

}
