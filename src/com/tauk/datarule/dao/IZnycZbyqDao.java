package com.tauk.datarule.dao;

import java.util.List;
import java.util.Map;

/**
 * PMS
 * 站内一次-主变压器
 * @author zyb_s
 *
 */
public interface IZnycZbyqDao {

	/**
	 * 查询
	 * @param maxXH
	 */
   public List<Map<String,String>> readData(int maxXH);	
   
}
