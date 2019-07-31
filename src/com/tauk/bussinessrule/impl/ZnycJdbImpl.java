package com.tauk.bussinessrule.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.alibaba.druid.util.StringUtils;
import com.tauk.datarule.base.Request;
import com.tauk.datarule.base.Response;
import com.tauk.datarule.base.RuleChain;
import com.tauk.datarule.base.SimpleRule;
import com.tauk.datarule.exception.DataExceptionMessage;
/**
 * �ӵر�ҵ�����
 */
public class ZnycJdbImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //�Ƶ��EDPL
        if(field.equals("EDPL")) {
        	if(!validateEdpl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_JDB_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_JDB_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //Ͷ������
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_JDB_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_JDB_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

	}


	/**
	 * �Ƶ��EDPL
	 * ����Ĭ��ֵ50
	 */
	private boolean validateEdpl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {
    		return true;
    	}
		BigDecimal edpl = new BigDecimal(value);
		if(edpl.compareTo(new BigDecimal(50.0000)) != 0){
			return false;
		}
		return true;
	}

	/**
	 * Ͷ������ TYQR
	 * �����豸Ͷ��������е����ڣ����ڳ�������
	 */
	private boolean validateTyrq(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String ccrq = row.get("CCRQ");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
        	if(StringUtils.isEmpty(value) ||StringUtils.isEmpty(ccrq)) {
        		return true;
        	}
            Date dt1 = df.parse(value);
            Date dt2 = df.parse(ccrq);
            if (dt1.getTime() > dt2.getTime()) {
                return true;
            } else if (dt1.getTime() <= dt2.getTime()) {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
		return true;
	}

}
