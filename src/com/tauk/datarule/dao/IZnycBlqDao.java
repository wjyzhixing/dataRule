package com.tauk.datarule.dao;

import java.util.List;
import java.util.Map;

/**
 * PMS
 * վ��һ��-������
 *
 */
public interface IZnycBlqDao {

	/**
	 * ��ѯ
	 * @param maxXH
	 */
   public List<Map<String,String>> readData(int maxXH);

}
