package com.qaii.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountDatetoNowDays {

	/*
	 * 计算参数与当前时间相差的天数
	 * @author wangxin
	 * @method return int:返回目标日期与当前日期相差的天数,return String:返回目标日期的时间戳
	 * @param Date d2 Date类型时间
	 * @param String d2 String类型时间
	 * @param String s1 时间戳类型时间
	 * @param String date 要转换为时间戳的date时间
	 * @param int addDay 要加在date时间上的天数
	 */
	
	//将参数日期格式化为时间戳类型
	public static String SDatetoStamp(String date) throws ParseException {
		if(date!=null&&date!="") {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal1=Calendar.getInstance();
			cal1.setTime(sdf.parse(date));
			date=String.valueOf(cal1.getTimeInMillis());
			return date;
		}else {
			return "";
		}		
	}
	
	//将时间戳类型参数转为日期
	public static String StamptoDate(String date) {
		if(date!=null&date!="") {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			long dt=new Long(date);
			System.out.println(sdf.format(new Date(dt)));
			return sdf.format(new Date(dt));
		}else {
			return "";
		}
		
	}
	
	//目标日期至今天相差的天数,参数为Date型
	public static int Datetonow(Date d2) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d1=sdf.parse(sdf.format(new Date()));
		d2=sdf.parse(sdf.format(d2));
		Calendar cal=Calendar.getInstance();
		cal.setTime(d1);
		long tm1=cal.getTimeInMillis();
		cal.setTime(d2);
		long tm2=cal.getTimeInMillis();
		long day=(tm2-tm1)/(1000*3600*24);
		
		return Integer.parseInt(String.valueOf(day));
	}
	
	//将日期类型格式化为yyyy-MM-dd字符串
	public static String DatetoString(Date date) {
		if(date!=null) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		}else {
			return "";
		}	
	}
	
	//目标日期至今日相差的天数，参数为String(yyyy-MM-dd)型
	public static int Stringtonow(String d2) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.setTime(sdf.parse(sdf.format(new Date())));
		long tm1=cal.getTimeInMillis();
		cal.setTime(sdf.parse(d2));
		long tm2=cal.getTimeInMillis();
		long  day=(tm2-tm1)/(1000*3600*24);
		
		return Integer.parseInt(String.valueOf(day));
	}
	
	//目标日期至今日相差的天数，参数为时间戳字符串
	public static int stamptonow(String s1) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		long l1=new Long(s1);
		Date date1=sdf.parse(sdf.format(new Date(l1)));
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		long tm1=cal.getTimeInMillis();
		cal.setTime(date1);
		long tm2=cal.getTimeInMillis();
		long day=(tm2-tm1)/(1000*3600*24);
		
		return Integer.parseInt(String.valueOf(day));
		
	}
	
	
	//将参数日期加上addDay天转换为时间戳类型
	public static String SDatetoStamp(String date,int addDay) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal1=Calendar.getInstance();
		cal1.setTime(sdf.parse(date));
		cal1.add(cal1.DATE, addDay);
		date=String.valueOf(cal1.getTimeInMillis());
		return date;
		
	}
	
	//返回参数日期加上addDay天的日期
	public static String DateaddDays(String date,int addDay) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		cal.add(cal.DATE, addDay);
		return sdf.format(cal.getTime());
	}
		
	//获取目标当月的时间戳参数以及上个月的时间戳，本月的key值为this，上月的为last
	public static Map<String,String> getfistDay(Date date) throws ParseException {
		Map<String, String> map=new HashMap<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal1=Calendar.getInstance();
		date=sdf.parse(sdf.format(date));
		cal1.setTime(date);
		cal1.set(cal1.DATE, 1);
		map.put("this", String.valueOf(cal1.getTimeInMillis()));
		cal1.add(cal1.MONTH, -1);
		map.put("last", String.valueOf(cal1.getTimeInMillis()));
		return map;
	}
	
	//获取目标当月1日的String型日期以及上个月1日的String日期，本月的key值为this，上月的为last
		public static Map<String,String> SgetfistDay(String date) throws ParseException {
			Map<String, String> map=new HashMap<>();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal1=Calendar.getInstance();
			cal1.setTime(sdf.parse(date));
			cal1.set(cal1.DATE, 1);
			map.put("this", sdf.format(cal1.getTime()));
			cal1.add(cal1.MONTH, -1);
			map.put("last", sdf.format(cal1.getTime()));
			return map;
		}
	
	/*
	 * 取得当前年的时间区间(去年的最后一天以及明年的第一天)
	 * @author wangxin
	 * @param example:'1971/01/01'
	 * 
	 */
	
	public static Map<String , String> FirstandEndDayofYear(String date) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		Map<String, String> map=new HashMap<>();
		cal.setTime(sdf.parse(date));
		cal.add(cal.YEAR, 1);
		cal.set(cal.MONTH, Calendar.JANUARY);
		cal.set(cal.DATE, 1);
		map.put("this", sdf.format(cal.getTime()));
		cal.add(cal.YEAR, -1);
		cal.add(cal.DATE, -1);
		map.put("last", sdf.format(cal.getTime()));
		return map;
		
	}
	
	//获取包括当前时间的前几个月
	public static List<String> getpremonth(String date,int add) throws ParseException{
		List<String> result = new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		for(int i=0;i<add;i++) {
			result.add(sdf.format(cal.getTime()));
			cal.add(cal.MONTH, -1);
		}
			
		return result;
		
	}
	
	//获取包括当前年的前几年日期
	public static List<String> getpreYears(String date,int add) throws ParseException{
		List<String> result=new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		for(int i=0;i<add;i++) {
			result.add(sdf.format(cal.getTime()));
			cal.add(cal.YEAR, -1);
		}
		return result;
	}
}
