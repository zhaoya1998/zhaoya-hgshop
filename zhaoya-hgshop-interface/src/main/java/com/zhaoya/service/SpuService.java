package com.zhaoya.service;

import com.github.pagehelper.PageInfo;
import com.zhaoya.pojo.Spu;
import com.zhaoya.pojo.SpuVo;

public interface SpuService {

	// �б��ѯ����
	PageInfo<Spu> list(int page, SpuVo spuVo);

	// ���
	int add(Spu spu);

	// ����ɾ��
	int deleteBatch(int ids[]);

	// �޸�
	int update(Spu spu);

	// ��ȡ�������Ʒ
	Spu getById(int id);

	// �ϼ��¼�1����0����
	int updateMarkable(int id, int marketable);
}
