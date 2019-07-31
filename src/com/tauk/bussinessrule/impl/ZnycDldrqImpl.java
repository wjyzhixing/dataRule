package com.tauk.bussinessrule.impl;

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
 * ����������ҵ�����
 */
public class ZnycDldrqImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //��Ե����
        if(field.equals("JYJZ")) {
        	if(!validateJyjz(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLDRQ_JYJZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLDRQ_JYJZ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //Ͷ������
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLDRQ_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLDRQ_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

	}

	/**
	 * ��Ե����
	 * ���򣺾�Ե���ʣ��ͽ�����ʽ���ͺ��к�BAMΪ�ͽ�
	 */
	private boolean validateJyjz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		String xh = row.get("XH");
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(xh.indexOf("BAM")!=-1) {
			if(!"1".equals(value)){
			  return false;
			}
		}
		return true;
	}

	/**
	 * Ͷ������ TYQR
	 * ����Ͷ������ ���� ��������
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
