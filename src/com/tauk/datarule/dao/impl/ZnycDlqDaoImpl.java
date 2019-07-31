package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tauk.datarule.dao.IZnycDlhgqDao;
import com.tauk.datarule.dao.IZnycDlqDao;
import com.tauk.datarule.dao.IZnycDyhgqDao;
import com.tauk.datarule.dao.IZnycZbyqDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycDlqDaoImpl implements IZnycDlqDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='¶ÏÂ·Æ÷'"
		String sql = "SELECT * "+
				"FROM " + 
				" t_sb_znyc_dlq";
		
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
						map.put("XS", rs.getString("XS"));
						map.put("XB", rs.getString("XB"));
						map.put("EDDL", rs.getString("EDDL"));
						map.put("EDPL", rs.getString("EDPL"));
						map.put("SCCJ", rs.getString("SCCJ"));
						map.put("CCBH", rs.getString("CCBH"));
						map.put("CPDH", rs.getString("CPDH"));
						map.put("ZZGJ", rs.getString("ZZGJ"));
						map.put("YXBH", rs.getString("YXBH"));
						map.put("CCRQ", rs.getString("CCRQ"));
						
						map.put("SYHJ", rs.getString("SYHJ"));
						map.put("ZCBH", rs.getString("ZCBH"));
						map.put("WBSBH", rs.getString("WBSBH"));
						map.put("WBSMS", rs.getString("WBSMS"));
						map.put("SBZJFS", rs.getString("SBZJFS"));
						map.put("XH", rs.getString("XH"));
						map.put("ZHSBLX", rs.getString("ZHSBLX"));
						map.put("JGXS", rs.getString("JGXS"));
						map.put("CZJGXS", rs.getString("CZJGXS"));
						map.put("MHJZ", rs.getString("MHJZ"));
						map.put("EDJYSP", rs.getString("EDJYSP"));
						map.put("YWDW", rs.getString("YWDW"));
						

						map.put("EDDLKDDL", rs.getString("EDDLKDDL"));
						map.put("EDDLDLKDCS", rs.getString("EDDLDLKDCS"));
						map.put("EDDLGHDL", rs.getString("EDDLGHDL"));
						map.put("DWDDL", rs.getString("DWDDL"));
						map.put("RWDDL", rs.getString("RWDDL"));
						map.put("RWDCXSJ", rs.getString("RWDCXSJ"));
						map.put("DKSL", rs.getString("DKSL"));
						map.put("TGPDJL", rs.getString("TGPDJL"));
						map.put("TGGHJL", rs.getString("TGGHJL"));
						map.put("DDXLBJ", rs.getString("DDXLBJ"));
						map.put("JXSM", rs.getString("JXSM"));
						
						map.put("HZDZ", rs.getString("HZDZ"));
						map.put("HFSJJSDJSJ", rs.getString("HFSJJSDJSJ"));
						map.put("SF6QTEDYL", rs.getString("SF6QTEDYL"));
						map.put("SF6QTBJYL", rs.getString("SF6QTBJYL"));
						map.put("SF6QTBSYL", rs.getString("SF6QTBSYL"));
						map.put("SSZF", rs.getString("SSZF"));
						map.put("HZBSCZYL", rs.getString("HZBSCZYL"));
						map.put("FZBSCZYL", rs.getString("FZBSCZYL"));
						map.put("ZHZBSYL", rs.getString("ZHZBSYL"));
						map.put("ZJTYRQ", rs.getString("ZJTYRQ"));
						map.put("YXZT", rs.getString("YXZT"));
						
						map.put("ZDYXTZCS", rs.getString("ZDYXTZCS"));
						map.put("GZTZCS", rs.getString("GZTZCS"));
						map.put("LJTZCS", rs.getString("LJTZCS"));
						map.put("EDSBKDDL", rs.getString("EDSBKDDL"));
						map.put("JQGZKDDL", rs.getString("JQGZKDDL"));
						map.put("ZCXZ", rs.getString("ZCXZ"));
						map.put("EDXLCDKDDL", rs.getString("EDXLCDKDDL"));
						map.put("EDDLCDKDDL", rs.getString("EDDLCDKDDL"));
						map.put("EDLDCJNSDYDD", rs.getString("EDLDCJNSDYDD"));
						
						map.put("EDLDCJNSDYXJ", rs.getString("EDLDCJNSDYXJ"));
						map.put("EDLDCJNSDYDK", rs.getString("EDLDCJNSDYDK"));
						map.put("YFZGPNYDD", rs.getString("YFZGPNYDD"));
						map.put("YFZGPNYXJ", rs.getString("YFZGPNYXJ"));
						map.put("YFZGPNYDK", rs.getString("YFZGPNYDK"));
						map.put("FZHLEDDYDY", rs.getString("FZHLEDDYDY"));
						map.put("EDSTHFDY", rs.getString("EDSTHFDY"));
						map.put("ZCDW", rs.getString("ZCDW"));
						map.put("DKXLBJ", rs.getString("DKXLBJ"));
						map.put("SXFZBTQ", rs.getString("SXFZBTQ"));
						map.put("SXHZBTQ", rs.getString("SXHZBTQ"));
						map.put("TXFZBTQ", rs.getString("TXFZBTQ"));
						map.put("TXHZBTQ", rs.getString("TXHZBTQ"));
						map.put("FHZZZEDDY", rs.getString("FHZZZEDDY"));
						map.put("CZJGEDCZDY", rs.getString("CZJGEDCZDY"));
						map.put("YZDX", rs.getString("YZDX"));
						map.put("DYDJ", rs.getString("DYDJ"));
						map.put("YCJ", rs.getString("YCJ"));
						map.put("SF6QTZL", rs.getString("SF6QTZL"));
						map.put("CNDJXH", rs.getString("CNDJXH"));
						map.put("CNDJDY", rs.getString("CNDJDY"));
						
						map.put("CNSJ", rs.getString("CNSJ"));
						map.put("QDYL", rs.getString("QDYL"));
						map.put("TZYL", rs.getString("TZYL"));
						map.put("HZJCBSCZYL", rs.getString("HZJCBSCZYL"));
						map.put("FZJCBSCZYL", rs.getString("FZJCBSCZYL"));
						map.put("ZHZBSJCCZYL", rs.getString("ZHZBSJCCZYL"));
						map.put("JGDY", rs.getString("JGDY"));
						map.put("YCSGYL", rs.getString("YCSGYL"));
						map.put("YCJDYL", rs.getString("YCJDYL"));
						map.put("AQFDZYL", rs.getString("AQFDZYL"));
						map.put("TYRQ", rs.getString("TYRQ"));
						map.put("ZDBWCS", rs.getString("ZDBWCS"));
						map.put("ZDSGBWCS", rs.getString("ZDSGBWCS"));
						map.put("ZDGZDY", rs.getString("ZDGZDY"));
						
						map.put("EDDY", rs.getString("EDDY"));
						map.put("ZHDQKGGMC", rs.getString("ZHDQKGGMC"));
						map.put("YH", rs.getString("YH"));
						map.put("SSDS", rs.getString("SSDS"));
						map.put("WHBZ", rs.getString("WHBZ"));
						map.put("SFDW", rs.getString("SFDW"));
						map.put("CZJGXH", rs.getString("CZJGXH"));
						map.put("KGZY", rs.getString("KGZY"));
						map.put("GLTKQEDTKDLDY", rs.getString("GLTKQEDTKDLDY"));
						map.put("EDDWDDLFZ", rs.getString("EDDWDDLFZ"));
						map.put("EDRWDDL", rs.getString("EDRWDDL"));
						map.put("FHZKZXQEDDY", rs.getString("FHZKZXQEDDY"));
						map.put("GYHZSJ", rs.getString("GYHZSJ"));
						map.put("GYFZSJ", rs.getString("GYFZSJ"));
						map.put("CZFS", rs.getString("CZFS"));
						map.put("ZCYXFS", rs.getString("ZCYXFS"));
						map.put("ZYCD", rs.getString("ZYCD"));
						map.put("BZ", rs.getString("BZ"));
						map.put("DQTZ", rs.getString("DQTZ"));
						map.put("DJSJ", rs.getString("DJSJ"));
						
						map.put("SBZR", rs.getString("SBZR"));
						map.put("ZCDWMC", rs.getString("ZCDWMC"));
						map.put("WHBZMC", rs.getString("WHBZMC"));
						map.put("SBZRMC", rs.getString("SBZRMC"));
						map.put("SSDSMC", rs.getString("SSDSMC"));
						map.put("YWDWMC", rs.getString("YWDWMC"));
						map.put("SFNW", rs.getString("SFNW"));
						map.put("SBPBS", rs.getString("SBPBS"));
						map.put("EDGZYL", rs.getString("EDGZYL"));
						map.put("FBZT", rs.getString("FBZT"));
						map.put("FZSJ", rs.getString("FZSJ"));
						map.put("HZSJ", rs.getString("HZSJ"));
						map.put("ERPWBSBM", rs.getString("ERPWBSBM"));
						map.put("ZYFL", rs.getString("ZYFL"));
						map.put("XGHSBMC", rs.getString("XGHSBMC"));
						map.put("SFYC", rs.getString("SFYC"));
						map.put("SSDKX", rs.getString("SSDKX"));
						map.put("SSKXXD", rs.getString("SSKXXD"));
						map.put("GDQY", rs.getString("GDQY"));
						map.put("SWID", rs.getString("SWID"));
						
						
						dataList.add(map);
					}
				}
				
			});
		return dataList;
	}

}
