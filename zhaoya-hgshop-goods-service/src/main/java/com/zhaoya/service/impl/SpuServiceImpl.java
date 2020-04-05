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

	// �б��ѯ����
	@Override
	public PageInfo<Spu> list(int page, SpuVo spuVo) {
		PageHelper.startPage(page, 10);
		return new PageInfo<Spu>(spuDao.list(spuVo));
	}

	// ���
	@Override
	public int add(Spu spu) {
		return spuDao.add(spu);
	}

	// ����ɾ��
	@Override
	public int deleteBatch(int[] ids) {
		return spuDao.deleteBatch(ids);
	}

	// �޸�
	@Override
	public int update(Spu spu) {
		return spuDao.update(spu);
	}

	// ��ȡ�������Ʒ
	@Override
	public Spu getById(int id) {
		return spuDao.getById(id);
	}

	// �ϼ��¼�1����0����
	@Override
	public int updateMarkable(int id, int marketable) {
		return spuDao.updateMarkable(id, marketable);
	}
}
