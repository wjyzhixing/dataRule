package com.tauk.datarule.impl;

import com.tauk.datarule.base.Request;
import com.tauk.datarule.base.Response;
import com.tauk.datarule.base.RuleChain;
import com.tauk.datarule.base.SimpleRule;
import com.tauk.datarule.exception.DataExceptionMessage;
import com.tauk.datarule.exception.RuleException;
import com.tauk.datarule.exception.RuleExceptionMessage;

public class DataRangeRule extends SimpleRule{

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {

		super.applyRule(request, response, chain);
		
		System.out.println("DataRangeRule");
		String value =(String) requestDataMap.get("value");
		String datapk = (String)requestDataMap.get("datapk");
		String field = (String)requestDataMap.get("field");
		
		String minvalue = (String)dataRuleMap.get("min");
		String maxvalue = (String)dataRuleMap.get("max");
		
		
		
		if(minvalue==null||maxvalue==null) {
			//throw new RuleException(RuleExceptionMessage.valueOf(40002).getMessage());
			return;
		}
		
		if(value.trim().length()==0){
			return;
		}
		
		if(Double.parseDouble(value)>=Double.parseDouble(minvalue)&&Double.parseDouble(value)<=Double.parseDouble(maxvalue)) {
			chain.applyRule(request, response, chain);
		}else {
			System.out.println("���ݲ��ڷ�Χ��");
			String code = String.valueOf(DataExceptionMessage.DATA_RANGE_RULE.getCode());
			DataExceptionMessage.DATA_RANGE_RULE.setMessage("��ʷ�������ֵΪ:"+maxvalue+"��СֵΪ:"+minvalue+"���ݲ��ڷ�Χ��");
			String message = DataExceptionMessage.DATA_RANGE_RULE.getMessage();
			recordErrData(datapk,code,message,field);
		}
		
	}
}
