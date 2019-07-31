package com.tauk.datarule.dao.factory;

import com.tauk.datarule.dao.IDataRuleDao;
import com.tauk.datarule.dao.IDataSourceDao;
import com.tauk.datarule.dao.IDataStatisticDao;
import com.tauk.datarule.dao.IPrimaryDataDao;
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
import com.tauk.datarule.dao.impl.DataRuleDaoImpl;
import com.tauk.datarule.dao.impl.DataSourceDaoImpl;
import com.tauk.datarule.dao.impl.DataStatisticDaoImpl;
import com.tauk.datarule.dao.impl.PrimaryDataDaoImpl;
import com.tauk.datarule.dao.impl.ProblemBillDaoImpl;
import com.tauk.datarule.dao.impl.RuleDaoImpl;
import com.tauk.datarule.dao.impl.ZnycBlqDaoImpl;
import com.tauk.datarule.dao.impl.ZnycDkqDaoImpl;
import com.tauk.datarule.dao.impl.ZnycDldrqDaoImpl;
import com.tauk.datarule.dao.impl.ZnycDlhgqDaoImpl;
import com.tauk.datarule.dao.impl.ZnycDlqDaoImpl;
import com.tauk.datarule.dao.impl.ZnycDyhgqDaoImpl;
import com.tauk.datarule.dao.impl.ZnycGlkgDaoImpl;
import com.tauk.datarule.dao.impl.ZnycJdbDaoImpl;
import com.tauk.datarule.dao.impl.ZnycKggDaoImpl;
import com.tauk.datarule.dao.impl.ZnycMxDaoImpl;
import com.tauk.datarule.dao.impl.ZnycPdbyqDaoImpl;
import com.tauk.datarule.dao.impl.ZnycSybDaoImpl;
import com.tauk.datarule.dao.impl.ZnycZbyqDaoImpl;
import com.tauk.datarule.dao.impl.ZnycZhdqDaoImpl;

public class DAOFactory {

	public static IDataRuleDao getDataRuleDao(){
		return new DataRuleDaoImpl();
	}
	
	public static IDataSourceDao getDataSourceDao(){
		return new DataSourceDaoImpl();
	}
	
	public static IProblemBillDao getProblemBillDao() {
		return new ProblemBillDaoImpl();
	}
	
	public static IPrimaryDataDao getPrimaryDataDao() {
		return new PrimaryDataDaoImpl();
	}
	
	public static IDataStatisticDao getDataStatisticDao() {
		return new DataStatisticDaoImpl();
	}
	
	public static IRuleLogDao getRuleLogDao() {
		return new RuleDaoImpl();
	}
	
	public static IZnycZbyqDao getZnycZbyqDao() {
		return new ZnycZbyqDaoImpl();
	}
	public static IZnycZhdqDao getZnycZhdqDao() {
		return new ZnycZhdqDaoImpl();
	}

	public static IZnycDldrqDao getZnycDldrqDao() {
		return new ZnycDldrqDaoImpl();
	}

	public static IZnycPdbyqDao getZnycPdbyqDao() {
		return new ZnycPdbyqDaoImpl();
	}

	public static IZnycGlkgDao getZnycGlkgDao() {
		return new ZnycGlkgDaoImpl();
	}

	public static IZnycBlqDao getZnycBlqDao() {
		return new ZnycBlqDaoImpl();
	}

	public static IZnycSybDao getZnycSybDao() {
		return new ZnycSybDaoImpl();
	}

	public static IZnycDkqDao getZnycDkqDao() {
		return new ZnycDkqDaoImpl();
	}

	public static IZnycMxDao getZnycMxDao() {
		return new ZnycMxDaoImpl();
	}

	public static IZnycJdbDao getZnycJdbDao() {
		return new ZnycJdbDaoImpl();
	}
	
	//开关柜
	public static IZnycKggDao getZnycKggDao() {
		return new ZnycKggDaoImpl();
	}
	//电压互感器
	public static IZnycDyhgqDao getZnycDyhgqDao() {
		return new ZnycDyhgqDaoImpl();
	}
	
	//电流互感器
	public static IZnycDlhgqDao getZnycDlhgqDao() {
		return new ZnycDlhgqDaoImpl();
	}
		
	//断路器
	public static IZnycDlqDao getZnycDlqDao() {
		return new ZnycDlqDaoImpl();
	}
	
}
