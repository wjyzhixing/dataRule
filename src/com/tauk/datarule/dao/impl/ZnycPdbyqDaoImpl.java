package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tauk.datarule.dao.IZnycDldrqDao;
import com.tauk.datarule.dao.IZnycPdbyqDao;
import com.tauk.datarule.dao.IZnycZhdqDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycPdbyqDaoImpl implements IZnycPdbyqDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='±ÜÀ×Æ÷'"
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OBJ_ID,JGDY,DXMPYXKID,SBBM,SBMC,TYRQ,JYJZ,EDRL,ZKDY,DLSH,");
		sql.append(" KZSH,JXZB,GYCEDDL,YXBH,DYCEDDL,YZ,WKQCJ,WKQXH,JYDJ,ZCBH,DYDJ,SYXZ,");
		sql.append(" XH,SCCJ,CCBH,CCRQ,YWDW,JDDZ,SFSDY,ZCDW,WHBZ,YXZT,SFDW,ZCXZ,SSZF,SSDS,");
		sql.append(" KZDL,DYB,YH,ZZ,ZYCD,BZ,DJSJ,SBZR,ZCDWMC,WHBZMC,SBZRMC,SSDSMC,YWDWMC,");
		sql.append(" SFNW,WBSBH,WBSMS,SBZJFS,SBPBS,SFFJB,LJZBH,DQTZ,ZBID,FBZT,HM,ERPWBSBM,");
		sql.append(" ZYFL,XGHSBMC,SFYC,GDQY,SSDKX,SSKXXD,SWID FROM T_SB_ZNYC_PDBYQ");
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql.toString(), null, new JDBCHelper.QueryCallback() {

				@Override
				public void process(ResultSet rs) throws Exception {
					while(rs.next()) {
						Map map = new HashMap();
						map.put("ZYFL", rs.getString("ZYFL"));
						map.put("XGHSBMC", rs.getString("XGHSBMC"));
						map.put("SFYC", rs.getString("SFYC"));
						map.put("GDQY", rs.getString("GDQY"));
						map.put("SSDKX", rs.getString("SSDKX"));
						map.put("SSKXXD", rs.getString("SSKXXD"));
						map.put("SWID", rs.getString("SWID"));

						map.put("SFNW", rs.getString("SFNW"));
						map.put("WBSBH", rs.getString("WBSBH"));
						map.put("WBSMS", rs.getString("WBSMS"));
						map.put("SBZJFS", rs.getString("SBZJFS"));
						map.put("SBPBS", rs.getString("SBPBS"));
						map.put("SFFJB", rs.getString("SFFJB"));
						map.put("LJZBH", rs.getString("LJZBH"));
						map.put("DQTZ", rs.getString("DQTZ"));
						map.put("ZBID", rs.getString("ZBID"));
						map.put("FBZT", rs.getString("FBZT"));
						map.put("HM", rs.getString("HM"));
						map.put("ERPWBSBM", rs.getString("ERPWBSBM"));

						map.put("KZDL", rs.getString("KZDL"));
						map.put("DYB", rs.getString("DYB"));
						map.put("YH", rs.getString("YH"));
						map.put("ZZ", rs.getString("ZZ"));
						map.put("ZYCD", rs.getString("ZYCD"));
						map.put("BZ", rs.getString("BZ"));
						map.put("DJSJ", rs.getString("DJSJ"));
						map.put("SBZR", rs.getString("SBZR"));
						map.put("ZCDWMC", rs.getString("ZCDWMC"));
						map.put("WHBZMC", rs.getString("WHBZMC"));
						map.put("SBZRMC", rs.getString("SBZRMC"));
						map.put("SSDSMC", rs.getString("SSDSMC"));
						map.put("YWDWMC", rs.getString("YWDWMC"));

						map.put("XH", rs.getString("XH"));
						map.put("SCCJ", rs.getString("SCCJ"));
						map.put("CCBH", rs.getString("CCBH"));
						map.put("CCRQ", rs.getString("CCRQ"));
						map.put("YWDW", rs.getString("YWDW"));
						map.put("JDDZ", rs.getString("JDDZ"));
						map.put("SFSDY", rs.getString("SFSDY"));
						map.put("ZCDW", rs.getString("ZCDW"));
						map.put("YXZT", rs.getString("YXZT"));
						map.put("SFDW", rs.getString("SFDW"));
						map.put("ZCXZ", rs.getString("ZCXZ"));
						map.put("SSZF", rs.getString("SSZF"));
						map.put("SSDS", rs.getString("SSDS"));

						map.put("KZSH", rs.getString("KZSH"));
						map.put("JXZB", rs.getString("JXZB"));
						map.put("GYCEDDL", rs.getString("GYCEDDL"));
						map.put("YXBH", rs.getString("YXBH"));
						map.put("DYCEDDL", rs.getString("DYCEDDL"));
						map.put("YZ", rs.getString("YZ"));
						map.put("WKQCJ", rs.getString("WKQCJ"));
						map.put("WKQXH", rs.getString("WKQXH"));
						map.put("JYDJ", rs.getString("JYDJ"));
						map.put("ZCBH", rs.getString("ZCBH"));
						map.put("DYDJ", rs.getString("DYDJ"));
						map.put("SYXZ", rs.getString("SYXZ"));

						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("JGDY", rs.getString("JGDY"));
						map.put("DXMPYXKID", rs.getString("DXMPYXKID"));
						map.put("SBBM", rs.getString("SBBM"));
						map.put("SBMC", rs.getString("SBMC"));
						map.put("TYRQ", rs.getString("TYRQ"));
						map.put("JYJZ", rs.getString("JYJZ"));
						map.put("EDRL", rs.getString("EDRL"));
						map.put("ZKDY", rs.getString("ZKDY"));
						map.put("DLSH", rs.getString("DLSH"));
						dataList.add(map);
					}
				}

			});
		return dataList;
	}

}
