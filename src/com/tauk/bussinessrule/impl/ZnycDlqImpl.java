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
 * 断路器业务规则
 * @author zyb_s
 *
 */
public class ZnycDlqImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //  额定绝缘水平
        if(field.equals("EDJYSP")) {
        	if(!validateEdjysp(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDJYSP.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_EDJYSP.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //额定电流(A)
        if(field.equals("EDDL")) {
        	if(!validateEddl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_EDDL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //分闸时间(基准值)(ms)
        if(field.equals("FZSJ")){
        	if(!validateFzsj(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_FZSJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_FZSJ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
	     }

       /*
        * 机械寿命
        */
        if(field.equals("JXSM")) {
        	if(!validateJxsm(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_JXSM.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_JXSM.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        /*
         *  组合电器名称
         */
        if(field.equals("ZHDQKGGMC")) {
        	if(!validateZhdqkggmc(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_ZHDQKGGMC.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_ZHDQKGGMC.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        //  合闸电阻(Ω)
        if(field.equals("HZDZ")){
        	if(!validateHzdz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_HZDZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_HZDZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //  热稳定持续时间(s)
        if(field.equals("RWDCXSJ")){
        	if(!validateRwdcxsj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_RWDCXSJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_RWDCXSJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 额定短路关合电流(kA)
        if(field.equals("EDDLGHDL")){
        	if(!validateEddlghdl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDDLGHDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_EDDLGHDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //   额定短路开断电流(kA)
        if(field.equals("EDDLKDDL")){
        	if(!validateEddlkddl(value,row)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDDLKDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_EDDLKDDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 动稳定电流(kA)
        if(field.equals("DWDDL")){
        	if(!validateDwddl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_DWDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_DWDDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 套管爬电距离(mm)
        if(field.equals("TGPDJL")){
        	if(!validateTgpdjl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_TGPDJL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_TGPDJL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 断口数量
        if(field.equals("DKSL")){
        	if(!validateDksl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_DKSL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_DKSL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //  对地泄漏比距(cm/kV)
        if(field.equals("DDXLBJ")){
        	if(!validateDdxlbj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_DDXLBJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_DDXLBJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //  合闸时间(精度范围)(ms)
        if(field.equals("GYHZSJ")){
        	if(!validateGyhzsj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_GYHZSJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_GYHZSJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }
        
    //  合闸时间(基准值)(ms)
        if(field.equals("HZSJ")){
        	if(!validateHzsj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_HZSJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_HZSJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }
        //  SF6气体闭锁压力(Mpa)
        if(field.equals("SF6QTBSYL")){
        	if(!validateSf6qtbsyl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_SF6QTBSYL.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_SF6QTBSYL.getMessage();
        		recordErrData(datapk,code,message,field);
        	}
        }
        //  分闸时间(精度范围)(ms)
        if(field.equals("GYFZSJ")){
        	if(!validateGyfzsj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_GYFZSJ.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_GYFZSJ.getMessage();
        		recordErrData(datapk,code,message,field);
        	}
        }
        //  额定频率(Hz)
        if(field.equals("EDPL")){
        	if(!validateEdpl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDPL.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_EDPL.getMessage();
        		recordErrData(datapk,code,message,field);
        	}
        }
        //  投运日期
        if(field.equals("TYRQ")){
        	if(!validateTyrq(value,row)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_TYRQ.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_TYRQ.getMessage();
        		recordErrData(datapk,code,message,field);
        	}
        }
        //   额定电压(kV)
        if(field.equals("EDDY")){
        	if(!validateEddy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDDY.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_EDDY.getMessage();
        		recordErrData(datapk,code,message,field);
        	}
        }
   
        //   使用环境
        if(field.equals("SYHJ")){
        	if(!validateSyhj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_SYHJ.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_SYHJ.getMessage();
        		recordErrData(datapk,code,message,field);
        	}
        }
        //  合闸时间(基准值)(ms)
        if(field.equals("EDDLDLKDCS")){
        	if(!validateEddldlkdcs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDDLDLKDCS.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_EDDLDLKDCS.getMessage();
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
	 * 额定绝缘水平	EDJYSP,编号 DLQ0001
	 * 规则：750kV包含“960"和"1550"和"2100”；330kV包含"510"和"950"和"1175"；110kV包含"230"和"550"两个值；66kV为"160"和"350"两个值；35kV包含"95"和"185"两个值；10kV包含"42"和"75"两个值；6kV为"30","60","42"及"75"四个值。 额定电压145 包含 275 和 650；
	 */
	private boolean validateEdjysp(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		
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
	 * DLQ0002
	 *   额定电流(A)	EDDL
	 * 规则：额定电流应从下列数值中选取：400、630、800、1000、1250、1600、2000、2500、3150、4000、5000。根据电压等级不同，按实际填写。（以铭牌为准）型号以s开头,可以为1200,1500;以D开头的可以为600
	 */
	private boolean validateEddl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
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
	 *  分闸时间(基准值)(ms)	FZSJ   DLQ0003
	 * 规则：10~100
	 * 
	 * @return
	 */
	private boolean validateFzsj(String value,Map<String,String> row) {

		String fzsj = row.get("FZSJ");//分闸时间(基准值)(ms)
		if(StringUtils.isEmpty(fzsj)) {
			return true;
		}
		try {
			if(isNumericZidai(fzsj)) {
				double fzsj_num = Double.parseDouble(fzsj);
				if(fzsj_num <10 && fzsj_num >100) {
					return false;
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	
	}
	
	
	/**
	 * DLQ0004
	 *   机械寿命	JXSM 
	 * 规则：1000,2000,3000,5000,6000,10000,20000,30000；110kV不能上10000
	 */
	private boolean validateJxsm(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//电压等级
		String jxsm = row.get("JXSM");//机械寿命
		if(StringUtils.isEmpty(jxsm)) {
			return true;
		}
		if("32".equals(dydj) || "06".equals(dydj)){
				try {
					double jxsm_num = Double.parseDouble(jxsm);
					if(jxsm_num >10000) {
						return false;
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		return true;
	}

	/**DLQ0005
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
	 * DLQ0006
	 * 合闸电阻(Ω)	HZDZ
	 * 规则：110kV及以下电压等级没有合闸电阻，不涉及此参数填写，填写为0
	 */
	private boolean validateHzdz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//电压等级
		String hzdz = row.get("HZDZ");//合闸电阻(Ω)
		if(StringUtils.isEmpty(dydj)){
			return true;
		}
		String dydj_yx ="80,78,76,77,73,72,71,70,60,56,55,54,53,52,51,99,31,30,25,24,23,22,21,20,14,15,13,10,12,09,11,08,07,06,05,04,03,02,01";
		if(dydj_yx.contains(dydj)){
			if(StringUtils.isEmpty(hzdz)){
				return true;
			}else{
				  if(!hzdz.equals("0")) {  
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	 * DLQ0007
	 *  热稳定持续时间(s)	RWDCXSJ
	 * 规则：750kV为2；330kV为3；110kV及以下为4。根据制造厂说明书按实际填写。
	 */
	private boolean validateRwdcxsj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//电压等级
		String rwdcxsj = row.get("RWDCXSJ");//热稳定持续时间(s)
		String dydj_yx ="80,78,76,77,73,72,71,70,60,56,55,54,53,52,51,99,31,30,25,24,23,22,21,20,14,15,13,10,12,09,11,08,07,06,05,04,03,02,01";
		if(StringUtils.isEmpty(rwdcxsj)){
			return true;
		}
		if(dydj_yx.contains(dydj)){
			  if(!rwdcxsj.equals("4")) {  
				return false;
			}
		}else if("36".equals(dydj)) {
			if(!"2".equals(rwdcxsj)) {
				return false;
			}
		}else if("34".equals(dydj)) {
			if(!"3".equals(rwdcxsj)) {
				return false;
			}
		}
		return true;
	}
	

	/**
	 * DLQ0008
	 *   额定短路关合电流(kA)	EDDLGHDL
	 * 规则：数值等于额定短路开断电流的2.5倍
	 * @param value   
	 * @param row     额定短路开断电流(kA)  EDDLKDDL
	 * @return
	 */
	private boolean validateEddlghdl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String eddlghdl = row.get("EDDLGHDL");//额定短路关合电流(kA)
		String eddlkddl = row.get("EDDLKDDL");//额定短路开断电流(kA)
		if(StringUtils.isEmpty(eddlghdl)){
			return true;
		}
		if(StringUtils.isEmpty(eddlkddl)){
			return true;
		}
		try {
			 double eddlghdl_num = Double.parseDouble(eddlghdl);
			 double eddlkddl_num = Double.parseDouble(eddlkddl);
			if(eddlghdl_num != eddlkddl_num*2.5) {
				return false;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 *   额定短路开断电流(kA)	EDDLKDDL  DLQ0009
	 * 规则：额定短路开断电流的交流分量有效值应从下列数值中选取：6.3、8、10、12.5、16、20、25、31.5、40、50、63、80、100。根据电压等级，按实际填写。按铭牌上填写。
	 * @return
	 */
	private boolean validateEddlkddl(String value,Map<String,String> row) {

		return true;
	}
	
	/**DLQ0010
	 *  动稳定电流(kA)	DWDDL
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
	
	
	
	/**
	 * DLQ0011
	 *    套管爬电距离(mm)	TGPDJL
	 *    
	 *    组合设备类型	ZHSBLX    开关柜  02
	 *    结构型式	JGXS        GIS   03
	 * 规则：750kV  10161~25404 330kV  4611~11527 110kV  1600~4605 66kV  1600~11527 35kV 489~1286 10kV 140~381 6kV 140~381组合设备类型为开关柜，套管爬电距离为0 或结构型式为GIS，套管爬电距离为0
	 *     36                34                 32              30                25            22           21
	 */
	private boolean validateTgpdjl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//电压等级
		String tgpdjl = row.get("TGPDJL");//套管爬电距离(mm)
		String zhsblx = row.get("ZHSBLX");//组合设备类型
		String jgxs = row.get("JGXS");//结构型式
		if(StringUtils.isEmpty(tgpdjl)) {
			return true;
		}
		 double tgpdjl_num = Double.parseDouble(tgpdjl);
		if("36".equals(dydj)){
				if(tgpdjl_num >25404 || tgpdjl_num<10161 ) {
					return false;
				}
		}else if ("34".equals(dydj)){
			
				if(tgpdjl_num >11527 || tgpdjl_num<4611 ) {
					return false;
				}
		}else if ("32".equals(dydj)){
				if(tgpdjl_num >4605 || tgpdjl_num<1600 ) {
					return false;
				}
	    }else if ("30".equals(dydj)){
				if(tgpdjl_num >11527 || tgpdjl_num<1600 ) {
					return false;
				}
	    }else if ("25".equals(dydj)){
				if(tgpdjl_num >1286 || tgpdjl_num<489 ) {
					return false;
				}
	    }else if ("22".equals(dydj) || "21".equals(dydj)){
				if(tgpdjl_num >381 || tgpdjl_num<140 ) {
					return false;
				}
	    }else if("02".equals(zhsblx)) {
	    	if(tgpdjl_num != 0) {
	    		return false;
	    	}
	    }else if("03".equals(jgxs)) {
	    	if(tgpdjl_num != 0) {
	    		return false;
	    	}
	    }
		return true;
	}
	
	
	/**
	 * DLQ0012
	 *    断口数量	DKSL 
	 * 规则：断口类型只有1、2，按断路器说明书或制造厂产品技术条件填写
	 */
	private boolean validateDksl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dksl = row.get("DKSL");//断口数量
		if(StringUtils.isEmpty(dksl)) {
			return true;
		}
		try {
			 double dksl_num = Double.parseDouble(dksl);
			if(dksl_num != 1 || dksl_num != 2) {
				return false;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return true;
	}
	
	/**
	 * DLQ0013
	 *     对地泄漏比距(cm/kV)	DDXLBJ
	 * 规则：1.8~6(根据铜川局实测反馈将范围由1.8~3.2调整为1.8~6)
	 */
	private boolean validateDdxlbj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String ddxlbj = row.get("DDXLBJ");//对地泄漏比距(cm/kV)
		if(StringUtils.isEmpty(ddxlbj)) {
			return true;
		}
		try {
		 double ddxlbj_num = Double.parseDouble(ddxlbj);
			if(ddxlbj_num >6 || ddxlbj_num < 1.8) {
				return false;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return true;
	}
	
	
	/**
	 * DLQ0014
	 *      合闸时间(精度范围)(ms)	GYHZSJ
	 * 规则：0~20
	 */
	private boolean validateGyhzsj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String gyhzsj = row.get("GYHZSJ");//合闸时间(精度范围)(ms)
		if(StringUtils.isEmpty(gyhzsj)) {
			return true;
		}
		try {
			double gyhzsj_num = Double.parseDouble(gyhzsj);
			if(gyhzsj_num >=20 || gyhzsj_num < 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return true;
	}
	
	/**
	 * DLQ0015
	 *      合闸时间(基准值)(ms)	HZSJ
	 * 规则：30~200
	 */
	
	public static boolean isNumericZidai(String str){
		for (int i = 0; i < str.length(); i++) {
		System.out.println(str.charAt(i));
		if (!Character.isDigit(str.charAt(i))) {
		 return false;
		}
		}
		return true;
		 }
	private boolean validateHzsj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String hzsj = row.get("HZSJ");//合闸时间(精度范围)(ms)
		if(StringUtils.isEmpty(hzsj)) {
			return true;
		}
		try {	
			if(isNumericZidai(hzsj)) {
				double hzsj_num = Double.parseDouble(hzsj);
				if(hzsj_num >=200 || hzsj_num < 30) {
					return false;
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return true;
	}
	
	/**
	 * DLQ00016
	 * SF6气体闭锁压力(Mpa)	SF6QTBSYL
	 * 规则：800kV断路器的SF6气体闭锁压力0.5Mpa。
	 *    85   
	 */
	private boolean validateSf6qtbsyl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//电压等级
		String sf6qtbsyl = row.get("SF6QTBSYL");//SF6气体闭锁压力(Mpa)
		if(StringUtils.isEmpty(sf6qtbsyl)) {
			return true;
		}
		if("85".equals(dydj)) {
			try {
				double sf6qtbsyl_num = Double.parseDouble(sf6qtbsyl);
				if(sf6qtbsyl_num != 05) {
					return false;
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
	/**
	 * DLQ0017
	 *      分闸时间(精度范围)(ms)	GYFZSJ
	 * 规则：0~20
	 */
	private boolean validateGyfzsj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String gyfzsj = row.get("GYFZSJ");//分闸时间(精度范围)(ms)
		if(StringUtils.isEmpty(gyfzsj)) {
			return true;
		}
		try {
			double gyfzsj_num = Double.parseDouble(gyfzsj);
			if(gyfzsj_num >=20 || gyfzsj_num < 0) {
				return false;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return true;
	}
	
	/**
	 * DLQ0018
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
	 *  投运日期	TYRQ  DLQ0019
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
	 * DLQ0020
	 *  额定电压(kV)	EDDY
	 * 规则：一般电压等级为6kV、10kV、20kV、35kV、66kV、110kV、330kV、750kV对应的额定电压分别为：(6,7.2)、(10,12)、(20,24)、(35,40.5)(66,72.5)、(110,126,145)、(330,363,420)、800。
	 *                21   22   24   25    30    32    34     36
	 */
	private boolean validateEddy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//电压等级
		String eddy = row.get("EDDY");//额定电压(kV)
		if(StringUtils.isEmpty(eddy)) {
			return true;
		}
		try {
			if("21".equals(dydj)) {
					if(!eddy.equals("7.2")) {
						return false;
					}
						
			}else if ("22".equals(dydj)) {
				if(!eddy.equals("12")) {
					return false;
				}
			}else if ("24".equals(dydj)) {
				if(!eddy.equals("24")) {
					return false;
				}
			}else if ("25".equals(dydj)) {
				if(!eddy.equals("40.5")) {
					return false;
				}
			}else if ("30".equals(dydj)) {
				if(!eddy.equals("72.5")) {
					return false;
				}
			}else if ("32".equals(dydj)) {
				if(eddy.equals("126") || eddy.equals("145") ) {
					return true;
				}else{
					return false;
				}
			}else if ("34".equals(dydj)) {
				if(eddy.equals("363")  || eddy.equals("420")) {
					return true;
				}else {
					return false;
				}
			}else if ("36".equals(dydj)) {
				if(eddy.equals("800")) {
					return false;
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	/**
	 * 制造国家,编号DLQ0021
	 * 规则：选择设备的制造国家。默认值为“中国“ 代码 156
	 */


	
	/**
	 * DLQ0022
	 *   使用环境	SYHJ
	 * 规则：型号中含“N”不能为户外式 
	 *                  2
	 */
	private boolean validateSyhj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//型号
		String syhj = row.get("SYHJ");//使用环境
			if(StringUtils.isEmpty(syhj)){
				return true;
			}
			if(StringUtils.isEmpty(xh)){
				return true;
			}
			if(xh.contains("N")) {
				if("2".equals(syhj)) {
					return false;
				}
			}
		
		return true;
	}

	
	/**
	 * DLQ0023
	 *   额定短路电流开断次数(次)	EDDLDLKDCS
	 * 规则：一、对于40.5kV及以下的真空断路器的电寿命也可按以下规定选取：a） 额定短路开断电流为31.5kA及以下时，其电寿命（额定短路电流的开断次数）由下列数值中选取：10，30，50次。b）额定短路开断电流为40～63kA时，其电寿命（额定短路电流的开断次数）由下列数值中选取： 16，20，30次。                                              二、对于40.5kV以上的SF6高压断路器，需进行额定短路开断电流下的连续开断能力试验（电寿命试验）。断路器在其主回路中开断用的零件不需要维修的情况下，可连续开断额定短路开断电流的次数应由下列数值中选取：16，20，25次
	 * @param value
	 *   
	 * @param row
	 * @return
	 */
	private boolean validateEddldlkdcs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		/*String dydj = row.get("DYDJ");//电压等级
		String eddldlkdcs = row.get("EDDLDLKDCS");//额定短路电流开断次数
		String  dydj_max = "37,36,35,34,33,32,31,30,91,86,85,84,92,93,83,82,88,87,90,81,80,78";
		*/
		
		return true;
	}
	
}
