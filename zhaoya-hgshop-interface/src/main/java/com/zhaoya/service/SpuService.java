package com.zhaoya.service;

import com.github.pagehelper.PageInfo;
import com.zhaoya.pojo.Spu;
import com.zhaoya.pojo.SpuVo;

public interface SpuService {

	// 列表查询条件
	PageInfo<Spu> list(int page, SpuVo spuVo);

	// 添加
	int add(Spu spu);

	// 批量删除
	int deleteBatch(int ids[]);

	// 修改
	int update(Spu spu);

	// 获取具体的商品
	Spu getById(int id);

	// 上架下架1在售0售罄
	int updateMarkable(int id, int marketable);
}
