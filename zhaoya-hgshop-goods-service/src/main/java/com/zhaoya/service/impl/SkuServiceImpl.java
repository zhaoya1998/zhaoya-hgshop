package com.zhaoya.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaoya.dao.SkuDao;
import com.zhaoya.pojo.Sku;
import com.zhaoya.pojo.SkuVo;
import com.zhaoya.pojo.SpecOption;
import com.zhaoya.service.SkuService;

@Service(interfaceClass = SkuService.class)
public class SkuServiceImpl implements SkuService{

	@Autowired
	SkuDao skuDao;

	@Override
	public PageInfo<Sku> list(int page, SkuVo skuVo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 10);
		return new PageInfo<Sku>(skuDao.list(skuVo));
	}

	@Override
	public Sku getById(int id) {
		// TODO Auto-generated method stub
		return skuDao.getById(id);
	}
	
	@Override
	public int update(Sku sku) {
		// TODO Auto-generated method stub
		int resut1=skuDao.update(sku);
		resut1 +=skuDao.deleteSkuSpec(sku.getId());
		List<SpecOption> optionList=sku.getSpecOptionList();
		for (SpecOption specOption : optionList) {
			resut1 +=skuDao.addSkuSpec(sku.getId(),specOption);
		}
		return resut1;
	}
	
	@Override
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		//删除主表
		int result=skuDao.deleteBatch(ids);
		//删除子表
		result =skuDao.deleteSkuSpec(ids);
		return result;
	}
	
	@Override
	public int add(Sku sku) {
		// TODO Auto-generated method stub
		//必须生成主键 添加到主表
		int resut1=skuDao.add(sku);
		List<SpecOption> optionList=sku.getSpecOptionList();
		for (SpecOption specOption : optionList) {
			resut1 +=skuDao.addSkuSpec(sku.getId(),specOption);
		}
		return resut1;
	}
}
