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
        //处理过程结束，给出的响应
        Response response=new Response();
        
        //FilterChain,过滤规则形成的拦截链条
        RuleChain fc=new RuleChain();
        //规则链条添加过滤规则，采用的是链式调用
        fc.addRule(new NotNullRule())
          .addRule(new NumberTypeRule())
          .addRule(new DataRangeRule());
        
        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.applyRule(request, response,fc);
}
	
	public static void testNumber(Map<String,String> requestData,Map<String,String> dataRule) {
		    Request request=new Request();
		    request.setRequestData(requestData);
		    request.setDataRule(dataRule);
	        //处理过程结束，给出的响应
	        Response response=new Response();
	        
	        //FilterChain,过滤规则形成的拦截链条
	        RuleChain fc=new RuleChain();
	        //规则链条添加过滤规则，采用的是链式调用
	        fc.addRule(new NotNullRule())
	          .addRule(new NumberTypeRule());
	          //.addRule(new DataRangeRule());
	        //按照FilterChain的规则顺序，依次应用过滤规则
	        fc.applyRule(request, response,fc);
	}
	
	public static void testVarchar(Map<String,String> requestData,Map<String,String> dataRule) {
		 Request request=new Request();
		    request.setRequestData(requestData);
		    request.setDataRule(dataRule);
		   
	        //处理过程结束，给出的响应
	        Response response=new Response();
	        
	        //FilterChain,过滤规则形成的拦截链条
	        RuleChain fc=new RuleChain();
	        //规则链条添加过滤规则，采用的是链式调用
	        fc.addRule(new NotNullRule())
	          .addRule(new VarcharTypeRule());
	        //按照FilterChain的规则顺序，依次应用过滤规则
	        fc.applyRule(request, response,fc);
	}
	
	public static void testSelect(Map<String,String> requestData,Map<String,String> dataRule) {
		    Request request=new Request();
		    request.setRequestData(requestData);
		    request.setDataRule(dataRule);
	        
	        //处理过程结束，给出的响应
	        Response response=new Response();
	        
	        //FilterChain,过滤规则形成的拦截链条
	        RuleChain fc=new RuleChain();
	        //规则链条添加过滤规则，采用的是链式调用
	        fc.addRule(new NotNullRule()).addRule(new VarcharTypeRule()).addRule(new SelectTypeRule());
	        //按照FilterChain的规则顺序，依次应用过滤规则
	        fc.applyRule(request, response,fc);
	}
	
	
	public static void testDate(Map<String,String> requestData,Map<String,String> dataRule) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
        //处理过程结束，给出的响应
        Response response=new Response();
        
        //FilterChain,过滤规则形成的拦截链条
        RuleChain fc=new RuleChain();
        //规则链条添加过滤规则，采用的是链式调用
        fc.addRule(new NotNullRule()).addRule(new DateTypeRule());
        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.applyRule(request, response,fc);
    }
	
	/**
	 * 测试主变压器的业务规则
	 * @param requestData
	 * @param dataRule
	 */
	public static void testZbyqBusiness(Map<String,String> requestData,Map<String,String> dataRule,Map<String,String> row) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
	    request.setRow(row);
        //处理过程结束，给出的响应
        Response response=new Response();
        
        //FilterChain,过滤规则形成的拦截链条
        RuleChain fc=new RuleChain();
        //规则链条添加过滤规则，采用的是链式调用
        fc.addRule(new ZnycZbyqImpl());
        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.applyRule(request, response,fc);
    }
	
	/**
	 * 测试开关柜的业务规则
	 * @param requestData
	 * @param dataRule
	 */
	public static void testKggBusiness(Map<String,String> requestData,Map<String,String> dataRule,Map<String,String> row) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
	    request.setRow(row);
        //处理过程结束，给出的响应
        Response response=new Response();
        
        //FilterChain,过滤规则形成的拦截链条
        RuleChain fc=new RuleChain();
        //规则链条添加过滤规则，采用的是链式调用
        fc.addRule(new ZnycKggImpl());
        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.applyRule(request, response,fc);
    }
	
	/**
	 * 测试电压互感器的业务规则
	 * @param requestData
	 * @param dataRule
	 */
	public static void testDyhgqBusiness(Map<String,String> requestData,Map<String,String> dataRule,Map<String,String> row) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
	    request.setRow(row);
        //处理过程结束，给出的响应
        Response response=new Response();
        
        //FilterChain,过滤规则形成的拦截链条
        RuleChain fc=new RuleChain();
        //规则链条添加过滤规则，采用的是链式调用
        fc.addRule(new ZnycDyhgqImpl());
        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.applyRule(request, response,fc);
    }
	
	/**
	 * 测试电流互感器的业务规则
	 * @param requestData
	 * @param dataRule
	 */
	public static void testDlhgqBusiness(Map<String,String> requestData,Map<String,String> dataRule,Map<String,String> row) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
	    request.setRow(row);
        //处理过程结束，给出的响应
        Response response=new Response();
        
        //FilterChain,过滤规则形成的拦截链条
        RuleChain fc=new RuleChain();
        //规则链条添加过滤规则，采用的是链式调用
        fc.addRule(new ZnycDlhgqImpl());
        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.applyRule(request, response,fc);
    }
	
	/**
	 * 测试断路器的业务规则
	 * @param requestData
	 * @param dataRule
	 */
	public static void testDlqBusiness(Map<String,String> requestData,Map<String,String> dataRule,Map<String,String> row) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
	    request.setRow(row);
        //处理过程结束，给出的响应
        Response response=new Response();
        
        //FilterChain,过滤规则形成的拦截链条
        RuleChain fc=new RuleChain();
        //规则链条添加过滤规则，采用的是链式调用
        fc.addRule(new ZnycDlqImpl());
        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.applyRule(request, response,fc);
    }
	
	/**
	 * 测试业务规则  主变压器、组合电器、电力电容器、配电变压器、隔离开关、避雷器、所用变、电抗器、母线、接地变，开关柜，电压互感器，电流互感器，断路器
	 * @param requestData
	 * @param dataRule
	 */
	public static void testBusiness(Map<String,String> requestData,Map<String,String> dataRule,Map<String,String> row,String tname) {
	    Request request=new Request();
	    request.setRequestData(requestData);
	    request.setDataRule(dataRule);
	    request.setRow(row);
        //处理过程结束，给出的响应
        Response response=new Response();
        //FilterChain,过滤规则形成的拦截链条
        RuleChain fc=new RuleChain();
        //规则链条添加过滤规则，采用的是链式调用
        if("zbyq".equals(tname)) {//主变压器
        	fc.addRule(new ZnycZbyqImpl());
		}else if("zhdq".equals(tname)){//组合电器
			fc.addRule(new ZnycZhdqImpl());
		}else if("dldrq".equals(tname)){//电力电容器
			fc.addRule(new ZnycDldrqImpl());
		}else if("pdbyq".equals(tname)){//配电变压器
			fc.addRule(new ZnycPdbyqImpl());
		}else if("glkg".equals(tname)){//隔离开关
			fc.addRule(new ZnycGlkgImpl());
		}else if("blq".equals(tname)){//避雷器
			fc.addRule(new ZnycBlqImpl());
		}else if("syb".equals(tname)){//所用变
			fc.addRule(new ZnycSybImpl());
		}else if("dkq".equals(tname)){//电抗器
			fc.addRule(new ZnycDkqImpl());
		}else if("mx".equals(tname)){//母线
			fc.addRule(new ZnycMxImpl());
		}else if("jdb".equals(tname)){//接地变
			fc.addRule(new ZnycJdbImpl());
		}else if("kgg".equals(tname)){//开关柜
			fc.addRule(new ZnycKggImpl());
		}else if("dyhgq".equals(tname)){//电压互感器
			fc.addRule(new ZnycDyhgqImpl());
		}else if("dlhgq".equals(tname)){//电流互感器
			fc.addRule(new ZnycDlhgqImpl());
		}else if("dlq".equals(tname)){//断路器
			fc.addRule(new ZnycDlqImpl());
		}
        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.applyRule(request, response,fc);
    }
	
	public static void testODS(){
		
		IDataSourceDao dataSourceDao =DAOFactory.getDataSourceDao();
		IDataRuleDao dataRuleDao = DAOFactory.getDataRuleDao();
		IDataStatisticDao dataStatisticDao = DAOFactory.getDataStatisticDao();
		IRuleLogDao ruleLogDao = DAOFactory.getRuleLogDao();
		
		//基本规则
		Map<String,Map<String,Map<String,String>>> rules = new HashMap();
		//列统计规则
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
				if(tname.equals("避雷器(变电)")) {
					sbname="避雷器";
				}
				if(tname.equals("开关柜(变电)")) {
					sbname="开关柜";
				}
				if(tname.equals("组合电器或复合电器")) {
					sbname="组合电器";
				}
				if(tname.equals("组合电器(变电)")) {
					sbname="组合电器";
				}
				if(tname.equals("电抗器(站内一次)")) {
					sbname="电抗器";
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
			
				//没有找到验证规则的情况
				if(ruledata==null) {
					continue;
				}
				ruledata.put("tname", tname);
				
				/**
				 * 数据基本规则
				 */
				if(false) {
					String inputway = ruledata.get("inputway");
					String type = ruledata.get("type");
					
					if(inputway.equals("文本")) {
						testVarchar(requestData,ruledata);
					}else if(inputway.equals("数值")) {
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
					}else if(inputway.equals("下拉框")) {
						testSelect(requestData,ruledata);
					}else if(inputway.equals("日期")) {
						testDate(requestData,ruledata);
					}else if(inputway.equals("选择")) {
						testSelect(requestData,ruledata);
					}
				}
				
				/**
				 * 业务规则
				 */
				if(true) {
					
					if(tname.equals("主变压器")) {
						testZbyqBusiness(requestData, ruledata, row);
					}else if (tname.equals("开关柜")) {
						testKggBusiness(requestData, ruledata, row);
					}else if (tname.equals("电压互感器")) {
						testDyhgqBusiness(requestData, ruledata, row);
					}else if (tname.equals("电流互感器")) {
						testDlhgqBusiness(requestData, ruledata, row);
					}else if (tname.equals("断路器")) {
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
	 * PMS主变压器
	 */
	public static void testPMSZbyq(){
		IDataRuleDao dataRuleDao = DAOFactory.getDataRuleDao();
		
		IZnycZbyqDao znycZbyqDao = DAOFactory.getZnycZbyqDao();
		
		//基本规则
		Map<String,Map<String,Map<String,String>>> rules = new HashMap();
		Gson gson = new Gson();
		
		List<Map<String,String>> wzjscss = znycZbyqDao.readData(0);
		
		for(Map<String,String> row:wzjscss) {//for1
			
			String tname = "主变压器";
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
					//没有找到验证规则的情况
					if(ruledata==null) {
						continue;
					}
					ruledata.put("tname", tname);
					String inputway = ruledata.get("inputway");
					String type = ruledata.get("type");
					
					if(inputway.equals("文本")) {
						testVarchar(requestData,ruledata);
					}else if(inputway.equals("数值")) {
						if(type.equals("VARCHAR")) {
							testVarchar(requestData,ruledata);
						}
					}else if(inputway.equals("下拉框")) {
						testSelect(requestData,ruledata);
					}else if(inputway.equals("日期")) {
						testDate(requestData,ruledata);
					}else if(inputway.equals("选择")) {
						testSelect(requestData,ruledata);
					}
				}
				
				/**
				 * 业务规则
				 */
				if(true) {
					
					if(tname.equals("主变压器")) {
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
	 * PMS 主变压器、组合电器、电力电容器、配电变压器、隔离开关、避雷器、所用变、电抗器、母线、接地变、开关柜、电压互感器、电流互感器、断路器
	 */
	public static void testPMS(String name,boolean istartBaseRule,boolean istartBusRule){
		IDataRuleDao dataRuleDao = DAOFactory.getDataRuleDao();
		List<Map<String,String>> wzjscss = new ArrayList<Map<String,String>>();
		String tname = "";
		if("zbyq".equals(name)){
			IZnycZbyqDao znycZbyqDao = DAOFactory.getZnycZbyqDao();
			wzjscss = znycZbyqDao.readData(0);
			tname = "主变压器";
		}else if("zhdq".equals(name)){
			IZnycZhdqDao znycZhdqDao = DAOFactory.getZnycZhdqDao();
			wzjscss = znycZhdqDao.readData(0);
			tname = "组合电器";
		}else if("dldrq".equals(name)){
			IZnycDldrqDao znycDldrqDao = DAOFactory.getZnycDldrqDao();
			wzjscss = znycDldrqDao.readData(0);
			tname = "电力电容器";
		}else if("pdbyq".equals(name)){
			IZnycPdbyqDao znycPdbyqDao = DAOFactory.getZnycPdbyqDao();
			wzjscss = znycPdbyqDao.readData(0);
			tname = "配电变压器";
		}else if("glkg".equals(name)){
			IZnycGlkgDao znycGlkgDao = DAOFactory.getZnycGlkgDao();
			wzjscss = znycGlkgDao.readData(0);
			tname = "隔离开关";
		}else if("blq".equals(name)){
			IZnycBlqDao znycBlqDao = DAOFactory.getZnycBlqDao();
			wzjscss = znycBlqDao.readData(0);
			tname = "避雷器";
		}else if("syb".equals(name)){
			IZnycSybDao znycSybDao = DAOFactory.getZnycSybDao();
			wzjscss = znycSybDao.readData(0);
			tname = "所用变";
		}else if("dkq".equals(name)){
			IZnycDkqDao znycDkqDao = DAOFactory.getZnycDkqDao();
			wzjscss = znycDkqDao.readData(0);
			tname = "电抗器";
		}else if("mx".equals(name)){
			IZnycMxDao znycMxDao = DAOFactory.getZnycMxDao();
			wzjscss = znycMxDao.readData(0);
			tname = "母线";
		}else if("jdb".equals(name)){
			IZnycJdbDao znycJdbDao = DAOFactory.getZnycJdbDao();
			wzjscss = znycJdbDao.readData(0);
			tname = "接地变";
		}else if("kgg".equals(name)){
			IZnycKggDao znycKggDao = DAOFactory.getZnycKggDao();
			wzjscss = znycKggDao.readData(0);
			tname = "开关柜";
		}else if("dyhgq".equals(name)){
			IZnycDyhgqDao znycDyhgqDao = DAOFactory.getZnycDyhgqDao();
			wzjscss = znycDyhgqDao.readData(0);
			tname = "电压互感器";
		}else if("dlhgq".equals(name)){
			IZnycDlhgqDao znycDlhgqDao = DAOFactory.getZnycDlhgqDao();
			wzjscss = znycDlhgqDao.readData(0);
			tname = "电流互感器";
		}else if("dlq".equals(name)){
			IZnycDlqDao znycDlqDao = DAOFactory.getZnycDlqDao();
			wzjscss = znycDlqDao.readData(0);
			tname = "断路器";
		}
		//基本规则
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
					//没有找到验证规则的情况
					if(ruledata==null) {
						continue;
					}
					ruledata.put("tname", tname);
					String inputway = ruledata.get("inputway");
					String type = ruledata.get("type");

					if(inputway.equals("文本")) {
						testVarchar(requestData,ruledata);
					}else if(inputway.equals("数值")) {
						if(type.equals("VARCHAR")) {
							testVarchar(requestData,ruledata);
						}
					}else if(inputway.equals("下拉框")) {
						testSelect(requestData,ruledata);
					}else if(inputway.equals("日期")) {
						//testDate(requestData,ruledata);
					}else if(inputway.equals("选择")) {
						testSelect(requestData,ruledata);
					}
				}

				/**
				 * 业务规则
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
	 * ODS区数据规则
	 * @param istartBaseRule 是否运行基本规则
	 * @param istartBusRule 是否运行业务规则
	 */
	public static void testODSNew(boolean istartBaseRule,boolean istartBusRule){
		IDataSourceDao dataSourceDao =DAOFactory.getDataSourceDao();
		IDataRuleDao dataRuleDao = DAOFactory.getDataRuleDao();
		IDataStatisticDao dataStatisticDao = DAOFactory.getDataStatisticDao();
		IRuleLogDao ruleLogDao = DAOFactory.getRuleLogDao();
		//基本规则
		Map<String,Map<String,Map<String,String>>> rules = new HashMap();
		//列统计规则
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
				
				if(tname.equals("避雷器(变电)")) {
					sbname="避雷器";
				}
				if(tname.equals("开关柜(变电)")) {
					sbname="开关柜";
				}
				if(tname.equals("组合电器或复合电器")) {
					sbname="组合电器";
				}
				if(tname.equals("组合电器(变电)")) {
					sbname="组合电器";
				}
				if(tname.equals("电抗器(站内一次)")) {
					sbname="电抗器";
				}
				if(tname.equals("接地变压器")) {
					sbname="接地变";
				}
				if(tname.equals("所用变压器/柜")) {
					sbname="所用变";
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
				//没有找到验证规则的情况
				if(ruledata==null) {
					continue;
				}
				ruledata.put("tname", tname);

				/**
				 * 数据基本规则
				 */
				if(istartBaseRule) {
					String inputway = ruledata.get("inputway");
					String type = ruledata.get("type");
					if(inputway.equals("文本")) {
						testVarchar(requestData,ruledata);
					}else if(inputway.equals("数值")) {
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
					}else if(inputway.equals("下拉框")) {
						testSelect(requestData,ruledata);
					}else if(inputway.equals("日期")) {
						testDate(requestData,ruledata);
					}else if(inputway.equals("选择")) {
						testSelect(requestData,ruledata);
					}
				}

				/**
				 * 业务规则
				 */
				if(istartBusRule) {
					if(tname.equals("主变压器")) {
						testBusiness(requestData, ruledata, row,"zbyq");
					}else if(tname.equals("组合电器")){
						testBusiness(requestData, ruledata, row,"zhdq");
					}else if(tname.equals("电力电容器")){
						testBusiness(requestData, ruledata, row,"dldrq");
					}else if(tname.equals("配电变压器")){
						testBusiness(requestData, ruledata, row,"pdbyq");
					}else if(tname.equals("隔离开关")){
						testBusiness(requestData, ruledata, row,"glkg");
					}else if(tname.equals("避雷器")){
						testBusiness(requestData, ruledata, row,"blq");
					}else if(tname.equals("所用变")){
						testBusiness(requestData, ruledata, row,"syb");
					}else if(tname.equals("电抗器")){
						testBusiness(requestData, ruledata, row,"dkq");
					}else if(tname.equals("母线")){
						testBusiness(requestData, ruledata, row,"mx");
					}else if(tname.equals("接地变")){
						testBusiness(requestData, ruledata, row,"jdb");
					}else if(tname.equals("开关柜")){
						testBusiness(requestData, ruledata, row,"kgg");
					}else if(tname.equals("电压互感器")){
						testBusiness(requestData, ruledata, row,"dyhgq");
					}else if(tname.equals("电流互感器")){
						testBusiness(requestData, ruledata, row,"dlhgq");
					}else if(tname.equals("断路器")){
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
		MainApplication.testPMS("zbyq",true,true);//主变压器
		MainApplication.testPMS("zhdq",true,true);//组合电器
		MainApplication.testPMS("dldrq",true,true);//电力电容器
		MainApplication.testPMS("pdbyq",true,true);//配电变压器
		MainApplication.testPMS("glkg",true,true);//隔离开关
		MainApplication.testPMS("blq",true,true);//避雷器
		MainApplication.testPMS("syb",true,true);//所用变
		MainApplication.testPMS("dkq",true,true);//电抗器
		MainApplication.testPMS("mx",true,true);//母线
		MainApplication.testPMS("jdb",true,true);//开关柜
		MainApplication.testPMS("dyhgq",true,true);//电压互感器
		MainApplication.testPMS("dlhgq",true,true);//电流互感器
		MainApplication.testPMS("dlq",true,true);//断路器
		
		//MainApplication.testODSNew(true,true);
	}

}
