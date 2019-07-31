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
 * 配电变压器业务规则
 */
public class ZnycPdbyqImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //出厂日期 CCRQ
        if(field.equals("CCRQ")) {
        	if(!validateCcrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_CCRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_CCRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // 额定容量(kVA) EDRL
        if(field.equals("EDRL")) {
        	if(!validateEdrl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_EDRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_EDRL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //  接地电阻(Ω) JDDZ
        if(field.equals("JDDZ")) {
        	if(!validateJddz(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_JDDZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_JDDZ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // 空载损耗(W) KZSH
        if(field.equals("KZSH")) {
        	if(!validateKzsh(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_KZSH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_KZSH.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // 短路损耗(W) DLSH
        if(field.equals("DLSH")) {
        	if(!validateDlsh(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_DLSH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_DLSH.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //空载电流(A) KZDL
        if(field.equals("KZDL")) {
        	if(!validateKzdl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_KZDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_KZDL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // 阻抗电压 ZKDY
        if(field.equals("ZKDY")) {
        	if(!validateZkdy(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_ZKDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_ZKDY.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //油号YH
        if(field.equals("YH")){
        	if(!validateYh(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_YH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_YH.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //总重ZZ
        if(field.equals("ZZ")){
        	if(!validateZz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_ZZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_ZZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 接线组别 JXZB
        if(field.equals("JXZB")){
        	if(!validateJxzb(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_JXZB.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_JXZB.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // 油重 YZ
        if(field.equals("YZ")){
        	if(!validateYz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_YZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_YZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //投运日期
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

	}

	/**
	 * 出厂日期CCQR
	 * 规则：出厂日期<投运日期
	 */
	private boolean validateCcrq(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String tyrq = row.get("TYRQ");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
        	if(StringUtils.isEmpty(value) ||StringUtils.isEmpty(tyrq)) {
        		return true;
        	}
            Date dt1 = df.parse(value);
            Date dt2 = df.parse(tyrq);
            if (dt1.getTime() <dt2.getTime()) {
                return true;
            } else if (dt1.getTime() >= dt2.getTime()) {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
		return true;
	}

	/** 额定容量:EDRL
	 * 与型号字段中最后一个"-"到"/"之间的数值判定；如果只有"-"取"-"到字符串最后的数值。
	 * 如：容量为315，型号中需出现"315"字样
	 * 所有数值，则在下列序列值中选择：10,20,30,50,80,100,160,200,250,315,320,500,630,800,1000，1250,1600,2000
	 */
	private boolean validateEdrl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String[] arrStr = {"10.0000", "20.0000", "30.0000", "50.0000", "80.0000", "100.0000", "160.0000",
				"200.0000", "250.0000","315.0000", "320.0000", "500.0000", "630.0000", "800.0000",
				"1000.0000", "1250.0000", "1600.0000", "2000.0000"};
		String xh = row.get("XH");
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		String tvalue = xh;
		//SZ13-M.ZT-400(125)/10
		if(xh.lastIndexOf("-")!=-1) {
			if(xh.lastIndexOf("/")!=-1) {
				if(xh.lastIndexOf("-")<xh.lastIndexOf("/")) {
					tvalue = xh.substring(xh.lastIndexOf("-")+1, xh.lastIndexOf("/"));
				}else {
					tvalue = xh.substring(xh.indexOf("-")+1, xh.lastIndexOf("/"));
				}
			}else {
				String xhs[] = xh.split("-");
				if(xhs.length>0) {
					tvalue = xh.substring(xh.lastIndexOf("-")+1, xh.length());
				}else{
					return true;
				}
			}
		}else{
			return true;
		}
		tvalue = tvalue.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\（", "").replaceAll("\\）", "");
		BigDecimal newValue = new BigDecimal(value);
		if(isInteger(tvalue)){
			if(newValue.compareTo(new BigDecimal(tvalue)) != 0){
				for (String str : arrStr) {
					if (!str.contains(value)) {
						return false;
					}
				}
			}
		}else{
			return false;
		}
		return true;
	}

	public static boolean isInteger(String str) {//";
        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");//^[-\\+]?[\\d]*$
        return pattern.matcher(str).matches();
	}

	/** 接地电阻:JDDZ
	 * 额定容量100KVA及以上接地电阻不大于4欧姆，100KVA以下不大于10欧姆
	 */
	private boolean validateJddz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String edrl = row.get("EDRL");
		if(StringUtils.isEmpty(edrl)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {
			return true;
		}

		BigDecimal edrlNew = new BigDecimal(edrl);
		BigDecimal jddz = new BigDecimal(value);
		if(edrlNew.compareTo(new BigDecimal(100.0000))==1 || edrlNew.compareTo(new BigDecimal(100.0000))==0){
			if(jddz.compareTo(new BigDecimal(4.0000))==1){
				return false;
			}
		}else{
			if(jddz.compareTo(new BigDecimal(10.0000))==1){
				return false;
			}
		}
		return true;
	}

	/**
	 * 空载损耗KZSH
	 * 规则：1、范围3600≥X≥10    2、不等于0
	 */
	private boolean validateKzsh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		BigDecimal kzsh = new BigDecimal(value);
		if(kzsh.compareTo(new BigDecimal(10.0000))==-1
				|| kzsh.compareTo(new BigDecimal(3600.0000))==1
				|| kzsh.compareTo(new BigDecimal(0.0000))==0){
			return false;
		}
		return true;
	}

	/**
	 * 短路损耗DLSH
	 * 规则：1、范围21330≥X≥10    2、不等于0    3、短路损耗在空载损耗的1-10倍之间
	 */
	private boolean validateDlsh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		String kzsh = row.get("KZSH");//空载损耗
		if(StringUtils.isEmpty(kzsh)) {
			return true;
		}
		BigDecimal kzshNew = new BigDecimal(kzsh);
		BigDecimal dlsh = new BigDecimal(value);
		if(dlsh.compareTo(new BigDecimal(10.0000))==-1
				|| dlsh.compareTo(new BigDecimal(21330.0000))==1
				|| dlsh.compareTo(new BigDecimal(0.0000))==0
				|| dlsh.compareTo(kzshNew.multiply(new BigDecimal(1)))==-1
				|| dlsh.compareTo(kzshNew.multiply(new BigDecimal(10)))==1 ){
			return false;
		}
		return true;
	}

	/**
	 * 空载电流(A) KZDL
	 * 规则：2.1%*高压侧额定电流≥X≥0.6%*高压侧额定电流
	 */
	private boolean validateKzdl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		String gyceddl = row.get("GYCEDDL");//高压侧额定电流
		if(StringUtils.isEmpty(gyceddl)) {
			return true;
		}
		BigDecimal gyceddlNew = new BigDecimal(gyceddl);
		BigDecimal kzdl = new BigDecimal(value);
		if(kzdl.compareTo(gyceddlNew.multiply(new BigDecimal(0.021)))==1
				|| kzdl.compareTo(gyceddlNew.multiply(new BigDecimal(0.006)))==-1 ){
			return false;
		}
		return true;
	}

	/**
	 *  阻抗电压 ZKDY
	 * 规则：0-10之间
	 */
	private boolean validateZkdy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		BigDecimal zkdy = new BigDecimal(value);
		if(zkdy.compareTo(new BigDecimal(10.0000))==1
				|| zkdy.compareTo(new BigDecimal(0.0000))==-1 ){
			return false;
		}
		return true;
	}

	/**
	 * 油号YH
	 * 规则：1、“绝缘介质”字段=油浸式，字符中可包含25、45
	 * 2、其它绝缘介质，可填写空格、/、\、无
	 */
	private boolean validateYh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//绝缘介质
		if(StringUtils.isEmpty(jyjz)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//油号
			return true;
		}

		if("1".equals(jyjz)) {//油浸式
			if(!"25".equals(value) && !"45".equals(value)){
				return false;
			}
		}else {
			//无或/或\或空格
			if(!"无".equals(value)
					&& !" ".equals(value)
					&& !"/".equals(value)
					&& !"\\".equals(value)){
				return false;
			}
		}
		return true;
	}

	/**
	 * 总重ZZ
	 * 规则：1、260~2200   2、油浸：""油重""<""总重""
	 */
	private boolean validateZz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String yz = row.get("YZ");//油重
		if(StringUtils.isEmpty(yz)) {
			return true;
		}
		String jyjz = row.get("JYJZ");//绝缘介质
		if(StringUtils.isEmpty(jyjz)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//总重
			return true;
		}
		BigDecimal zz = new BigDecimal(value);
		if(zz.compareTo(new BigDecimal(260.0000))==-1
				|| zz.compareTo(new BigDecimal(2200.0000))==1){
			return false;
		}
		if("1".equals(jyjz)) {//油浸式
			if(zz.compareTo(new BigDecimal(yz))==-1){
				return false;
			}
		}
		return true;
	}

	/**
	 * 接线组别 JXZB
	 * 规则：一般为Dyn11或Yyn0
	 */
	private boolean validateJxzb(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//接线组别
			return true;
		}
		if(!"Dyn11".equals(value) && !"Yyn0".equals(value)) {
				return false;
		}
		return true;
	}

	/**
	 * 油重ZZ
	 * 规则：绝缘介质=油浸式,50~500kg(参考）;绝缘介质=干式:空；“油重”字段不能大于“总重”
	 */
	private boolean validateYz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String zz = row.get("ZZ");//总重
		if(StringUtils.isEmpty(zz)) {
			return true;
		}
		String jyjz = row.get("JYJZ");//绝缘介质
		if(StringUtils.isEmpty(jyjz)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//油重
			return true;
		}
		BigDecimal yz = new BigDecimal(value);
		if("1".equals(jyjz)) {//油浸式
			if(yz.compareTo(new BigDecimal(50.0000))==-1
					|| yz.compareTo(new BigDecimal(500.0000))==1){
				return false;
			}
		}else if("3".equals(jyjz)){//干式
			if(yz.compareTo(new BigDecimal(zz))==1){
				return false;
			}
		}
		return true;
	}

	/**
	 * 投运日期 TYRQ
	 * 规则：投运日期 大于 出场日期
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

}
