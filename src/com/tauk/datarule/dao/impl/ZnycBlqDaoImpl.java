package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.tauk.datarule.dao.IZnycBlqDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycBlqDaoImpl implements IZnycBlqDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='±ÜÀ×Æ÷'"
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OBJ_ID,MXJS,CXYXDL,EDPL,SYHJ,ZZGJ,ZHDQKGGMC,ZHSBLX,");
		sql.append(" FDJXLX,EDDY,JGXS,XH FROM T_SB_ZNYC_BLQ" );
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql.toString(), null, new JDBCHelper.QueryCallback() {

				@Override
				public void process(ResultSet rs) throws Exception {
					while(rs.next()) {
						Map map = new HashMap();
						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("MXJS", rs.getString("MXJS"));
						map.put("CXYXDL", rs.getString("CXYXDL"));
						map.put("EDPL", rs.getString("EDPL"));
						map.put("SYHJ", rs.getString("SYHJ"));
						map.put("ZZGJ", rs.getString("ZZGJ"));
						map.put("ZHDQKGGMC", rs.getString("ZHDQKGGMC"));
						map.put("ZHSBLX", rs.getString("ZHSBLX"));
						map.put("FDJXLX", rs.getString("FDJXLX"));
						map.put("EDDY", rs.getString("EDDY"));
						map.put("JGXS", rs.getString("JGXS"));
						map.put("XH", rs.getString("XH"));
						dataList.add(map);
					}
				}

			});
		return dataList;
	}

}
