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
 * 隔离开关业务规则
 */
public class ZnycGlkgImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");
        // 接地刀闸配置JDDZPZ
        if(field.equals("JDDZPZ")){
        	if(!validateJddzpz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_JDDZPZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_JDDZPZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 组合电器名称ZHDQKGGMC
        if(field.equals("ZHDQKGGMC")){
        	if(!validateZhdqkggmc(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_ZHDQKGGMC.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_ZHDQKGGMC.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        //  接地开关开合感应电流能力 JDKGKHGYDLNL
        if(field.equals("JDKGKHGYDLNL")){
        	if(!validateJdkgkhgydlnl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_JDKGKHGYDLNL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_JDKGKHGYDLNL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        // 额定短时耐受时间EDDSNSSJ
        if(field.equals("EDDSNSSJ")){
        	if(!validateEddsnssj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_EDDSNSSJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_EDDSNSSJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 相别XB
        if(field.equals("XB")){
        	if(!validateXb(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_XB.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_XB.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

       //额定频率EDPL
        if(field.equals("EDPL")) {
        	if(!validateEdpl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }


        //投运日期
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }


	}

	/**
	 *接地刀闸配置JDDZPZ
	 * 规则：类型为隔离开关且设备型号中有1个D或2D、2T D2  或 Ⅱ的,根据实际情况填写单侧或双侧。无D的选择“无” ，类型为接地开关的选择“无”
	 */
	private boolean validateJddzpz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String lx = row.get("LX");//类型
		if(StringUtils.isEmpty(lx)) {
			return true;
		}
		String xh = row.get("XH");//型号
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//接地刀闸配置
			return true;
		}
		if("1".equals(lx)){//隔离开关
			if(xh.indexOf("D")==-1
					|| xh.indexOf("DD")==-1
					|| xh.indexOf("TT")==-1
					|| xh.indexOf("D2")==-1
					|| xh.indexOf("Ⅱ")==-1){
				if(!"2".equals(value) && !"3".equals(value)){//单侧或双侧
					return false;
				}
			}
			if(xh.indexOf("D")==-1){
				if(!"1".equals(value)){//无
					return false;
				}
			}
		}else{//接地开关
			if(!"1".equals(value)){//无
				return false;
			}
		}
		return true;
	}

	/**
	 *组合电器名称ZHDQKGGMC
	 * 规则：当“组合设备类型”选择“开关柜”或“组合电器”时，此项填写其所属开关 柜或组合电器的名称。若“组合设备类型”选“否”，此项不填写。
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
		}
		return true;
	}

	/**
	 *接地开关开合感应电流能力 JDKGKHGYDLNL
	 * 规则：根据标准规范，填写具体的数，不能填写A类、B类
	 */
	private boolean validateJdkgkhgydlnl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//接地开关开合感应电流能力
			return true;
		}
		if("1".equals(value) || "2".equals(value) || "3".equals(value)){
			return true;
		}
		return false;
	}

	/**
	 *  额定短时耐受时间EDDSNSSJ
	 * 规则：750为2；330为3；110为3或者4；35及以下为4；
	 */
	private boolean validateEddsnssj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//电压等级
		if(StringUtils.isEmpty(dydj)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//额定短时耐受时间
			return true;
		}
		BigDecimal eddsnssj = new BigDecimal(value);
		if("750".equals(dydj)){
			if(eddsnssj.compareTo(new BigDecimal(2.0000)) != 0){
				return false;
			}
		}else if("330".equals(dydj)){
			if(eddsnssj.compareTo(new BigDecimal(3.0000)) != 0){
				return false;
			}
		}else if("110".equals(dydj)){
			if(eddsnssj.compareTo(new BigDecimal(3.0000)) != 0
					||eddsnssj.compareTo(new BigDecimal(4.0000)) != 0){
				return false;
			}
		}else{
			if(eddsnssj.compareTo(new BigDecimal(4.0000)) != 0){
				return false;
			}
		}
		return true;
	}

	/**
	 * 相别XB       相数:1单相，2两相，3三相
	 * 规则：如果“相数”选择“三相设备”，则相别自动设置为“ABC”
	 */
	private boolean validateXb(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xs = row.get("XS");
		if(StringUtils.isEmpty(xs)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//相别
			return true;
		}
		if("3".equals(xs)){//三相
			if(!"5".equals(value)){//ABC
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
