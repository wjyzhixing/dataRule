package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tauk.datarule.dao.IZnycMxDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycMxDaoImpl implements IZnycMxDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='±ÜÀ×Æ÷'"
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OBJ_ID,JMGG,XH,JGXS,RWDDLSJ,AZFS,MXCD,ZHSBLX,MXCZ,RWDDL,");
		sql.append(" DWDDL,EDPL,TYRQ,EDDL,FWDJ,EDDY,YXBH,ZCXZ,JYNRDJ,SBMC");
		sql.append(" FROM T_SB_ZNYC_MX");
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql.toString(), null, new JDBCHelper.QueryCallback() {

				@Override
				public void process(ResultSet rs) throws Exception {
					while(rs.next()) {
						Map map = new HashMap();
						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("XH", rs.getString("XH"));
						map.put("JMGG", rs.getString("JMGG"));
						map.put("JGXS", rs.getString("JGXS"));
						map.put("RWDDLSJ", rs.getString("RWDDLSJ"));
						map.put("AZFS", rs.getString("AZFS"));
						map.put("MXCD", rs.getString("MXCD"));
						map.put("ZHSBLX", rs.getString("ZHSBLX"));
						map.put("MXCZ", rs.getString("MXCZ"));
						map.put("RWDDL", rs.getString("RWDDL"));
						map.put("DWDDL", rs.getString("DWDDL"));

						map.put("EDPL", rs.getString("EDPL"));
						map.put("TYRQ", rs.getString("TYRQ"));
						map.put("EDDL", rs.getString("EDDL"));
						map.put("FWDJ", rs.getString("FWDJ"));
						map.put("EDDY", rs.getString("EDDY"));
						map.put("YXBH", rs.getString("YXBH"));
						map.put("ZCXZ", rs.getString("ZCXZ"));
						map.put("JYNRDJ", rs.getString("JYNRDJ"));
						map.put("SBMC", rs.getString("SBMC"));

						dataList.add(map);
					}
				}

			});
		return dataList;
	}

}
