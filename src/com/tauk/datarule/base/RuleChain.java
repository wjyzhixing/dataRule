package com.tauk.datarule.base;

import java.util.ArrayList;
import java.util.List;

public class RuleChain implements Rule {

	 //用List集合来存储过滤规则
	private List<Rule> ruleFilters = new ArrayList<Rule>();
    private int index=0;
    
	public RuleChain addRule(Rule rule) {
		ruleFilters.add(rule);
		return this;
	}
	
	@Override
	public void applyRule(Request request, Response response, RuleChain chain) {
		
		   if(index==ruleFilters.size()){
		          return;
		      }
		         
		   Rule f=ruleFilters.get(index);
		   index++;
		   
		   //根据索引值获取对应的规律规则对字符串进行处理
		   f.applyRule(request, response, chain);
	}

}
