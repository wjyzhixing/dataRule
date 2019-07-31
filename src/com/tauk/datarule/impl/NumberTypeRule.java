package com.tauk.datarule.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tauk.datarule.base.Request;
import com.tauk.datarule.base.Response;
import com.tauk.datarule.base.RuleChain;
import com.tauk.datarule.base.SimpleRule;
import com.tauk.datarule.exception.DataExceptionMessage;
/**
 * 数字类型规则NUMBER(12,4)
 * 1.保证不超过总位数
 * 2.保证小数位不超过总位数
 * 3.保证每一位都是数字
 * @author zyb_s
 *
 */
public class NumberTypeRule extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {

		super.applyRule(request, response, chain);
		
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
		String datapk = (String)requestDataMap.get("datapk");
		
		String totalbit = (String)dataRuleMap.get("totalbit");
		String decimalbit = (String)dataRuleMap.get("decimalbit");
		
		if(value.trim().length()>0) {
			double data = Double.valueOf(value);
			
			//5000.0000 超过了总位数
			String treg = "^[0-9]{1,"+(Integer.parseInt(totalbit))+"}\\.[0]*$";
			Pattern tp = Pattern.compile(treg);
			Matcher tm = tp.matcher(value);
			boolean tb = tm.matches();
			
			if(tb) {
				value = value.substring(0,value.indexOf("."));
			}
			//判断是否超过总位数
			if((value.length()-1)>Integer.parseInt(totalbit)){
				String code = String.valueOf(DataExceptionMessage.DATA_NUMBER_TOTAL_BIT_RULE.getCode());
				String message = DataExceptionMessage.DATA_NUMBER_TOTAL_BIT_RULE.getMessage();
				recordErrData(datapk,code,message,field);
				return;
			}
			
			//判断是否符合数据格式
			String reg = "(^[0-9]*$)||"+"^[0-9]{1,"+(Integer.parseInt(totalbit)-1)+"}\\.[0-9]{1,"+decimalbit+"}$";
			
			if(decimalbit.equals("0")) {
				//50.00
				 reg = "(^[0-9]*$)||"+"^[0-9]{1,"+(Integer.parseInt(totalbit))+"}\\.[0]*$";
			}
			
			Pattern p = Pattern.compile(reg);
			Matcher m = p.matcher(value);
			boolean b = m.matches();
			if(b) {
				chain.applyRule(request, response, chain);
			}else {
				String code = String.valueOf(DataExceptionMessage.DATA_NUMBER_TOTAL_FORMATTED_RULE.getCode());
				
				DataExceptionMessage.DATA_NUMBER_TOTAL_FORMATTED_RULE.setMessage("数字不符合"+"Number("+totalbit+","+decimalbit+")格式要求");
				String message = DataExceptionMessage.DATA_NUMBER_TOTAL_FORMATTED_RULE.getMessage();
				recordErrData(datapk,code,message,field);
			}
			
		}
		
	}

}
