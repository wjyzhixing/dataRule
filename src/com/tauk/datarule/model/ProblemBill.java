package com.tauk.datarule.model;

public class ProblemBill {

	private int problemid;
	private String datapk;
	private String problemcode;
	private String problemdesc;
	private String problemfield;
	private String problemfieldcomment;
	private String createtime;
	private String tname;
	private String tid;
	private String problemstatus="0";
	//数据来源哪里
	private String datasource="ODS";
	
	public int getProblemid() {
		return problemid;
	}
	public void setProblemid(int problemid) {
		this.problemid = problemid;
	}
	public String getDatapk() {
		return datapk;
	}
	public void setDatapk(String datapk) {
		this.datapk = datapk;
	}
	public String getProblemcode() {
		return problemcode;
	}
	public void setProblemcode(String problemcode) {
		this.problemcode = problemcode;
	}
	public String getProblemdesc() {
		return problemdesc;
	}
	public void setProblemdesc(String problemdesc) {
		this.problemdesc = problemdesc;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getProblemfield() {
		return problemfield;
	}
	public void setProblemfield(String problemfield) {
		this.problemfield = problemfield;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getProblemstatus() {
		return problemstatus;
	}
	public void setProblemstatus(String problemstatus) {
		this.problemstatus = problemstatus;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	public String getProblemfieldcomment() {
		return problemfieldcomment;
	}
	public void setProblemfieldcomment(String problemfieldcomment) {
		this.problemfieldcomment = problemfieldcomment;
	}
	
}
