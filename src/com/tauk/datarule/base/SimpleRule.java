package com.tauk.datarule.base;

import java.util.Map;

import com.tauk.datarule.dao.IProblemBillDao;
import com.tauk.datarule.dao.factory.DAOFactory;
import com.tauk.datarule.model.ProblemBill;

public abstract class SimpleRule implements Rule {

	protected Map<String,String> requestDataMap;
	protected Map<String,String> dataRuleMap;
	protected Map<String,String> row;
	
	private String tname;
	private String tid;
	//数据源类型(ODS区,PMS资产数据)
	private String sourceType="ODS";
	
	private String fieldComment;
	
	
	public Map getRequestDataMap() {
		return requestDataMap;
	}

	public void setRequestDataMap(Map requestDataMap) {
		this.requestDataMap = requestDataMap;
	}

	public Map getDataRuleMap() {
		return dataRuleMap;
	}

	public void setDataRuleMap(Map dataRuleMap) {
		this.dataRuleMap = dataRuleMap;
	}


	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {

		requestDataMap = request.getRequestData();
		dataRuleMap = request.getDataRule();
		row = request.getRow();
		
		tname = (String)dataRuleMap.get("tname");
		sourceType = (String)requestDataMap.get("sourceType");
		tid = (String)requestDataMap.get("tid");
		fieldComment = (String)dataRuleMap.get("fieldComment");
	}
	
	/**
	 * 
	 */
	public void recordErrData(String datapk,String code,String message,String field) {
		ProblemBill problemBill =  new ProblemBill();
		
		problemBill.setDatapk(datapk);
		problemBill.setProblemcode(code);
		problemBill.setProblemdesc(message);
		problemBill.setProblemfield(field);
		problemBill.setTname(tname);
		problemBill.setTid(tid);
		problemBill.setDatasource(sourceType);
		problemBill.setProblemfieldcomment(fieldComment);
		IProblemBillDao iproblemBillDao = DAOFactory.getProblemBillDao();
		iproblemBillDao.addProblemBill(problemBill);
	}

}
