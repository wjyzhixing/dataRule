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
 * ����ѹ��ҵ�����
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

        //��Ե����
        if(field.equals("JYJZ")) {
        	if(!validateJyjz(value,row,dataRuleMap)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_JYJZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_JYJZ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //Ͷ������
        if(field.equals("TYRQ")) {
        	if(!validateTyrq(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_TYRQ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_TYRQ.getMessage();
    			recordErrData(datapk,code,message,field);
            }
        }

        //��ѹ��
        if(field.equals("DYB")){
        	if(!validateDyb(value,row)) {
            	String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_DYB.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_DYB.getMessage();
    			recordErrData(datapk,code,message,field);
            }
	     }

        //�����
        if(field.equals("EDDL")) {
        	if(!validateEddl(value,row)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_EDDL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_EDDL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

       /*
        * ��·�迹(��ѹ-��ѹ) (kW)
        * ��·�迹(��ѹ-��ѹ)
        */
        if(field.equals("DLZKGYDY")) {
        	if(!validateFZSHGYDY(value,row)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_DLZKGYDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_DLZKGYDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        /*
         * �����(MVA)
         */
        if(field.equals("EDRL")) {
        	if(!validateEDRL(value,row)) {
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_EDRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_EDRL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        // ������ʽ
        if(field.equals("RZXS")){
        	if(!validateRzxs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_RZXS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_RZXS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //��ȴ��ʽLQFS
        if(field.equals("LQFS")){
        	if(!validateLqfs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_LQFS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_LQFS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //��ѹ��ʽDYFS
        if(field.equals("DYFS")){
        	if(!validateDyfs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_DYFS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_DYFS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ��·�迹��ѹ����ѹDLZKZYDY
        if(field.equals("DLZKZYDY")){
        	if(!validateDlzkzydy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_DLZKZYDY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_DLZKZYDY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // �������(����)FZSHMZ
        if(field.equals("FZSHMZ")){
        	if(!validateFzshmz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_FZSHMZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_FZSHMZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //����ȴ����ZLQRL
        if(field.equals("ZLQRL")){
        	if(!validateZlqrl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_ZLQRL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_ZLQRL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //�ͺ�YH
        if(field.equals("YH")){
        	if(!validateYh(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_YH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_YH.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // �Ͳ���YCD
        if(field.equals("YCD")){
        	if(!validateYcd(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_YCD.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_YCD.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        // ��·�迹��ѹ����ѹDLZKGYZY
        if(field.equals("DLZKGYZY")){
        	if(!validateDlzkgyzy(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_DLZKGYZY.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_DLZKGYZY.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //����ZZ
        if(field.equals("ZZ")){
        	if(!validateZz(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_ZZ.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_ZZ.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //����XS
        if(field.equals("XS")){
        	if(!validateXs(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_XS.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_XS.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //�������KZSH
        if(field.equals("KZSH")){
        	if(!validateKzsh(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_KZSH.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_KZSH.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //�Ƶ��EDPL
        if(field.equals("EDPL")){
        	if(!validateEdpl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_EDPL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_EDPL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        // ��Ȼ��ȴ����ZSSP
        if(field.equals("ZSSP")){
        	if(!validateZssp(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_ZSSP.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_ZSSP.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


        //SF6���屨��ѹ��(Mpa)  SF6QTBJYL
        if(field.equals("SF6QTBJYL")){
        	if(!validateSf6qtbjyl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_SF6QTBJYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_SF6QTBJYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }

        //SF6����ѹ��(Mpa)  SF6QTEDYL
        if(field.equals("SF6QTEDYL")){
        	if(!validateSf6qtedyl(value,row,dataRuleMap)){
        		String code = String.valueOf(DataExceptionMessage.BUSSINESS_ZBYQ_SF6QTEDYL.getCode());
    			String message = DataExceptionMessage.BUSSINESS_ZBYQ_SF6QTEDYL.getMessage();
    			recordErrData(datapk,code,message,field);
        	}
        }


	}


	/**
	 * ��Ե����,���zbyq0001
	 * �����豸�ͺ��к�G��CΪ��ʽ������Ϊ�ͽ�
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
			if(!selecttexts[i].equals("��ʽ")){
			  return false;
			}
		}
		return true;
	}

	/**
	 * Ͷ������zbyq0002
	 * ����Ͷ������ ���� ��������
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
	 * ��ѹ��:zbyq0003
	 * ���򣺵�ѹ����������ʽ��أ�˫�����ѹ������һ����/�����������ѹ������������/����
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
		//˫����
		if(rzxs.equals("1")) {
			if(values.length!=2) {
				return false;
			}
		}
		//������
		if(rzxs.equals("2")) {
			if(values.length!=3) {
				return false;
			}
		}
		return true;
	}

	/**
	 * �����:zbyq0004
	 * ���򣺶������: (�����)*1000/(��ѹ��*1.732)��Χ�ڡ�����ѹ�Σ�750(765)��330(��363)��110(��126)��63(��76.5)��35(��38.5)��10(��11)��
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
		//330(��363)
		if((((Double.valueOf(edrl)*1000)/(330*1.732))>=dvalue)&&(dvalue>=((Double.valueOf(edrl)*1000)/(363*1.732)))) {
			return true;
		}
		//110(��126)
		if((((Double.valueOf(edrl)*1000)/(110*1.732))>=dvalue)&&(dvalue>=((Double.valueOf(edrl)*1000)/(126*1.732)))) {
			return true;
		}
		//63(��76.5)
		if((((Double.valueOf(edrl)*1000)/(63*1.732))>=dvalue)&&(dvalue>=((Double.valueOf(edrl)*1000)/(76.5*1.732)))) {
			return true;
		}
		//35(��38.5)
		if((((Double.valueOf(edrl)*1000)/(35*1.732))>=dvalue)&&(dvalue>=((Double.valueOf(edrl)*1000)/(38.5*1.732)))) {
			return true;
		}
		//10(��11)
		if((((Double.valueOf(edrl)*1000)/(10*1.732))>=dvalue)&&(dvalue>=((Double.valueOf(edrl)*1000)/(11*1.732)))) {
			return true;
		}
		return false;
	}

	/** ��·�迹��ѹ����ѹ:zbyq0005
	 *       ����˫���飺����Ϊ�ա�
                     �����顢�����·�迹����ѹ-��ѹ��>��·�迹����ѹ-��ѹ��
	 */
	private boolean validateFZSHGYDY(String value,Map<String,String> row) {
		//��·�迹����ѹ-��ѹ��
		String FZSHGYZY = row.get("FZSHGYZY");
		//˫���顢�����顢��ż  (1��2��3)
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

	/** �����:zbyq0006
	 *       �ͺ� ��-��/ ֮�������1000
	 */
	private boolean validateEDRL(String value,Map<String,String> row) {
		//��·�迹����ѹ-��ѹ��
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
	 * ������ʽ
	 * ����˫����(�ͺ��н���1��S)��������(�ͺ�����2��S)������(�ͺ�����ĸΪO) (O��ͷ������˫S��Ϊ������)
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
				if(!"2".equals(selectvalues[i])){//������
					  return false;
				}
			}
			if(!"3".equals(selectvalues[i])){//��ż
			  return false;
			}
		}else{
			if(xh.indexOf("SS")!=-1){
				if(!"2".equals(selectvalues[i])){//������
					  return false;
				}
			}else if(xh.indexOf("S")!=-1){
				if(!"1".equals(selectvalues[i])){//˫����
					  return false;
				}
			}
		}
		return true;
	}

	/**
	 * ��ȴ��ʽ
	 * ���򣺶����ͽ�ʽ��ѹ��
	 * �ͺ��а�����F���͡�P���ģ�ѡ��ǿ����ѭ��(����)���䡱��
	 * �ͺ��н��С�F��û�С�P����ѡ����Ȼ��ѭ�����䡱��
	 * �ͺ��м��ޡ�F�����ޡ�P���ģ�ѡ����Ȼ��ȴ��
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
		//�豸�ͺ��к�G��CΪ��ʽ������Ϊ�ͽ�
		if(xh.indexOf("G")==-1 && xh.indexOf("C")==-1) {//�ͽ�ʽ
			if(xh.indexOf("F")!=-1 && xh.indexOf("P")!=-1){
				if(!"5".equals(selectvalues[i])){//ǿ����ѭ���������(ODAF)
					return false;
				}
			}
			if(xh.indexOf("F")!=-1 && xh.indexOf("P")==-1){
				if(!"2".equals(selectvalues[i])){//��Ȼ��ѭ������(ONAF)
					return false;
				}
			}
			if(xh.indexOf("F")==-1 && xh.indexOf("P")==-1){
				if(!"1".equals(selectvalues[i])){//��Ȼ��ȴ/�ͽ�����(ONAN)
					return false;
				}
			}
		}

		return true;
	}


	/**
	 *  ��ѹ��ʽ
	 * �����ͺ��к���Z����Ϊ���ص�ѹ���ޡ�Z��Ϊ�����ŵ�ѹ���޵�ѹ����ʵ��д���ͺ��к���'��'һ����Ϊ����ѹ,�޵�ѹ���豸�ͺ��в��ܺ���'��'
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
			if(!"1".equals(selectvalues[i])){//���ص�ѹ
				return false;
			}
		}else{
			if(!"2".equals(selectvalues[i]) && !"3".equals(selectvalues[i])){//�����ŵ�ѹ���޵�ѹ
				return false;
			}
		}
		if(xh.indexOf("��")!=-1){
			if("3".equals(selectvalues[i])){//һ����Ϊ����ѹ
				return false;
			}
		}

		return true;
	}

	/**
	 *  ��·�迹��ѹ����ѹ
	 * ����˫���飺X=0���޻�/��\��ո� �����顢����40��X>0,С�ڸ�ѹ-��ѹ
	 */
	private boolean validateDlzkzydy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String rzxs = row.get("RZXS");//������ʽ
		if(StringUtils.isEmpty(rzxs)) {
			return true;
		}

		String dlzkzydy = row.get("DLZKZYDY");//��·�迹��ѹ����ѹ
		BigDecimal zydy = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(dlzkzydy)){
			zydy = new BigDecimal(dlzkzydy);
		}
		String dlzkgydy = row.get("DLZKGYDY");//��·�迹��ѹ-��ѹ
		BigDecimal gydy = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(dlzkgydy)){
			gydy = new BigDecimal(dlzkgydy);
		}

		if("1".equals(rzxs)) {//˫����
			//X=0���޻�/��\��ո�
			if(!"��".equals(dlzkzydy)
					&& !" ".equals(dlzkzydy)
					&& !"/".equals(dlzkzydy)
					&& !"\\".equals(dlzkzydy)
					&& zydy.compareTo(new BigDecimal(0.0000)) != 0){
				return false;
			}
		}else if("2".equals(rzxs) ||"3".equals(rzxs)){//�����顢����
			//40��X>0,С�ڸ�ѹ-��ѹ    zydy > 40 || zydy<=0 || gydy<zydy
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
	 *  �������(����)FZSHMZ
	 * ���򣺲��ѹ���������ϣ�ֻ��д���֣�ȡֵ��Χ:��ѹ�ȼ�Խ�͡���������ԽС����ֵԽС���Ҹ�ֵ������10���Ŀ������ֵ��
	 * һ���ڿ������ֵ��7�����¡�
	 * 35kV���䣬��ֵһ����10~90��
	 * 110kV���䣬��ֵһ����35~450��
	 * 330kV���䣬��ֵһ����230~950(�������>������ġ�0)
	 */
	private boolean validateFzshmz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		if(StringUtils.isEmpty(dydj)) {
			return true;
		}

		String mzfzsh = row.get("FZSHMZ");//�������(����)
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
	 * ����ȴ����ZLQRL
	 * ������ȴ��ʽ=OFAF��0��ONAN�100����ONAF�������޲������66����ȡֵ��Χ:50��ZLQRL��100
	 */
	private boolean validateZlqrl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String lqfs = row.get("LQFS");//��ȴ��ʽ
		if(StringUtils.isEmpty(lqfs)) {
			return true;
		}

		String zlqrl = row.get("ZLQRL");//����ȴ����
		BigDecimal zlq = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(zlqrl)){
			zlq = new BigDecimal(zlqrl);
		}

		if("3".equals(lqfs)) {//ǿ����ѭ������(OFAF)
			if(zlq.compareTo(new BigDecimal(0.0000)) != 0){
				return false;
			}
		}else if("1".equals(lqfs)){//��Ȼ��ȴ/�ͽ�����(ONAN)
			if(zlq.compareTo(new BigDecimal(100.0000)) != 0){
				return false;
			}
		}else if("2".equals(lqfs)){//��Ȼ��ѭ������(ONAF)
			if(zlq.compareTo(new BigDecimal(66.0000)) != 0){
				return false;
			}
		}

		return true;
	}

	/**
	 * �ͺ�YH
	 * �����ͽ�ʽ��ѹ��ȫ����д��25��45�����ִ����ѹ���͵����̵㣬45Ϊ����45�����̡�25Ϊ����25�����̡�������Ϊ25��
	 * ���ͽ�ʽ��ѹ����дΪ��
	 */
	private boolean validateYh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//�ͺ�
		if(StringUtils.isEmpty(xh)) {
			return true;
		}

		String yh = row.get("YH");//�ͺ�

		//�豸�ͺ��к�G��CΪ��ʽ������Ϊ�ͽ�
		if(xh.indexOf("G")==-1 && xh.indexOf("C")==-1) {//�ͽ�ʽ
			if(!"25".equals(yh) && !"45".equals(yh)){
				return false;
			}
		}else {
			if(!"��".equals(yh)){
				return false;
			}
		}
		return true;
	}


	/**
	 * �Ͳ���YCD
	 * �����ͽ���ѹ����д�½��������������������ͽ���д�޻�/
	 */
	private boolean validateYcd(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String xh = row.get("XH");//�ͺ�
		if(StringUtils.isEmpty(xh)) {
			return true;
		}

		String yh = row.get("YCD");//�Ͳ���

		//�豸�ͺ��к�G��CΪ��ʽ������Ϊ�ͽ�
		if(xh.indexOf("G")==-1 && xh.indexOf("C")==-1) {//�ͽ�ʽ
			if(!"�½���������".equals(yh) && !"��������".equals(yh) && !"����".equals(yh)){
				return false;
			}
		}else {
			if(!"��".equals(yh) && !"/".equals(yh)){
				return false;
			}
		}
		return true;
	}

	/**
	 * ��·�迹��ѹ����ѹ
	 * ����˫���飺X=0���޻�/��\��ո� �����顢���ȡֵ��Χ:20��X>0����·�迹����ѹ-��ѹ��>��·�迹����ѹ-��ѹ��
	 */
	private boolean validateDlzkgyzy(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String rzxs = row.get("RZXS");//������ʽ
		if(StringUtils.isEmpty(rzxs)) {
			return true;
		}

		String dlzkgyzy = row.get("DLZKGYZY");//��·�迹��ѹ����ѹ
		BigDecimal gyzy = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(dlzkgyzy)){
			gyzy = new BigDecimal(dlzkgyzy);
		}
		String dlzkgydy = row.get("DLZKGYDY");//��·�迹��ѹ-��ѹ
		BigDecimal gydy = new BigDecimal(0.0000);
		if(!StringUtils.isEmpty(dlzkgydy)){
			gydy = new BigDecimal(dlzkgydy);
		}

		if("1".equals(rzxs)) {//˫����
			//X=0���޻�/��\��ո�
			if(!"��".equals(dlzkgyzy)
					&& !" ".equals(dlzkgyzy)
					&& !"/".equals(dlzkgyzy)
					&& !"\\".equals(dlzkgyzy)
					&& gyzy.compareTo(new BigDecimal(0.0000)) != 0){
				return false;
			}
		}else if("2".equals(rzxs) ||"3".equals(rzxs)){//�����顢����
			//20��X>0����·�迹����ѹ-��ѹ��>��·�迹����ѹ-��ѹ��    gyzy > 20 || gyzy<=0 || gydy<gyzy
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
	 * ����ZZ
	 * ����330kV 100-400T    110kV 20-120T
	 */
	private boolean validateZz(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		if(StringUtils.isEmpty(dydj)) {
			return true;
		}

		String zz = row.get("ZZ");//����
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
	 * ����XS   1���࣬2���࣬3����
	 * �����豸�ͺ��к���ĸ��D����Ϊ����
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
	 * �������KZSH
	 * ���򣺲��ѹ���������ϣ�ֻ��д����,ȡֵ��Χ:��ѹ�ȼ�Խ�͡���������ԽС����ֵԽС��
	 * 35kV���䣬��ֵһ����1~20��
	 * 110kV���䣬��ֵһ����10~75��
	 * 330kV���䣬��ֵһ����30~260(�������>������ġ�0)
	 */
	private boolean validateKzsh(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String dydj = row.get("DYDJ");//��ѹ�ȼ�
		if(StringUtils.isEmpty(dydj)) {
			return true;
		}

		String kzsh = row.get("KZSH");//�������
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
	 * �Ƶ��EDPL
	 * ����Ĭ��ֵ50
	 */
	private boolean validateEdpl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String edpl = row.get("EDPL");//�Ƶ��
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
	 * ��Ȼ��ȴ����ZSSP
	 * ����ȡֵ��Χ��50~80������Ӧѡ��һ�㣬ֻ��д���ֶ�����д�ַ���dB��
	 */
	private boolean validateZssp(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String zssp = row.get("ZSSP");//����ˮƽ
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
	 * SF6���屨��ѹ��(Mpa)  SF6QTBJYL
	 * ����SF6��ѹ������������д ,��Ե���ʷ�SF6 ��0����
	 */
	private boolean validateSf6qtbjyl(String value,Map<String,String> row,Map<String,String> dataRuleMap) {
		String jyjz = row.get("JYJZ");//��Ե����
		String sf6qtbjyl = row.get("SF6QTBJYL");//SF6���屨��ѹ��
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

}
