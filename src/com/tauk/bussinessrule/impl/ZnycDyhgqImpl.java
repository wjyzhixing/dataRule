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
 * ��ѹ������ҵ�����
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

        //���ѹ��
        if(field.equals("EDDYB")) {
        	if(!validateEddyb(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_EDDYB.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_EDDYB.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //�Ƶ��(Hz)
        if(field.equals("EDPL")) {
        	if(!validateEdpl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //Ͷ������
        if(field.equals("TYRQ")){
        	if(!validateTyrq(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
	     }

  

       /*
        * ����Ⱦ�(mm/kV)
        */
        if(field.equals("PDBJ")) {
        	if(!validatePdbj(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_PDBJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_PDBJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        /*
         * SF6���屨��ѹ��(Mpa)
         */
        if(field.equals("SF6QTBJYL")) {
        	if(!validateSf6qtbjyl(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_SF6QTBJYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_SF6QTBJYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        // ��ϵ�������
        if(field.equals("ZHDQKGGMC")){
        	if(!validateZhdqkggmc(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_ZHDQKGGMC.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_ZHDQKGGMC.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //�½�C1������(pF)
        if(field.equals("XJC1DRL")){
        	if(!validateXjc1drl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_XJC1DRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_XJC1DRL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //SF6����ѹ��(Mpa)
        if(field.equals("SF6QTEDYL")){
        	if(!validateSf6qtedyl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_SF6QTEDYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_SF6QTEDYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ��������������
        if(field.equals("ECRZZSL")){
        	if(!validateEcrzzsl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_ECRZZSL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_ECRZZSL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ���ѹ(kV)
        if(field.equals("EDDY")){
        	if(!validateEddy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_EDDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_EDDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

    

        //����������(��)
        if(field.equals("DRQJS")){
        	if(!validateDrqjs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_DRQJS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_DRQJS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // �Ͻڵ�����(pF)
        if(field.equals("SJDRL")){
        	if(!validateSjdrl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_SJDRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_SJDRL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // �½�C2������(pF)
        if(field.equals("XJC2DRL")){
        	if(!validateXjc2drl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DYHGQ_XJC2DRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DYHGQ_XJC2DRL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

	}
	
	
	
	 public int search(String str,String strRes) {//�����ַ�������ָ���ַ�����ͬ�ĸ���
	        int n=0;//������
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
	 * ���ѹ��,��� dyhgq0001
	 * ���򣺶�������������Ϊ��  ���м���0.1   ��3/0.1
	 */
	private boolean validateEddyb(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		
		String ecrzzsl = row.get("ECRZZSL");//��������������
		if(StringUtils.isEmpty(ecrzzsl)) {
			return true;
		}else{
			 double ecrzzsl_num = Double.parseDouble(ecrzzsl);
			String eddyb = row.get("EDDYB");//���ѹ��
			if(StringUtils.isEmpty(eddyb)) {
				return true;
			}
			int eddyb_num = search(eddyb,"��3/0.1");
			if(ecrzzsl_num != eddyb_num ) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * dyhgq0002
	 * �Ƶ��EDPL
	 * ����Ĭ��ֵ50
	 */
	private boolean validateEdpl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String edpl = row.get("EDPL");//�Ƶ��
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
	 * Ͷ������dyhgq0003
	 * ����Ͷ������ ���� ��������
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
	 *  ����Ⱦ� (mm/kV) PDBJ
	 * ���򣺷�Χ12.7��60.6
	 */
	private boolean validatePdbj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {

		String pdbj = row.get("PDBJ");//���
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
	 * SF6���屨��ѹ��(Mpa)	SF6QTBJYL  
	 * ����SF6��ѹ������������д ,��Ե���ʷ�SF6 ��0����
	 */
	private boolean validateSf6qtbjyl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//��Ե����
		String sf6qtbjyl = row.get("SF6QTBJYL");//SF6���屨��ѹ��(Mpa)
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
	 * ��ϵ�������	ZHDQKGGMC
	 * ���򣺵�������豸���� ��ѡ�񡰿��ع񡱻���ϵ�����ʱ��������д���������ع����ϵ��������ơ���������豸���͡�ѡ���񡱣������д��
	 * @param value    ZHDQKGGMC/
	 * @param row
	 * @return
	 */
	private boolean validateZhdqkggmc(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String zhsblx = row.get("ZHSBLX");//����豸����
		String zhdqkggmc = row.get("ZHDQKGGMC");//��ϵ���������
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
	 * �½�C1������(pF)	XJC1DRL
	 * ���򣺽ṹ��ʽ=�����ͣ�X>0;
	 * @param value    ZHDQKGGMC/
	 * @param row
	 * @return
	 */
	private boolean validateXjc1drl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jgxs = row.get("JGXS");//�ṹ��ʽ
		String xjc1drl = row.get("XJC1DRL");//�½�C1������(pF)
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
	 * SF6����ѹ��(Mpa)  SF6QTEDYL
	 * ����SF6��ѹ������������д ,��Ե���ʷ�SF6 ��0����
	 */
	private boolean validateSf6qtedyl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//��Ե����
		String sf6qtedyl = row.get("SF6QTEDYL");//SF6����ѹ��
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
	 * ��������������	ECRZZSL
	 * ����С�ڻ����4�����ѹ���С�0.1������=��������������   ��3/0.1
	 */
	private boolean validateEcrzzsl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		
		String ecrzzsl = row.get("ECRZZSL");//��������������
		if(StringUtils.isEmpty(ecrzzsl)) {
			return true;
		}
		if(!ecrzzsl.equals("") || !ecrzzsl.equals(" ") || !ecrzzsl.equals("null")) {
		double ecrzzsl_num = Double.parseDouble(ecrzzsl);
		String eddyb = row.get("EDDYB");//���ѹ��
		if(StringUtils.isEmpty(eddyb)) {
			return true;
		}
		int eddyb_num = search(eddyb,"��3/0.1");
		if(ecrzzsl_num == eddyb_num && ecrzzsl_num <=4) {
			return true;
		}
		}
		return false;
	}
	
	/**dyhgq0010
	 * ���ѹ(kV)	EDDY
	 * ���򣺰��豸������д�������ࣨABC�ࣩ�����Ե㲻����3�����ࣨ'A��', 'B��', 'C��', 'O��'���豸�������3��   ��3/0.1
	 */
private boolean validateEddy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		
	/*	String ecrzzsl = row.get("ECRZZSL");//��������������
		int ecrzzsl_num = Integer.valueOf(ecrzzsl);
		if(ecrzzsl==null) {
			return true;
		}
		String eddyb = row.get("EDDYB");//���ѹ��
		int eddyb_num = search(eddyb,"��3/0.1");

		if(ecrzzsl_num == eddyb_num && ecrzzsl_num <=4) {
			return true;
		}*/
		return true ;
	}
	
	
	/**
	 * �������,���dyhgq0011
	 * ����ѡ���豸��������ҡ�Ĭ��ֵΪ���й��� ���� 156
	 */

	
	/**dyhgq0012
	 * ����������(��)	DRQJS
	 * ����750kV:4�ڣ�330kV:3�ڣ�110kV��35kV��1�ڣ�����ʽ��ѹ��������д��
	 */
	private boolean validateDrqjs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {

		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		String drqjs = row.get("DRQJS");//����������(��)
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
	 * �Ͻڵ�����(pF)	SJDRL
	 * ���򣺽ṹ��ʽ=�����ͣ���ѹ�ȼ�>=220kV:X>0  ��ѹ�ȼ�С��220kV����  0   ����  �� /  ��\  ��ո� �� ����
	 */
	private boolean validateSjdrl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {

		String jgxs = row.get("JGXS");//�ṹ��ʽ 2  ����ʽ
		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		String sjdrl = row.get("SJDRL");//�Ͻڵ�����(pF)
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
				if(sjdrl_num == 0 || sjdrl.equals("") || sjdrl.equals(" ")|| sjdrl.equals("��")) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * dyhgq0014
	 * �½�C2������(pF)	XJC2DRL
	 * ���򣺽ṹ��ʽ=�����ͣ�X>0;
	 * @param value    ZHDQKGGMC/
	 * @param row
	 * @return
	 */
	private boolean validateXjc2drl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jgxs = row.get("JGXS");//�ṹ��ʽ
		String xjc2drl = row.get("XJC2DRL");//�½�C1������(pF)
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
