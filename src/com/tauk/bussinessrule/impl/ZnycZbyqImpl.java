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
 * 主变压器业务规则
 * @author zyb_s
 *
 */
public class ZnycZbyqImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //绝缘介质
        if(field.equals("JYJZ")) {
        	if(!validateJyjz(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_JYJZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_JYJZ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //投运日期
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //电压比
        if(field.equals("DYB")){
        	if(!validateDyb(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_DYB.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_DYB.getMessage();
    			recordErrData(datapk,code,message,field);
            }
	     }

        //额定电流
        if(field.equals("EDDL")) {
        	if(!validateEddl(value,row)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_EDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_EDDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

       /*
        * 短路阻抗(高压-低压) (kW)
        * 短路阻抗(中压-低压)
        */
        if(field.equals("DLZKGYDY")) {
        	if(!validateFZSHGYDY(value,row)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_DLZKGYDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_DLZKGYDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        /*
         * 额定容量(MVA)
         */
        if(field.equals("EDRL")) {
        	if(!validateEDRL(value,row)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_EDRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_EDRL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        // 绕组型式
        if(field.equals("RZXS")){
        	if(!validateRzxs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_RZXS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_RZXS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //冷却方式LQFS
        if(field.equals("LQFS")){
        	if(!validateLqfs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_LQFS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_LQFS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //调压方式DYFS
        if(field.equals("DYFS")){
        	if(!validateDyfs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_DYFS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_DYFS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 短路阻抗中压－低压DLZKZYDY
        if(field.equals("DLZKZYDY")){
        	if(!validateDlzkzydy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_DLZKZYDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_DLZKZYDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 负载损耗(满载)FZSHMZ
        if(field.equals("FZSHMZ")){
        	if(!validateFzshmz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_FZSHMZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_FZSHMZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //自冷却容量ZLQRL
        if(field.equals("ZLQRL")){
        	if(!validateZlqrl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_ZLQRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_ZLQRL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //油号YH
        if(field.equals("YH")){
        	if(!validateYh(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_YH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_YH.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 油产地YCD
        if(field.equals("YCD")){
        	if(!validateYcd(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_YCD.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_YCD.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 短路阻抗高压－中压DLZKGYZY
        if(field.equals("DLZKGYZY")){
        	if(!validateDlzkgyzy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_DLZKGYZY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_DLZKGYZY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //总重ZZ
        if(field.equals("ZZ")){
        	if(!validateZz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_ZZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_ZZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //相数XS
        if(field.equals("XS")){
        	if(!validateXs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_XS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_XS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //空载损耗KZSH
        if(field.equals("KZSH")){
        	if(!validateKzsh(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_KZSH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_KZSH.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //额定频率EDPL
        if(field.equals("EDPL")){
        	if(!validateEdpl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        // 自然冷却噪声ZSSP
        if(field.equals("ZSSP")){
        	if(!validateZssp(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_ZSSP.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_ZSSP.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        //SF6气体报警压力(Mpa)  SF6QTBJYL
        if(field.equals("SF6QTBJYL")){
        	if(!validateSf6qtbjyl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_SF6QTBJYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_SF6QTBJYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //SF6气体额定压力(Mpa)  SF6QTEDYL
        if(field.equals("SF6QTEDYL")){
        	if(!validateSf6qtedyl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_SF6QTEDYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_SF6QTEDYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


	}


	/**
	 * 绝缘介质,编号zbyq0001
	 * 规则：设备型号中含G、C为干式，其他为油浸
	 */
	private boolean validateJyjz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String selectvalue = (String)dataRuleMap.get("selectvalue");
		String selecttext = (String)dataRuleMap.get("selecttext");
		if(StringUtils.isEmpty(selectvalue)) {
			return true;
		}
		String selectvalues[] = selectvalue.split(",");
		String selecttexts[] = selecttext.split(",");
		int i=0;
		for(i=0;i<selectvalues.length;i++) {
			if(selectvalues[i].equals(value)) {
				break;
			}
		}
		if(i>=selectvalues.length) {
			return true;
		}
		String xh = row.get("XH");
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(xh.indexOf("G")!=-1||xh.indexOf("C")!=-1) {
			if(!selecttexts[i].equals("干式")){
			  return false;
			}
		}
		return true;
	}

	/**
	 * 投运日期zbyq0002
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
	 * 电压比:zbyq0003
	 * 规则：电压比与绕组形式相关，双绕组电压比中有一个‘/’，三绕组电压比中有两个‘/’。
	 * @param value
	 * @param row
	 * @return
	 */
	private boolean validateDyb(String value,Map<String,String> row) {
		String rzxs = row.get("RZXS");
		if(StringUtils.isEmpty(rzxs)) {
			return true;
		}
		String values[] = value.split("/");
		//双绕组
		if(rzxs.equals("1")) {
			if(values.length!=2) {
				return false;
			}
		}
		//三绕组
		if(rzxs.equals("2")) {
			if(values.length!=3) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 额定电流:zbyq0004
	 * 规则：额定电流在: (额定容量)*1000/(电压段*1.732)范围内。（电压段：750(765)、330(或363)、110(或126)、63(或76.5)、35(或38.5)、10(或11)）
	 * @param value
	 * @param row
	 * @return
	 */
	private boolean validateEddl(String value,Map<String,String> row) {
		String edrl = row.get("EDRL");
		if(StringUtils.isEmpty(edrl)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		double dvalue = Double.valueOf(value);
		//750(765)
		if((((Double.valueOf(edrl)*1000)/(750*1.732))>=dvalue)&&(dvalue>=((Double.valueOf(edrl)*1000)/(765*1.732)))) {
			return true;
		}
		//330(或363)
		if((((Double.valueOf(edrl)*1000)/(330*1.732))>=dvalue)&&(dvalue>=((Double.valueOf(edrl)*1000)/(363*1.732)))) {
			return true;
		}
		//110(或126)
		if((((Double.valueOf(edrl)*1000)/(110*1.732))>=dvalue)&&(dvalue>=((Double.valueOf(edrl)*1000)/(126*1.732)))) {
			return true;
		}
		//63(或76.5)
		if((((Double.valueOf(edrl)*1000)/(63*1.732))>=dvalue)&&(dvalue>=((Double.valueOf(edrl)*1000)/(76.5*1.732)))) {
			return true;
		}
		//35(或38.5)
		if((((Double.valueOf(edrl)*1000)/(35*1.732))>=dvalue)&&(dvalue>=((Double.valueOf(edrl)*1000)/(38.5*1.732)))) {
			return true;
		}
		//10(或11)
		if((((Double.valueOf(edrl)*1000)/(10*1.732))>=dvalue)&&(dvalue>=((Double.valueOf(edrl)*1000)/(11*1.732)))) {
			return true;
		}
		return false;
	}

	/** 短路阻抗高压－低压:zbyq0005
	 *       规则：双绕组：不能为空。
                     三绕组、自耦：短路阻抗（高压-低压）>短路阻抗（高压-中压）
	 */
	private boolean validateFZSHGYDY(String value,Map<String,String> row) {
		//短路阻抗（高压-中压）
		String FZSHGYZY = row.get("FZSHGYZY");
		//双绕组、三绕组、自偶  (1、2、3)
		String rzxs = row.get("RZXS");
		if(StringUtils.isEmpty(rzxs)) {
			return true;
		}
		if(rzxs.equals("1")) {
			if(StringUtils.isEmpty(value)) {
				return false;
			}else {
				return true;
			}
		}
		if(rzxs.equals("2")||rzxs.equals("3")) {
			if(StringUtils.isEmpty(FZSHGYZY)) {
				return true;
			}
			if(StringUtils.isEmpty(value)) {
				return true;
			}
			if(Double.valueOf(value)>Double.valueOf(FZSHGYZY)) {
				return true;
			}
		}
		return false;
	}

	/** 额定容量:zbyq0006
	 *       型号 中-与/ 之间的数除1000
	 */
	private boolean validateEDRL(String value,Map<String,String> row) {
		//短路阻抗（高压-中压）
		String xh = row.get("XH");
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		String tvalue = xh;
		//SZ11-6300/35SZ11-6300/35    S7-3150-35
		if(xh.indexOf("-")!=-1) {
			if(xh.indexOf("/")!=-1) {
				if(xh.lastIndexOf("-")<xh.lastIndexOf("/")) {
					tvalue  = xh.substring(xh.lastIndexOf("-")+1, xh.lastIndexOf("/"));
				}else {
					//SL-500/35-T
					tvalue  = xh.substring(xh.indexOf("-")+1, xh.lastIndexOf("/"));
				}
			}else {
				String xhs[] = xh.split("-");
				if(xhs.length==3) {
					tvalue  = xh.substring(xh.indexOf("-")+1, xh.lastIndexOf("-"));
				}else{
					return false;
				}
			}
		}else {
			String xhs[] = xh.split("/");
			if(xhs.length==3) {
				tvalue  = xh.substring(xh.indexOf("/")+1, xh.lastIndexOf("/"));
			}else {
				return true;
			}
		}
		if((Double.valueOf(tvalue)/1000)==(Double.valueOf(value))) {
			return true;
		}
		return false;
	}


	/**
	 * 绕组型式
	 * 规则：双绕组(型号中仅有1个S)、三绕组(型号中有2个S)、自耦(型号首字母为O) (O开头并且有双S的为三绕组)
	 */
	private boolean validateRzxs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String selectvalue = (String)dataRuleMap.get("selectvalue");
		String selecttext = (String)dataRuleMap.get("selecttext");
		String selectvalues[] = selectvalue.split(",");
		String selecttexts[] = selecttext.split(",");
		int i=0;
		for(i=0;i<selectvalues.length;i++) {
			if(selectvalues[i].equals(value)) {
				break;
			}
		}
		if(i>=selectvalues.length) {
			return true;
		}
		String xh = row.get("XH");
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(xh.substring(0,1)=="O") {
			if(xh.indexOf("SS")!=-1){
				if(!"2".equals(selectvalues[i])){//三绕组
					  return false;
				}
			}
			if(!"3".equals(selectvalues[i])){//自偶
			  return false;
			}
		}else{
			if(xh.indexOf("SS")!=-1){
				if(!"2".equals(selectvalues[i])){//三绕组
					  return false;
				}
			}else if(xh.indexOf("S")!=-1){
				if(!"1".equals(selectvalues[i])){//双绕组
					  return false;
				}
			}
		}
		return true;
	}

	/**
	 * 冷却方式
	 * 规则：对于油浸式变压器
	 * 型号中包含“F”和“P”的，选择“强迫油循环(导向)风冷”；
	 * 型号中仅有“F”没有“P”，选择“自然油循环风冷”；
	 * 型号中既无“F”又无“P”的，选择“自然冷却”
	 */
	private boolean validateLqfs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String selectvalue = (String)dataRuleMap.get("selectvalue");
		String selecttext = (String)dataRuleMap.get("selecttext");
		String selectvalues[] = selectvalue.split(",");
		String selecttexts[] = selecttext.split(",");
		int i=0;
		for(i=0;i<selectvalues.length;i++) {
			if(selectvalues[i].equals(value)) {
				break;
			}
		}

		if(i>=selectvalues.length) {
			return true;
		}
		String xh = row.get("XH");
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		//设备型号中含G、C为干式，其他为油浸
		if(xh.indexOf("G")==-1 && xh.indexOf("C")==-1) {//油浸式
			if(xh.indexOf("F")!=-1 && xh.indexOf("P")!=-1){
				if(!"5".equals(selectvalues[i])){//强迫油循环导向风冷(ODAF)
					return false;
				}
			}
			if(xh.indexOf("F")!=-1 && xh.indexOf("P")==-1){
				if(!"2".equals(selectvalues[i])){//自然油循环风冷(ONAF)
					return false;
				}
			}
			if(xh.indexOf("F")==-1 && xh.indexOf("P")==-1){
				if(!"1".equals(selectvalues[i])){//自然冷却/油浸自冷(ONAN)
					return false;
				}
			}
		}

		return true;
	}


	/**
	 *  调压方式
	 * 规则：型号中含“Z”的为有载调压，无“Z”为无励磁调压或无调压，据实填写。型号中喊有'±'一定不为无跳压,无调压在设备型号中不能喊有'±'
	 */
	private boolean validateDyfs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String selectvalue = (String)dataRuleMap.get("selectvalue");
		String selecttext = (String)dataRuleMap.get("selecttext");
		String selectvalues[] = selectvalue.split(",");
		String selecttexts[] = selecttext.split(",");
		int i=0;
		for(i=0;i<selectvalues.length;i++) {
			if(selectvalues[i].equals(value)) {
				break;
			}
		}
		if(i>=selectvalues.length) {
			return true;
		}

		String xh = row.get("XH");
		if(StringUtils.isEmpty(xh)) {
			return true;
		}

		if(xh.indexOf("Z")!=-1){
			if(!"1".equals(selectvalues[i])){//有载调压
				return false;
			}
		}else{
			if(!"2".equals(selectvalues[i]) && !"3".equals(selectvalues[i])){//无励磁调压或无调压
				return false;
			}
		}
		if(xh.indexOf("±")!=-1){
			if("3".equals(selectvalues[i])){//一定不为无跳压
				return false;
			}
		}

		return true;
	}

	/**
	 *  短路阻抗中压－低压
	 * 规则：双绕组：X=0或无或/或\或空格； 三绕组、自耦40≥X>0,小于高压-低压
	 */
	private boolean validateDlzkzydy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String rzxs = row.get("RZXS");//绕组形式
		if(StringUtils.isEmpty(rzxs)) {
			return true;
		}

		String dlzkzydy = row.get("DLZKZYDY");//短路阻抗中压－低压
		BigDecimal zydy = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(dlzkzydy)){
			zydy = new BigDecimal(dlzkzydy);
		}
		String dlzkgydy = row.get("DLZKGYDY");//短路阻抗高压-低压
		BigDecimal gydy = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(dlzkgydy)){
			gydy = new BigDecimal(dlzkgydy);
		}

		if("1".equals(rzxs)) {//双绕组
			//X=0或无或/或\或空格
			if(!"无".equals(dlzkzydy)
					&& !" ".equals(dlzkzydy)
					&& !"/".equals(dlzkzydy)
					&& !"\\".equals(dlzkzydy)
					&& zydy.compareTo(new BigDecimal(0.0000)) != 0){
				return false;
			}
		}else if("2".equals(rzxs) ||"3".equals(rzxs)){//三绕组、自耦
			//40≥X>0,小于高压-低压    zydy > 40 || zydy<=0 || gydy<zydy
			if(zydy.compareTo(new BigDecimal(40.0000))==1
					|| zydy.compareTo(new BigDecimal(0.0000))==0
					|| zydy.compareTo(new BigDecimal(0.0000))==-1
					|| zydy.compareTo(gydy)==1){
				return false;
			}
		}

		return true;
	}

	/**
	 *  负载损耗(满载)FZSHMZ
	 * 规则：查变压器出厂资料，只填写数字，取值范围:电压等级越低、主变额定容量越小，该值越小，且该值均低于10倍的空载损耗值，
	 * 一般在空载损耗值的7倍以下。
	 * 35kV主变，该值一般在10~90；
	 * 110kV主变，该值一般在35~450；
	 * 330kV主变，该值一般在230~950(负载损耗>空载损耗≠0)
	 */
	private boolean validateFzshmz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//电压等级
		if(StringUtils.isEmpty(dydj)) {
			return true;
		}

		String mzfzsh = row.get("FZSHMZ");//负载损耗(满载)
		BigDecimal fzsh = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(mzfzsh)){
			fzsh = new BigDecimal(mzfzsh);
		}

		if("35".equals(dydj)) {//35kv
			//10~90
			if(fzsh.compareTo(new BigDecimal(10.0000))==-1
					|| fzsh.compareTo(new BigDecimal(90.0000))==1){
				return false;
			}
		}else if("110".equals(dydj)){//110kv
			//35~450
			if(fzsh.compareTo(new BigDecimal(35.0000))==-1
					|| fzsh.compareTo(new BigDecimal(450.0000))==1){
				return false;
			}
		}else if("330".equals(dydj)){//330kv
			//230~950
			if(fzsh.compareTo(new BigDecimal(230.0000))==-1
					|| fzsh.compareTo(new BigDecimal(950.0000))==1){
				return false;
			}
		}

		return true;
	}



	/**
	 * 自冷却容量ZLQRL
	 * 规则：冷却方式=OFAF填0，ONAN填“100”；ONAF且铭牌无参数的填“66”，取值范围:50≤ZLQRL≤100
	 */
	private boolean validateZlqrl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String lqfs = row.get("LQFS");//冷却方式
		if(StringUtils.isEmpty(lqfs)) {
			return true;
		}

		String zlqrl = row.get("ZLQRL");//自冷却容量
		BigDecimal zlq = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(zlqrl)){
			zlq = new BigDecimal(zlqrl);
		}

		if("3".equals(lqfs)) {//强迫油循环风冷(OFAF)
			if(zlq.compareTo(new BigDecimal(0.0000)) != 0){
				return false;
			}
		}else if("1".equals(lqfs)){//自然冷却/油浸自冷(ONAN)
			if(zlq.compareTo(new BigDecimal(100.0000)) != 0){
				return false;
			}
		}else if("2".equals(lqfs)){//自然油循环风冷(ONAF)
			if(zlq.compareTo(new BigDecimal(66.0000)) != 0){
				return false;
			}
		}

		return true;
	}

	/**
	 * 油号YH
	 * 规则：油浸式变压器全部填写：25或45，数字代表变压器油的凝固点，45为零下45度凝固、25为零下25度凝固。陕西多为25号
	 * 非油浸式变压器填写为无
	 */
	private boolean validateYh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//型号
		if(StringUtils.isEmpty(xh)) {
			return true;
		}

		String yh = row.get("YH");//油号

		//设备型号中含G、C为干式，其他为油浸
		if(xh.indexOf("G")==-1 && xh.indexOf("C")==-1) {//油浸式
			if(!"25".equals(yh) && !"45".equals(yh)){
				return false;
			}
		}else {
			if(!"无".equals(yh)){
				return false;
			}
		}
		return true;
	}


	/**
	 * 油产地YCD
	 * 规则：油浸变压器填写新疆克拉玛依、兰炼，非油浸填写无或/
	 */
	private boolean validateYcd(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//型号
		if(StringUtils.isEmpty(xh)) {
			return true;
		}

		String yh = row.get("YCD");//油产地

		//设备型号中含G、C为干式，其他为油浸
		if(xh.indexOf("G")==-1 && xh.indexOf("C")==-1) {//油浸式
			if(!"新疆克拉玛依".equals(yh) && !"克拉玛依".equals(yh) && !"兰炼".equals(yh)){
				return false;
			}
		}else {
			if(!"无".equals(yh) && !"/".equals(yh)){
				return false;
			}
		}
		return true;
	}

	/**
	 * 短路阻抗高压－中压
	 * 规则：双绕组：X=0或无或/或\或空格； 三绕组、自耦：取值范围:20≥X>0。短路阻抗（高压-低压）>短路阻抗（高压-中压）
	 */
	private boolean validateDlzkgyzy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String rzxs = row.get("RZXS");//绕组形式
		if(StringUtils.isEmpty(rzxs)) {
			return true;
		}

		String dlzkgyzy = row.get("DLZKGYZY");//短路阻抗高压－中压
		BigDecimal gyzy = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(dlzkgyzy)){
			gyzy = new BigDecimal(dlzkgyzy);
		}
		String dlzkgydy = row.get("DLZKGYDY");//短路阻抗高压-低压
		BigDecimal gydy = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(dlzkgydy)){
			gydy = new BigDecimal(dlzkgydy);
		}

		if("1".equals(rzxs)) {//双绕组
			//X=0或无或/或\或空格
			if(!"无".equals(dlzkgyzy)
					&& !" ".equals(dlzkgyzy)
					&& !"/".equals(dlzkgyzy)
					&& !"\\".equals(dlzkgyzy)
					&& gyzy.compareTo(new BigDecimal(0.0000)) != 0){
				return false;
			}
		}else if("2".equals(rzxs) ||"3".equals(rzxs)){//三绕组、自耦
			//20≥X>0。短路阻抗（高压-低压）>短路阻抗（高压-中压）    gyzy > 20 || gyzy<=0 || gydy<gyzy
			if(gyzy.compareTo(new BigDecimal(20.0000))==1
					|| gyzy.compareTo(new BigDecimal(0.0000))==0
					|| gyzy.compareTo(new BigDecimal(0.0000))==-1
					|| gyzy.compareTo(gydy)==1){
				return false;
			}
		}

		return true;
	}

	/**
	 * 总重ZZ
	 * 规则：330kV 100-400T    110kV 20-120T
	 */
	private boolean validateZz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//电压等级
		if(StringUtils.isEmpty(dydj)) {
			return true;
		}

		String zz = row.get("ZZ");//总重
		BigDecimal zzl = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(zz)){
			zzl = new BigDecimal(zz);
		}

		if("110".equals(dydj)){//110kv
			//20-120
			if(zzl.compareTo(new BigDecimal(20.0000))==-1
					|| zzl.compareTo(new BigDecimal(120.0000))==1){
				return false;
			}
		}else if("330".equals(dydj)){//330kv
			//100-400
			if(zzl.compareTo(new BigDecimal(100.0000))==-1
					|| zzl.compareTo(new BigDecimal(400.0000))==1){
				return false;
			}
		}
		return true;
	}

	/**
	 * 相数XS   1单相，2两相，3三相
	 * 规则：设备型号中含字母‘D’的为单相
	 */
	private boolean validateXs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");
		if(StringUtils.isEmpty(xh)) {
			return true;
		}

		String xs = row.get("XS");
		if(StringUtils.isEmpty(xs)) {
			return true;
		}

		if(xh.indexOf("D")!=-1) {
			if(!"1".equals(xs)){
			  return false;
			}
		}
		return true;

	}

	/**
	 * 空载损耗KZSH
	 * 规则：查变压器出厂资料，只填写数字,取值范围:电压等级越低、主变额定容量越小，该值越小；
	 * 35kV主变，该值一般在1~20；
	 * 110kV主变，该值一般在10~75；
	 * 330kV主变，该值一般在30~260(负载损耗>空载损耗≠0)
	 */
	private boolean validateKzsh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//电压等级
		if(StringUtils.isEmpty(dydj)) {
			return true;
		}

		String kzsh = row.get("KZSH");//空载损耗
		BigDecimal kzshNew = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(kzsh)){
			kzshNew = new BigDecimal(kzsh);
		}

		if("35".equals(dydj)) {//35kv
			//1~20
			if(kzshNew.compareTo(new BigDecimal(1.0000))==-1
					|| kzshNew.compareTo(new BigDecimal(20.0000))==1){
				return false;
			}
		}else if("110".equals(dydj)){//110kv
			//10~75
			if(kzshNew.compareTo(new BigDecimal(10.0000))==-1
					|| kzshNew.compareTo(new BigDecimal(75.0000))==1){
				return false;
			}
		}else if("330".equals(dydj)){//330kv
			//30~260
			if(kzshNew.compareTo(new BigDecimal(30.0000))==-1
					|| kzshNew.compareTo(new BigDecimal(260.0000))==1){
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
		String edpl = row.get("EDPL");//额定频率
		BigDecimal edplNew = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(edpl)){
			edplNew = new BigDecimal(edpl);
		}
		if(edplNew.compareTo(new BigDecimal(50.0000)) != 0){
			return false;
		}
		return true;
	}

	/**
	 * 自然冷却噪声ZSSP
	 * 规则：取值范围：50~80，风冷应选大一点，只填写数字而不填写字符“dB”
	 */
	private boolean validateZssp(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String zssp = row.get("ZSSP");//噪声水平
		if(StringUtils.isEmpty(zssp)){
			return false;
		}
		if(zssp.indexOf("dB")!=-1 || zssp.indexOf("DB")!=-1  || zssp.indexOf("db")!=-1){
			return false;
		}

		BigDecimal zsspNew = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(zssp)){
			zsspNew = new BigDecimal(zssp);
		}

		if(zsspNew.compareTo(new BigDecimal(50.0000))==-1
				|| zsspNew.compareTo(new BigDecimal(80.0000))==1){
			return false;
		}

		return true;
	}

	/**
	 * SF6气体报警压力(Mpa)  SF6QTBJYL
	 * 规则：SF6变压器按照铭牌填写 ,绝缘介质非SF6 填0或不填
	 */
	private boolean validateSf6qtbjyl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//绝缘介质
		String sf6qtbjyl = row.get("SF6QTBJYL");//SF6气体报警压力
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

}
