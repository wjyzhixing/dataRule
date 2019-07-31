package com.tauk.datarule.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.tauk.bussinessrule.impl.ZnycBlqImpl;
import com.tauk.bussinessrule.impl.ZnycDkqImpl;
import com.tauk.bussinessrule.impl.ZnycDldrqImpl;
import com.tauk.bussinessrule.impl.ZnycDlhgqImpl;
import com.tauk.bussinessrule.impl.ZnycDlqImpl;
import com.tauk.bussinessrule.impl.ZnycDyhgqImpl;
import com.tauk.bussinessrule.impl.ZnycGlkgImpl;
import com.tauk.bussinessrule.impl.ZnycJdbImpl;
import com.tauk.bussinessrule.impl.ZnycKggImpl;
import com.tauk.bussinessrule.impl.ZnycMxImpl;
import com.tauk.bussinessrule.impl.ZnycPdbyqImpl;
import com.tauk.bussinessrule.impl.ZnycSybImpl;
import com.tauk.bussinessrule.impl.ZnycZbyqImpl;
import com.tauk.bussinessrule.impl.ZnycZhdqImpl;
import com.tauk.datarule.base.Request;
import com.tauk.datarule.base.Response;
import com.tauk.datarule.base.RuleChain;
import com.tauk.datarule.dao.IDataRuleDao;
import com.tauk.datarule.dao.IDataSourceDao;
import com.tauk.datarule.dao.IDataStatisticDao;
import com.tauk.datarule.dao.IProblemBillDao;
import com.tauk.datarule.dao.IRuleLogDao;
import com.tauk.datarule.dao.IZnycBlqDao;
import com.tauk.datarule.dao.IZnycDkqDao;
import com.tauk.datarule.dao.IZnycDldrqDao;
import com.tauk.datarule.dao.IZnycDlhgqDao;
import com.tauk.datarule.dao.IZnycDlqDao;
import com.tauk.datarule.dao.IZnycDyhgqDao;
import com.tauk.datarule.dao.IZnycGlkgDao;
import com.tauk.datarule.dao.IZnycJdbDao;
import com.tauk.datarule.dao.IZnycKggDao;
import com.tauk.datarule.dao.IZnycMxDao;
import com.tauk.datarule.dao.IZnycPdbyqDao;
import com.tauk.datarule.dao.IZnycSybDao;
import com.tauk.datarule.dao.IZnycZbyqDao;
import com.tauk.datarule.dao.IZnycZhdqDao;
import com.tauk.datarule.dao.factory.DAOFactory;
import com.tauk.datarule.exception.DataExceptionMessage;
import com.tauk.datarule.impl.DataRangeRule;
import com.tauk.datarule.impl.DateTypeRule;
import com.tauk.datarule.impl.NotNullRule;
import com.tauk.datarule.impl.NumberTypeRule;
import com.tauk.datarule.impl.SelectTypeRule;
import com.tauk.datarule.impl.VarcharTypeRule;
import com.tauk.datarule.model.ProblemBill;
import com.tauk.datarule.model.RuleLog;
import com.tauk.datarule.model.WZJSCS;

public class MainApplication {

	public static void testNumberDataRange(Map<String,String> requestData,Map<String,String> dataRule) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
        //������̽�������������Ӧ
        Response response=new Response();
        
        //FilterChain,���˹����γɵ���������
        RuleChain fc=new RuleChain();
        //����������ӹ��˹��򣬲��õ�����ʽ����
        fc.addRule(new NotNullRule())
          .addRule(new NumberTypeRule())
          .addRule(new DataRangeRule());
        
