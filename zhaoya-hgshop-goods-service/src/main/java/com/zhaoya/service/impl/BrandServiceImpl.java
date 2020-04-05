package com.zhaoya.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaoya.dao.BrandDao;
import com.zhaoya.pojo.Brand;
import com.zhaoya.service.BrandService;

@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;

	@Override
	public List<Brand> listByFirst(String firstChar) {
		// TODO Auto-generated method stub
		return brandDao.listByFirstChar(firstChar);
	}

	@Override
	public PageInfo<Brand> list(int page) {
		PageHelper.startPage(page, 10);
		return new PageInfo<Brand>(brandDao.list());
	}

	@Override
	public int update(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.update(brand);
	}

	@Override
	public Brand brandById(int id) {
		// TODO Auto-generated method stub
		return brandDao.getById(id);
	}
}
