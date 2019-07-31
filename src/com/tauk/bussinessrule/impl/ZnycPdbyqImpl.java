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
 * ����ѹ��ҵ�����
 */
public class ZnycPdbyqImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //�������� CCRQ
        if(field.equals("CCRQ")) {
        	if(!validateCcrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_CCRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_CCRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // �����(kVA) EDRL
        if(field.equals("EDRL")) {
        	if(!validateEdrl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_EDRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_EDRL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //  �ӵص���(��) JDDZ
        if(field.equals("JDDZ")) {
        	if(!validateJddz(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_JDDZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_JDDZ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // �������(W) KZSH
        if(field.equals("KZSH")) {
        	if(!validateKzsh(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_KZSH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_KZSH.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // ��·���(W) DLSH
        if(field.equals("DLSH")) {
        	if(!validateDlsh(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_DLSH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_DLSH.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //���ص���(A) KZDL
        if(field.equals("KZDL")) {
        	if(!validateKzdl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_KZDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_KZDL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // �迹��ѹ ZKDY
        if(field.equals("ZKDY")) {
        	if(!validateZkdy(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_ZKDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_ZKDY.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //�ͺ�YH
        if(field.equals("YH")){
        	if(!validateYh(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_YH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_YH.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //����ZZ
        if(field.equals("ZZ")){
        	if(!validateZz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_ZZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_ZZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ������� JXZB
        if(field.equals("JXZB")){
        	if(!validateJxzb(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_JXZB.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_JXZB.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ���� YZ
        if(field.equals("YZ")){
        	if(!validateYz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_YZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_YZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //Ͷ������
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_PDBYQ_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_PDBYQ_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

	}

	/**
	 * ��������CCQR
	 * ���򣺳�������<Ͷ������
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

	/** �����:EDRL
	 * ���ͺ��ֶ������һ��"-"��"/"֮�����ֵ�ж������ֻ��"-"ȡ"-"���ַ���������ֵ��
	 * �磺����Ϊ315���ͺ��������"315"����
	 * ������ֵ��������������ֵ��ѡ��10,20,30,50,80,100,160,200,250,315,320,500,630,800,1000��1250,1600,2000
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
		tvalue = tvalue.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\��", "").replaceAll("\\��", "");
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

	/** �ӵص���:JDDZ
	 * �����100KVA�����Ͻӵص��費����4ŷķ��100KVA���²�����10ŷķ
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
	 * �������KZSH
	 * ����1����Χ3600��X��10    2��������0
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
	 * ��·���DLSH
	 * ����1����Χ21330��X��10    2��������0    3����·����ڿ�����ĵ�1-10��֮��
	 */
	private boolean validateDlsh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		String kzsh = row.get("KZSH");//�������
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
	 * ���ص���(A) KZDL
	 * ����2.1%*��ѹ��������X��0.6%*��ѹ������
	 */
	private boolean validateKzdl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		String gyceddl = row.get("GYCEDDL");//��ѹ������
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
	 *  �迹��ѹ ZKDY
	 * ����0-10֮��
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
	 * �ͺ�YH
	 * ����1������Ե���ʡ��ֶ�=�ͽ�ʽ���ַ��пɰ���25��45
	 * 2��������Ե���ʣ�����д�ո�/��\����
	 */
	private boolean validateYh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//��Ե����
		if(StringUtils.isEmpty(jyjz)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//�ͺ�
			return true;
		}

		if("1".equals(jyjz)) {//�ͽ�ʽ
			if(!"25".equals(value) && !"45".equals(value)){
				return false;
			}
		}else {
			//�޻�/��\��ո�
			if(!"��".equals(value)
					&& !" ".equals(value)
					&& !"/".equals(value)
					&& !"\\".equals(value)){
				return false;
			}
		}
		return true;
	}

	/**
	 * ����ZZ
	 * ����1��260~2200   2���ͽ���""����""<""����""
	 */
	private boolean validateZz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String yz = row.get("YZ");//����
		if(StringUtils.isEmpty(yz)) {
			return true;
		}
		String jyjz = row.get("JYJZ");//��Ե����
		if(StringUtils.isEmpty(jyjz)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//����
			return true;
		}
		BigDecimal zz = new BigDecimal(value);
		if(zz.compareTo(new BigDecimal(260.0000))==-1
				|| zz.compareTo(new BigDecimal(2200.0000))==1){
			return false;
		}
		if("1".equals(jyjz)) {//�ͽ�ʽ
			if(zz.compareTo(new BigDecimal(yz))==-1){
				return false;
			}
		}
		return true;
	}

	/**
	 * ������� JXZB
	 * ����һ��ΪDyn11��Yyn0
	 */
	private boolean validateJxzb(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//�������
			return true;
		}
		if(!"Dyn11".equals(value) && !"Yyn0".equals(value)) {
				return false;
		}
		return true;
	}

	/**
	 * ����ZZ
	 * ���򣺾�Ե����=�ͽ�ʽ,50~500kg(�ο���;��Ե����=��ʽ:�գ������ء��ֶβ��ܴ��ڡ����ء�
	 */
	private boolean validateYz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String zz = row.get("ZZ");//����
		if(StringUtils.isEmpty(zz)) {
			return true;
		}
		String jyjz = row.get("JYJZ");//��Ե����
		if(StringUtils.isEmpty(jyjz)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//����
			return true;
		}
		BigDecimal yz = new BigDecimal(value);
		if("1".equals(jyjz)) {//�ͽ�ʽ
			if(yz.compareTo(new BigDecimal(50.0000))==-1
					|| yz.compareTo(new BigDecimal(500.0000))==1){
				return false;
			}
		}else if("3".equals(jyjz)){//��ʽ
			if(yz.compareTo(new BigDecimal(zz))==1){
				return false;
			}
		}
		return true;
	}

	/**
	 * Ͷ������ TYRQ
	 * ����Ͷ������ ���� ��������
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
