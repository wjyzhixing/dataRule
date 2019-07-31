package com.tauk.datarule.dao;

import com.tauk.datarule.model.RuleLog;

public interface IRuleLogDao {

	public void addRuleLog(RuleLog ruleLog);
	
	public int getMaxXh();
}
