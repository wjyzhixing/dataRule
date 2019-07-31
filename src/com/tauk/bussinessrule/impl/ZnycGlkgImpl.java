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
 * ���뿪��ҵ�����
 */
public class ZnycGlkgImpl extends SimpleRule {

	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		super.applyRule(request, response, chain);
		String field = (String)requestDataMap.get("field");
		String value =(String) requestDataMap.get("value");
        String datapk = (String)requestDataMap.get("datapk");
        // �ӵص�բ����JDDZPZ
        if(field.equals("JDDZPZ")){
        	if(!validateJddzpz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_JDDZPZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_JDDZPZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ��ϵ�������ZHDQKGGMC
        if(field.equals("ZHDQKGGMC")){
        	if(!validateZhdqkggmc(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_ZHDQKGGMC.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_ZHDQKGGMC.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        //  �ӵؿ��ؿ��ϸ�Ӧ�������� JDKGKHGYDLNL
        if(field.equals("JDKGKHGYDLNL")){
        	if(!validateJdkgkhgydlnl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_JDKGKHGYDLNL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_JDKGKHGYDLNL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        // ���ʱ����ʱ��EDDSNSSJ
        if(field.equals("EDDSNSSJ")){
        	if(!validateEddsnssj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_EDDSNSSJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_EDDSNSSJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ���XB
        if(field.equals("XB")){
        	if(!validateXb(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_XB.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_XB.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

       //�Ƶ��EDPL
        if(field.equals("EDPL")) {
        	if(!validateEdpl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }


        //Ͷ������
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_GLKG_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_GLKG_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }


	}

	/**
	 *�ӵص�բ����JDDZPZ
	 * ��������Ϊ���뿪�����豸�ͺ�����1��D��2D��2T D2  �� ���,����ʵ�������д�����˫�ࡣ��D��ѡ���ޡ� ������Ϊ�ӵؿ��ص�ѡ���ޡ�
	 */
	private boolean validateJddzpz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String lx = row.get("LX");//����
		if(StringUtils.isEmpty(lx)) {
			return true;
		}
		String xh = row.get("XH");//�ͺ�
		if(StringUtils.isEmpty(xh)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//�ӵص�բ����
			return true;
		}
		if("1".equals(lx)){//���뿪��
			if(xh.indexOf("D")==-1
					|| xh.indexOf("DD")==-1
					|| xh.indexOf("TT")==-1
					|| xh.indexOf("D2")==-1
					|| xh.indexOf("��")==-1){
				if(!"2".equals(value) && !"3".equals(value)){//�����˫��
					return false;
				}
			}
			if(xh.indexOf("D")==-1){
				if(!"1".equals(value)){//��
					return false;
				}
			}
		}else{//�ӵؿ���
			if(!"1".equals(value)){//��
				return false;
			}
		}
		return true;
	}

	/**
	 *��ϵ�������ZHDQKGGMC
	 * ���򣺵�������豸���͡�ѡ�񡰿��ع񡱻���ϵ�����ʱ��������д���������� �����ϵ��������ơ���������豸���͡�ѡ���񡱣������д��
	 */
	private boolean validateZhdqkggmc(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String zhsblx = row.get("ZHSBLX");//����豸����
		if(StringUtils.isEmpty(zhsblx)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//��ϵ�������
			return true;
		}
		if("01".equals(zhsblx)){//��
			if(value != null){
				return false;
			}
		}
		return true;
	}

	/**
	 *�ӵؿ��ؿ��ϸ�Ӧ�������� JDKGKHGYDLNL
	 * ���򣺸��ݱ�׼�淶����д���������������дA�ࡢB��
	 */
	private boolean validateJdkgkhgydlnl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		if(StringUtils.isEmpty(value)) {//�ӵؿ��ؿ��ϸ�Ӧ��������
			return true;
		}
		if("1".equals(value) || "2".equals(value) || "3".equals(value)){
			return true;
		}
		return false;
	}

	/**
	 *  ���ʱ����ʱ��EDDSNSSJ
	 * ����750Ϊ2��330Ϊ3��110Ϊ3����4��35������Ϊ4��
	 */
	private boolean validateEddsnssj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		if(StringUtils.isEmpty(dydj)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//���ʱ����ʱ��
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
	 * ���XB       ����:1���࣬2���࣬3����
	 * ���������������ѡ�������豸����������Զ�����Ϊ��ABC��
	 */
	private boolean validateXb(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xs = row.get("XS");
		if(StringUtils.isEmpty(xs)) {
			return true;
		}
		if(StringUtils.isEmpty(value)) {//���
			return true;
		}
		if("3".equals(xs)){//����
			if(!"5".equals(value)){//ABC
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


}
