package com.zhaoya.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhaoya.pojo.Spu;
import com.zhaoya.pojo.SpuVo;

public interface SpuDao {
	// �б��ѯ����
	List<Spu> list(SpuVo spuVo);

	// ���
	int add(Spu spu);

	// ����ɾ��
	int deleteBatch(int[] ids);

	// �޸�
	int update(Spu spu);

	// ��ȡ�������Ʒ
	Spu getById(@Param("id") int id);

	// �ϼ��¼�1����0����
	int updateMarkable(@Param("id")int id, @Param("isMarketable")int marketable);

}
