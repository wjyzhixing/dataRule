package com.tauk.datarule.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tauk.datarule.base.Request;
import com.tauk.datarule.base.Response;
import com.tauk.datarule.base.RuleChain;
import com.tauk.datarule.base.SimpleRule;
import com.tauk.datarule.exception.DataExceptionMessage;

/**
 * 日期格式规则
 * @author zyb_s
 *
 */
public class DateTypeRule extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {

		super.applyRule(request, response, chain);
		
		String value =(String) requestDataMap.get("value");
		String field = (String)requestDataMap.get("field");
		String datapk = (String)requestDataMap.get("datapk");
		
		//2016/12/8
		//2016-12-8
		String rqregex="((^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(10|12|0?[13578])([-\\/\\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(11|0?[469])([-\\/\\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(0?2)([-\\/\\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([3579][26]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$))";
		
		Pattern rqp = Pattern.compile(rqregex);
		Matcher rqm = rqp.matcher(value);
		boolean rqb = rqm.matches();
		
		if(rqb) {
			chain.applyRule(request, response, chain);
		}else if(value.length()==8) {//20161208
			chain.applyRule(request, response, chain);
		}else {
			System.out.println("日期格式不正确");
			String code = String.valueOf(DataExceptionMessage.DATA_DATE_VALUE_RULE.getCode());
			String message = DataExceptionMessage.DATA_DATE_VALUE_RULE.getMessage();
			recordErrData(datapk,code,message,field);
		}
		
	}
}
