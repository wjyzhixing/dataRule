package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tauk.datarule.dao.IZnycDlhgqDao;
import com.tauk.datarule.dao.IZnycDyhgqDao;
import com.tauk.datarule.dao.IZnycZbyqDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycDlhgqDaoImpl implements IZnycDlhgqDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='µçÁ÷»¥¸ÐÆ÷'"
		String sql = "SELECT * "+
				"FROM " + 
				" t_sb_znyc_dlhgq";
		
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {
				
				@Override
				public void process(ResultSet rs) throws Exception {
					
					while(rs.next()) {
						
						Map map = new HashMap();
						
						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("SJSBID", rs.getString("SJSBID"));
						map.put("DXMPYXKID", rs.getString("DXMPYXKID"));
						map.put("JGDY", rs.getString("JGDY"));
						map.put("SBBM", rs.getString("SBBM"));
						map.put("SBMC", rs.getString("SBMC"));
						
						map.put("XS", rs.getString("XS"));
						map.put("XB", rs.getString("XB"));
						map.put("ZHDQKGGMC", rs.getString("ZHDQKGGMC"));
						map.put("EDDL", rs.getString("EDDL"));
						map.put("EDPL", rs.getString("EDPL"));
						map.put("SCCJ", rs.getString("SCCJ"));
						map.put("CCBH", rs.getString("CCBH"));
						map.put("CPDH", rs.getString("CPDH"));
						map.put("ZZGJ", rs.getString("ZZGJ"));
						map.put("YXBH", rs.getString("YXBH"));
						map.put("CCRQ", rs.getString("CCRQ"));
						
						map.put("TYRQ", rs.getString("TYRQ"));
						map.put("ZJTYRQ", rs.getString("ZJTYRQ"));
						map.put("YXZT", rs.getString("YXZT"));
						map.put("SYHJ", rs.getString("SYHJ"));
						map.put("ZCBH", rs.getString("ZCBH"));
						map.put("ZHSBLX", rs.getString("ZHSBLX"));
						map.put("JGXS", rs.getString("JGXS"));
						map.put("JYJZ", rs.getString("JYJZ"));
						map.put("YWDW", rs.getString("YWDW"));
						map.put("WJYXS", rs.getString("WJYXS"));
						map.put("JYLX", rs.getString("JYLX"));
						map.put("MFXS", rs.getString("MFXS"));
						

						map.put("SFWLXCT", rs.getString("SFWLXCT"));
						map.put("WBSBH", rs.getString("WBSBH"));
						map.put("WBSMS", rs.getString("WBSMS"));
						map.put("SBZJFS", rs.getString("SBZJFS"));
						map.put("XH", rs.getString("XH"));
						map.put("ECXHSCXS", rs.getString("ECXHSCXS"));
						map.put("YCCGQYL", rs.getString("YCCGQYL"));
						map.put("YH", rs.getString("YH"));
						map.put("ZZ", rs.getString("ZZ"));
						map.put("EDDLB", rs.getString("EDDLB"));
						map.put("DWDDL", rs.getString("DWDDL"));
						
						map.put("RWDDL", rs.getString("RWDDL"));
						map.put("PDBJ", rs.getString("PDBJ"));
						map.put("ECRZZSL", rs.getString("ECRZZSL"));
						map.put("SF6QTEDYL", rs.getString("SF6QTEDYL"));
						map.put("SF6QTZXYXYL", rs.getString("SF6QTZXYXYL"));
						map.put("SF6QTBJYL", rs.getString("SF6QTBJYL"));
						map.put("JYSP", rs.getString("JYSP"));
						map.put("LXRWDDL", rs.getString("LXRWDDL"));
						map.put("RWDDLSJ", rs.getString("RWDDLSJ"));
						map.put("ECRZSLCL", rs.getString("ECRZSLCL"));
						map.put("ECRZSLBH", rs.getString("ECRZSLBH"));
						
						map.put("ECRZSLZTBH", rs.getString("ECRZSLZTBH"));
						map.put("SSZF", rs.getString("SSZF"));
						map.put("SF6QTZL", rs.getString("SF6QTZL"));
						map.put("SF6QTYSYL", rs.getString("SF6QTYSYL"));
						map.put("YZ", rs.getString("YZ"));
						map.put("YCJ", rs.getString("YCJ"));
						map.put("GD", rs.getString("GD"));
						map.put("ZQJCL", rs.getString("ZQJCL"));
						map.put("ZQJBH", rs.getString("ZQJBH"));
						
						map.put("ZQJZTBH", rs.getString("ZQJZTBH"));
						map.put("ZCXZ", rs.getString("ZCXZ"));
						map.put("EDSCRLCL", rs.getString("EDSCRLCL"));
						map.put("EDSCRLBH", rs.getString("EDSCRLBH"));
						map.put("EDSCRLZTBH", rs.getString("EDSCRLZTBH"));
						map.put("EDSCRLBH", rs.getString("EDSCRLBH"));
						map.put("BMJYDYDJ", rs.getString("BMJYDYDJ"));
						map.put("ZDCXDL", rs.getString("ZDCXDL"));
						map.put("LDCJDY", rs.getString("LDCJDY"));
						map.put("CZCJDY", rs.getString("CZCJDY"));
						map.put("DSNSDL", rs.getString("DSNSDL"));
						map.put("PDJL", rs.getString("PDJL"));
						map.put("ZDCXDY", rs.getString("ZDCXDY"));
						map.put("ZCDW", rs.getString("ZCDW"));
						map.put("LDCJNYFZ", rs.getString("LDCJNYFZ"));
						map.put("DSRDL", rs.getString("DSRDL"));
						map.put("CZCJNYFZST", rs.getString("CZCJNYFZST"));
						map.put("ZLNY", rs.getString("ZLNY"));
						map.put("KSZTDL", rs.getString("KSZTDL"));
						map.put("JBFDSYDY", rs.getString("JBFDSYDY"));
						map.put("ZLDLCLJD", rs.getString("ZLDLCLJD"));
						
						map.put("WXDGRSYDY", rs.getString("WXDGRSYDY"));
						map.put("XBDLCLJD", rs.getString("XBDLCLJD"));
						map.put("JYXY1090", rs.getString("JYXY1090"));
						map.put("DYDJ", rs.getString("DYDJ"));
						map.put("EDYCDL", rs.getString("EDYCDL"));
						map.put("EDKDYCDLXS", rs.getString("EDKDYCDLXS"));
						map.put("EDDSRDL", rs.getString("EDDSRDL"));
						map.put("EDECSC", rs.getString("EDECSC"));
						map.put("EDSYSJ", rs.getString("EDSYSJ"));
						map.put("FZDY", rs.getString("FZDY"));
						map.put("CPXH", rs.getString("CPXH"));
						map.put("SSDS", rs.getString("SSDS"));
						map.put("WHBZ", rs.getString("WHBZ"));
						map.put("SFDW", rs.getString("SFDW"));
						
						map.put("EDDY", rs.getString("EDDY"));
						map.put("EDECRL", rs.getString("EDECRL"));
						map.put("ZQDJ", rs.getString("ZQDJ"));
						map.put("DQTZ", rs.getString("DQTZ"));
						map.put("BZ", rs.getString("BZ"));
						map.put("DJSJ", rs.getString("DJSJ"));
						map.put("SBZR", rs.getString("SBZR"));
						map.put("YWDWMC", rs.getString("YWDWMC"));
						map.put("SSDSMC", rs.getString("SSDSMC"));
						map.put("SBZRMC", rs.getString("SBZRMC"));
						map.put("ZCDWMC", rs.getString("ZCDWMC"));
						map.put("WHBZMC", rs.getString("WHBZMC"));
						map.put("SFNW", rs.getString("SFNW"));
						map.put("SBPBS", rs.getString("SBPBS"));
						map.put("BHBB", rs.getString("BHBB"));
						map.put("CLBB", rs.getString("CLBB"));
						map.put("FBZT", rs.getString("FBZT"));
						map.put("YXBB", rs.getString("YXBB"));
						map.put("ERPWBSBM", rs.getString("ERPWBSBM"));
						map.put("ZYFL", rs.getString("ZYFL"));
						
						map.put("XGHSBMC", rs.getString("XGHSBMC"));
						map.put("SFYC", rs.getString("SFYC"));
						map.put("JLBB", rs.getString("JLBB"));
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
