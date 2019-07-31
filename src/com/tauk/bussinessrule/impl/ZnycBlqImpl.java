package com.tauk.bussinessrule.impl;

import java.math.BigDecimal;
import java.util.Map;
import java.util.regex.Pattern;

import com.alibaba.druid.util.StringUtils;
import com.tauk.datarule.base.Request;
import com.tauk.datarule.base.Response;
import com.tauk.datarule.base.RuleChain;
import com.tauk.datarule.base.SimpleRule;
import com.tauk.datarule.exception.DataExceptionMessage;
/**
 * ������ҵ�����
 */
public class ZnycBlqImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //ÿ����� MXJS
        if(field.equals("MXJS")) {
        	if(!validateMxjs(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_BLQ_MXJS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_BLQ_MXJS.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //�Ƶ��EDPL
        if(field.equals("EDPL")){
        	if(!validateEdpl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_BLQ_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_BLQ_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //��ϵ������� ZHDQKGGMC
        if(field.equals("ZHDQKGGMC")){
        	if(!validateZhdqkggmc(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_BLQ_ZHDQKGGMC.getCode());
    			String message = DataExceptionMessage.BUSSINESS_BLQ_ZHDQKGGMC.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //���ѹ EDDY
        if(field.equals("EDDY")){
        	if(!validateEddy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_BLQ_EDDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_BLQ_EDDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


	}


	/**
	 * ÿ����� MXJS
	 * ����ȡֵ˵����1~5
	 */
	private boolean validateMxjs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		BigDecimal mxjs = new BigDecimal(value);
		if(mxjs.compareTo(new BigDecimal(1))==-1
				|| mxjs.compareTo(new BigDecimal(5))==1){
			return false;
		}
		return true;
	}

	/**
	 *  �Ƶ��EDPL
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
	 * ��ϵ������� ZHDQKGGMC
	 * �����������豸����ѡ�񡰷�,����д�������ǿ��ع����ϵ�������Ҫ����д
	 */
	private boolean validateZhdqkggmc(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String zhsblx = row.get("ZHSBLX");//����豸����
		if(StringUtils.isEmpty(zhsblx)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//��ϵ�������
			return true;
		}
		if("01".equals(zhsblx)){//��
			if(value != null){
				return false;
			}
		}else if("02".equals(zhsblx) || "03".equals(zhsblx)){//���ع����ϵ���
			if(value == null){
				return false;
			}
		}
		return true;
	}

	/** ���ѹ:EDDY
	 * �����豸���ƻ�������鱨���������д����������п���������豸�ͺź���λ���ֱַ��ʾ���ѹ���׵�����ѹ��
	 * �����ͺ�ΪHY5WZ-51/134Q�����ѹ��51kV
	 */
	private boolean validateEddy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//�ͺ�
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		String jgxs = row.get("JGXS");//�ṹ��ʽ
		if(StringUtils.isEmpty(jgxs)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//���ѹ
			return true;
		}
		value = value.replaceAll("KV", "").replaceAll("kV", "").replaceAll("kv", "");
		if(isInteger(value)){
			BigDecimal eddy = new BigDecimal(value);
		}else{
			return false;
		}
		if("01".equals(jgxs)){//����п������
			String tvalue = xh;
			if(xh.indexOf("-")!=-1) {
				if(xh.lastIndexOf("/")!=-1) {
					if(xh.lastIndexOf("-")<xh.lastIndexOf("/")) {
						tvalue = xh.substring(xh.lastIndexOf("-")+1, xh.lastIndexOf("/"));
						if(tvalue.contains("/")){
							tvalue = tvalue.substring(0, tvalue.indexOf("/"));
						}
						if(tvalue.contains("-")){
							tvalue = tvalue.replaceAll("-", "");
						}
					}else if(xh.indexOf("-")<xh.lastIndexOf("/")){
						tvalue = xh.substring(xh.indexOf("-")+1, xh.lastIndexOf("/"));
						if(tvalue.contains("/")){
							tvalue = tvalue.substring(0, tvalue.indexOf("/"));
						}
						if(tvalue.contains("-")){
							tvalue = tvalue.replaceAll("-", "");
						}
					}
				}else{
					return false;
				}
			}else{
				return false;
			}
			if(!isInteger(tvalue.replaceAll("KV", "").replaceAll("kV", "").replaceAll("kv", ""))){
				return false;
			}
			if(new BigDecimal(value).compareTo(new BigDecimal(tvalue)) != 0){
				return false;
			}
		}
		return true;
	}


	public static boolean isInteger(String str) {//";
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");//^[-\\+]?[\\d]*$
        return pattern.matcher(str).matches();
	}

}
