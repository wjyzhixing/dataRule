package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;

import com.tauk.datarule.dao.IPrimaryDataDao;
import com.tauk.datarule.util.JDBCHelper;

public class PrimaryDataDaoImpl implements IPrimaryDataDao {

	@Override
	public String selectDictData(String tableName, String columnName) {
		
        StringBuilder sb = new StringBuilder();		
		String sql = "select distinct "+columnName+" from "+tableName;
		  JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {
				
				@Override
				public void process(ResultSet rs) throws Exception {
					
					while(rs.next()) {
						String tname = rs.getString(columnName);
						sb.append(tname).append(",");
					}
				}
				
			});
			return sb.toString();
	}

}
