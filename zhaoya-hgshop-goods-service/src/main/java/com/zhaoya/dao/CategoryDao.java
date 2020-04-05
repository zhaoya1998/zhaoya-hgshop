package com.zhaoya.dao;

import java.util.List;

import com.zhaoya.pojo.Category;

public interface CategoryDao {

	// ���ݸ�id��ȡ�б�
	List<Category> listByParentId(int pid);

	// ���
	int add(Category cat);

	// �޸�
	int update(Category cat);

	// ɾ��
	int delete(int catId);

}
