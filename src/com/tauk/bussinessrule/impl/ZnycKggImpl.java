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
 * 开关柜业务规则
 * @author zyb_s
 *
 */
public class ZnycKggImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //柜面宽度(mm)
        if(field.equals("GMKD")) {
        	if(!validateGmkd(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_KGG_GMKD.getCode());
    			String message = DataExceptionMessage.BUSSINESS_KGG_GMKD.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //额定电流(A)
        if(field.equals("EDDL")) {
        	if(!validateEddl(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_KGG_EDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_KGG_EDDL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //额定频率(Hz)
        if(field.equals("EDPL")){
        	if(!validateEdpl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_KGG_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_KGG_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
	     }

        //额定电压(kV)
        if(field.equals("EDDY")) {
        	if(!validateEddy(value,row)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_KGG_EDDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_KGG_EDDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

  
        
        // 投运日期  TYRQ
        if(field.equals("TYRQ")){
        	if(!validateTyrq(value,row)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_KGG_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_KGG_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }
        if(field.equals("CCRQ")){
        	if(!validateCcrq(value,row)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_KGG_CCRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_KGG_CCRQ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        /*
         * 宽度(mm)
         */
        if(field.equals("KD")) {
        	if(!validateKd(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_KGG_KD.getCode());
    			String message = DataExceptionMessage.BUSSINESS_KGG_KD.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        // 深度(mm)
        if(field.equals("SD")){
        	if(!validateSd(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_KGG_SD.getCode());
    			String message = DataExceptionMessage.BUSSINESS_KGG_SD.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //出厂日期CCRQ
        if(field.equals("CCRQ")){
        	if(!validateCcrq(value,row)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_KGG_CCRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_KGG_CCRQ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //高度(mm)GD
        if(field.equals("GD")){
        	if(!validateGd(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_KGG_GD.getCode());
    			String message = DataExceptionMessage.BUSSINESS_KGG_GD.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

	}

	/**
	 * 柜面宽度(mm):kgg0001
	 * 规则：电压等级10kV  柜面宽度(mm)在300~1300   
35kV 柜面宽度(mm)在 600~1860
	 * @param value
	 * @param row
	 * @return
	 */
	private boolean validateGmkd(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//电压等级
		if(StringUtils.isEmpty(dydj)) {
			return true;
		}

		String gmkd = row.get("GMKD");//柜面宽度(mm)
		BigDecimal gmkd0 = new BigDecimal(0.0000);
		if(StringUtils.isEmpty(gmkd)) {
			return true;
		}
		gmkd0 = new BigDecimal(gmkd);
		if("10".equals(dydj)) {//10kv
			//300~1300   
			if(gmkd0.compareTo(new BigDecimal(300.0000))==-1
					|| gmkd0.compareTo(new BigDecimal(1300.0000))==1){
				return false;
			}
		}else if("35".equals(dydj)){//110kv
			//600~1860
			if(gmkd0.compareTo(new BigDecimal(600.0000))==-1
					|| gmkd0.compareTo(new BigDecimal(1860.0000))==1){
				return false;
			}
		}

		return true;
	}

	/**
	 * 额定电流:KGG0002
	 * 规则：额定电流应从下列数值中选取：0.5,2,5,6.3,8,10,12.5,16,20,25,31.5,40,50,63,100,125,150,160,200,315,400,500,630，800,1000,1250，1500,1600,2000,2500,3150,4000,5000。按实际填写，按铭牌填写。
	 * @param value
	 * @param row
	 * @return
	 */
	private boolean validateEddl(String value,Map<String,String> row) {
		String eddl = row.get("EDDL");
		if(StringUtils.isEmpty(eddl)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {
			return true;
		}

		if(eddl.equals("0.5") || eddl.equals("0.5000")) {
			return true;
		}else if (eddl.equals("2") || eddl.equals("0.5000") ) {
			return true;
		}else if (eddl.equals("5") || eddl.equals("5.0000")) {
			return true;
		}else if (eddl.equals("6.3") || eddl.equals("6.3000")) {
			return true;
		}else if (eddl.equals("8") || eddl.equals("8.0000")) {
			return true;
		}else if (eddl.equals("10") || eddl.equals("10.0000")) {
			return true;
		}else if (eddl.equals("12.5")|| eddl.equals("12.5000")) {
			return true;
		}else if (eddl.equals("16") || eddl.equals("16.0000")) {
			return true;
		}else if (eddl.equals("20") || eddl.equals("20.0000")) {
			return true;
		}else if (eddl.equals("25") || eddl.equals("25.0000")) {
			return true;
		}else if (eddl.equals("31.5") || eddl.equals("31.5000")) {
			return true;
		}else if (eddl.equals("40") || eddl.equals("40.0000")) {
			return true;
		}else if (eddl.equals("50") || eddl.equals("50.0000")) {
			return true;
		}else if (eddl.equals("63") || eddl.equals("63.0000")) {
			return true;
		}else if (eddl.equals("100") || eddl.equals("100.0000")) {
			return true;
		}else if (eddl.equals("125") || eddl.equals("125.0000")) {
			return true;
		}else if (eddl.equals("150") || eddl.equals("150.0000")) {
			return true;
		}else if (eddl.equals("160") || eddl.equals("160.0000")) {
			return true;
		}else if (eddl.equals("200") || eddl.equals("200.0000")) {
			return true;
		}else if (eddl.equals("315") || eddl.equals("315.0000")) {
			return true;
		}else if (eddl.equals("400") || eddl.equals("400.0000")) {
			return true;
		}else if (eddl.equals("500") || eddl.equals("500.0000")) {
			return true;
		}else if (eddl.equals("630") || eddl.equals("630.0000")) {
			return true;
		}else if (eddl.equals("800") || eddl.equals("800.0000")) {
			return true;
		}else if (eddl.equals("1000") || eddl.equals("1000.0000")) {
			return true;
		}else if (eddl.equals("1250") || eddl.equals("1250.0000")) {
			return true;
		}else if (eddl.equals("1500") || eddl.equals("1500.0000")) {
			return true;
		}else if (eddl.equals("1600") || eddl.equals("1600.0000")) {
			return true;
		}else if (eddl.equals("2000") || eddl.equals("2000.0000")) {
			return true;
		}else if (eddl.equals("2500") || eddl.equals("2500.0000")) {
			return true;
		}else if (eddl.equals("3150") || eddl.equals("3150.0000")) {
			return true;
		}else if (eddl.equals("4000") || eddl.equals("4000.0000")) {
			return true;
		}else if (eddl.equals("5000") || eddl.equals("5000.0000")) {
			return true;
		}else {
		return false;
		}
	}

	/**
	 * kgg0003
	 * 额定频率EDPL
	 * 规则：默认值50
	 */
	private boolean validateEdpl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String edpl = row.get("EDPL");//额定频率
		BigDecimal edplNew = new BigDecimal(0.0000);
		if(StringUtils.isEmpty(edpl)) {
			return true;
		}
			edplNew = new BigDecimal(edpl);
		if(edplNew.compareTo(new BigDecimal(50.0000)) != 0){
			return false;
		}
		return true;
	}
	
	
	/**
	 * 额定电流:KGG0004
	 * 规则：额定电压应从下列数值中选取： 6、7.2、10、12、20、24、35、40.5。
	 * @param value
	 * @param row
	 * @return
	 */
	private boolean validateEddy(String value,Map<String,String> row) {
		String eddy = row.get("EDDY");
		if(StringUtils.isEmpty(eddy)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {
			return true;
		}

		if(eddy.equals("6")) {
			return true;
		}else if (eddy.equals("7.2")) {
			return true;
		}else if (eddy.equals("10")) {
			return true;
		}else if (eddy.equals("12")) {
			return true;
		}else if (eddy.equals("20")) {
			return true;
		}else if (eddy.equals("24")) {
			return true;
		}else if (eddy.equals("35")) {
			return true;
		}else if (eddy.equals("40.5")) {
			return true;
		}else {
		return false;
		}
	}
	
	
	/**
	 * 制造国家,编号KGG0005
	 * 规则：选择设备的制造国家。默认值为“中国“ 代码 156
	 */
	

	/**
	 * 投运日期kgg0006
	 * 规则：投运日期 大于 出场日期
	 * @return
	 */
	private boolean validateTyrq(String value,Map<String,String> row) {

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
	 * KGG0007
	 *  宽度(mm)KD
	 * 规则：320~1300
	 */
	private boolean validateKd(String value,Map<String,String> row,Map<String,String> dataRuleMap) {

		String kd = row.get("KD");//宽度
		BigDecimal kdl = new BigDecimal(0.0000);
		if(StringUtils.isEmpty(kd)) {
			return true;
		}
			kdl = new BigDecimal(kd);
			//320~1300
			if(kdl.compareTo(new BigDecimal(320.0000))==-1
					|| kdl.compareTo(new BigDecimal(1300.0000))==1){
				return false;
			}
		return true;
	}
	/**
	 * KGG0008
	 *   深度(mm)SD
	 * 规则：320~2000),西安局存在深度320mm，规则由400mm加大到320mm
	 */
	private boolean validateSd(String value,Map<String,String> row,Map<String,String> dataRuleMap) {

		String sd = row.get("SD");//深度
		BigDecimal sdl = new BigDecimal(0.0000);
		if(StringUtils.isEmpty(sd)) {
			return true;
		}
			sdl = new BigDecimal(sd);
			//320~2000
			if(sdl.compareTo(new BigDecimal(320.0000))==-1
					|| sdl.compareTo(new BigDecimal(2000.0000))==1){
				return false;
			}
		return true;
	}
	
	
	

	/**
	 *  出厂日期  kgg0009
	 * 规则：投运日期 大于 出场日期
	 * @return
	 */
	private boolean validateCcrq(String value,Map<String,String> row) {

		String tyrq = row.get("TYRQ");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
        	if(StringUtils.isEmpty(value) ||StringUtils.isEmpty(tyrq)) {
        		return true;
        	}

            Date dt1 = df.parse(value);
            Date dt2 = df.parse(tyrq);
            if (dt1.getTime() < dt2.getTime()) {
                return true;
            } else if (dt1.getTime() >= dt2.getTime()) {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
		return true;
	}

	/**
	 * KGG0010
	 *   高度(mm)GD
	 * 规则：800~2500
	 */
	private boolean validateGd(String value,Map<String,String> row,Map<String,String> dataRuleMap) {

		String gd = row.get("GD");//高度
		BigDecimal gdl = new BigDecimal(0.0000);
		if(StringUtils.isEmpty(gd)) {
			return true;
		}
			gdl = new BigDecimal(gd);
			//320~2000
			if(gdl.compareTo(new BigDecimal(800.0000))==-1
					|| gdl.compareTo(new BigDecimal(2500.0000))==1){
				return false;
			}
		return true;
	}	
}
