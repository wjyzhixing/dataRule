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
 * ��·��ҵ�����
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

        //  ���Եˮƽ
        if(field.equals("EDJYSP")) {
        	if(!validateEdjysp(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDJYSP.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_EDJYSP.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //�����(A)
        if(field.equals("EDDL")) {
        	if(!validateEddl(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_EDDL.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //��բʱ��(��׼ֵ)(ms)
        if(field.equals("FZSJ")){
        	if(!validateFzsj(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_FZSJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_FZSJ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
	     }

       /*
        * ��е����
        */
        if(field.equals("JXSM")) {
        	if(!validateJxsm(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_JXSM.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_JXSM.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        /*
         *  ��ϵ�������
         */
        if(field.equals("ZHDQKGGMC")) {
        	if(!validateZhdqkggmc(value,row,dataRuleMap)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_ZHDQKGGMC.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_ZHDQKGGMC.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        //  ��բ����(��)
        if(field.equals("HZDZ")){
        	if(!validateHzdz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_HZDZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_HZDZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //  ���ȶ�����ʱ��(s)
        if(field.equals("RWDCXSJ")){
        	if(!validateRwdcxsj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_RWDCXSJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_RWDCXSJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ���·�غϵ���(kA)
        if(field.equals("EDDLGHDL")){
        	if(!validateEddlghdl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDDLGHDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_EDDLGHDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //   ���·���ϵ���(kA)
        if(field.equals("EDDLKDDL")){
        	if(!validateEddlkddl(value,row)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDDLKDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_EDDLKDDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ���ȶ�����(kA)
        if(field.equals("DWDDL")){
        	if(!validateDwddl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_DWDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_DWDDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // �׹��������(mm)
        if(field.equals("TGPDJL")){
        	if(!validateTgpdjl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_TGPDJL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_TGPDJL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // �Ͽ�����
        if(field.equals("DKSL")){
        	if(!validateDksl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_DKSL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_DKSL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //  �Ե�й©�Ⱦ�(cm/kV)
        if(field.equals("DDXLBJ")){
        	if(!validateDdxlbj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_DDXLBJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_DDXLBJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //  ��բʱ��(���ȷ�Χ)(ms)
        if(field.equals("GYHZSJ")){
        	if(!validateGyhzsj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_GYHZSJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_GYHZSJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }
        
    //  ��բʱ��(��׼ֵ)(ms)
        if(field.equals("HZSJ")){
        	if(!validateHzsj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_HZSJ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_DLQ_HZSJ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }
        //  SF6�������ѹ��(Mpa)
        if(field.equals("SF6QTBSYL")){
        	if(!validateSf6qtbsyl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_SF6QTBSYL.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_SF6QTBSYL.getMessage();
        		recordErrData(datapk,code,message,field);
        	}
        }
        //  ��բʱ��(���ȷ�Χ)(ms)
        if(field.equals("GYFZSJ")){
        	if(!validateGyfzsj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_GYFZSJ.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_GYFZSJ.getMessage();
        		recordErrData(datapk,code,message,field);
        	}
        }
        //  �Ƶ��(Hz)
        if(field.equals("EDPL")){
        	if(!validateEdpl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDPL.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_EDPL.getMessage();
        		recordErrData(datapk,code,message,field);
        	}
        }
        //  Ͷ������
        if(field.equals("TYRQ")){
        	if(!validateTyrq(value,row)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_TYRQ.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_TYRQ.getMessage();
        		recordErrData(datapk,code,message,field);
        	}
        }
        //   ���ѹ(kV)
        if(field.equals("EDDY")){
        	if(!validateEddy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDDY.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_EDDY.getMessage();
        		recordErrData(datapk,code,message,field);
        	}
        }
   
        //   ʹ�û���
        if(field.equals("SYHJ")){
        	if(!validateSyhj(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_SYHJ.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_SYHJ.getMessage();
        		recordErrData(datapk,code,message,field);
        	}
        }
        //  ��բʱ��(��׼ֵ)(ms)
        if(field.equals("EDDLDLKDCS")){
        	if(!validateEddldlkdcs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_DLQ_EDDLDLKDCS.getCode());
        		String message = DataExceptionMessage.BUSSINESS_DLQ_EDDLDLKDCS.getMessage();
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
	 * ���Եˮƽ	EDJYSP,��� DLQ0001
	 * ����750kV������960"��"1550"��"2100����330kV����"510"��"950"��"1175"��110kV����"230"��"550"����ֵ��66kVΪ"160"��"350"����ֵ��35kV����"95"��"185"����ֵ��10kV����"42"��"75"����ֵ��6kVΪ"30","60","42"��"75"�ĸ�ֵ�� ���ѹ145 ���� 275 �� 650��
	 */
	private boolean validateEdjysp(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		
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
	 * DLQ0002
	 *   �����(A)	EDDL
	 * ���򣺶����Ӧ��������ֵ��ѡȡ��400��630��800��1000��1250��1600��2000��2500��3150��4000��5000�����ݵ�ѹ�ȼ���ͬ����ʵ����д����������Ϊ׼���ͺ���s��ͷ,����Ϊ1200,1500;��D��ͷ�Ŀ���Ϊ600
	 */
	private boolean validateEddl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
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
	 *  ��բʱ��(��׼ֵ)(ms)	FZSJ   DLQ0003
	 * ����10~100
	 * 
	 * @return
	 */
	private boolean validateFzsj(String value,Map<String,String> row) {

		String fzsj = row.get("FZSJ");//��բʱ��(��׼ֵ)(ms)
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
	 *   ��е����	JXSM 
	 * ����1000,2000,3000,5000,6000,10000,20000,30000��110kV������10000
	 */
	private boolean validateJxsm(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		String jxsm = row.get("JXSM");//��е����
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
	 * DLQ0006
	 * ��բ����(��)	HZDZ
	 * ����110kV�����µ�ѹ�ȼ�û�к�բ���裬���漰�˲�����д����дΪ0
	 */
	private boolean validateHzdz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		String hzdz = row.get("HZDZ");//��բ����(��)
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
	 *  ���ȶ�����ʱ��(s)	RWDCXSJ
	 * ����750kVΪ2��330kVΪ3��110kV������Ϊ4���������쳧˵���鰴ʵ����д��
	 */
	private boolean validateRwdcxsj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		String rwdcxsj = row.get("RWDCXSJ");//���ȶ�����ʱ��(s)
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
	 *   ���·�غϵ���(kA)	EDDLGHDL
	 * ������ֵ���ڶ��·���ϵ�����2.5��
	 * @param value   
	 * @param row     ���·���ϵ���(kA)  EDDLKDDL
	 * @return
	 */
	private boolean validateEddlghdl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String eddlghdl = row.get("EDDLGHDL");//���·�غϵ���(kA)
		String eddlkddl = row.get("EDDLKDDL");//���·���ϵ���(kA)
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
	 *   ���·���ϵ���(kA)	EDDLKDDL  DLQ0009
	 * ���򣺶��·���ϵ����Ľ���������ЧֵӦ��������ֵ��ѡȡ��6.3��8��10��12.5��16��20��25��31.5��40��50��63��80��100�����ݵ�ѹ�ȼ�����ʵ����д������������д��
	 * @return
	 */
	private boolean validateEddlkddl(String value,Map<String,String> row) {

		return true;
	}
	
	/**DLQ0010
	 *  ���ȶ�����(kA)	DWDDL
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
	
	
	
	/**
	 * DLQ0011
	 *    �׹��������(mm)	TGPDJL
	 *    
	 *    ����豸����	ZHSBLX    ���ع�  02
	 *    �ṹ��ʽ	JGXS        GIS   03
	 * ����750kV  10161~25404 330kV  4611~11527 110kV  1600~4605 66kV  1600~11527 35kV 489~1286 10kV 140~381 6kV 140~381����豸����Ϊ���ع��׹��������Ϊ0 ��ṹ��ʽΪGIS���׹��������Ϊ0
	 *     36                34                 32              30                25            22           21
	 */
	private boolean validateTgpdjl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		String tgpdjl = row.get("TGPDJL");//�׹��������(mm)
		String zhsblx = row.get("ZHSBLX");//����豸����
		String jgxs = row.get("JGXS");//�ṹ��ʽ
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
	 *    �Ͽ�����	DKSL 
	 * ���򣺶Ͽ�����ֻ��1��2������·��˵��������쳧��Ʒ����������д
	 */
	private boolean validateDksl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dksl = row.get("DKSL");//�Ͽ�����
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
	 *     �Ե�й©�Ⱦ�(cm/kV)	DDXLBJ
	 * ����1.8~6(����ͭ����ʵ�ⷴ������Χ��1.8~3.2����Ϊ1.8~6)
	 */
	private boolean validateDdxlbj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String ddxlbj = row.get("DDXLBJ");//�Ե�й©�Ⱦ�(cm/kV)
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
	 *      ��բʱ��(���ȷ�Χ)(ms)	GYHZSJ
	 * ����0~20
	 */
	private boolean validateGyhzsj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String gyhzsj = row.get("GYHZSJ");//��բʱ��(���ȷ�Χ)(ms)
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
	 *      ��բʱ��(��׼ֵ)(ms)	HZSJ
	 * ����30~200
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
		String hzsj = row.get("HZSJ");//��բʱ��(���ȷ�Χ)(ms)
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
	 * SF6�������ѹ��(Mpa)	SF6QTBSYL
	 * ����800kV��·����SF6�������ѹ��0.5Mpa��
	 *    85   
	 */
	private boolean validateSf6qtbsyl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		String sf6qtbsyl = row.get("SF6QTBSYL");//SF6�������ѹ��(Mpa)
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
	 *      ��բʱ��(���ȷ�Χ)(ms)	GYFZSJ
	 * ����0~20
	 */
	private boolean validateGyfzsj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String gyfzsj = row.get("GYFZSJ");//��բʱ��(���ȷ�Χ)(ms)
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
	 *  Ͷ������	TYRQ  DLQ0019
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
	 * DLQ0020
	 *  ���ѹ(kV)	EDDY
	 * ����һ���ѹ�ȼ�Ϊ6kV��10kV��20kV��35kV��66kV��110kV��330kV��750kV��Ӧ�Ķ��ѹ�ֱ�Ϊ��(6,7.2)��(10,12)��(20,24)��(35,40.5)(66,72.5)��(110,126,145)��(330,363,420)��800��
	 *                21   22   24   25    30    32    34     36
	 */
	private boolean validateEddy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		String eddy = row.get("EDDY");//���ѹ(kV)
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
	 * �������,���DLQ0021
	 * ����ѡ���豸��������ҡ�Ĭ��ֵΪ���й��� ���� 156
	 */


	
	/**
	 * DLQ0022
	 *   ʹ�û���	SYHJ
	 * �����ͺ��к���N������Ϊ����ʽ 
	 *                  2
	 */
	private boolean validateSyhj(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//�ͺ�
		String syhj = row.get("SYHJ");//ʹ�û���
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
	 *   ���·�������ϴ���(��)	EDDLDLKDCS
	 * ����һ������40.5kV�����µ���ն�·���ĵ�����Ҳ�ɰ����¹涨ѡȡ��a�� ���·���ϵ���Ϊ31.5kA������ʱ��������������·�����Ŀ��ϴ�������������ֵ��ѡȡ��10��30��50�Ρ�b�����·���ϵ���Ϊ40��63kAʱ��������������·�����Ŀ��ϴ�������������ֵ��ѡȡ�� 16��20��30�Ρ�                                              ��������40.5kV���ϵ�SF6��ѹ��·��������ж��·���ϵ����µ����������������飨���������飩����·����������·�п����õ��������Ҫά�޵�����£����������϶��·���ϵ����Ĵ���Ӧ��������ֵ��ѡȡ��16��20��25��
	 * @param value
	 *   
	 * @param row
	 * @return
	 */
	private boolean validateEddldlkdcs(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		/*String dydj = row.get("DYDJ");//��ѹ�ȼ�
		String eddldlkdcs = row.get("EDDLDLKDCS");//���·�������ϴ���
		String  dydj_max = "37,36,35,34,33,32,31,30,91,86,85,84,92,93,83,82,88,87,90,81,80,78";
		*/
		
		return true;
	}
	
}
