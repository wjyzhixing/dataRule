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
 * 所用变业务规则
 */
public class ZnycSybImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //油号YH
        if(field.equals("YH")){
        	if(!validateYh(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_SYB_YH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_SYB_YH.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //调压方式DYFS
        if(field.equals("DYFS")){
        	if(!validateDyfs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_SYB_DYFS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_SYB_DYFS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //额定频率EDPL
        if(field.equals("EDPL")) {
        	if(!validateEdpl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_SYB_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_SYB_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //投运日期
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_SYB_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_SYB_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

	}

	/**
	 * 油号YH
	 * 规则：变压器油的油号，数字代表变压器油的凝固点，45为零下45度凝固、25为零下25度凝固。陕西多为25号，非油浸式变压器不填油号
	 */
	private boolean validateYh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//型号
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		if(xh.indexOf("G")==-1 && xh.indexOf("C")==-1) {//油浸式
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
	 *  调压方式
	 * 规则：变压器高压侧绕组调压方式，型号中含“Z”的为有载调压，无“Z”为无励磁调压或无调压，据实填写。
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
			if(!"1".equals(value)){//有载调压
				return false;
			}
		}else{
			if(!"2".equals(value) && !"3".equals(value)){//无励磁调压或无调压
				return false;
			}
		}
		return true;
	}


	/**
	 * 额定频率EDPL
	 * 规则：默认值50
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
	 * 投运日期 TYQR
	 * 规则：投运日期 大于 出厂日期
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
