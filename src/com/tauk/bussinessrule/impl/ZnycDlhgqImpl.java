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
 * ����������ҵ�����
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

        // �����(A)
        if(field.equals("EDDL")) {
        	if(!validateEddl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_EDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_EDDL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //���ȶ�����(kA)
        if(field.equals("RWDDL")) {
        	if(!validateRwddl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_RWDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_RWDDL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //��������������(��)
        if(field.equals("ECRZZSL")){
        	if(!validateEcrzzsl(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_ECRZZSL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_ECRZZSL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
	     }

       /*
        * SF6���屨��ѹ��(Mpa)
        */
        if(field.equals("SF6QTBJYL")) {
        	if(!validateSf6qtbjyl(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_SF6QTBJYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_SF6QTBJYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        /*
         *  SF6����ѹ��(Mpa)
         */
        if(field.equals("SF6QTEDYL")) {
        	if(!validateSf6qtedyl(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_SF6QTEDYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_SF6QTEDYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        //  �Ƶ��(Hz)
        if(field.equals("EDPL")){
        	if(!validateEdpl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // Ͷ������
        if(field.equals("TYRQ")){
        	if(!validateTyrq(value,row)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //���ѹ(kV)
        if(field.equals("EDDY")){
        	if(!validateEddy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_EDDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_EDDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ���ѹ(kV)
        if(field.equals("EDDY")){
        	if(!validateEddy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_EDDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_EDDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

 

        // ���ȶ�����(kA)
        if(field.equals("DWDDL")){
        	if(!validateDwddl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_DWDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_DWDDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //  ��ϵ�������
        if(field.equals("ZHDQKGGMC")){
        	if(!validateZhdqkggmc(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_ZHDQKGGMC.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_ZHDQKGGMC.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //  SF6������С����ѹ��(Mpa)
        if(field.equals("SF6QTZXYXYL")){
        	if(!validateSf6qtzxyxyl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_SF6QTZXYXYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_SF6QTZXYXYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }
        
    //  ��߹�����ѹ(kV)
        if(field.equals("ZDCXDY")){
        	if(!validateZdcxdy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLHGQ_ZDCXDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLHGQ_ZDCXDY.getMessage();
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
	 *  �����(A) EDDL,��� dlhgq0001
	 * ���򣺶�������ڶ��������һ�ε���ֵ����ѡ�ã�'5','6','40','50','100','150','200','300','500','600','1200', '1500', '400', '630', '800', '1000', '1250','1600', '2000', '2500', '3000','3150', '4000', '5000'��
	 */
	private boolean validateEddl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		
		/*String ecrzzsl = row.get("ECRZZSL");//��������������
		if(ecrzzsl==null) {
			return true;
		}
		if(!ecrzzsl.equals("") || !ecrzzsl.equals(" ") || !ecrzzsl.equals("null")) {
		int ecrzzsl_num = Integer.valueOf(ecrzzsl);
		
		String eddyb = row.get("EDDYB");//���ѹ��
		int eddyb_num = search(eddyb,"0.1");

		if(ecrzzsl_num == eddyb_num ) {
			return true;
		}
		}*/
		return true;
	}

	/**
	 * dlhgq0002
	 *  ���ȶ�����(kA)	RWDDL
	 * ���򣺶��ʱ�ȵ���ͨ��Ϊ6.3��8��10��12.5��16��20��25��31.5��40��45��50��63��80��100��kA��
	 */
	private boolean validateRwddl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		/*String edpl = row.get("EDPL");//�Ƶ��
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
	 *  ��������������(��)	ECRZZSL   dlhgq0003
	 * ���򣺵�ѹ�ȼ���35kv��6��X>0;����9��X>0
	 * 
	 * @return
	 */
	private boolean validateEcrzzsl(String value,Map<String,String> row) {

		
		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		String ecrzzsl = row.get("ECRZZSL");//��������������(��))
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
	 *   SF6���屨��ѹ��(Mpa)	SF6QTBJYL
	 * ���򣺸����豸���ƻ����������д����λ��Mpa����Ե���ʲ���SF6�ģ�Ӧ����д��
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
	 * dlhgq0005
	 * SF6����ѹ��(Mpa)	SF6QTEDYL
	 * ����SF6��ѹ������������д ,��Ե���ʷ�SF6 ��0����
	 */
	private boolean validateSf6qtedyl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//��Ե����
		String sf6qtedyl = row.get("SF6QTEDYL");//SF6���屨��ѹ��(Mpa)
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
	 *  �Ƶ��(Hz)	EDPL
	 * ����Ĭ�� 50
	 * @param value   
	 * @param row
	 * @return
	 */
	private boolean validateEdpl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String edpl = row.get("EDPL");//�Ƶ��
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
	 *  Ͷ������	TYRQ  dlhgq0007
	 * ����Ͷ������ ���� ��������
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
	 *  ���ѹ(kV)	EDDY
	 * ���򣺵�ѹ 10,12�� 110��126 ��330��363 ��35��40.5�� 20,24��6���
	 */
	private boolean validateEddy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		
		
		return true;
	}
	
	/**
	 * �������,���dlhgq0009
	 * ����ѡ���豸��������ҡ�Ĭ��ֵΪ���й��� ���� 156
	 */
	
	
	
	/**dlhgq0010
	 *  ���ȶ�����(kA)	DWDDL      ���ȶ����� RWDDL
	 * ���򣺶��ȶ������������ȶ�������2.5�����������ƻ�˵���鳭¼                 
	 */
	private boolean validateDwddl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dwddl = row.get("DWDDL");//���ȶ�����(kA)
		String rwddl = row.get("RWDDL");//���ȶ�����
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
	 *  ��ϵ�������	ZHDQKGGMC
	 * ����ѡ���񡱣������д��ѡ����ϵ�����������豸���������������ϵ�������ѡ�����ع񡱣�����豸����������������ع񡱣�
	 * 
	 * ��,���ع�,��ϵ���,��������������װ��,������Ȧ����װ��,������,�ӵر����װ��,�翹������װ��,վ�ڻ�����	
	 * 01,02,03,10,11,15,16,17,19
	 */
	private boolean validateZhdqkggmc(String value,Map<String,String> row,Map<String,String> dataRuleMap) {

		String zhsblx = row.get("ZHSBLX");//����豸����
		String zhdqkggmc = row.get("ZHDQKGGMC");//��ϵ�������
		if(StringUtils.isEmpty(zhdqkggmc)) {
			return true;
		}
		if("01".equals(zhsblx)) {
			if(!zhdqkggmc.equals("") || !zhdqkggmc.equals(" ")) {
				return false;
			}
		}else if("02".equals(zhsblx)) {
			if(!zhdqkggmc.contains("���ع�")) {
				return false;
			}
		}else if("03".equals(zhsblx)) {
			if(!zhdqkggmc.contains("��ϵ���")) {
				return false;
			}
		}else if("10".equals(zhsblx)) {
			if(!zhdqkggmc.contains("��������������װ��")) {
				return false;
			}
		}else if("11".equals(zhsblx)) {
			if(!zhdqkggmc.contains("������Ȧ����װ��")) {
				return false;
			}
		}else if("15".equals(zhsblx)) {
			if(!zhdqkggmc.contains("������")) {
				return false;
			}
		}else if("16".equals(zhsblx)) {
			if(!zhdqkggmc.contains("�ӵر����װ��")) {
				return false;
			}
		}else if("17".equals(zhsblx)) {
			if(!zhdqkggmc.contains("�翹������װ��")) {
				return false;
			}
		}else if("19".equals(zhsblx)) {
			if(!zhdqkggmc.contains("վ�ڻ�����")) {
				return false;
			}
		}
		
		return true;
	}
	
	
	/**
	 * dlhgq0012
	 *  SF6������С����ѹ��(Mpa)	SF6QTZXYXYL
	 * ����SF6��ѹ������������д ,��Ե���ʷ�SF6 ��0����
	 */
	private boolean validateSf6qtzxyxyl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//��Ե����
		String sf6qtzxyxyl = row.get("SF6QTZXYXYL");//SF6������С����ѹ��(Mpa)
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
	 *  ��߹�����ѹ(kV)	ZDCXDY
	 * ���򣺱�ʡ����Ϊ750��500kVֱ����330��110��66��35��20��10��6��Ҫ���ѹ�ȼ�С�ڵ��ڱ��վ���е�ѹ
	 * @param value
	 * @param row
	 * @return
	 */
	private boolean validateZdcxdy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
	
		return true;
	}
	
}
