package com.tauk.datarule.base;

import java.util.Map;

/**
 * �������ݷ�װ
 * @author zyb_s
 *
 */
public class Request {

	/**
	 * ����,json��ʽ{field:'XH',value:'S13-M-100/10'}
	 * field:�ֶ�����
	 * value:����ֵ
	 */
	private Map<String,String> requestData;
	
	/**
	 * ���ݹ���,json��ʽ{field:'XH',required:'��',type:'NUMBER',totalbit:'12',decimalbit:'2'}
	 *        json��ʽ{field:'XH',required:'��',type:'VARCHAR',length:'80'}
	 *        json��ʽ{field:'XH',required:'��',type:'SELECT',selectvalue:'1,2,3,4,5,6'}
	 *        json��ʽ{field:'XH',required:'��',type:'NUMBER',totalbit:'12',decimalbit:'2',min:'1',max:'10'}
	 * field:�ֶ�����
	 * required:�Ƿ��Ǳ�����
	 * type:�ֶ�����
	 * totalbit:��λ��
	 * decimalbit:С��λ
	 * length:�ַ����ܳ���
	 * selectvalue:ѡ����ֵ
	 * min:��Сֵ
	 * max:���ֵ
	 */
	private Map<String,String> dataRule;
	
	/**
	 * ��������
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
