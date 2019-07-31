package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tauk.datarule.dao.IZnycSybDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycSybDaoImpl implements IZnycSybDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='±ÜÀ×Æ÷'"
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OBJ_ID,BYQYT,YH,DYFS,JYJZ,EDPL,ZCXZ,CCRQ,TYRQ,XH FROM T_SB_ZNYC_SYB");
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql.toString(), null, new JDBCHelper.QueryCallback() {

				@Override
				public void process(ResultSet rs) throws Exception {
					while(rs.next()) {
						Map map = new HashMap();
						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("BYQYT", rs.getString("BYQYT"));
						map.put("YH", rs.getString("YH"));
						map.put("DYFS", rs.getString("DYFS"));
						map.put("JYJZ", rs.getString("JYJZ"));
						map.put("EDPL", rs.getString("EDPL"));
						map.put("ZCXZ", rs.getString("ZCXZ"));
						map.put("CCRQ", rs.getString("CCRQ"));
						map.put("TYRQ", rs.getString("TYRQ"));
						map.put("XH", rs.getString("XH"));
						dataList.add(map);
					}
				}

			});
		return dataList;
	}

}
