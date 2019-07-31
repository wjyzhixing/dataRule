package com.tauk.datarule.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String columntype = "NUMBER(12)";
		
		System.out.println(columntype.substring(columntype.indexOf("(")+1,columntype.length()-1));
//		System.out.println(columntype.substring(columntype.indexOf("(")+1,columntype.indexOf(",")));
//		System.out.println(columntype.substring(columntype.indexOf(",")+1,columntype.indexOf(")")));
		
		String reg = "(^[0-9]*$)||"+"^[0-9]{1,"+(Integer.parseInt("12")-1)+"}\\.[0-9]{1,"+4+"}$";
		
		// reg = "(^[0-9]*$)||"+"^[0-9]{1,"+(Integer.parseInt("12")-1)+"}.[0]*$";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher("50");
		boolean b = m.matches();
		System.out.println(b);
		
		
		//5000.0000
		String value = "5000.00";
		String treg = "^[0-9]{1,10}\\.{1,1}[0]*$";
		Pattern tp = Pattern.compile(treg);
		Matcher tm = tp.matcher(value);
		boolean tb = tm.matches();
		
		if(tb) {
			 value = value.substring(0,value.indexOf("."));
			 System.out.println(value);
		}
		
		String xh = "SZ10-M-5000/35";
		
		String tvalue = xh.substring(xh.lastIndexOf("-")+1, xh.lastIndexOf("/"));
		
		System.out.println(tvalue);
		
		System.out.println(Double.valueOf("31500")/1000==Double.valueOf("31.5000"));
		
		if(xh.indexOf("-")!=-1) {
			String xhs[] = xh.split("-");
			if(xhs.length==3) {
				tvalue  = xh.substring(xh.indexOf("-")+1, xh.lastIndexOf("-"));
			}else {
				tvalue  = xh.substring(xh.lastIndexOf("-")+1, xh.lastIndexOf("/"));
			}
			
		}else {
			String xhs[] = xh.split("/");
			if(xhs.length==3) {
				tvalue  = xh.substring(xh.indexOf("/")+1, xh.lastIndexOf("/"));
			}else {
				System.out.println(xh+"*****"+tvalue);
			}
		}
		
		
		String rqregex="((^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(10|12|0?[13578])([-\\/\\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(11|0?[469])([-\\/\\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(0?2)([-\\/\\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([3579][26]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$))";
		
				
		Pattern rqp = Pattern.compile(rqregex);
		Matcher rqm = rqp.matcher("2008-2-22");
		boolean rqb = rqm.matches();
		System.out.println("rqb="+rqb);
		
		
		
	}

}
