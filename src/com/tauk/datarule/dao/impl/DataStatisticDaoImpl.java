package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.tauk.datarule.dao.IDataStatisticDao;
import com.tauk.datarule.util.JDBCHelper;

public class DataStatisticDaoImpl implements IDataStatisticDao {

	@Override
	public Map<String,Map<String,String>> queryStatisticValue(String tname) {

		Map<String,Map<String,String>> dataMap = new HashMap();
		
		String sql = " SELECT t2.columnname,t1.statisticstype,t1.statisticsvalue,t1.groupcolumn FROM t_rule_datastatistics t1,t_rule_data t2 " + 
				"  WHERE t1.ruleid=t2.ruleid AND t2.tname='"+tname+"'";
		
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {
			
			@Override
			public void process(ResultSet rs) throws Exception {
				
				while(rs.next()) {
				
					String columnname = rs.getString("columnname");
					String statisticstype = rs.getString("statisticstype");
					String statisticsvalue = rs.getString("statisticsvalue");
					String groupcolumn = rs.getString("groupcolumn");
					
					Map<String,String> t = null;
					if(dataMap.get(columnname+"-"+groupcolumn)!=null) {
						t = dataMap.get(columnname+"-"+groupcolumn);
					}else {
						t = new HashMap();
					}
					
					t.put(statisticstype, statisticsvalue);
					dataMap.put(columnname+"-"+groupcolumn, t);
				}
			}
			
		});
		
		return dataMap;
	  }
}


