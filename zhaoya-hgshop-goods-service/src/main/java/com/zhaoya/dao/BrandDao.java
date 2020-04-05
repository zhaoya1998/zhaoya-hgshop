package com.zhaoya.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaoya.pojo.Brand;

public interface BrandDao {

	List<Brand> listByFirstChar(@Param("firstChar")String firstChar);

	List<Brand> list();

	Brand getById(int id);

	int update(Brand brand);
}
