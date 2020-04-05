package com.zhaoya.service;

import com.github.pagehelper.PageInfo;
import com.zhaoya.pojo.Spec;

//规格管理服务
public interface SpecService {

	int add(Spec spec);

	// 修改
	int update(Spec spec);

	// 详情，修改的回显
	Spec findById(int id);

	// 批量删除
	int deleteBatch(int[] ids);

	// 列表分页
	PageInfo<Spec> list(String name, int page);
}
