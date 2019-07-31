package com.tauk.datarule.dao;

import java.util.List;
import java.util.Map;

public interface IDataRuleDao {

	/**
	 * 读取数据规则根据设备类型名称
	 */
	public Map<String,Map<String, String>>  readDataRule(String tname);
}
