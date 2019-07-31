package com.tauk.datarule.dao;

import java.util.List;

import com.tauk.datarule.model.WZJSCS;

/**
 * 数据源数据操作
 * @author zyb_s
 *
 */
public interface IDataSourceDao {

	/**
	 * 查询
	 * @param maxXH
	 */
   public List<WZJSCS> readData(int maxXH);	
}
