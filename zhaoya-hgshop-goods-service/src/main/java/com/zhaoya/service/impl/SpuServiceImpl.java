package com.zhaoya.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaoya.dao.SpuDao;
import com.zhaoya.pojo.Spu;
import com.zhaoya.pojo.SpuVo;
import com.zhaoya.service.SpuService;

@Service(interfaceClass = SpuService.class)
public class SpuServiceImpl implements SpuService {

	@Autowired
	SpuDao spuDao;

	// 列表查询条件
	@Override
	public PageInfo<Spu> list(int page, SpuVo spuVo) {
		PageHelper.startPage(page, 10);
		return new PageInfo<Spu>(spuDao.list(spuVo));
	}

	// 添加
	@Override
	public int add(Spu spu) {
		return spuDao.add(spu);
	}

	// 批量删除
	@Override
	public int deleteBatch(int[] ids) {
		return spuDao.deleteBatch(ids);
	}

	// 修改
	@Override
	public int update(Spu spu) {
		return spuDao.update(spu);
	}

	// 获取具体的商品
	@Override
	public Spu getById(int id) {
		return spuDao.getById(id);
	}

	// 上架下架1在售0售罄
	@Override
	public int updateMarkable(int id, int marketable) {
		return spuDao.updateMarkable(id, marketable);
	}
}
