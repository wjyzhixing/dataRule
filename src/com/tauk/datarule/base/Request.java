package com.tauk.datarule.base;

import java.util.Map;

/**
 * 请求数据封装
 * @author zyb_s
 *
 */
public class Request {

	/**
	 * 数据,json格式{field:'XH',value:'S13-M-100/10'}
	 * field:字段名称
	 * value:数据值
	 */
	private Map<String,String> requestData;
	
	/**
	 * 数据规则,json格式{field:'XH',required:'是',type:'NUMBER',totalbit:'12',decimalbit:'2'}
	 *        json格式{field:'XH',required:'是',type:'VARCHAR',length:'80'}
	 *        json格式{field:'XH',required:'是',type:'SELECT',selectvalue:'1,2,3,4,5,6'}
	 *        json格式{field:'XH',required:'是',type:'NUMBER',totalbit:'12',decimalbit:'2',min:'1',max:'10'}
	 * field:字段名称
	 * required:是否是必填项
	 * type:字段类型
	 * totalbit:总位数
	 * decimalbit:小数位
	 * length:字符串总长度
	 * selectvalue:选择框的值
	 * min:最小值
	 * max:最大值
	 */
	private Map<String,String> dataRule;
	
	/**
	 * 整行数据
	 */
	private Map<String,String> row;


	public Map<String, String> getRequestData() {
		return requestData;
	}

	public void setRequestData(Map<String, String> requestData) {
		this.requestData = requestData;
	}

	public Map<String, String> getDataRule() {
		return dataRule;
	}

	public void setDataRule(Map<String, String> dataRule) {
		this.dataRule = dataRule;
	}

	public Map<String, String> getRow() {
		return row;
	}

	public void setRow(Map<String, String> row) {
		this.row = row;
	}
   
}
