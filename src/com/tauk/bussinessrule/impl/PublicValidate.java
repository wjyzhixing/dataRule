package com.tauk.bussinessrule.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class PublicValidate {

	/** 额定容量:zbyq0006
	 *       型号 中-与/ 之间的数除1000
	 */
	public static boolean validateEDRL(String value,Map<String,String> row) {
		//短路阻抗（高压-中压）
		String xh = row.get("XH");

		if(xh==null) {
			return true;
		}

		if(value==null) {
			return true;
		}

		String tvalue = xh;

		//SZ11-6300/35SZ11-6300/35    S7-3150-35
		if(xh.indexOf("-")!=-1) {

			if(xh.indexOf("/")!=-1) {
				if(xh.lastIndexOf("-")<xh.lastIndexOf("/")) {
					tvalue  = xh.substring(xh.lastIndexOf("-")+1, xh.lastIndexOf("/"));
				}else {
					//SL-500/35-T
					tvalue  = xh.substring(xh.indexOf("-")+1, xh.lastIndexOf("/"));
				}

			}else {
				String xhs[] = xh.split("-");
				if(xhs.length==3) {
					tvalue  = xh.substring(xh.indexOf("-")+1, xh.lastIndexOf("-"));
				}
			}


		}else {
			String xhs[] = xh.split("/");
			if(xhs.length==3) {
				tvalue  = xh.substring(xh.indexOf("/")+1, xh.lastIndexOf("/"));
			}else {
				return true;
			}
		}


		if((Double.valueOf(tvalue)/1000)==(Double.valueOf(value))) {
			return true;
		}
		return false;
	}

	public static boolean validateTyrq(String value,Map<String,String> row) {

		String ccrq = row.get("CCRQ");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {

        	if(value==null ||ccrq==null) {
        		return true;
        	}

            Date dt1 = df.parse(value);
            Date dt2 = df.parse(ccrq);
            if (dt1.getTime() > dt2.getTime()) {
                return true;
            } else if (dt1.getTime() <= dt2.getTime()) {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
		return true;
	}
	
}