        //����FilterChain�Ĺ���˳������Ӧ�ù��˹���
        fc.applyRule(request, response,fc);
}
	
	public static void testNumber(Map<String,String> requestData,Map<String,String> dataRule) {
		    Request request=new Request();
		    request.setRequestData(requestData);
		    request.setDataRule(dataRule);
	        //������̽�������������Ӧ
	        Response response=new Response();
	        
	        //FilterChain,���˹����γɵ���������
	        RuleChain fc=new RuleChain();
	        //����������ӹ��˹��򣬲��õ�����ʽ����
	        fc.addRule(new NotNullRule())
	          .addRule(new NumberTypeRule());
	          //.addRule(new DataRangeRule());
	        //����FilterChain�Ĺ���˳������Ӧ�ù��˹���
	        fc.applyRule(request, response,fc);
	}
	
	public static void testVarchar(Map<String,String> requestData,Map<String,String> dataRule) {
		 Request request=new Request();
		    request.setRequestData(requestData);
		    request.setDataRule(dataRule);
		   
	        //������̽�������������Ӧ
	        Response response=new Response();
	        
	        //FilterChain,���˹����γɵ���������
	        RuleChain fc=new RuleChain();
	        //����������ӹ��˹��򣬲��õ�����ʽ����
	        fc.addRule(new NotNullRule())
	          .addRule(new VarcharTypeRule());
	        //����FilterChain�Ĺ���˳������Ӧ�ù��˹���
	        fc.applyRule(request, response,fc);
	}
	
	public static void testSelect(Map<String,String> requestData,Map<String,String> dataRule) {
		    Request request=new Request();
		    request.setRequestData(requestData);
		    request.setDataRule(dataRule);
	        
	        //������̽�������������Ӧ
	        Response response=new Response();
	        
	        //FilterChain,���˹����γɵ���������
	        RuleChain fc=new RuleChain();
	        //����������ӹ��˹��򣬲��õ�����ʽ����
	        fc.addRule(new NotNullRule()).addRule(new VarcharTypeRule()).addRule(new SelectTypeRule());
	        //����FilterChain�Ĺ���˳������Ӧ�ù��˹���
	        fc.applyRule(request, response,fc);
	}
	
	
	public static void testDate(Map<String,String> requestData,Map<String,String> dataRule) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
        //������̽�������������Ӧ
        Response response=new Response();
        
        //FilterChain,���˹����γɵ���������
        RuleChain fc=new RuleChain();
        //����������ӹ��˹��򣬲��õ�����ʽ����
        fc.addRule(new NotNullRule()).addRule(new DateTypeRule());
        //����FilterChain�Ĺ���˳������Ӧ�ù��˹���
        fc.applyRule(request, response,fc);
    }
	
	/**
	 * ��������ѹ����ҵ�����
	 * @param requestData
	 * @param dataRule
	 */
	public static void testZbyqBusiness(Map<String,String> requestData,Map<String,String> dataRule,Map<String,String> row) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
	    request.setRow(row);
        //������̽�������������Ӧ
        Response response=new Response();
        
        //FilterChain,���˹����γɵ���������
        RuleChain fc=new RuleChain();
        //����������ӹ��˹��򣬲��õ�����ʽ����
        fc.addRule(new ZnycZbyqImpl());
        //����FilterChain�Ĺ���˳������Ӧ�ù��˹���
        fc.applyRule(request, response,fc);
    }
	
	/**
	 * ���Կ��ع��ҵ�����
	 * @param requestData
	 * @param dataRule
	 */
	public static void testKggBusiness(Map<String,String> requestData,Map<String,String> dataRule,Map<String,String> row) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
	    request.setRow(row);
        //������̽�������������Ӧ
        Response response=new Response();
        
        //FilterChain,���˹����γɵ���������
        RuleChain fc=new RuleChain();
        //����������ӹ��˹��򣬲��õ�����ʽ����
        fc.addRule(new ZnycKggImpl());
        //����FilterChain�Ĺ���˳������Ӧ�ù��˹���
        fc.applyRule(request, response,fc);
    }
	
	/**
	 * ���Ե�ѹ��������ҵ�����
	 * @param requestData
	 * @param dataRule
	 */
	public static void testDyhgqBusiness(Map<String,String> requestData,Map<String,String> dataRule,Map<String,String> row) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
	    request.setRow(row);
        //������̽�������������Ӧ
        Response response=new Response();
        
        //FilterChain,���˹����γɵ���������
        RuleChain fc=new RuleChain();
        //����������ӹ��˹��򣬲��õ�����ʽ����
        fc.addRule(new ZnycDyhgqImpl());
        //����FilterChain�Ĺ���˳������Ӧ�ù��˹���
        fc.applyRule(request, response,fc);
    }
	
	/**
	 * ���Ե�����������ҵ�����
	 * @param requestData
	 * @param dataRule
	 */
	public static void testDlhgqBusiness(Map<String,String> requestData,Map<String,String> dataRule,Map<String,String> row) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
	    request.setRow(row);
        //������̽�������������Ӧ
        Response response=new Response();
        
        //FilterChain,���˹����γɵ���������
        RuleChain fc=new RuleChain();
        //����������ӹ��˹��򣬲��õ�����ʽ����
        fc.addRule(new ZnycDlhgqImpl());
        //����FilterChain�Ĺ���˳������Ӧ�ù��˹���
        fc.applyRule(request, response,fc);
    }
	
	/**
	 * ���Զ�·����ҵ�����
	 * @param requestData
	 * @param dataRule
	 */
	public static void testDlqBusiness(Map<String,String> requestData,Map<String,String> dataRule,Map<String,String> row) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
	    request.setRow(row);
        //������̽�������������Ӧ
        Response response=new Response();
        
        //FilterChain,���˹����γɵ���������
        RuleChain fc=new RuleChain();
        //����������ӹ��˹��򣬲��õ�����ʽ����
        fc.addRule(new ZnycDlqImpl());
        //����FilterChain�Ĺ���˳������Ӧ�ù��˹���
        fc.applyRule(request, response,fc);
    }
	
	/**
	 * ����ҵ�����  ����ѹ������ϵ���������������������ѹ�������뿪�ء������������ñ䡢�翹����ĸ�ߡ��ӵر䣬���ع񣬵�ѹ����������������������·��
	 * @param requestData
	 * @param dataRule
	 */
	public static void testBusiness(Map<String,String> requestData,Map<String,String> dataRule,Map<String,String> row,String tname) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
	    request.setRow(row);
        //������̽�������������Ӧ
        Response response=new Response();
        //FilterChain,���˹����γɵ���������
        RuleChain fc=new RuleChain();
        //����������ӹ��˹��򣬲��õ�����ʽ����
        if("zbyq".equals(tname)) {//����ѹ��
        	fc.addRule(new ZnycZbyqImpl());
		}else if("zhdq".equals(tname)){//��ϵ���
			fc.addRule(new ZnycZhdqImpl());
		}else if("dldrq".equals(tname)){//����������
			fc.addRule(new ZnycDldrqImpl());
		}else if("pdbyq".equals(tname)){//����ѹ��
			fc.addRule(new ZnycPdbyqImpl());
		}else if("glkg".equals(tname)){//���뿪��
			fc.addRule(new ZnycGlkgImpl());
		}else if("blq".equals(tname)){//������
			fc.addRule(new ZnycBlqImpl());
		}else if("syb".equals(tname)){//���ñ�
			fc.addRule(new ZnycSybImpl());
		}else if("dkq".equals(tname)){//�翹��
			fc.addRule(new ZnycDkqImpl());
		}else if("mx".equals(tname)){//ĸ��
			fc.addRule(new ZnycMxImpl());
		}else if("jdb".equals(tname)){//�ӵر�
			fc.addRule(new ZnycJdbImpl());
		}else if("kgg".equals(tname)){//���ع�
			fc.addRule(new ZnycKggImpl());
		}else if("dyhgq".equals(tname)){//��ѹ������
			fc.addRule(new ZnycDyhgqImpl());
		}else if("dlhgq".equals(tname)){//����������
			fc.addRule(new ZnycDlhgqImpl());
		}else if("dlq".equals(tname)){//��·��
			fc.addRule(new ZnycDlqImpl());
		}
        //����FilterChain�Ĺ���˳������Ӧ�ù��˹���
        fc.applyRule(request, response,fc);
    }
	
	public static void testODS(){
		
		IDataSourceDao dataSourceDao =DAOFactory.getDataSourceDao();
		IDataRuleDao dataRuleDao = DAOFactory.getDataRuleDao();
		IDataStatisticDao dataStatisticDao = DAOFactory.getDataStatisticDao();
		IRuleLogDao ruleLogDao = DAOFactory.getRuleLogDao();
		
		//��������
		Map<String,Map<String,Map<String,String>>> rules = new HashMap();
		//��ͳ�ƹ���
		Map<String,Map<String,Map<String,String>>> statisticRules = new HashMap();
		
		Gson gson = new Gson();
		
		int maxXh = ruleLogDao.getMaxXh();
		List<WZJSCS> wzjscss = dataSourceDao.readData(maxXh);
		
		for(WZJSCS data:wzjscss) {//for1
			
			if(data.getXh()>maxXh) {
				maxXh = data.getXh();
			}
			
			String tid = data.getEqart();
			
			String tname = data.getEartx();
			if(rules.get(tname)==null) {
				String sbname = tname;
				if(tname.equals("������(���)")) {
					sbname="������";
				}
				if(tname.equals("���ع�(���)")) {
					sbname="���ع�";
				}
				if(tname.equals("��ϵ����򸴺ϵ���")) {
					sbname="��ϵ���";
				}
				if(tname.equals("��ϵ���(���)")) {
					sbname="��ϵ���";
				}
				if(tname.equals("�翹��(վ��һ��)")) {
					sbname="�翹��";
				}
				
				rules.clear();
				statisticRules.clear();
				
				rules.put(tname, dataRuleDao.readDataRule(sbname));
				statisticRules.put(tname, dataStatisticDao.queryStatisticValue(sbname));
			}
			
			Map<String,Map<String,String>> rule = rules.get(tname);
			Map<String,Map<String,String>> statisticrule = statisticRules.get(tname);
			
			String zswsxz = data.getZswsxz();
			Map<String,String> row = gson.fromJson(zswsxz, Map.class);
			
			String swid = row.get("SWID");
			if(row.size()==1) {
				ProblemBill problemBill =  new ProblemBill();
				
				problemBill.setDatapk("{'swid':'"+swid+"'}");
				problemBill.setProblemcode(String.valueOf(DataExceptionMessage.DATA_COMPLETE_RULE.getCode()));
				problemBill.setProblemdesc(DataExceptionMessage.DATA_COMPLETE_RULE.getMessage());
				problemBill.setProblemfield("");
				problemBill.setTname(tname);
				problemBill.setTid(tid);
				
				IProblemBillDao iproblemBillDao = DAOFactory.getProblemBillDao();
				iproblemBillDao.addProblemBill(problemBill);
				continue;
			}
			
			String sccj = row.get("SCCJ");
			String xh = row.get("XH");
			String groupWhere = "sccj="+sccj+","+"xh="+xh;
			
			for(Entry<String, String> entry: row.entrySet()) {//for2
				String key = entry.getKey();
				String value = entry.getValue();
				
				//String requestData1 = "{field:'"+key+"'"+",value:'"+value+"',datapk:'{swid="+swid+"}'}";
				
				Map<String,String> requestData = new HashMap();
				requestData.put("field", key);
				requestData.put("value", value);
				requestData.put("datapk", "{'swid':'"+swid+"'}");
				requestData.put("tid", tid);
				requestData.put("sourceType", "ODS");
				
				Map<String,String> ruledata = rule.get(key);
			
				//û���ҵ���֤��������
				if(ruledata==null) {
					continue;
				}
				ruledata.put("tname", tname);
				
				/**
				 * ���ݻ�������
				 */
				if(false) {
					String inputway = ruledata.get("inputway");
					String type = ruledata.get("type");
					
					if(inputway.equals("�ı�")) {
						testVarchar(requestData,ruledata);
					}else if(inputway.equals("��ֵ")) {
						if(type.equals("VARCHAR")) {
							testVarchar(requestData,ruledata);
						}else {
							if(statisticrule.get(key+"-"+groupWhere)!=null) {
								ruledata.putAll(statisticrule.get(key+"-"+groupWhere));
								testNumberDataRange(requestData,ruledata);
							}else {
								testNumber(requestData,ruledata);
							}
							
						}
					}else if(inputway.equals("������")) {
						testSelect(requestData,ruledata);
					}else if(inputway.equals("����")) {
						testDate(requestData,ruledata);
					}else if(inputway.equals("ѡ��")) {
						testSelect(requestData,ruledata);
					}
				}
				
				/**
				 * ҵ�����
				 */
				if(true) {
					
					if(tname.equals("����ѹ��")) {
						testZbyqBusiness(requestData, ruledata, row);
					}else if (tname.equals("���ع�")) {
						testKggBusiness(requestData, ruledata, row);
					}else if (tname.equals("��ѹ������")) {
						testDyhgqBusiness(requestData, ruledata, row);
					}else if (tname.equals("����������")) {
						testDlhgqBusiness(requestData, ruledata, row);
					}else if (tname.equals("��·��")) {
						testDlqBusiness(requestData, ruledata, row);
					}
					
				}
				
				
			}//end for2
		}//end for1
		
		RuleLog ruleLog = new RuleLog();
		ruleLog.setMaxxh(maxXh);
		ruleLogDao.addRuleLog(ruleLog);
	}
	
	
	/**
	 * PMS����ѹ��
	 */
	public static void testPMSZbyq(){
		IDataRuleDao dataRuleDao = DAOFactory.getDataRuleDao();
		
		IZnycZbyqDao znycZbyqDao = DAOFactory.getZnycZbyqDao();
		
		//��������
		Map<String,Map<String,Map<String,String>>> rules = new HashMap();
		Gson gson = new Gson();
		
		List<Map<String,String>> wzjscss = znycZbyqDao.readData(0);
		
		for(Map<String,String> row:wzjscss) {//for1
			
			String tname = "����ѹ��";
			if(rules.get(tname)==null) {
				String sbname = tname;
				rules.put(tname, dataRuleDao.readDataRule(sbname));
			}
			
			Map<String,Map<String,String>> rule = rules.get(tname);
			
			String obj_id = row.get("OBJ_ID");
			if(row.size()==1) {
				ProblemBill problemBill =  new ProblemBill();
				
				problemBill.setDatapk("{'obj_id':'"+obj_id+"'}");
				problemBill.setProblemcode(String.valueOf(DataExceptionMessage.DATA_COMPLETE_RULE.getCode()));
				problemBill.setProblemdesc(DataExceptionMessage.DATA_COMPLETE_RULE.getMessage());
				problemBill.setProblemfield("");
				problemBill.setTname(tname);
				
				IProblemBillDao iproblemBillDao = DAOFactory.getProblemBillDao();
				iproblemBillDao.addProblemBill(problemBill);
			}
			
			
			for(Entry<String, String> entry: row.entrySet()) {//for2
				String key = entry.getKey();
				String value = entry.getValue();
				
				//String requestData1 = "{field:'"+key+"'"+",value:'"+value+"',datapk:'{swid="+swid+"}'}";
				
				Map<String,String> requestData = new HashMap();
				requestData.put("field", key);
				requestData.put("value", value);
				requestData.put("datapk", "{'obj_id':'"+obj_id+"'}");
				requestData.put("sourceType", "PMS");
				
				Map<String,String> ruledata = rule.get(key);
				
				if(true) {
					//û���ҵ���֤��������
					if(ruledata==null) {
						continue;
					}
					ruledata.put("tname", tname);
					String inputway = ruledata.get("inputway");
					String type = ruledata.get("type");
					
					if(inputway.equals("�ı�")) {
						testVarchar(requestData,ruledata);
					}else if(inputway.equals("��ֵ")) {
						if(type.equals("VARCHAR")) {
							testVarchar(requestData,ruledata);
						}
					}else if(inputway.equals("������")) {
						testSelect(requestData,ruledata);
					}else if(inputway.equals("����")) {
						testDate(requestData,ruledata);
					}else if(inputway.equals("ѡ��")) {
						testSelect(requestData,ruledata);
					}
				}
				
				/**
				 * ҵ�����
				 */
				if(true) {
					
					if(tname.equals("����ѹ��")) {
						if(ruledata==null) {
							ruledata = new HashMap();
						}
						
						ruledata.put("tname", tname);
						testZbyqBusiness(requestData, ruledata, row);
					}
					
				}
				
			}//end for2
		}//end for1
	}
	
	
	/**
	 * PMS ����ѹ������ϵ���������������������ѹ�������뿪�ء������������ñ䡢�翹����ĸ�ߡ��ӵر䡢���ع񡢵�ѹ����������������������·��
	 */
	public static void testPMS(String name,boolean istartBaseRule,boolean istartBusRule){
		IDataRuleDao dataRuleDao = DAOFactory.getDataRuleDao();
		List<Map<String,String>> wzjscss = new ArrayList<Map<String,String>>();
		String tname = "";
		if("zbyq".equals(name)){
			IZnycZbyqDao znycZbyqDao = DAOFactory.getZnycZbyqDao();
			wzjscss = znycZbyqDao.readData(0);
			tname = "����ѹ��";
		}else if("zhdq".equals(name)){
			IZnycZhdqDao znycZhdqDao = DAOFactory.getZnycZhdqDao();
			wzjscss = znycZhdqDao.readData(0);
			tname = "��ϵ���";
		}else if("dldrq".equals(name)){
			IZnycDldrqDao znycDldrqDao = DAOFactory.getZnycDldrqDao();
			wzjscss = znycDldrqDao.readData(0);
			tname = "����������";
		}else if("pdbyq".equals(name)){
			IZnycPdbyqDao znycPdbyqDao = DAOFactory.getZnycPdbyqDao();
			wzjscss = znycPdbyqDao.readData(0);
			tname = "����ѹ��";
		}else if("glkg".equals(name)){
			IZnycGlkgDao znycGlkgDao = DAOFactory.getZnycGlkgDao();
			wzjscss = znycGlkgDao.readData(0);
			tname = "���뿪��";
		}else if("blq".equals(name)){
			IZnycBlqDao znycBlqDao = DAOFactory.getZnycBlqDao();
			wzjscss = znycBlqDao.readData(0);
			tname = "������";
		}else if("syb".equals(name)){
			IZnycSybDao znycSybDao = DAOFactory.getZnycSybDao();
			wzjscss = znycSybDao.readData(0);
			tname = "���ñ�";
		}else if("dkq".equals(name)){
			IZnycDkqDao znycDkqDao = DAOFactory.getZnycDkqDao();
			wzjscss = znycDkqDao.readData(0);
			tname = "�翹��";
		}else if("mx".equals(name)){
			IZnycMxDao znycMxDao = DAOFactory.getZnycMxDao();
			wzjscss = znycMxDao.readData(0);
			tname = "ĸ��";
		}else if("jdb".equals(name)){
			IZnycJdbDao znycJdbDao = DAOFactory.getZnycJdbDao();
			wzjscss = znycJdbDao.readData(0);
			tname = "�ӵر�";
		}else if("kgg".equals(name)){
			IZnycKggDao znycKggDao = DAOFactory.getZnycKggDao();
			wzjscss = znycKggDao.readData(0);
			tname = "���ع�";
		}else if("dyhgq".equals(name)){
			IZnycDyhgqDao znycDyhgqDao = DAOFactory.getZnycDyhgqDao();
			wzjscss = znycDyhgqDao.readData(0);
			tname = "��ѹ������";
		}else if("dlhgq".equals(name)){
			IZnycDlhgqDao znycDlhgqDao = DAOFactory.getZnycDlhgqDao();
			wzjscss = znycDlhgqDao.readData(0);
			tname = "����������";
		}else if("dlq".equals(name)){
			IZnycDlqDao znycDlqDao = DAOFactory.getZnycDlqDao();
			wzjscss = znycDlqDao.readData(0);
			tname = "��·��";
		}
		//��������
		Map<String,Map<String,Map<String,String>>> rules = new HashMap();
		Gson gson = new Gson();
		for(Map<String,String> row:wzjscss) {//for1
			if(rules.get(tname)==null) {
				String sbname = tname;
				rules.put(tname, dataRuleDao.readDataRule(sbname));
			}
			Map<String,Map<String,String>> rule = rules.get(tname);
			String obj_id = row.get("OBJ_ID");
			if(row.size()==1) {
				ProblemBill problemBill =  new ProblemBill();
				problemBill.setDatapk("{'obj_id':'"+obj_id+"'}");
				problemBill.setProblemcode(String.valueOf(DataExceptionMessage.DATA_COMPLETE_RULE.getCode()));
				problemBill.setProblemdesc(DataExceptionMessage.DATA_COMPLETE_RULE.getMessage());
				problemBill.setProblemfield("");
				problemBill.setTname(tname);
				IProblemBillDao iproblemBillDao = DAOFactory.getProblemBillDao();
				iproblemBillDao.addProblemBill(problemBill);
			}
			for(Entry<String, String> entry: row.entrySet()) {//for2
				String key = entry.getKey();
				String value = entry.getValue();
				//String requestData1 = "{field:'"+key+"'"+",value:'"+value+"',datapk:'{swid="+swid+"}'}";
				Map<String,String> requestData = new HashMap();
				requestData.put("field", key);
				requestData.put("value", value);
				requestData.put("datapk", "{'obj_id':'"+obj_id+"'}");
				requestData.put("sourceType", "PMS");
				Map<String,String> ruledata = rule.get(key);
				
				if(istartBaseRule) {
					//û���ҵ���֤��������
					if(ruledata==null) {
						continue;
					}
					ruledata.put("tname", tname);
					String inputway = ruledata.get("inputway");
					String type = ruledata.get("type");

					if(inputway.equals("�ı�")) {
						testVarchar(requestData,ruledata);
					}else if(inputway.equals("��ֵ")) {
						if(type.equals("VARCHAR")) {
							testVarchar(requestData,ruledata);
						}
					}else if(inputway.equals("������")) {
						testSelect(requestData,ruledata);
					}else if(inputway.equals("����")) {
						//testDate(requestData,ruledata);
					}else if(inputway.equals("ѡ��")) {
						testSelect(requestData,ruledata);
					}
				}

				/**
				 * ҵ�����
				 */
				if(istartBusRule) {
					if(ruledata==null) {
						ruledata = new HashMap();
					}
					ruledata.put("tname", tname);
					testBusiness(requestData, ruledata, row, name);
				}
			}
		}
	}

	/**
	 * ODS�����ݹ���
	 * @param istartBaseRule �Ƿ����л�������
	 * @param istartBusRule �Ƿ�����ҵ�����
	 */
	public static void testODSNew(boolean istartBaseRule,boolean istartBusRule){
		IDataSourceDao dataSourceDao =DAOFactory.getDataSourceDao();
		IDataRuleDao dataRuleDao = DAOFactory.getDataRuleDao();
		IDataStatisticDao dataStatisticDao = DAOFactory.getDataStatisticDao();
		IRuleLogDao ruleLogDao = DAOFactory.getRuleLogDao();
		//��������
		Map<String,Map<String,Map<String,String>>> rules = new HashMap();
		//��ͳ�ƹ���
		Map<String,Map<String,Map<String,String>>> statisticRules = new HashMap();
		Gson gson = new Gson();
		int maxXh = ruleLogDao.getMaxXh();
		List<WZJSCS> wzjscss = dataSourceDao.readData(maxXh);
		for(WZJSCS data:wzjscss) {//for1
			if(data.getXh()>maxXh) {
				maxXh = data.getXh();
			}
			String tid = data.getEqart();
			String tname = data.getEartx();
			if(rules.get(tname)==null) {
				String sbname = tname;
				
				if(tname.equals("������(���)")) {
					sbname="������";
				}
				if(tname.equals("���ع�(���)")) {
					sbname="���ع�";
				}
				if(tname.equals("��ϵ����򸴺ϵ���")) {
					sbname="��ϵ���";
				}
				if(tname.equals("��ϵ���(���)")) {
					sbname="��ϵ���";
				}
				if(tname.equals("�翹��(վ��һ��)")) {
					sbname="�翹��";
				}
				if(tname.equals("�ӵر�ѹ��")) {
					sbname="�ӵر�";
				}
				if(tname.equals("���ñ�ѹ��/��")) {
					sbname="���ñ�";
				}
				
				rules.clear();
				statisticRules.clear();
				rules.put(tname, dataRuleDao.readDataRule(sbname));
				statisticRules.put(tname, dataStatisticDao.queryStatisticValue(sbname));
			}
			Map<String,Map<String,String>> rule = rules.get(tname);
			Map<String,Map<String,String>> statisticrule = statisticRules.get(tname);
			String zswsxz = data.getZswsxz();
			Map<String,String> row = gson.fromJson(zswsxz, Map.class);
			String swid = row.get("SWID");
			if(row.size()==1) {
				ProblemBill problemBill =  new ProblemBill();
				problemBill.setDatapk("{'swid':'"+swid+"'}");
				problemBill.setProblemcode(String.valueOf(DataExceptionMessage.DATA_COMPLETE_RULE.getCode()));
				problemBill.setProblemdesc(DataExceptionMessage.DATA_COMPLETE_RULE.getMessage());
				problemBill.setProblemfield("");
				problemBill.setTname(tname);
				problemBill.setTid(tid);
				IProblemBillDao iproblemBillDao = DAOFactory.getProblemBillDao();
				iproblemBillDao.addProblemBill(problemBill);
				continue;
			}
			String sccj = row.get("SCCJ");
			String xh = row.get("XH");
			String groupWhere = "sccj="+sccj+","+"xh="+xh;
			for(Entry<String, String> entry: row.entrySet()) {//for2
				String key = entry.getKey();
				String value = entry.getValue();
				//String requestData1 = "{field:'"+key+"'"+",value:'"+value+"',datapk:'{swid="+swid+"}'}";
				Map<String,String> requestData = new HashMap();
				requestData.put("field", key);
				requestData.put("value", value);
				requestData.put("datapk", "{'swid':'"+swid+"'}");
				requestData.put("tid", tid);
				requestData.put("sourceType", "ODS");
				Map<String,String> ruledata = rule.get(key);
				//û���ҵ���֤��������
				if(ruledata==null) {
					continue;
				}
				ruledata.put("tname", tname);

				/**
				 * ���ݻ�������
				 */
				if(istartBaseRule) {
					String inputway = ruledata.get("inputway");
					String type = ruledata.get("type");
					if(inputway.equals("�ı�")) {
						testVarchar(requestData,ruledata);
					}else if(inputway.equals("��ֵ")) {
						if(type.equals("VARCHAR")) {
							testVarchar(requestData,ruledata);
						}else {
							if(statisticrule.get(key+"-"+groupWhere)!=null) {
								ruledata.putAll(statisticrule.get(key+"-"+groupWhere));
								testNumberDataRange(requestData,ruledata);
							}else {
								testNumber(requestData,ruledata);
							}
						}
					}else if(inputway.equals("������")) {
						testSelect(requestData,ruledata);
					}else if(inputway.equals("����")) {
						testDate(requestData,ruledata);
					}else if(inputway.equals("ѡ��")) {
						testSelect(requestData,ruledata);
					}
				}

				/**
				 * ҵ�����
				 */
				if(istartBusRule) {
					if(tname.equals("����ѹ��")) {
						testBusiness(requestData, ruledata, row,"zbyq");
					}else if(tname.equals("��ϵ���")){
						testBusiness(requestData, ruledata, row,"zhdq");
					}else if(tname.equals("����������")){
						testBusiness(requestData, ruledata, row,"dldrq");
					}else if(tname.equals("����ѹ��")){
						testBusiness(requestData, ruledata, row,"pdbyq");
					}else if(tname.equals("���뿪��")){
						testBusiness(requestData, ruledata, row,"glkg");
					}else if(tname.equals("������")){
						testBusiness(requestData, ruledata, row,"blq");
					}else if(tname.equals("���ñ�")){
						testBusiness(requestData, ruledata, row,"syb");
					}else if(tname.equals("�翹��")){
						testBusiness(requestData, ruledata, row,"dkq");
					}else if(tname.equals("ĸ��")){
						testBusiness(requestData, ruledata, row,"mx");
					}else if(tname.equals("�ӵر�")){
						testBusiness(requestData, ruledata, row,"jdb");
					}else if(tname.equals("���ع�")){
						testBusiness(requestData, ruledata, row,"kgg");
					}else if(tname.equals("��ѹ������")){
						testBusiness(requestData, ruledata, row,"dyhgq");
					}else if(tname.equals("����������")){
						testBusiness(requestData, ruledata, row,"dlhgq");
					}else if(tname.equals("��·��")){
						testBusiness(requestData, ruledata, row,"dlq");
					}
				}
			}
		}
		RuleLog ruleLog = new RuleLog();
		ruleLog.setMaxxh(maxXh);
		ruleLogDao.addRuleLog(ruleLog);
	}
	
	
	public static void main(String[] args) {
		
		//MainApplication.testPMSZbyq();
		//MainApplication.testODS();
		//MainApplication.testPMSKgg();
		//MainApplication.testPMSDyhgq();
		//MainApplication.testPMSDlhgq();
		//MainApplication.testPMSDlq();
		MainApplication.testPMS("zbyq",true,true);//����ѹ��
		MainApplication.testPMS("zhdq",true,true);//��ϵ���
		MainApplication.testPMS("dldrq",true,true);//����������
		MainApplication.testPMS("pdbyq",true,true);//����ѹ��
		MainApplication.testPMS("glkg",true,true);//���뿪��
		MainApplication.testPMS("blq",true,true);//������
		MainApplication.testPMS("syb",true,true);//���ñ�
		MainApplication.testPMS("dkq",true,true);//�翹��
		MainApplication.testPMS("mx",true,true);//ĸ��
		MainApplication.testPMS("jdb",true,true);//���ع�
		MainApplication.testPMS("dyhgq",true,true);//��ѹ������
		MainApplication.testPMS("dlhgq",true,true);//����������
		MainApplication.testPMS("dlq",true,true);//��·��
		
		//MainApplication.testODSNew(true,true);
	}

}
