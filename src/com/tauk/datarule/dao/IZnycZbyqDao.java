package com.tauk.datarule.dao;

import java.util.List;
import java.util.Map;

/**
 * PMS
 * վ��һ��-����ѹ��
 * @author zyb_s
 *
 */
public interface IZnycZbyqDao {

	/**
	 * ��ѯ
	 * @param maxXH
	 */
   public List<Map<String,String>> readData(int maxXH);	
   
}
