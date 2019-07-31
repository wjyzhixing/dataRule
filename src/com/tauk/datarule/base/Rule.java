package com.tauk.datarule.base;

public interface Rule {

	public void applyRule(Request request, Response response,RuleChain chain);
	
}
