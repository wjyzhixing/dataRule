package com.tauk.datarule.dao;

import java.util.List;

import com.tauk.datarule.model.WZJSCS;

/**
 * ����Դ���ݲ���
 * @author zyb_s
 *
 */
public interface IDataSourceDao {

	/**
	 * ��ѯ
	 * @param maxXH
	 */
   public List<WZJSCS> readData(int maxXH);	
}
