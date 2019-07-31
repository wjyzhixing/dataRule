package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tauk.datarule.dao.IDataSourceDao;
import com.tauk.datarule.model.WZJSCS;
import com.tauk.datarule.util.JDBCHelperForOracle;

public class DataSourceDaoImpl implements IDataSourceDao {

	@Override
	public List<WZJSCS> readData(int maxXH) {
		
		List<WZJSCS> dataList = new ArrayList();
		//where t.eartx='±ÜÀ×Æ÷'"
		String sql = "select xh,zswid,zswsxz,eartx,eqart from T_WZJSCS t where t.zswid like '026%' and"
				+ " t.xh>"+maxXH+" order by eartx";
		
		JDBCHelperForOracle jdbcHelper = JDBCHelperForOracle.getInstance();
			jdbcHelper.executeQuery(sql, null, new JDBCHelperForOracle.QueryCallback() {
				
				@Override
				public void process(ResultSet rs) throws Exception {
					
					while(rs.next()) {
						
						WZJSCS wzjscs = new WZJSCS();
						int xh = rs.getInt("xh");
						wzjscs.setXh(xh);
						String zswid = rs.getString("zswid");
						wzjscs.setZwid(zswid);
						String zswsxz = rs.getString("zswsxz");
						wzjscs.setZswsxz(zswsxz);
						String eartx = rs.getString("eartx");
						wzjscs.setEartx(eartx);
						String eqart = rs.getString("eqart");
						wzjscs.setEqart(eqart);
						dataList.add(wzjscs);
					}
				}
				
			});
			return dataList;
	}

}
