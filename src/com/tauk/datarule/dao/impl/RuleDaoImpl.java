package com.tauk.datarule.dao.impl;

import java.sql.ResultSet;

import com.tauk.datarule.dao.IRuleLogDao;
import com.tauk.datarule.model.RuleLog;
import com.tauk.datarule.util.DateUtil;
import com.tauk.datarule.util.JDBCHelper;

public class RuleDaoImpl implements IRuleLogDao {

	@Override
	public void addRuleLog(RuleLog ruleLog) {

		String sql = "INSERT INTO t_rule_log(maxxh,createtime) "
 		         + " VALUES(?,?)";
	
		Object[] params = new Object[]{ruleLog.getMaxxh(),DateUtil.getNowDate()};
		
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		jdbcHelper.executeUpdate(sql, params);
	}

	@Override
	public int getMaxXh() {
		String sql = "SELECT MAX(maxxh) maxxh FROM t_rule_log";
		
		StringBuilder sb = new StringBuilder();	
		int maxXh = 0;
		 JDBCHelper jdbcHelper = JDBCHelper.getInstance();
			jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {
				@Override
				public void process(ResultSet rs) throws Exception {
					if(rs.next()) {
						sb.append(rs.getInt("maxxh"));
					}
				}
			});
			
			if(sb.length()>0) {
				maxXh = Integer.parseInt(sb.toString());
			}
			
		return maxXh;
	}

}
