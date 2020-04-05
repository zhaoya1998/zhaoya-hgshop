package com.zhaoya.service;

import com.github.pagehelper.PageInfo;
import com.zhaoya.pojo.Spec;

//���������
public interface SpecService {

	int add(Spec spec);

	// �޸�
	int update(Spec spec);

	// ���飬�޸ĵĻ���
	Spec findById(int id);

	// ����ɾ��
	int deleteBatch(int[] ids);

	// �б��ҳ
	PageInfo<Spec> list(String name, int page);
}
