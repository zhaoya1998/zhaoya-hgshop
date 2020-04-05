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

//ʵ�ֹ��������
@Service(interfaceClass = SpecService.class)
public class SpecServiceImpl implements SpecService {

	@Autowired
	private SpecDao specDao;

	@Override
	public int add(Spec spec) {
		// TODO Auto-generated method stub
		// ��������
		int result = specDao.addSpec(spec);
		List<SpecOption> optionList = spec.getOptionList();
		// �����ӱ�
		for (SpecOption specOption : optionList) {
			specOption.setSpecId(spec.getId());
			result += specDao.addSpecOption(specOption);
		}

		return result;
	}

	@Override
	public int update(Spec spec) {
		// �޸�����
		int result = specDao.updateSpec(spec);

		// ɾ���ӱ�����
		result += specDao.deleteSpecOption(spec.getId());

		List<SpecOption> optionList = spec.getOptionList();

		// ���²����ӱ�
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
		// ɾ������
		int result = specDao.deteteBatch(ids);
		// ɾ���ӱ�
		result += specDao.deteteOptionBatch(ids);

		return result;
	}

	@Override
	public PageInfo<Spec> list(String name, int page) {
		PageHelper.startPage(page, 10);
		return new PageInfo<Spec>(specDao.list(name));
	}
}
