package com.tauk.datarule.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tauk.datarule.base.Request;
import com.tauk.datarule.base.Response;
import com.tauk.datarule.base.RuleChain;
import com.tauk.datarule.base.SimpleRule;
import com.tauk.datarule.exception.DataExceptionMessage;
/**
 * �������͹���NUMBER(12,4)
 * 1.��֤��������λ��
 * 2.��֤С��λ��������λ��
 * 3.��֤ÿһλ��������
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
			
			//5000.0000 ��������λ��
			String treg = "^[0-9]{1,"+(Integer.parseInt(totalbit))+"}\\.[0]*$";
			Pattern tp = Pattern.compile(treg);
			Matcher tm = tp.matcher(value);
			boolean tb = tm.matches();
			
			if(tb) {
				value = value.substring(0,value.indexOf("."));
			}
			//�ж��Ƿ񳬹���λ��
			if((value.length()-1)>Integer.parseInt(totalbit)){
				String code = String.valueOf(DataExceptionMessage.DATA_NUMBER_TOTAL_BIT_RULE.getCode());
				String message = DataExceptionMessage.DATA_NUMBER_TOTAL_BIT_RULE.getMessage();
				recordErrData(datapk,code,message,field);
				return;
			}
			
			//�ж��Ƿ�������ݸ�ʽ
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
				
				DataExceptionMessage.DATA_NUMBER_TOTAL_FORMATTED_RULE.setMessage("���ֲ�����"+"Number("+totalbit+","+decimalbit+")��ʽҪ��");
				String message = DataExceptionMessage.DATA_NUMBER_TOTAL_FORMATTED_RULE.getMessage();
				recordErrData(datapk,code,message,field);
			}
			
		}
		
	}

}
