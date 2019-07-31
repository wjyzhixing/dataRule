package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.tauk.datarule.dao.IZnycJdbDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycJdbDaoImpl implements IZnycJdbDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='±ÜÀ×Æ÷'"
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OBJ_ID,EDPL,TYRQ,CCRQ,ZZGJ,SYHJ,ZCXZ,LQFS,DYFS,JYJZ ");
		sql.append(" FROM T_SB_ZNYC_JDB");
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql.toString(), null, new JDBCHelper.QueryCallback() {

				@Override
				public void process(ResultSet rs) throws Exception {
					while(rs.next()) {
						Map map = new HashMap();
						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("EDPL", rs.getString("EDPL"));
						map.put("ZZGJ", rs.getString("ZZGJ"));
						map.put("SYHJ", rs.getString("SYHJ"));
						map.put("ZCXZ", rs.getString("ZCXZ"));
						map.put("LQFS", rs.getString("LQFS"));
						map.put("TYRQ", rs.getString("TYRQ"));
						map.put("CCRQ", rs.getString("CCRQ"));
						map.put("DYFS", rs.getString("DYFS"));
						map.put("JYJZ", rs.getString("JYJZ"));
						dataList.add(map);
					}
				}

			});
		return dataList;
	}

}
