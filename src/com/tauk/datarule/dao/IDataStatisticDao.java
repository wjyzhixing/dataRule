package com.tauk.datarule.dao;

import java.util.Map;

public interface IDataStatisticDao {

	public Map<String,Map<String,String>> queryStatisticValue(String tname);
}
