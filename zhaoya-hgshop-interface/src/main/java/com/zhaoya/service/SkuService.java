package com.zhaoya.service;

import com.github.pagehelper.PageInfo;
import com.zhaoya.pojo.Sku;
import com.zhaoya.pojo.SkuVo;

public interface SkuService {

	PageInfo<Sku> list(int page, SkuVo skuVo);

	Sku getById(int id);

	int update(Sku sku);

	int deleteBatch(int[] ids);

	int add(Sku sku);

}
