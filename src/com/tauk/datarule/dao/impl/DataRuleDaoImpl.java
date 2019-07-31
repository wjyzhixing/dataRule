package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import com.tauk.datarule.dao.IPrimaryDataDao;
import com.tauk.datarule.dao.factory.DAOFactory;
import com.tauk.datarule.util.JDBCHelper;

public class DataRuleDaoImpl implements com.tauk.datarule.dao.IDataRuleDao {

	@Override
	public Map<String,Map<String, String>> readDataRule(String tname) {
		
		Map<String,Map<String, String>> dataList = new HashMap();
		String sql = " SELECT t.tname,t.columnname,t.columncomment,t.columntype,t.required,t.inputway,"
				+ " t.inputcontent,t.convertvalue,"
				+ " t.remark,t.isprimarydata,t.primarytablename FROM t_rule_data t where t.tname='"+tname+"'";
		
        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {
			
			@Override
			public void process(ResultSet rs) throws Exception {
				
				while(rs.next()) {
					Map<String,String> dataMap = new HashMap();
					
					String tname = rs.getString("tname");
					
					String columnname = rs.getString("columnname");
					dataMap.put("field", columnname);
					
					String columncomment = rs.getString("columncomment");
					dataMap.put("fieldComment", columncomment);
					
					String columntype = rs.getString("columntype");
					if(columntype==null) {
						System.out.println(columntype);
					}
					if(columntype.toUpperCase().startsWith("VARCHAR")) {
						dataMap.put("type", "VARCHAR");
						dataMap.put("length", columntype.substring(columntype.indexOf("(")+1,columntype.length()-1));
					}
                    if(columntype.toUpperCase().startsWith("NUMBER")) {
						dataMap.put("type", "NUMBER");
						
						if(columntype.indexOf(",")==-1) {//NUMBER(6)
							dataMap.put("totalbit", columntype.substring(columntype.indexOf("(")+1,columntype.indexOf(")")));
							dataMap.put("decimalbit", "0");
						}else {//NUMBER(12,2)
							dataMap.put("totalbit", columntype.substring(columntype.indexOf("(")+1,columntype.indexOf(",")));
							dataMap.put("decimalbit", columntype.substring(columntype.indexOf(",")+1,columntype.indexOf(")")));
						}
						
					}
					
					String required = rs.getString("required");
					dataMap.put("required", required);
					
					String inputway = rs.getString("inputway");
					dataMap.put("inputway", inputway);
					if(inputway.equals("下拉框")) {
						String convertvalue = rs.getString("convertvalue");
						String inputcontent = rs.getString("inputcontent");
						
						dataMap.put("selectvalue", convertvalue);
						dataMap.put("selecttext", inputcontent);
					}
					
					String isprimarydata = rs.getString("isprimarydata");
					
					
					if(isprimarydata.equals("是")) {
						String primarytablename = rs.getString("primarytablename");
						String t[] = primarytablename.split(",");
						//查询外部数据
						IPrimaryDataDao primaryDataDao = DAOFactory.getPrimaryDataDao();
						String data = primaryDataDao.selectDictData(t[0], t[1]);
						dataMap.put("selectvalue", data);
					}
					
					dataList.put(columnname,dataMap);
				}
			}
			
		});
		return dataList;
	}

}
