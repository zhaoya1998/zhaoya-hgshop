package com.zhaoya.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaoya.pojo.Spec;
import com.zhaoya.pojo.SpecOption;



public interface SpecDao {

	int addSpec(Spec spec);

	int addSpecOption(SpecOption specOption);

	int updateSpec(Spec spec);

	int deleteSpecOption(Integer id);

	Spec getById(int id);

	int deteteBatch(int[] ids);

	int deteteOptionBatch(int[] ids);

	List<Spec> list(@Param("name") String name);

}
