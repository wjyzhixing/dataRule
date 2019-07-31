package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tauk.datarule.dao.IZnycDyhgqDao;
import com.tauk.datarule.dao.IZnycZbyqDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycDyhgqDaoImpl implements IZnycDyhgqDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='µçÑ¹»¥¸ÐÆ÷'"
		String sql = "SELECT * "+
				"FROM " + 
				" t_sb_znyc_dyhgq ";
		
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {
				
				@Override
				public void process(ResultSet rs) throws Exception {
					
					while(rs.next()) {
						
						Map map = new HashMap();
						
						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("SJSBID", rs.getString("SJSBID"));
						map.put("DXMPYXKID", rs.getString("DXMPYXKID"));
						map.put("SBMC", rs.getString("SBMC"));
						map.put("SBBM", rs.getString("SBBM"));
						map.put("JGDY", rs.getString("JGDY"));
						
						map.put("XS", rs.getString("XS"));
						map.put("XB", rs.getString("XB"));
						map.put("EDDY", rs.getString("EDDY"));
						map.put("EDPL", rs.getString("EDPL"));
						map.put("SCCJ", rs.getString("SCCJ"));
						map.put("CCBH", rs.getString("CCBH"));
						map.put("CPDH", rs.getString("CPDH"));
						map.put("ZZGJ", rs.getString("ZZGJ"));
						map.put("CCRQ", rs.getString("CCRQ"));
						map.put("YXBH", rs.getString("YXBH"));
						map.put("ZJTYRQ", rs.getString("ZJTYRQ"));
						
						map.put("YXZT", rs.getString("YXZT"));
						map.put("SYHJ", rs.getString("SYHJ"));
						map.put("ZCBH", rs.getString("ZCBH"));
						map.put("WBSBH", rs.getString("WBSBH"));
						map.put("WBSMS", rs.getString("WBSMS"));
						map.put("SBZJFS", rs.getString("SBZJFS"));
						map.put("XH", rs.getString("XH"));
						map.put("ZHSBLX", rs.getString("ZHSBLX"));
						map.put("JYJZ", rs.getString("JYJZ"));
						map.put("WJYXS", rs.getString("WJYXS"));
						map.put("JGXS", rs.getString("JGXS"));
						map.put("YWDW", rs.getString("YWDW"));
						

						map.put("TXJG", rs.getString("TXJG"));
						map.put("SFQJY", rs.getString("SFQJY"));
						map.put("EDDYB", rs.getString("EDDYB"));
						map.put("ECRZZSL", rs.getString("ECRZZSL"));
						map.put("PDBJ", rs.getString("PDBJ"));
						map.put("ZEDDRL", rs.getString("ZEDDRL"));
						map.put("DRQJS", rs.getString("DRQJS"));
						map.put("SJDRL", rs.getString("SJDRL"));
						map.put("ZJDRL", rs.getString("ZJDRL"));
						map.put("XJC1DRL", rs.getString("XJC1DRL"));
						map.put("XJC2DRL", rs.getString("XJC2DRL"));
						
						map.put("SF6QTEDYL", rs.getString("SF6QTEDYL"));
						map.put("SF6QTBJYL", rs.getString("SF6QTBJYL"));
						map.put("MFJG", rs.getString("MFJG"));
						map.put("JYSP", rs.getString("JYSP"));
						map.put("ECRZSLCL", rs.getString("ECRZSLCL"));
						map.put("ECRZSLBH", rs.getString("ECRZSLBH"));
						map.put("GD", rs.getString("GD"));
						map.put("SSZF", rs.getString("SSZF"));
						map.put("EDKLZJDY", rs.getString("EDKLZJDY"));
						map.put("SCFYB", rs.getString("SCFYB"));
						map.put("SJDRQBH", rs.getString("SJDRQBH"));
						
						map.put("SJDRQXS", rs.getString("SJDRQXS"));
						map.put("ZJDRQBH", rs.getString("ZJDRQBH"));
						map.put("ZJDRQXS", rs.getString("ZJDRQXS"));
						map.put("XJC1DRQBH", rs.getString("XJC1DRQBH"));
						map.put("XJC1DRQXS", rs.getString("XJC1DRQXS"));
						map.put("XJC2DRQBH", rs.getString("XJC2DRQBH"));
						map.put("ZCXZ", rs.getString("ZCXZ"));
						map.put("XJC2DRQXS", rs.getString("XJC2DRQXS"));
						map.put("YCJ", rs.getString("YCJ"));
						
						map.put("YZ", rs.getString("YZ"));
						map.put("SF6QTZL", rs.getString("SF6QTZL"));
						map.put("ZQJCL", rs.getString("ZQJCL"));
						map.put("ZQJBH", rs.getString("ZQJBH"));
						map.put("EDSCRLCL", rs.getString("EDSCRLCL"));
						map.put("EDSCRLBH", rs.getString("EDSCRLBH"));
						map.put("TYRQ", rs.getString("TYRQ"));
						map.put("ZCDW", rs.getString("ZCDW"));
						map.put("DYDJ", rs.getString("DYDJ"));
						map.put("ZHDQKGGMC", rs.getString("ZHDQKGGMC"));
						map.put("ECXHSCXS", rs.getString("ECXHSCXS"));
						map.put("LX", rs.getString("LX"));
						map.put("YH", rs.getString("YH"));
						map.put("ZZ", rs.getString("ZZ"));
						map.put("SSDS", rs.getString("SSDS"));
						map.put("WHBZ", rs.getString("WHBZ"));
						map.put("SFDW", rs.getString("SFDW"));
						map.put("EDECRL", rs.getString("EDECRL"));
						map.put("ZQDJ", rs.getString("ZQDJ"));
						map.put("BZ", rs.getString("BZ"));
						map.put("DJSJ", rs.getString("DJSJ"));
						
						map.put("SBZR", rs.getString("SBZR"));
						map.put("YWDWMC", rs.getString("YWDWMC"));
						map.put("SSDSMC", rs.getString("SSDSMC"));
						map.put("SBZRMC", rs.getString("SBZRMC"));
						map.put("ZCDWMC", rs.getString("ZCDWMC"));
						map.put("WHBZMC", rs.getString("WHBZMC"));
						map.put("SFNW", rs.getString("SFNW"));
						map.put("DQTZ", rs.getString("DQTZ"));
						map.put("SBPBS", rs.getString("SBPBS"));
						map.put("CLBB", rs.getString("CLBB"));
						map.put("BHBB", rs.getString("BHBB"));
						map.put("FBZT", rs.getString("FBZT"));
						map.put("ZYFL", rs.getString("ZYFL"));
						map.put("XGHSBMC", rs.getString("XGHSBMC"));
						
						map.put("SFYC", rs.getString("SFYC"));
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
