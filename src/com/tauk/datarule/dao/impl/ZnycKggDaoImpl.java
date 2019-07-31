package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tauk.datarule.dao.IZnycKggDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycKggDaoImpl implements IZnycKggDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='¿ª¹Ø¹ñ'"
		String sql = "SELECT * " +
				"FROM " + 
				" t_sb_znyc_kgg ";
		
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {
				
				@Override
				public void process(ResultSet rs) throws Exception {
					
					while(rs.next()) {
						
						Map map = new HashMap();
						
						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("SBBM", rs.getString("SBBM"));
						map.put("DXMPYXKID", rs.getString("DXMPYXKID"));
						map.put("SBMC", rs.getString("SBMC"));
						map.put("JGDY", rs.getString("JGDY"));
						map.put("SSZF", rs.getString("SSZF"));
						
						map.put("EDDL", rs.getString("EDDL"));
						map.put("EDPL", rs.getString("EDPL"));
						map.put("SCCJ", rs.getString("SCCJ"));
						map.put("CCBH", rs.getString("CCBH"));
						map.put("CPDH", rs.getString("CPDH"));
						map.put("ZZGJ", rs.getString("ZZGJ"));
						map.put("CCRQ", rs.getString("CCRQ"));
						map.put("TYRQ", rs.getString("TYRQ"));
						map.put("ZJTYRQ", rs.getString("ZJTYRQ"));
						map.put("YXBH", rs.getString("YXBH"));
						map.put("YXZT", rs.getString("YXZT"));
						
						map.put("SYHJ", rs.getString("SYHJ"));
						map.put("ZCBH", rs.getString("ZCBH"));
						map.put("WBSBH", rs.getString("WBSBH"));
						map.put("WBSMS", rs.getString("WBSMS"));
						map.put("SBZJFS", rs.getString("SBZJFS"));
						map.put("XH", rs.getString("XH"));
						map.put("DQTZ", rs.getString("DQTZ"));
						map.put("GMKD", rs.getString("GMKD"));
						map.put("YWDW", rs.getString("YWDW"));
						map.put("ZCXZ", rs.getString("ZCXZ"));
						map.put("ZCDW", rs.getString("ZCDW"));
						map.put("DYDJ", rs.getString("DYDJ"));
						

						map.put("JYJZ", rs.getString("JYJZ"));
						map.put("SFIACJ", rs.getString("SFIACJ"));
						map.put("SFLSC2L", rs.getString("SFLSC2L"));
						map.put("JGLX", rs.getString("JGLX"));
						map.put("LX", rs.getString("LX"));
						map.put("EDDY", rs.getString("EDDY"));
						map.put("SSDS", rs.getString("SSDS"));
						map.put("WHBZ", rs.getString("WHBZ"));
						map.put("SFDW", rs.getString("SFDW"));
						map.put("GD", rs.getString("GD"));
						map.put("KD", rs.getString("KD"));
						
						map.put("SD", rs.getString("SD"));
						map.put("SFFD", rs.getString("SFFD"));
						map.put("BZ", rs.getString("BZ"));
						map.put("DJSJ", rs.getString("DJSJ"));
						map.put("SBZR", rs.getString("SBZR"));
						map.put("ZCDWMC", rs.getString("ZCDWMC"));
						map.put("WHBZMC", rs.getString("WHBZMC"));
						map.put("SBZRMC", rs.getString("SBZRMC"));
						map.put("SSDSMC", rs.getString("SSDSMC"));
						map.put("YWDWMC", rs.getString("YWDWMC"));
						map.put("SFNW", rs.getString("SFNW"));
						
						map.put("SBPBS", rs.getString("SBPBS"));
						map.put("ZYCD", rs.getString("ZYCD"));
						map.put("FBZT", rs.getString("FBZT"));
						map.put("ERPWBSBM", rs.getString("ERPWBSBM"));
						map.put("ZYFL", rs.getString("ZYFL"));
						map.put("XGHSBMC", rs.getString("XGHSBMC"));
						map.put("SSDKX", rs.getString("SSDKX"));
						map.put("SSKXXD", rs.getString("SSKXXD"));
						map.put("SWID", rs.getString("SWID"));
						
						
						dataList.add(map);
					}
				}
				
			});
		return dataList;
	}

}
