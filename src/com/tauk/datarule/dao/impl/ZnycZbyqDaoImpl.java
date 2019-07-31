package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tauk.datarule.dao.IZnycZbyqDao;
import com.tauk.datarule.util.JDBCPMSHelper;

public class ZnycZbyqDaoImpl implements IZnycZbyqDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='±ÜÀ×Æ÷'"
		String sql = "SELECT" + 
				" OBJ_ID," + 
				" XH," + 
				" CCBH," + 
				" CPDH," + 
				" EDDY," + 
				" EDPL," + 
				" FWDJ," + 
				" RZXS," + 
				"LQFS," + 
				"LJZBH," + 
				"ZLQRL," + 
				"EDDYZY," + 
				"EDDLZY," + 
				"FZSHGYDY," + 
				"FZSHZYDY," + 
				"DLZKGYDY," + 
				"KZDL," + 
				"FZSHMZ," + 
				"YH," + 
				"YCD," + 
				"SF6QTBJYL," + 
				"YSZ," + 
				"JYSPZXD," + 
				"YZRL," + 
				"YWRHX," + 
				"YQXJG," + 
				"SF6QTZL," + 
				"SF6QZDLC," + 
				"SF6QZBT," + 
				"SF6QZYZKG," + 
				"RLB," + 
				"SCCJ," + 
				"CCRQ," + 
				"ZZGJ," + 
				"EDDL," + 
				"JYNRDJ," + 
				"JYJZ," + 
				"JGXS," + 
				"DYFS," + 
				"EDRL," + 
				"DYB," + 
				"EDDYDY," + 
				"EDDLDY," + 
				"FZSHGYZY," + 
				"DLZKGYZY," + 
				"DLZKZYDY," + 
				"KZSH," + 
				"ZZ," + 
				"YZ," + 
				"SF6QTEDYL," + 
				"QSZ," + 
				"JYSP," + 
				"QPFLZS," + 
				"YZMFFS," + 
				"SJYXZ," + 
				"SF6CJ," + 
				"SF6QTYLDLC," + 
				"LQSZ," + 
				"ZSSP, " + 
				"TYRQ " +
				"FROM " + 
				" t_sb_znyc_zbyq ";
		
		JDBCPMSHelper jdbcHelper = JDBCPMSHelper.getInstance();
			jdbcHelper.executeQuery(sql, null, new JDBCPMSHelper.QueryCallback() {
				
				@Override
				public void process(ResultSet rs) throws Exception {
					
					while(rs.next()) {
						
						Map map = new HashMap();
						
						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("XH", rs.getString("XH"));
						map.put("CCBH", rs.getString("CCBH"));
						map.put("CPDH", rs.getString("CPDH"));
						map.put("EDDY", rs.getString("EDDY"));
						map.put("EDPL", rs.getString("EDPL"));
						
						map.put("FWDJ", rs.getString("FWDJ"));
						map.put("RZXS", rs.getString("RZXS"));
						map.put("LQFS", rs.getString("LQFS"));
						map.put("LJZBH", rs.getString("LJZBH"));
						map.put("ZLQRL", rs.getString("ZLQRL"));
						map.put("EDDYZY", rs.getString("EDDYZY"));
						map.put("EDDLZY", rs.getString("EDDLZY"));
						map.put("FZSHGYDY", rs.getString("FZSHGYDY"));
						map.put("FZSHZYDY", rs.getString("FZSHZYDY"));
						map.put("DLZKGYDY", rs.getString("DLZKGYDY"));
						map.put("KZDL", rs.getString("KZDL"));
						
						map.put("FZSHMZ", rs.getString("FZSHMZ"));
						map.put("YH", rs.getString("YH"));
						map.put("YCD", rs.getString("YCD"));
						map.put("SF6QTBJYL", rs.getString("SF6QTBJYL"));
						map.put("YSZ", rs.getString("YSZ"));
						map.put("JYSPZXD", rs.getString("JYSPZXD"));
						map.put("YZRL", rs.getString("YZRL"));
						map.put("YWRHX", rs.getString("YWRHX"));
						map.put("YQXJG", rs.getString("YQXJG"));
						map.put("SF6QTZL", rs.getString("SF6QTZL"));
						map.put("SF6QZDLC", rs.getString("SF6QZDLC"));
						map.put("SF6QZBT", rs.getString("SF6QZBT"));
						

						map.put("SF6QZYZKG", rs.getString("SF6QZYZKG"));
						map.put("RLB", rs.getString("RLB"));
						map.put("SCCJ", rs.getString("SCCJ"));
						map.put("ZZGJ", rs.getString("ZZGJ"));
						map.put("EDDL", rs.getString("EDDL"));
						map.put("JYNRDJ", rs.getString("JYNRDJ"));
						map.put("JYJZ", rs.getString("JYJZ"));
						map.put("JGXS", rs.getString("JGXS"));
						map.put("DYFS", rs.getString("DYFS"));
						map.put("EDRL", rs.getString("EDRL"));
						map.put("DYB", rs.getString("DYB"));
						
						map.put("EDDYDY", rs.getString("EDDYDY"));
						map.put("EDDLDY", rs.getString("EDDLDY"));
						map.put("FZSHGYZY", rs.getString("FZSHGYZY"));
						map.put("DLZKGYZY", rs.getString("DLZKGYZY"));
						map.put("DLZKZYDY", rs.getString("DLZKZYDY"));
						map.put("KZSH", rs.getString("KZSH"));
						map.put("ZZ", rs.getString("ZZ"));
						map.put("YZ", rs.getString("YZ"));
						map.put("SF6QTEDYL", rs.getString("SF6QTEDYL"));
						map.put("QSZ", rs.getString("QSZ"));
						map.put("JYSP", rs.getString("JYSP"));
						
						map.put("QPFLZS", rs.getString("QPFLZS"));
						map.put("YZMFFS", rs.getString("YZMFFS"));
						map.put("SJYXZ", rs.getString("SJYXZ"));
						map.put("SF6CJ", rs.getString("SF6CJ"));
						map.put("SF6QZBT", rs.getString("SF6QZBT"));
						map.put("SF6QZYZKG", rs.getString("SF6QZYZKG"));
						map.put("SF6QTYLDLC", rs.getString("JYSP"));
						map.put("LQSZ", rs.getString("LQSZ"));
						map.put("ZSSP", rs.getString("ZSSP"));
						
						map.put("CCRQ", rs.getString("CCRQ"));
						map.put("TYRQ", rs.getString("TYRQ"));
						
						
						dataList.add(map);
					}
				}
				
			});
		return dataList;
	}

}
