package com.tauk.datarule.dao;

import java.util.List;
import java.util.Map;

/**
 * PMS
 * 站内一次-所用变
 *
 */
public interface IZnycSybDao {

	/**
	 * 查询
	 * @param maxXH
	 */
   public List<Map<String,String>> readData(int maxXH);

}
