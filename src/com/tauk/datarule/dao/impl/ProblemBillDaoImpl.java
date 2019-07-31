package com.tauk.datarule.dao.impl;

import com.tauk.datarule.dao.IProblemBillDao;
import com.tauk.datarule.model.ProblemBill;
import com.tauk.datarule.util.DateUtil;
import com.tauk.datarule.util.JDBCHelper;

public class ProblemBillDaoImpl implements IProblemBillDao{

	@Override
	public void addProblemBill(ProblemBill problemBill) {
		String sql = "INSERT INTO t_problem_bill(datapk,problemcode,problemdesc,problemfield,createtime,tname,tid,datasource,problemfieldcomment) "
  		         + " VALUES(?,?,?,?,?,?,?,?,?)";
	
		Object[] params = new Object[]{problemBill.getDatapk(),problemBill.getProblemcode(),problemBill.getProblemdesc(),problemBill.getProblemfield(),DateUtil.getNowDate(),problemBill.getTname(),problemBill.getTid(),problemBill.getDatasource(),problemBill.getProblemfieldcomment()};
		
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		jdbcHelper.executeUpdate(sql, params);
	}

}
