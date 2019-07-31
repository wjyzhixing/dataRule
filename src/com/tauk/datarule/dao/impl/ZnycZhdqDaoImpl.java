package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tauk.datarule.dao.IZnycZhdqDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycZhdqDaoImpl implements IZnycZhdqDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='±ÜÀ×Æ÷'"
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OBJ_ID,SBMC,DXMPYXKID,SBBM,SCCJ,CCBH,SSDS,WHBZ,WBSBH,");
		sql.append(" WBSMS,SBZJFS,XH,CPDH,ZZGJ,CCRQ,TYRQ,ZJTYRQ,YXZT,SYHJ,ZCBH,LX,YXBH,");
		sql.append(" JGXS,DLHGQBZFS,JCXFS,SF6QTEDYLFDLQQS,SF6QTYLJDBJYLFDLQQS,DLQSL,GLKGSL,");
		sql.append(" JDKGSL,BLQSL,YWDW,DLHGQSL,DYHGQSL,ZCXZ,ZCDW,DYDJ,JGDY,BZ,SSZF,DJSJ,SBZR,");
		sql.append(" ZCDWMC,WHBZMC,SBZRMC,SSDSMC,YWDWMC,SBPBS,EDDY,RWDCXSJ,RWDDL,EDDL,SFNW,FBZT,");
		sql.append(" ERPWBSBM,ZYFL,XGHSBMC,SFYC,SWID FROM T_SB_ZNYC_ZHDQ" );
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql.toString(), null, new JDBCHelper.QueryCallback() {

				@Override
				public void process(ResultSet rs) throws Exception {
					while(rs.next()) {
						Map map = new HashMap();
						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("SBMC", rs.getString("SBMC"));
						map.put("DXMPYXKID", rs.getString("DXMPYXKID"));
						map.put("SBBM", rs.getString("SBBM"));
						map.put("SCCJ", rs.getString("SCCJ"));
						map.put("CCBH", rs.getString("CCBH"));
						map.put("SSDS", rs.getString("SSDS"));
						map.put("WHBZ", rs.getString("WHBZ"));
						map.put("WBSBH", rs.getString("WBSBH"));

						map.put("WBSMS", rs.getString("WBSMS"));
						map.put("SBZJFS", rs.getString("SBZJFS"));
						map.put("XH", rs.getString("XH"));
						map.put("CPDH", rs.getString("CPDH"));
						map.put("ZZGJ", rs.getString("ZZGJ"));
						map.put("CCRQ", rs.getString("CCRQ"));
						map.put("TYRQ", rs.getString("TYRQ"));
						map.put("ZJTYRQ", rs.getString("ZJTYRQ"));
						map.put("YXZT", rs.getString("YXZT"));
						map.put("SYHJ", rs.getString("SYHJ"));
						map.put("ZCBH", rs.getString("ZCBH"));
						map.put("LX", rs.getString("LX"));
						map.put("YXBH", rs.getString("YXBH"));

						map.put("JGXS", rs.getString("JGXS"));
						map.put("DLHGQBZFS", rs.getString("DLHGQBZFS"));
						map.put("JCXFS", rs.getString("JCXFS"));
						map.put("SF6QTEDYLFDLQQS", rs.getString("SF6QTEDYLFDLQQS"));
						map.put("SF6QTYLJDBJYLFDLQQS", rs.getString("SF6QTYLJDBJYLFDLQQS"));
						map.put("DLQSL", rs.getString("DLQSL"));
						map.put("GLKGSL", rs.getString("GLKGSL"));

						map.put("JDKGSL", rs.getString("JDKGSL"));
						map.put("BLQSL", rs.getString("BLQSL"));
						map.put("YWDW", rs.getString("YWDW"));
						map.put("DLHGQSL", rs.getString("DLHGQSL"));
						map.put("DYHGQSL", rs.getString("DYHGQSL"));
						map.put("ZCXZ", rs.getString("ZCXZ"));
						map.put("ZCDW", rs.getString("ZCDW"));
						map.put("JGDY", rs.getString("JGDY"));
						map.put("DYDJ", rs.getString("DYDJ"));
						map.put("BZ", rs.getString("BZ"));
						map.put("SSZF", rs.getString("SSZF"));
						map.put("DJSJ", rs.getString("DJSJ"));
						map.put("SBZR", rs.getString("SBZR"));

						map.put("ZCDWMC", rs.getString("ZCDWMC"));
						map.put("WHBZMC", rs.getString("WHBZMC"));
						map.put("SBZRMC", rs.getString("SBZRMC"));
						map.put("SSDSMC", rs.getString("SSDSMC"));
						map.put("YWDWMC", rs.getString("YWDWMC"));
						map.put("SBPBS", rs.getString("SBPBS"));
						map.put("EDDY", rs.getString("EDDY"));
						map.put("RWDCXSJ", rs.getString("RWDCXSJ"));
						map.put("RWDDL", rs.getString("RWDDL"));
						map.put("EDDL", rs.getString("EDDL"));
						map.put("SFNW", rs.getString("SFNW"));
						map.put("FBZT", rs.getString("FBZT"));

						map.put("ERPWBSBM", rs.getString("ERPWBSBM"));
						map.put("ZYFL", rs.getString("ZYFL"));
						map.put("XGHSBMC", rs.getString("XGHSBMC"));
						map.put("SFYC", rs.getString("SFYC"));
						map.put("SWID", rs.getString("SWID"));

						dataList.add(map);
					}
				}

			});
		return dataList;
	}

}
