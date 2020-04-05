package com.zhaoya.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaoya.dao.SpecDao;
import com.zhaoya.pojo.Spec;
import com.zhaoya.pojo.SpecOption;
import com.zhaoya.service.SpecService;

//实现规格管理服务
@Service(interfaceClass = SpecService.class)
public class SpecServiceImpl implements SpecService {

	@Autowired
	private SpecDao specDao;

	@Override
	public int add(Spec spec) {
		// TODO Auto-generated method stub
		// 插入主表
		int result = specDao.addSpec(spec);
		List<SpecOption> optionList = spec.getOptionList();
		// 插入子表
		for (SpecOption specOption : optionList) {
			specOption.setSpecId(spec.getId());
			result += specDao.addSpecOption(specOption);
		}

		return result;
	}

	@Override
	public int update(Spec spec) {
		// 修改主表
		int result = specDao.updateSpec(spec);

		// 删除子表数据
		result += specDao.deleteSpecOption(spec.getId());

		List<SpecOption> optionList = spec.getOptionList();

		// 重新插入子表
		for (SpecOption specOption : optionList) {
			specOption.setSpecId(spec.getId());
			result += specDao.addSpecOption(specOption);
		}

		return result;
	}

	@Override
	public Spec findById(int id) {
		// TODO Auto-generated method stub
		return specDao.getById(id);
	}

	@Override
	public int deleteBatch(int[] ids) {
		// 删除主表
		int result = specDao.deteteBatch(ids);
		// 删除子表
		result += specDao.deteteOptionBatch(ids);

		return result;
	}

	@Override
	public PageInfo<Spec> list(String name, int page) {
		PageHelper.startPage(page, 10);
		return new PageInfo<Spec>(specDao.list(name));
	}
}
