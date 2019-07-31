package com.tauk.datarule.dao;

import java.util.List;
import java.util.Map;

/**
 * PMS
 * 站内一次-母线
 *
 */
public interface IZnycMxDao {

	/**
	 * 查询
	 * @param maxXH
	 */
   public List<Map<String,String>> readData(int maxXH);

}
