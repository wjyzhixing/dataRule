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
 * 电压互感器业务规则
 * @author zyb_s
 *
 */
public class ZnycDyhgqImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //额定电压比
        if(field.equals("EDDYB")) {
        	if(!validateEddyb(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_EDDYB.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_EDDYB.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //额定频率(Hz)
        if(field.equals("EDPL")) {
        	if(!validateEdpl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //投运日期
        if(field.equals("TYRQ")){
        	if(!validateTyrq(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
	     }

  

       /*
        * 爬电比距(mm/kV)
        */
        if(field.equals("PDBJ")) {
        	if(!validatePdbj(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_PDBJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_PDBJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        /*
         * SF6气体报警压力(Mpa)
         */
        if(field.equals("SF6QTBJYL")) {
        	if(!validateSf6qtbjyl(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_SF6QTBJYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_SF6QTBJYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        // 组合电器名称
        if(field.equals("ZHDQKGGMC")){
        	if(!validateZhdqkggmc(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_ZHDQKGGMC.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_ZHDQKGGMC.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //下节C1电容量(pF)
        if(field.equals("XJC1DRL")){
        	if(!validateXjc1drl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_XJC1DRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_XJC1DRL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //SF6气体额定压力(Mpa)
        if(field.equals("SF6QTEDYL")){
        	if(!validateSf6qtedyl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_SF6QTEDYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_SF6QTEDYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 二次绕组总数量
        if(field.equals("ECRZZSL")){
        	if(!validateEcrzzsl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_ECRZZSL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_ECRZZSL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 额定电压(kV)
        if(field.equals("EDDY")){
        	if(!validateEddy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_EDDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_EDDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

    

        //电容器节数(节)
        if(field.equals("DRQJS")){
        	if(!validateDrqjs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_DRQJS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_DRQJS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 上节电容量(pF)
        if(field.equals("SJDRL")){
        	if(!validateSjdrl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_SJDRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_SJDRL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 下节C2电容量(pF)
        if(field.equals("XJC2DRL")){
        	if(!validateXjc2drl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_XJC2DRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_XJC2DRL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

	}
	
	
	
	 public int search(String str,String strRes) {//查找字符串里与指定字符串相同的个数
	        int n=0;//计数器
	      for(int i = 0;i<str.length();i++) {
	         
	      }
	        while(str.indexOf(strRes)!=-1) {
	            int i = str.indexOf(strRes);
	            n++;
	            str = str.substring(i+1);
	        }
	        return n;
	 }
	/**
	 * 额定电压比,编号 dyhgq0001
	 * 规则：二次绕组总数量为几  就有几个0.1   √3/0.1
	 */
	private boolean validateEddyb(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		
		String ecrzzsl = row.get("ECRZZSL");//二次绕组总数量
		if(StringUtils.isEmpty(ecrzzsl)) {
			return true;
		}else{
			 double ecrzzsl_num = Double.parseDouble(ecrzzsl);
			String eddyb = row.get("EDDYB");//额定电压比
			if(StringUtils.isEmpty(eddyb)) {
				return true;
			}
			int eddyb_num = search(eddyb,"√3/0.1");
			if(ecrzzsl_num != eddyb_num ) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * dyhgq0002
	 * 额定频率EDPL
	 * 规则：默认值50
	 */
	private boolean validateEdpl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String edpl = row.get("EDPL");//额定频率
		BigDecimal edplNew = new BigDecimal(0.0000);
		if(StringUtils.isEmpty(edpl)){
			return true;
		}else {
			edplNew = new BigDecimal(edpl);
			if(edplNew.compareTo(new BigDecimal(50.0000)) != 0){
				return false;
			}
		}
		return true;
	}
	/**
	 * 投运日期dyhgq0003
	 * 规则：投运日期 大于 出场日期
	 * @return
	 */
	private boolean validateTyrq(String value,Map<String,String> row) {

		String ccrq = row.get("CCRQ");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
        	if(StringUtils.isEmpty(value) || StringUtils.isEmpty(ccrq)) {
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
	 * dyhgq0004
	 *  爬电比距 (mm/kV) PDBJ
	 * 规则：范围12.7至60.6
	 */
	private boolean validatePdbj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {

		String pdbj = row.get("PDBJ");//宽度
		BigDecimal pdbjl = new BigDecimal(0.0000);
		if(StringUtils.isEmpty(pdbj)) {
			return true;
		}
			pdbjl = new BigDecimal(pdbj);
			//320~1300
			if(pdbjl.compareTo(new BigDecimal(12.7000))==-1
					|| pdbjl.compareTo(new BigDecimal(60.6000))==1){
				return false;
			}
		return true;
	}

	
	/**
	 * dyhgq0005
	 * SF6气体报警压力(Mpa)	SF6QTBJYL  
	 * 规则：SF6变压器按照铭牌填写 ,绝缘介质非SF6 填0或不填
	 */
	private boolean validateSf6qtbjyl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//绝缘介质
		String sf6qtbjyl = row.get("SF6QTBJYL");//SF6气体报警压力(Mpa)
		if(!"2".equals(jyjz)){
			if(StringUtils.isEmpty(sf6qtbjyl)){
				return true;
			}else{
				BigDecimal sf6qtbjylNew = new BigDecimal(sf6qtbjyl);
				if(!"".equals(sf6qtbjyl)
						&& sf6qtbjylNew.compareTo(new BigDecimal(0.0000)) != 0
						&& sf6qtbjyl != null){
					return false;
				}
			}
		}
		return true;
	}
	

	/**
	 * dyhgq0006
	 * 组合电器名称	ZHDQKGGMC
	 * 规则：当“组合设备类型 ”选择“开关柜”或“组合电器”时，此项填写其所属开关柜或组合电器的名称。若“组合设备类型”选“否”，此项不填写。
	 * @param value    ZHDQKGGMC/
	 * @param row
	 * @return
	 */
	private boolean validateZhdqkggmc(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String zhsblx = row.get("ZHSBLX");//组合设备类型
		String zhdqkggmc = row.get("ZHDQKGGMC");//组合电器的名称
		if("02".equals(zhsblx)|| "03".equals(zhsblx)){
			if(StringUtils.isEmpty(zhdqkggmc)){
				return true;
			}else{
				return false;
			}
		}else if("01".equals(zhsblx) && !"".equals(zhdqkggmc)) {
				return false;
		}
		return true;
	}
	
	/**
	 * dyhgq0007
	 * 下节C1电容量(pF)	XJC1DRL
	 * 规则：结构型式=电容型，X>0;
	 * @param value    ZHDQKGGMC/
	 * @param row
	 * @return
	 */
	private boolean validateXjc1drl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jgxs = row.get("JGXS");//结构型式
		String xjc1drl = row.get("XJC1DRL");//下节C1电容量(pF)
		if("2".equals(jgxs)){
			if(StringUtils.isEmpty(xjc1drl)){
				return true;
			}else{
				BigDecimal xjc1drlNew = new BigDecimal(xjc1drl);
				if(xjc1drlNew.compareTo(new BigDecimal(0.0000)) < 0){
					return false;
				}
			}
		}
		return true;
	}

	
	/**
	 * dyhgq0008
	 * SF6气体额定压力(Mpa)  SF6QTEDYL
	 * 规则：SF6变压器按照铭牌填写 ,绝缘介质非SF6 填0或不填
	 */
	private boolean validateSf6qtedyl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//绝缘介质
		String sf6qtedyl = row.get("SF6QTEDYL");//SF6气体额定压力
		if(!"2".equals(jyjz)){
			if(StringUtils.isEmpty(sf6qtedyl)){
				return true;
			}else{
				BigDecimal sf6qtedylNew = new BigDecimal(sf6qtedyl);
				if(!"".equals(sf6qtedyl)
						&& sf6qtedylNew.compareTo(new BigDecimal(0.0000)) != 0
						&& sf6qtedyl != null){
					return false;
				}
			}
		}
		return true;
	}
	
	/**dyhgq0009
	 * 二次绕组总数量	ECRZZSL
	 * 规则：小于或等于4，额定电压比中‘0.1’数量=二次绕组总数量   √3/0.1
	 */
	private boolean validateEcrzzsl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		
		String ecrzzsl = row.get("ECRZZSL");//二次绕组总数量
		if(StringUtils.isEmpty(ecrzzsl)) {
			return true;
		}
		if(!ecrzzsl.equals("") || !ecrzzsl.equals(" ") || !ecrzzsl.equals("null")) {
		double ecrzzsl_num = Double.parseDouble(ecrzzsl);
		String eddyb = row.get("EDDYB");//额定电压比
		if(StringUtils.isEmpty(eddyb)) {
			return true;
		}
		int eddyb_num = search(eddyb,"√3/0.1");
		if(ecrzzsl_num == eddyb_num && ecrzzsl_num <=4) {
			return true;
		}
		}
		return false;
	}
	
	/**dyhgq0010
	 * 额定电压(kV)	EDDY
	 * 规则：按设备铭牌填写。不分相（ABC相）或中性点不带√3。分相（'A相', 'B相', 'C相', 'O相'）设备必须带√3。   √3/0.1
	 */
private boolean validateEddy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		
	/*	String ecrzzsl = row.get("ECRZZSL");//二次绕组总数量
		int ecrzzsl_num = Integer.valueOf(ecrzzsl);
		if(ecrzzsl==null) {
			return true;
		}
		String eddyb = row.get("EDDYB");//额定电压比
		int eddyb_num = search(eddyb,"√3/0.1");

		if(ecrzzsl_num == eddyb_num && ecrzzsl_num <=4) {
			return true;
		}*/
		return true ;
	}
	
	
	/**
	 * 制造国家,编号dyhgq0011
	 * 规则：选择设备的制造国家。默认值为“中国“ 代码 156
	 */

	
	/**dyhgq0012
	 * 电容器节数(节)	DRQJS
	 * 规则：750kV:4节；330kV:3节；110kV、35kV：1节（电容式电压互感器填写）
	 */
	private boolean validateDrqjs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {

		String dydj = row.get("DYDJ");//电压等级
		String drqjs = row.get("DRQJS");//电容器节数(节)
		if(StringUtils.isEmpty(drqjs)||StringUtils.isEmpty(dydj)) {
			return true;
		}else {
			int drqjs_num = Integer.valueOf(drqjs);
			if(dydj.contains("750kV")){
				if(drqjs_num !=4) {
					return false;
				}
			}else if (dydj.contains("330kV")) {
				if(drqjs_num != 3) {
					return false;
				}
			}else if (dydj.contains("110kV")||dydj.contains("35kV")) {
				if(drqjs_num !=1) {
					return false;
				}
			}
		}

		return true;
	}
	
	
	/**dyhgq0013
	 * 上节电容量(pF)	SJDRL
	 * 规则：结构型式=电容型，电压等级>=220kV:X>0  电压等级小于220kV的填  0   ，无  ， /  ，\  或空格 或 不填
	 */
	private boolean validateSjdrl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {

		String jgxs = row.get("JGXS");//结构型式 2  电容式
		String dydj = row.get("DYDJ");//电压等级
		String sjdrl = row.get("SJDRL");//上节电容量(pF)
		if(StringUtils.isEmpty(sjdrl)|| StringUtils.isEmpty(jgxs) ||StringUtils.isEmpty(dydj)) {
			return true;
		}else {
			String dydjmax = "37,36,35,34,33,91,86,85,84,92,93,83,82,88";
			 double sjdrl_num = Double.parseDouble(sjdrl);
			if("2".equals(jgxs) && dydjmax.contains(dydj)) {
				if(sjdrl_num >0) {
					return true;
				}
			}else if("2".equals(jgxs) && !dydjmax.contains(dydj)) {
				if(sjdrl_num == 0 || sjdrl.equals("") || sjdrl.equals(" ")|| sjdrl.equals("无")) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * dyhgq0014
	 * 下节C2电容量(pF)	XJC2DRL
	 * 规则：结构型式=电容型，X>0;
	 * @param value    ZHDQKGGMC/
	 * @param row
	 * @return
	 */
	private boolean validateXjc2drl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jgxs = row.get("JGXS");//结构型式
		String xjc2drl = row.get("XJC2DRL");//下节C1电容量(pF)
		if("2".equals(jgxs)){
			if(StringUtils.isEmpty(jgxs) || StringUtils.isEmpty(xjc2drl)){
				return true;
			}else{
				BigDecimal xjc1drlNew = new BigDecimal(xjc2drl);
				if(xjc1drlNew.compareTo(new BigDecimal(0.0000)) < 0){
					return false;
				}
			}
		}
		return true;
	}
	
}
