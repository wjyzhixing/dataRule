package com.tauk.datarule.dao;

import java.util.List;
import java.util.Map;

/**
 * PMS
 * վ��һ��-���ع�
 * @author zyb_s
 *
 */
public interface IZnycKggDao {

	/**
	 * ��ѯ
	 * @param maxXH
	 */
   public List<Map<String,String>> readData(int maxXH);	
   
}
