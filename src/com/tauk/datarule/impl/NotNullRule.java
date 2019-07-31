package com.tauk.datarule.impl;

import com.tauk.datarule.base.Request;
import com.tauk.datarule.base.Response;
import com.tauk.datarule.base.RuleChain;
import com.tauk.datarule.base.SimpleRule;
import com.tauk.datarule.dao.IProblemBillDao;
import com.tauk.datarule.dao.factory.DAOFactory;
import com.tauk.datarule.exception.DataExceptionMessage;
import com.tauk.datarule.model.ProblemBill;

/**
 * ������
 * ���ݲ���ΪNULL
 * @author zyb_s
 *
 */
public class NotNullRule extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {

		super.applyRule(request, response, chain);
		
		String field = (String)requestDataMap.get("field");
		String datapk = (String)requestDataMap.get("datapk");
		String value = (String)requestDataMap.get("value");
		
		
		
		//�Ƿ��Ǳ�����,�����ִ�й���,�������ֱ�ӽ�����һ������
		if(dataRuleMap.get("required").equals("��")) {
			if(value==null||value.trim().length()==0) {
				System.out.println("NotNullRule");
				String code = String.valueOf(DataExceptionMessage.DATA_NOTNULL_RULE.getCode());
				String message = DataExceptionMessage.DATA_NOTNULL_RULE.getMessage();
				recordErrData(datapk,code,message,field);
				return;
			}
		}
		chain.applyRule(request, response, chain);
	}

}
