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
 * �翹��ҵ�����
 */
public class ZnycDkqImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");

        //����XS
        if(field.equals("XS")){
        	if(!validateXs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_XS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_XS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //���� EDDG
        if(field.equals("EDDG")){
        	if(!validateEddg(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_EDDG.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_EDDG.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // �Ͳ���YCD
        if(field.equals("YCD")){
        	if(!validateYcd(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_YCD.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_YCD.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //�Ƶ��EDPL
        if(field.equals("EDPL")) {
        	if(!validateEdpl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //���Ͷ������
        if(field.equals("ZJTYRQ")) {
        	if(!validateZjtyrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_ZJYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_ZJYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // ���뷽ʽ JRFS
        if(field.equals("JRFS")) {
        	if(!validateJrfs(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_JRFS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_JRFS.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //��翹��EDDKL
        if(field.equals("EDDKL")) {
        	if(!validateEddkl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_EDDKL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_EDDKL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //�ͺ�YH
        if(field.equals("YH")){
        	if(!validateYh(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_YH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_YH.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //����ZZ
        if(field.equals("ZZ")) {
        	if(!validateZz(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_ZZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_ZZ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

      // ��翹EDDK
        if(field.equals("EDDK")) {
        	if(!validateEddk(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_EDDK.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_EDDK.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        // �����EDRL
        if(field.equals("EDRL")) {
        	if(!validateEdrl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_EDRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_EDRL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //Ͷ������
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DKQ_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DKQ_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }
	}

	/**
	 * ����XS   1���࣬2���࣬3����
	 * ����330kV�������豸���࣬���࣬���࣬������ѹ�ȼ������ࡣ
	 */
	private boolean validateXs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String eddy = row.get("EDDY");
		if(StringUtils.isEmpty(eddy)) {
			return true;
		}

		if(StringUtils.isEmpty(value)) {//����
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
	 * ���� EDDG
	 * ����x>0��
	 */
	private boolean validateEddg(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//����
			return true;
		}
		BigDecimal eddg = new BigDecimal(value);
		if(eddg.compareTo(new BigDecimal(0.0000)) != 1){
			return false;
		}
		return true;

	}

	/**
	 * �Ͳ���YCD
	 * ���򣺾�Ե����=�ͽ�:��Ϊ�գ�����Ϊ0���ޡ�/
	 */
	private boolean validateYcd(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//��Ե����
		if(StringUtils.isEmpty(jyjz)) {
			return true;
		}
		if("1".equals(jyjz)) {//�ͽ�ʽ
			if(value == null || "".equals(value)){
				return false;
			}
		}else {
			if(!"��".equals(value) && !"/".equals(value) && !"0".equals(value)){
				return false;
			}
		}
		return true;
	}

	/**
	 * �Ƶ��EDPL
	 * ����Ĭ��ֵ50
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
	 * ���Ͷ������ ZJTYQR
	 * ����Ͷ�����ڡ����Ͷ������
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
	 * ���뷽ʽ JRFS
	 * �����ͺ�������ĸΪCK�ľ�Ϊ����������ĸΪBK�ľ�Ϊ������
	 */
	private boolean validateJrfs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//�ͺ�
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {// ���뷽ʽ
			return true;
		}
		if(xh.startsWith("CK")) {//���� 2
			if(!"2".equals(value)){
				return false;
			}
		}else if(xh.startsWith("BK")){//���� 1\3
			if("2".equals(value)){
				return false;
			}
		}
		return true;
	}

	/**
	 * ��翹�� EDDKL
	 * ����x>0��
	 */
	private boolean validateEddkl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//��翹��
			return true;
		}
		BigDecimal eddkl = new BigDecimal(value);
		if(eddkl.compareTo(new BigDecimal(0.0000)) != 1){
			return false;
		}
		return true;

	}

	/**
	 * �ͺ�YH
	 * ���򣺰���������д���粻ȷ����ͳһ��д��45��25����ֻ�о�Ե����Ϊ�ͽ��Ĳ��
	 */
	private boolean validateYh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//�ͺ�
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {
			return true;
		}
		if(xh.indexOf("G")==-1 && xh.indexOf("C")==-1) {//�ͽ�ʽ
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
	 * ���� ZZ
	 * ����x>0��
	 */
	private boolean validateZz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//����
			return true;
		}
		BigDecimal zz = new BigDecimal(value);
		if(zz.compareTo(new BigDecimal(0.0000)) != 1){
			return false;
		}
		return true;

	}

	/**
	 * ��翹EDDK
	 * ����x>0��
	 */
	private boolean validateEddk(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//��翹
			return true;
		}
		BigDecimal eddk = new BigDecimal(value);
		if(eddk.compareTo(new BigDecimal(0.0000)) != 1){
			return false;
		}
		return true;

	}

	/**
	 * �����EDRL
	 * ����X>0��500kV�翹�����������10-100Mvar�����У�1-16H�����أ���30-90t��
	 */
	private boolean validateEdrl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//�����
			return true;
		}
		BigDecimal edrl = new BigDecimal(value);
		if(edrl.compareTo(new BigDecimal(0.0000)) != 1){
			return false;
		}
		return true;

	}

	/**
	 * Ͷ������ TYQR
	 * ����Ͷ������ ���� ��������
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
