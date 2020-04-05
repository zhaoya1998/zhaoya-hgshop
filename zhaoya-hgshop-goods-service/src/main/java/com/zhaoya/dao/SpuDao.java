package com.zhaoya.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaoya.pojo.Spu;
import com.zhaoya.pojo.SpuVo;

public interface SpuDao {
	// 列表查询条件
	List<Spu> list(SpuVo spuVo);

	// 添加
	int add(Spu spu);

	// 批量删除
	int deleteBatch(int[] ids);

	// 修改
	int update(Spu spu);

	// 获取具体的商品
	Spu getById(@Param("id") int id);

	// 上架下架1在售0售罄
	int updateMarkable(@Param("id")int id, @Param("isMarketable")int marketable);

}
