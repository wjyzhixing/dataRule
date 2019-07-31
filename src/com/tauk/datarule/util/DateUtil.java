package com.tauk.datarule.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {

	public static String getYesDate(){
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)-1);
		Date date1 = new Date(calendar.getTimeInMillis());
		String yesDate = sdf.format(date1);
		return yesDate;
	}
	
	public static String getNowDate(){
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(now);
	}
	
}
