package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tauk.datarule.dao.IZnycDldrqDao;
import com.tauk.datarule.dao.IZnycZhdqDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycDldrqDaoImpl implements IZnycDldrqDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='±ÜÀ×Æ÷'"
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OBJ_ID,JYJZ,TYRQ,CCRQ,AZFS,XH FROM T_SB_ZNYC_DLDRQ");
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql.toString(), null, new JDBCHelper.QueryCallback() {

				@Override
				public void process(ResultSet rs) throws Exception {
					while(rs.next()) {
						Map map = new HashMap();
						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("JYJZ", rs.getString("JYJZ"));
						map.put("TYRQ", rs.getString("TYRQ"));
						map.put("CCRQ", rs.getString("CCRQ"));
						map.put("AZFS", rs.getString("AZFS"));
						map.put("XH", rs.getString("XH"));
						dataList.add(map);
					}
				}

			});
		return dataList;
	}

}
