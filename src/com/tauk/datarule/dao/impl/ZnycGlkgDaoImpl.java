package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tauk.datarule.dao.IZnycDldrqDao;
import com.tauk.datarule.dao.IZnycGlkgDao;
import com.tauk.datarule.dao.IZnycZhdqDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycGlkgDaoImpl implements IZnycGlkgDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='±ÜÀ×Æ÷'"
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OBJ_ID,ZCXZ,CCRQ,DQTZ,YXZT,TYRQ,EDDL,EDDY,DYDJ,DWDDL,RWDDL,");
		sql.append(" GWS,ZYCD,XB,XS,ZHSBLX,ZHDQKGGMC,JDKGKHGYDLNL,EDDSNSSJ,JDDZPZ,LX,XH");
		sql.append(" FROM T_SB_ZNYC_GLKG");
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql.toString(), null, new JDBCHelper.QueryCallback() {

				@Override
				public void process(ResultSet rs) throws Exception {
					while(rs.next()) {
						Map map = new HashMap();
						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("ZCXZ", rs.getString("ZCXZ"));
						map.put("CCRQ", rs.getString("CCRQ"));
						map.put("DQTZ", rs.getString("DQTZ"));
						map.put("YXZT", rs.getString("YXZT"));
						map.put("TYRQ", rs.getString("TYRQ"));
						map.put("EDDL", rs.getString("EDDL"));
						map.put("EDDY", rs.getString("EDDY"));
						map.put("DYDJ", rs.getString("DYDJ"));
						map.put("DWDDL", rs.getString("DWDDL"));
						map.put("RWDDL", rs.getString("RWDDL"));
						map.put("GWS", rs.getString("GWS"));
						map.put("ZYCD", rs.getString("ZYCD"));
						map.put("XB", rs.getString("XB"));
						map.put("XS", rs.getString("XS"));
						map.put("ZHSBLX", rs.getString("ZHSBLX"));
						map.put("ZHDQKGGMC", rs.getString("ZHDQKGGMC"));
						map.put("JDKGKHGYDLNL", rs.getString("JDKGKHGYDLNL"));
						map.put("EDDSNSSJ", rs.getString("EDDSNSSJ"));
						map.put("JDDZPZ", rs.getString("JDDZPZ"));
						map.put("LX", rs.getString("LX"));
						map.put("XH", rs.getString("XH"));
						dataList.add(map);
					}
				}

			});
		return dataList;
	}

}
