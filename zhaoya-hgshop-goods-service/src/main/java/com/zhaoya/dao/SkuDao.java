package com.zhaoya.dao;

import java.util.List;

import com.zhaoya.pojo.Sku;
import com.zhaoya.pojo.SkuVo;
import com.zhaoya.pojo.SpecOption;

public interface SkuDao {

	List<Sku> list(SkuVo skuVo);

	Sku getById(int id);

	int update(Sku sku);

	int deleteSkuSpec(Integer id);

	int addSkuSpec(Integer id, SpecOption specOption);

	int deleteBatch(int[] ids);

	int deleteSkuSpec(int[] ids);

	int add(Sku sku);


}
