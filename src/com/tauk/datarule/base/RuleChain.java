package com.tauk.datarule.base;

import java.util.ArrayList;
import java.util.List;

public class RuleChain implements Rule {

	 //��List�������洢���˹���
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
		   
		   //��������ֵ��ȡ��Ӧ�Ĺ��ɹ�����ַ������д���
		   f.applyRule(request, response, chain);
	}

}
