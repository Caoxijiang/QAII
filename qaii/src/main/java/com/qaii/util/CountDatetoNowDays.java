package com.qaii.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.fabric.xmlrpc.base.Data;
import com.qaii.domain.EmpInfo;

public class CountDatetoNowDays {
	
	//将参数日期格式化为时间戳类型
	public static String SDatetoStamp(String date) throws ParseException {
		if(date==null) {
			return null;
		}
		else if(date.equals("")) {
			return null;
		}
		else {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal1=Calendar.getInstance();
			cal1.setTime(sdf.parse(date));
			date=String.valueOf(cal1.getTimeInMillis());
			return date;
		}	
	}
	
	//将时间戳类型参数转为日期
	public static String StamptoDate(String date) {
		if(date==null) {
			return null;
		}
		else if(date.equals("")) {
			return null;
		}
		else {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			long dt=new Long(date);
			return sdf.format(new Date(dt));
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


	//返回参数日期减去3个月的日期
	public static Date Monthlow(String date) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.setTime(sdf.parse(date));
		cal.add(cal.MONTH,-3);
		return cal.getTime();
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
	
	// 获取参数日期当前月第一天与最后一天的日期,返回类型为日期类型
	public static Map<String, String> getBothEnds(String date) throws ParseException{
		Map<String, String> result =new HashMap<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal1=Calendar.getInstance();
		cal1.setTime(sdf.parse(date));
		cal1.set(cal1.DATE, 1);
		result.put("first", sdf.format(cal1.getTime()));
		cal1.add(cal1.MONTH, +1);
		cal1.add(cal1.DATE, -1);
		result.put("end", sdf.format(cal1.getTime()));
		return result;
	}
	
	 // 取得当前年的时间区间(去年的最后一天以及明年的第一天)
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
	
	//将bean中的时间类型转换为时间戳类型
	public static EmpInfo TranstoStamp(EmpInfo emp) throws ParseException {
		if(emp!=null) {
			emp.setEmpTryoutendtime(CountDatetoNowDays.SDatetoStamp(emp.getEmpTryoutendtime()));	
			emp.setEmpIdcardEndtime(CountDatetoNowDays.SDatetoStamp(emp.getEmpIdcardEndtime()));
			emp.setEmpContractendtime(CountDatetoNowDays.SDatetoStamp(emp.getEmpContractendtime()));
			emp.setEmpFirstgraduationtime(CountDatetoNowDays.SDatetoStamp(emp.getEmpFirstgraduationtime()));	
			emp.setEmpSecondgraduationtime(CountDatetoNowDays.SDatetoStamp(emp.getEmpSecondgraduationtime()));	
			emp.setEmpThirdgraduationtime(CountDatetoNowDays.SDatetoStamp(emp.getEmpThirdgraduationtime()));	
			emp.setEmpInductiontime(CountDatetoNowDays.SDatetoStamp(emp.getEmpInductiontime()));
			emp.setEmpJobtitleobtaintime(CountDatetoNowDays.SDatetoStamp(emp.getEmpJobtitleobtaintime()));
			emp.setEmpDepartureTime(CountDatetoNowDays.SDatetoStamp(emp.getEmpDepartureTime()));
			emp.setEmpOthergraduationtime(CountDatetoNowDays.SDatetoStamp(emp.getEmpOthergraduationtime()));
		}
		return emp;
	}
	
	//将bean中的时间戳类型转换为时间类型
	public static  EmpInfo TranstoDate(EmpInfo emp) {
		if(emp!=null) {
			emp.setEmpTryoutendtime(CountDatetoNowDays.StamptoDate(emp.getEmpTryoutendtime()));
			emp.setEmpIdcardEndtime(CountDatetoNowDays.StamptoDate(emp.getEmpIdcardEndtime()));
			emp.setEmpContractendtime(CountDatetoNowDays.StamptoDate(emp.getEmpContractendtime()));
			emp.setEmpFirstgraduationtime(CountDatetoNowDays.StamptoDate(emp.getEmpFirstgraduationtime()));
			emp.setEmpSecondgraduationtime(CountDatetoNowDays.StamptoDate(emp.getEmpSecondgraduationtime()));
			emp.setEmpThirdgraduationtime(CountDatetoNowDays.StamptoDate(emp.getEmpThirdgraduationtime()));
			emp.setEmpInductiontime(CountDatetoNowDays.StamptoDate(emp.getEmpInductiontime()));
			emp.setEmpDepartureTime(CountDatetoNowDays.StamptoDate(emp.getEmpDepartureTime()));
			emp.setEmpJobtitleobtaintime(CountDatetoNowDays.StamptoDate(emp.getEmpJobtitleobtaintime()));
			emp.setEmpOthergraduationtime(CountDatetoNowDays.StamptoDate(emp.getEmpOthergraduationtime()));
		}
		return emp;
	}

	//讲string类型转为date类型
	public static Date StringConvertToDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		if(!"".equals(str))
			try{
				return  sdf.parse(str);
			}
			catch (ParseException e){
				e.printStackTrace();
				return null;
			}
		else
			return null;
	}
	
	public static Date StrconversionData(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(time);
            return date;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
          //  e.printStackTrace();
        	throw e;
           // return null;
        }
       
		
	}
	
	
	
}
