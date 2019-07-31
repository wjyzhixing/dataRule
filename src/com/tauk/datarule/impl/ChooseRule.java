package com.tauk.datarule.impl;

import com.tauk.datarule.base.Request;
import com.tauk.datarule.base.Response;
import com.tauk.datarule.base.RuleChain;
import com.tauk.datarule.base.SimpleRule;
import com.tauk.datarule.exception.DataExceptionMessage;

/**
 * 选择规则验证
 * @author zyb_s
 *
 */
public class ChooseRule extends SimpleRule{

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {

		super.applyRule(request, response, chain);
		
		System.out.println("ChooseRule");
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
		
		
		String datapk = (String)requestDataMap.get("datapk");
		
		String selectvalue = (String)dataRuleMap.get("selectvalue");
		
		
		
		if(value.trim().length()==0) {
			return;
		}
		
		boolean flag = false;
		String sv[] = selectvalue.split(",");
		
		for(int i=0;i<sv.length;i++) {
			if(sv[i].equals(value)) {
				flag=true;
				break;
			}
		}
		
		if(flag) {
			chain.applyRule(request, response, chain);
		}else {
			
			System.out.println("选择值不在列表范围值内");
			String code = String.valueOf(DataExceptionMessage.DATA_SELECT_VALUE_RULE.getCode());
			String message = DataExceptionMessage.DATA_SELECT_VALUE_RULE.getMessage();
			recordErrData(datapk,code,message,field);
		}
		
	}
}
