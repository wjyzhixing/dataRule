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
 * 母线业务规则
 */
public class ZnycMxImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        // 热稳定电流时间  RWDDLSJ
        if(field.equals("RWDDLSJ")){
        	if(!validateRwddlsj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_RWDDLSJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_RWDDLSJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 母线材质 MXCZ
        if(field.equals("MXCZ")){
        	if(!validateMxcz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_MXCZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_MXCZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


  	  	//  热稳定电流 RWDDL
        if(field.equals("RWDDL")){
        	if(!validateRwddl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_RWDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_RWDDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 动稳定电流 DWDDL
        if(field.equals("DWDDL")){
        	if(!validateDwddl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_DWDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_DWDDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //额定频率EDPL
        if(field.equals("EDPL")) {
        	if(!validateEdpl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //投运日期
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // 运行编号YXBH
        if(field.equals("YXBH")) {
        	if(!validateYxbh(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_YXBH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_YXBH.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // 设备名称 SBMC
        if(field.equals("SBMC")) {
        	if(!validateSbmc(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_MX_SBMC.getCode());
    			String message = DataExceptionMessage.BUSSINESS_MX_SBMC.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

	}


	/**
	 * 热稳定电流时间  RWDDLSJ
	 * 规则：根据设备铭牌或出厂资料填写（大于等于2，小于等于4)
	 */
	private boolean validateRwddlsj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//热稳定电流时间
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
	 * 母线材质 MXCZ
	 * 规则：选择TMY为铜,LMY为铝,LGJ-规格为钢芯铝绞线,LF为铝锰合金,合金（组合电器和开关柜不能填写钢芯铝绞线）
	 * 铜,  铝,   钢芯铝绞线,   铝合金,  铝镁合金,铝锰合金
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
		if(StringUtils.isEmpty(value)) {//母线材质
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
		if("03".equals(zhsblx) || "02".equals(zhsblx)){//组合电器和开关柜
			if("03".equals(value)){
				return false;
			}
		}
		return true;
	}


	/**
	 * 热稳定电流时间  RWDDL
	 * 规则：根据设备铭牌或出厂资料填写；无资料的，参照所连接断路器的最大额定短路开断电流填写。（大于等于12.5，小于等于50)
	 */
	private boolean validateRwddl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//热稳定电流时间
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
	 * 动稳定电流时间  DWDDL
	 * 规则：动稳定电流等于2.5倍热稳定电流（大于等于31.5，小于等于135)
	 */
	private boolean validateDwddl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String rwddl = row.get("RWDDL");//热稳定电流时间
		if(StringUtils.isEmpty(rwddl)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//动稳定电流时间
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

	/**
	 *  运行编号 YXBH
	 * 规则：运行编号不应含kv书写不规范，正确kV
	 */
	private boolean validateYxbh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//运行编号
			return true;
		}
		if(value.indexOf("kv") ==-1){
			return false;
		}
		return true;
	}

	/**
	 *  设备名称 SBMC
	 * 规则：设备名称不应含kv书写不规范，正确kV
	 */
	private boolean validateSbmc(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//设备名称
			return true;
		}
		if(value.indexOf("kv") ==-1){
			return false;
		}
		return true;
	}


}
