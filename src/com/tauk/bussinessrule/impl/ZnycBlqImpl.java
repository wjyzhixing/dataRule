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
 * 霹雷器业务规则
 */
public class ZnycBlqImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //每相节数 MXJS
        if(field.equals("MXJS")) {
        	if(!validateMxjs(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_BLQ_MXJS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_BLQ_MXJS.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //额定频率EDPL
        if(field.equals("EDPL")){
        	if(!validateEdpl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_BLQ_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_BLQ_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //组合电器名称 ZHDQKGGMC
        if(field.equals("ZHDQKGGMC")){
        	if(!validateZhdqkggmc(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_BLQ_ZHDQKGGMC.getCode());
    			String message = DataExceptionMessage.BUSSINESS_BLQ_ZHDQKGGMC.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //额定电压 EDDY
        if(field.equals("EDDY")){
        	if(!validateEddy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_BLQ_EDDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_BLQ_EDDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


	}


	/**
	 * 每相节数 MXJS
	 * 规则：取值说明：1~5
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
	 *  额定频率EDPL
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
	 * 组合电器名称 ZHDQKGGMC
	 * 规则：如果组合设备类型选择“否”,不填写此项，如果是开关柜或组合电器，按要求填写
	 */
	private boolean validateZhdqkggmc(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String zhsblx = row.get("ZHSBLX");//组合设备类型
		if(StringUtils.isEmpty(zhsblx)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//组合电器名称
			return true;
		}
		if("01".equals(zhsblx)){//否
			if(value != null){
				return false;
			}
		}else if("02".equals(zhsblx) || "03".equals(zhsblx)){//开关柜或组合电器
			if(value == null){
				return false;
			}
		}
		return true;
	}

	/** 额定电压:EDDY
	 * 根据设备铭牌或出厂试验报告等资料填写，对于氧化锌避雷器，设备型号后两位数字分别表示额定电压和雷电冲击残压，
	 * 例如型号为HY5WZ-51/134Q，额定电压即51kV
	 */
	private boolean validateEddy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//型号
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		String jgxs = row.get("JGXS");//结构形式
		if(StringUtils.isEmpty(jgxs)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//额定电压
			return true;
		}
		value = value.replaceAll("KV", "").replaceAll("kV", "").replaceAll("kv", "");
		if(isInteger(value)){
			BigDecimal eddy = new BigDecimal(value);
		}else{
			return false;
		}
		if("01".equals(jgxs)){//氧化锌避雷器
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
