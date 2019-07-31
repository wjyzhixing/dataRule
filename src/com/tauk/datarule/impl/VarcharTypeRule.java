package com.tauk.datarule.impl;

import com.tauk.datarule.base.Request;
import com.tauk.datarule.base.Response;
import com.tauk.datarule.base.RuleChain;
import com.tauk.datarule.base.SimpleRule;
import com.tauk.datarule.exception.DataExceptionMessage;
import com.tauk.datarule.exception.RuleException;
import com.tauk.datarule.exception.RuleExceptionMessage;
/**
 * �ı����͹��� varchar,varchar2
 * 1.�ж��Ƿ񳬹��ַ�����
 * @author zyb_s
 *
 */
public class VarcharTypeRule extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {

		super.applyRule(request, response, chain);
		
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
		String datapk = (String)requestDataMap.get("datapk");
		
		String length = (String)dataRuleMap.get("length");
		
		if(length==null) {
			throw new RuleException(RuleExceptionMessage.valueOf(40001).getMessage());
		}
		if(value == null) {
			return;
		}
		if(value.trim().length()==0) {
			return;
		}else if(value.trim().length()>Integer.parseInt(length)) {
			System.out.println("��������Ҫ��ĳ���");
			String code = String.valueOf(DataExceptionMessage.DATA_VARCHAR_TOTAL_BIT_RULE.getCode());
			String message = DataExceptionMessage.DATA_VARCHAR_TOTAL_BIT_RULE.getMessage();
			recordErrData(datapk,code,message,field);
		}else {
			chain.applyRule(request, response, chain);
		}
		
	}
}
