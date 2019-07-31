package com.tauk.bussinessrule.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

import com.alibaba.druid.util.StringUtils;
import com.tauk.datarule.base.Request;
import com.tauk.datarule.base.Response;
import com.tauk.datarule.base.RuleChain;
import com.tauk.datarule.base.SimpleRule;
import com.tauk.datarule.exception.DataExceptionMessage;
/**
 * 电抗器业务规则
 */
public class ZnycDkqImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //相数XS
        if(field.equals("XS")){
        	if(!validateXs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_XS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_XS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //额定电感 EDDG
        if(field.equals("EDDG")){
        	if(!validateEddg(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_EDDG.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_EDDG.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 油产地YCD
        if(field.equals("YCD")){
        	if(!validateYcd(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_YCD.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_YCD.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //额定频率EDPL
        if(field.equals("EDPL")) {
        	if(!validateEdpl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //最近投运日期
        if(field.equals("ZJTYRQ")) {
        	if(!validateZjtyrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_ZJYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_ZJYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // 接入方式 JRFS
        if(field.equals("JRFS")) {
        	if(!validateJrfs(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_JRFS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_JRFS.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //额定电抗率EDDKL
        if(field.equals("EDDKL")) {
        	if(!validateEddkl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_EDDKL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_EDDKL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //油号YH
        if(field.equals("YH")){
        	if(!validateYh(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_YH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_YH.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //总重ZZ
        if(field.equals("ZZ")) {
        	if(!validateZz(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_ZZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_ZZ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

      // 额定电抗EDDK
        if(field.equals("EDDK")) {
        	if(!validateEddk(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_EDDK.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_EDDK.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // 额定容量EDRL
        if(field.equals("EDRL")) {
        	if(!validateEdrl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_EDRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_EDRL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //投运日期
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }
	}

	/**
	 * 相数XS   1单相，2两相，3三相
	 * 规则：330kV及以上设备分相，单相，三相，其他电压等级不分相。
	 */
	private boolean validateXs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String eddy = row.get("EDDY");
		if(StringUtils.isEmpty(eddy)) {
			return true;
		}

		if(StringUtils.isEmpty(value)) {//相数
			return true;
		}

		if(isInteger(eddy)){
			Double eddyNew = Double.valueOf(eddy);
			if(eddyNew >= 330){
				if(!"1".equals(value) && !"3".equals(value)){
					return false;
				}
			}else{
				if("1".equals(value) || "2".equals(value) || "3".equals(value) ){
					return false;
				}
			}
		}
		return true;

	}

	/**
	 * 额定电感 EDDG
	 * 规则：x>0。
	 */
	private boolean validateEddg(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//额定电感
			return true;
		}
		BigDecimal eddg = new BigDecimal(value);
		if(eddg.compareTo(new BigDecimal(0.0000)) != 1){
			return false;
		}
		return true;

	}

	/**
	 * 油产地YCD
	 * 规则：绝缘介质=油浸:不为空；否则为0、无、/
	 */
	private boolean validateYcd(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//绝缘介质
		if(StringUtils.isEmpty(jyjz)) {
			return true;
		}
		if("1".equals(jyjz)) {//油浸式
			if(value == null || "".equals(value)){
				return false;
			}
		}else {
			if(!"无".equals(value) && !"/".equals(value) && !"0".equals(value)){
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
	 * 最近投运日期 ZJTYQR
	 * 规则：投运日期≤最近投运日期
	 */
	private boolean validateZjtyrq(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String tyrq = row.get("TYQR");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
        	if(StringUtils.isEmpty(value) ||StringUtils.isEmpty(tyrq)) {
        		return true;
        	}
            Date dt1 = df.parse(value);
            Date dt2 = df.parse(tyrq);
            if (dt1.getTime() >= dt2.getTime()) {
                return true;
            } else if (dt1.getTime() < dt2.getTime()) {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
		return true;
	}

	/**
	 * 接入方式 JRFS
	 * 规则：型号中首字母为CK的均为串抗，首字母为BK的均为并抗。
	 */
	private boolean validateJrfs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//型号
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {// 接入方式
			return true;
		}
		if(xh.startsWith("CK")) {//串抗 2
			if(!"2".equals(value)){
				return false;
			}
		}else if(xh.startsWith("BK")){//并抗 1\3
			if("2".equals(value)){
				return false;
			}
		}
		return true;
	}

	/**
	 * 额定电抗率 EDDKL
	 * 规则：x>0。
	 */
	private boolean validateEddkl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//额定电抗率
			return true;
		}
		BigDecimal eddkl = new BigDecimal(value);
		if(eddkl.compareTo(new BigDecimal(0.0000)) != 1){
			return false;
		}
		return true;

	}

	/**
	 * 油号YH
	 * 规则：按照铭牌填写，如不确定的统一填写“45或25”，只有绝缘介质为油浸的才填。
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
	 * 总重 ZZ
	 * 规则：x>0。
	 */
	private boolean validateZz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//总重
			return true;
		}
		BigDecimal zz = new BigDecimal(value);
		if(zz.compareTo(new BigDecimal(0.0000)) != 1){
			return false;
		}
		return true;

	}

	/**
	 * 额定电抗EDDK
	 * 规则：x>0。
	 */
	private boolean validateEddk(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//额定电抗
			return true;
		}
		BigDecimal eddk = new BigDecimal(value);
		if(eddk.compareTo(new BigDecimal(0.0000)) != 1){
			return false;
		}
		return true;

	}

	/**
	 * 额定容量EDRL
	 * 规则：X>0。500kV电抗器：额定容量（10-100Mvar）额定电感（1-16H）总重：（30-90t）
	 */
	private boolean validateEdrl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//额定容量
			return true;
		}
		BigDecimal edrl = new BigDecimal(value);
		if(edrl.compareTo(new BigDecimal(0.0000)) != 1){
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

	public static boolean isInteger(String str) {//";
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");//^[-\\+]?[\\d]*$
        return pattern.matcher(str).matches();
	}

}
