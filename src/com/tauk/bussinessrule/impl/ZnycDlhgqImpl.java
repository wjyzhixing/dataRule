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
 * 电流互感器业务规则
 * @author zyb_s
 *
 */
public class ZnycDlhgqImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        // 额定电流(A)
        if(field.equals("EDDL")) {
        	if(!validateEddl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_EDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_EDDL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //热稳定电流(kA)
        if(field.equals("RWDDL")) {
        	if(!validateRwddl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_RWDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_RWDDL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //二次绕组总数量(个)
        if(field.equals("ECRZZSL")){
        	if(!validateEcrzzsl(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_ECRZZSL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_ECRZZSL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
	     }

       /*
        * SF6气体报警压力(Mpa)
        */
        if(field.equals("SF6QTBJYL")) {
        	if(!validateSf6qtbjyl(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_SF6QTBJYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_SF6QTBJYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        /*
         *  SF6气体额定压力(Mpa)
         */
        if(field.equals("SF6QTEDYL")) {
        	if(!validateSf6qtedyl(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_SF6QTEDYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_SF6QTEDYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        //  额定频率(Hz)
        if(field.equals("EDPL")){
        	if(!validateEdpl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 投运日期
        if(field.equals("TYRQ")){
        	if(!validateTyrq(value,row)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //额定电压(kV)
        if(field.equals("EDDY")){
        	if(!validateEddy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_EDDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_EDDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 额定电压(kV)
        if(field.equals("EDDY")){
        	if(!validateEddy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_EDDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_EDDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

 

        // 动稳定电流(kA)
        if(field.equals("DWDDL")){
        	if(!validateDwddl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_DWDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_DWDDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //  组合电器名称
        if(field.equals("ZHDQKGGMC")){
        	if(!validateZhdqkggmc(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_ZHDQKGGMC.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_ZHDQKGGMC.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //  SF6气体最小运行压力(Mpa)
        if(field.equals("SF6QTZXYXYL")){
        	if(!validateSf6qtzxyxyl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_SF6QTZXYXYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_SF6QTZXYXYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }
        
    //  最高工作电压(kV)
        if(field.equals("ZDCXDY")){
        	if(!validateZdcxdy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_ZDCXDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_ZDCXDY.getMessage();
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
	 *  额定电流(A) EDDL,编号 dlhgq0001
	 * 规则：额定电流等于额定电流比中一次电流值，可选用：'5','6','40','50','100','150','200','300','500','600','1200', '1500', '400', '630', '800', '1000', '1250','1600', '2000', '2500', '3000','3150', '4000', '5000'；
	 */
	private boolean validateEddl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		
		/*String ecrzzsl = row.get("ECRZZSL");//二次绕组总数量
		if(ecrzzsl==null) {
			return true;
		}
		if(!ecrzzsl.equals("") || !ecrzzsl.equals(" ") || !ecrzzsl.equals("null")) {
		int ecrzzsl_num = Integer.valueOf(ecrzzsl);
		
		String eddyb = row.get("EDDYB");//额定电压比
		int eddyb_num = search(eddyb,"0.1");

		if(ecrzzsl_num == eddyb_num ) {
			return true;
		}
		}*/
		return true;
	}

	/**
	 * dlhgq0002
	 *  热稳定电流(kA)	RWDDL
	 * 规则：额定短时热电流通常为6.3、8、10、12.5、16、20、25、31.5、40、45、50、63、80、100（kA）
	 */
	private boolean validateRwddl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		/*String edpl = row.get("EDPL");//额定频率
		BigDecimal edplNew = new BigDecimal(0.0000);
		if(edpl!=null && !"".equals(edpl)){
			edplNew = new BigDecimal(edpl);
		}
		if(edplNew.compareTo(new BigDecimal(50.0000)) != 0){
			return false;
		}*/
		return true;
	}
	/**
	 *  二次绕组总数量(个)	ECRZZSL   dlhgq0003
	 * 规则：电压等级≤35kv：6≥X>0;否则9≥X>0
	 * 
	 * @return
	 */
	private boolean validateEcrzzsl(String value,Map<String,String> row) {

		
		String dydj = row.get("DYDJ");//电压等级
		String ecrzzsl = row.get("ECRZZSL");//二次绕组总数量(个))
		if(StringUtils.isEmpty(ecrzzsl)) {
			return true;
		}
		if(StringUtils.isEmpty(dydj)) {
			return true;
		}
		String dydjmin = "25,24,23,22,21,20,14,15,13,10,12,09,11,08,07,06,05,04,03,02,01,76,77,73,72,71,70,60,56,55,54,53,52,51";
		if(!ecrzzsl.equals("") || !ecrzzsl.equals(" ") || !ecrzzsl.equals("null")) {
		double ecrzzsl_num = Double.parseDouble(ecrzzsl);
		if(dydjmin.contains(dydj)) {
			if(ecrzzsl_num >0 && ecrzzsl_num<= 6) {
				return true;
			}
		}else if(!dydjmin.contains(dydj)) {
			if(ecrzzsl_num >0 && ecrzzsl_num<= 9) {
				return true;
			}
		}
		}
	
		return false;
	
	}
	
	
	/**
	 * dlhgq0004
	 *   SF6气体报警压力(Mpa)	SF6QTBJYL
	 * 规则：根据设备铭牌或出厂资料填写，单位：Mpa，绝缘介质不是SF6的，应不填写。
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
	 * dlhgq0005
	 * SF6气体额定压力(Mpa)	SF6QTEDYL
	 * 规则：SF6变压器按照铭牌填写 ,绝缘介质非SF6 填0或不填
	 */
	private boolean validateSf6qtedyl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//绝缘介质
		String sf6qtedyl = row.get("SF6QTEDYL");//SF6气体报警压力(Mpa)
		if(!"2".equals(jyjz)){
			if(StringUtils.isEmpty(sf6qtedyl)){
				return true;
			}else{
				BigDecimal sf6qtbjylNew = new BigDecimal(sf6qtedyl);
				if(!"".equals(sf6qtedyl)
						&& sf6qtbjylNew.compareTo(new BigDecimal(0.0000)) != 0
						&& sf6qtedyl != null){
					return false;
				}
			}
		}
		return true;
	}
	

	/**
	 * dlhgq0006
	 *  额定频率(Hz)	EDPL
	 * 规则：默认 50
	 * @param value   
	 * @param row
	 * @return
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
	 *  投运日期	TYRQ  dlhgq0007
	 * 规则：投运日期 大于 出场日期
	 * @return
	 */
	private boolean validateTyrq(String value,Map<String,String> row) {

		String ccrq = row.get("CCRQ");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
        	if(StringUtils.isEmpty(ccrq) ||StringUtils.isEmpty(value)) {
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

	/**dlhgq0008
	 *  额定电压(kV)	EDDY
	 * 规则：电压 10,12， 110，126 ，330，363 ，35，40.5， 20,24，6亦可
	 */
	private boolean validateEddy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		
		
		return true;
	}
	
	/**
	 * 制造国家,编号dlhgq0009
	 * 规则：选择设备的制造国家。默认值为“中国“ 代码 156
	 */
	
	
	
	/**dlhgq0010
	 *  动稳定电流(kA)	DWDDL      热稳定电流 RWDDL
	 * 规则：动稳定电流等于热稳定电流的2.5倍，根据铭牌或说明书抄录                 
	 */
	private boolean validateDwddl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dwddl = row.get("DWDDL");//动稳定电流(kA)
		String rwddl = row.get("RWDDL");//热稳定电流
		if(StringUtils.isEmpty(dwddl)){
			return true;
		}
		if(StringUtils.isEmpty(rwddl)){
			return true;
		}
		try {
			 double dwddl_num = Double.parseDouble(dwddl);
			 double rwddl_num = Double.parseDouble(rwddl);
			if(dwddl_num != rwddl_num*2.5) {
				return false;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	
	/**dlhgq0011
	 *  组合电器名称	ZHDQKGGMC
	 * 规则：选“否”，此项不填写；选“组合电器”，组合设备名称中因包含“组合电器”；选“开关柜”，组合设备名称中因包含“开关柜”；
	 * 
	 * 否,开关柜,组合电器,电力电容器成套装置,消弧线圈成套装置,充气柜,接地变成套装置,电抗器成套装置,站内环网柜	
	 * 01,02,03,10,11,15,16,17,19
	 */
	private boolean validateZhdqkggmc(String value,Map<String,String> row,Map<String,String> dataRuleMap) {

		String zhsblx = row.get("ZHSBLX");//组合设备类型
		String zhdqkggmc = row.get("ZHDQKGGMC");//组合电器名称
		if(StringUtils.isEmpty(zhdqkggmc)) {
			return true;
		}
		if("01".equals(zhsblx)) {
			if(!zhdqkggmc.equals("") || !zhdqkggmc.equals(" ")) {
				return false;
			}
		}else if("02".equals(zhsblx)) {
			if(!zhdqkggmc.contains("开关柜")) {
				return false;
			}
		}else if("03".equals(zhsblx)) {
			if(!zhdqkggmc.contains("组合电器")) {
				return false;
			}
		}else if("10".equals(zhsblx)) {
			if(!zhdqkggmc.contains("电力电容器成套装置")) {
				return false;
			}
		}else if("11".equals(zhsblx)) {
			if(!zhdqkggmc.contains("消弧线圈成套装置")) {
				return false;
			}
		}else if("15".equals(zhsblx)) {
			if(!zhdqkggmc.contains("充气柜")) {
				return false;
			}
		}else if("16".equals(zhsblx)) {
			if(!zhdqkggmc.contains("接地变成套装置")) {
				return false;
			}
		}else if("17".equals(zhsblx)) {
			if(!zhdqkggmc.contains("电抗器成套装置")) {
				return false;
			}
		}else if("19".equals(zhsblx)) {
			if(!zhdqkggmc.contains("站内环网柜")) {
				return false;
			}
		}
		
		return true;
	}
	
	
	/**
	 * dlhgq0012
	 *  SF6气体最小运行压力(Mpa)	SF6QTZXYXYL
	 * 规则：SF6变压器按照铭牌填写 ,绝缘介质非SF6 填0或不填
	 */
	private boolean validateSf6qtzxyxyl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//绝缘介质
		String sf6qtzxyxyl = row.get("SF6QTZXYXYL");//SF6气体最小运行压力(Mpa)
		if(!"2".equals(jyjz)){
			if(StringUtils.isEmpty(sf6qtzxyxyl)){
				return true;
			}else{
				BigDecimal sf6qtzxyxylNew = new BigDecimal(sf6qtzxyxyl);
				if(!"".equals(sf6qtzxyxyl)
						&& sf6qtzxyxylNew.compareTo(new BigDecimal(0.0000)) != 0
						&& sf6qtzxyxyl != null){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * dlhgq0013
	 *  最高工作电压(kV)	ZDCXDY
	 * 规则：本省可能为750、500kV直流、330、110、66、35、20、10、6；要求电压等级小于等于变电站运行电压
	 * @param value
	 * @param row
	 * @return
	 */
	private boolean validateZdcxdy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
	
		return true;
	}
	
}
