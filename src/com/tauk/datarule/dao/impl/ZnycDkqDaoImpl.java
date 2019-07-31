package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tauk.datarule.dao.IZnycDkqDao;
import com.tauk.datarule.util.JDBCHelper;

public class ZnycDkqDaoImpl implements IZnycDkqDao {

	@Override
	public List readData(int maxXH) {
		List<Map<String,String>> dataList = new ArrayList();
		//where t.eartx='±ÜÀ×Æ÷'"
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT OBJ_ID,XH,DYFS,XS,EDDG,YXZT,FWDJ,AZFS,YCD,EDPL,TYRQ,");
		sql.append(" ZJTYRQ,EDDY,SYHJ,JYNRDJ,XB,JRFS,EDDKL,YH,DCJG,ZZ,EDDK,EDRL,");
		sql.append(" JYJZ,CCRQ FROM T_SB_ZNYC_DKQ");
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql.toString(), null, new JDBCHelper.QueryCallback() {

				@Override
				public void process(ResultSet rs) throws Exception {
					while(rs.next()) {
						Map map = new HashMap();
						map.put("OBJ_ID", rs.getString("OBJ_ID"));
						map.put("XH", rs.getString("XH"));
						map.put("DYFS", rs.getString("DYFS"));
						map.put("XS", rs.getString("XS"));
						map.put("EDDG", rs.getString("EDDG"));
						map.put("YXZT", rs.getString("YXZT"));
						map.put("FWDJ", rs.getString("FWDJ"));
						map.put("AZFS", rs.getString("AZFS"));
						map.put("YCD", rs.getString("YCD"));
						map.put("EDPL", rs.getString("EDPL"));
						map.put("TYRQ", rs.getString("TYRQ"));

						map.put("ZJTYRQ", rs.getString("ZJTYRQ"));
						map.put("EDDY", rs.getString("EDDY"));
						map.put("SYHJ", rs.getString("SYHJ"));
						map.put("JYNRDJ", rs.getString("JYNRDJ"));
						map.put("XB", rs.getString("XB"));
						map.put("JRFS", rs.getString("JRFS"));
						map.put("EDDKL", rs.getString("EDDKL"));
						map.put("YH", rs.getString("YH"));
						map.put("DCJG", rs.getString("DCJG"));
						map.put("ZZ", rs.getString("ZZ"));
						map.put("EDRL", rs.getString("EDRL"));

						map.put("JYJZ", rs.getString("JYJZ"));
						map.put("CCRQ", rs.getString("CCRQ"));
						dataList.add(map);
					}
				}

			});
		return dataList;
	}

}
