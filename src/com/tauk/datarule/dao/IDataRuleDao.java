package com.tauk.datarule.dao;

import java.util.List;
import java.util.Map;

public interface IDataRuleDao {

	/**
	 * ��ȡ���ݹ�������豸��������
	 */
	public Map<String,Map<String, String>>  readDataRule(String tname);
}
