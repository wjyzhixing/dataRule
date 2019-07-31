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
 * ���ñ�ҵ�����
 */
public class ZnycSybImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //�ͺ�YH
        if(field.equals("YH")){
        	if(!validateYh(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_SYB_YH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_SYB_YH.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //��ѹ��ʽDYFS
        if(field.equals("DYFS")){
        	if(!validateDyfs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_SYB_DYFS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_SYB_DYFS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //�Ƶ��EDPL
        if(field.equals("EDPL")) {
        	if(!validateEdpl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_SYB_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_SYB_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //Ͷ������
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_SYB_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_SYB_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

	}

	/**
	 * �ͺ�YH
	 * ���򣺱�ѹ���͵��ͺţ����ִ����ѹ���͵����̵㣬45Ϊ����45�����̡�25Ϊ����25�����̡�������Ϊ25�ţ����ͽ�ʽ��ѹ�������ͺ�
	 */
	private boolean validateYh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//�ͺ�
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		if(xh.indexOf("G")==-1 && xh.indexOf("C")==-1) {//�ͽ�ʽ
			if(!"25".equals(value) && !"45".equals(value)){
				return false;
			}
		}else {
			if(!"".equals(value) || value != null){
				return false;
			}
		}
		return true;
	}

	/**
	 *  ��ѹ��ʽ
	 * ���򣺱�ѹ����ѹ�������ѹ��ʽ���ͺ��к���Z����Ϊ���ص�ѹ���ޡ�Z��Ϊ�����ŵ�ѹ���޵�ѹ����ʵ��д��
	 */
	private boolean validateDyfs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		if(xh.indexOf("Z")!=-1){
			if(!"1".equals(value)){//���ص�ѹ
				return false;
			}
		}else{
			if(!"2".equals(value) && !"3".equals(value)){//�����ŵ�ѹ���޵�ѹ
				return false;
			}
		}
		return true;
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
