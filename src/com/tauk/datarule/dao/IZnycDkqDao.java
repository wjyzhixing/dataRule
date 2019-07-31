package com.tauk.datarule.dao;

import java.util.List;
import java.util.Map;

/**
 * PMS
 * 站内一次-电抗器
 *
 */
public interface IZnycDkqDao {

	/**
	 * 查询
	 * @param maxXH
	 */
   public List<Map<String,String>> readData(int maxXH);

}
