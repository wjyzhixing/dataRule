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
 * ĸ��ҵ�����
 */
public class ZnycMxImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        // ���ȶ�����ʱ��  RWDDLSJ
        if(field.equals("RWDDLSJ")){
        	if(!validateRwddlsj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_RWDDLSJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_RWDDLSJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ĸ�߲��� MXCZ
        if(field.equals("MXCZ")){
        	if(!validateMxcz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_MXCZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_MXCZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


  	  	//  ���ȶ����� RWDDL
        if(field.equals("RWDDL")){
        	if(!validateRwddl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_RWDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_RWDDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ���ȶ����� DWDDL
        if(field.equals("DWDDL")){
        	if(!validateDwddl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_DWDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_DWDDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //�Ƶ��EDPL
        if(field.equals("EDPL")) {
        	if(!validateEdpl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //Ͷ������
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // ���б��YXBH
        if(field.equals("YXBH")) {
        	if(!validateYxbh(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_YXBH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_YXBH.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // �豸���� SBMC
        if(field.equals("SBMC")) {
        	if(!validateSbmc(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_SBMC.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_SBMC.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

	}


	/**
	 * ���ȶ�����ʱ��  RWDDLSJ
	 * ���򣺸����豸���ƻ����������д�����ڵ���2��С�ڵ���4)
	 */
	private boolean validateRwddlsj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//���ȶ�����ʱ��
			return true;
		}
		BigDecimal rwddlsj = new BigDecimal(value);
		if(rwddlsj.compareTo(new BigDecimal(2.0000)) == -1
				||rwddlsj.compareTo(new BigDecimal(4.0000)) == 1){
			return false;
		}
		return true;

	}

	/**
	 * ĸ�߲��� MXCZ
	 * ����ѡ��TMYΪͭ,LMYΪ��,LGJ-���Ϊ��о������,LFΪ���̺Ͻ�,�Ͻ���ϵ����Ϳ��ع�����д��о�����ߣ�
	 * ͭ,  ��,   ��о������,   ���Ͻ�,  ��þ�Ͻ�,���̺Ͻ�
	 * 01  02      03        04     05     06
	 */
	private boolean validateMxcz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		String zhsblx = row.get("ZHSBLX");
		if(StringUtils.isEmpty(zhsblx)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//ĸ�߲���
			return true;
		}
		if(xh.indexOf("TMY")!=-1){
			if(!"01".equals(value)){
				return false;
			}
		}
		if(xh.indexOf("LMY")!=-1){
			if(!"02".equals(value)){
				return false;
			}
		}
		if(xh.indexOf("LGJ")!=-1){
			if(!"03".equals(value)){
				return false;
			}
		}
		if(xh.indexOf("LF")!=-1){
			if(!"06".equals(value)){
				return false;
			}
		}
		if("03".equals(zhsblx) || "02".equals(zhsblx)){//��ϵ����Ϳ��ع�
			if("03".equals(value)){
				return false;
			}
		}
		return true;
	}


	/**
	 * ���ȶ�����ʱ��  RWDDL
	 * ���򣺸����豸���ƻ����������д�������ϵģ����������Ӷ�·���������·���ϵ�����д�������ڵ���12.5��С�ڵ���50)
	 */
	private boolean validateRwddl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//���ȶ�����ʱ��
			return true;
		}
		BigDecimal rwddl = new BigDecimal(value);
		if(rwddl.compareTo(new BigDecimal(12.5000)) == -1
				||rwddl.compareTo(new BigDecimal(50.0000)) == 1){
			return false;
		}
		return true;

	}

	/**
	 * ���ȶ�����ʱ��  DWDDL
	 * ���򣺶��ȶ���������2.5�����ȶ����������ڵ���31.5��С�ڵ���135)
	 */
	private boolean validateDwddl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String rwddl = row.get("RWDDL");//���ȶ�����ʱ��
		if(StringUtils.isEmpty(rwddl)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//���ȶ�����ʱ��
			return true;
		}
		BigDecimal rwddlNew = new BigDecimal(rwddl);
		BigDecimal dwddl = new BigDecimal(value);
		if(dwddl.compareTo(rwddlNew.multiply(new BigDecimal(2.5))) != 0){
			return false;
		}
		if(dwddl.compareTo(new BigDecimal(31.5000)) == -1
				||dwddl.compareTo(new BigDecimal(135.0000)) == 1){
			return false;
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

	/**
	 *  ���б�� YXBH
	 * �������б�Ų�Ӧ��kv��д���淶����ȷkV
	 */
	private boolean validateYxbh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//���б��
			return true;
		}
		if(value.indexOf("kv") ==-1){
			return false;
		}
		return true;
	}

	/**
	 *  �豸���� SBMC
	 * �����豸���Ʋ�Ӧ��kv��д���淶����ȷkV
	 */
	private boolean validateSbmc(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//�豸����
			return true;
		}
		if(value.indexOf("kv") ==-1){
			return false;
		}
		return true;
	}


}
