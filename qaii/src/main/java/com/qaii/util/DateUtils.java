package com.qaii.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.StringUtils;

public class DateUtils extends org.apache.commons.lang.time.DateUtils{
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("",
			Locale.SIMPLIFIED_CHINESE);

	private static String deaultDateTimeFormatFull = "yyyy-MM-dd HH:mm:ss";

	private static String deaultDateFormat = "yyyy-MM-dd";

	/**
	 * 返回当前的小时
	 */
	public static int getHour() {
		GregorianCalendar gcNow = new GregorianCalendar();
		return gcNow.get(GregorianCalendar.HOUR);
	}

	/**
	 * 返回当前的分钟
	 * @return int 返回当前的分钟
	 */
	public static int getMinute() {
		GregorianCalendar gcNow = new GregorianCalendar();
		return gcNow.get(GregorianCalendar.MINUTE);
	}

	/**
	 * 返回当前的秒数
	 * @return int 第几秒
	 */
	public static int getSecond() {
		GregorianCalendar gcNow = new GregorianCalendar();
		return gcNow.get(GregorianCalendar.SECOND);
	}

	/**
	 * 返回今天是本月的第几天
	 */
	public static int getToDayOfMonth() {
		GregorianCalendar gcNow = new GregorianCalendar();
		return gcNow.get(GregorianCalendar.DAY_OF_MONTH);
	}

	/**
	 * 返回今天是本年的第几周 
	 * @return int 从1开始
	 */
	public static int getToWeekOfYear() {
		GregorianCalendar gcNow = new GregorianCalendar();
		return gcNow.get(GregorianCalendar.WEEK_OF_YEAR);
	}

	/**
	 * 返回本月
	 */
	public static int getThisMonth() {
		GregorianCalendar gcNow = new GregorianCalendar();
		return gcNow.get(GregorianCalendar.MONTH) + 1;
	}

	/**
	 * 返回当前年
	 */
	public static int getThisYear() {
		GregorianCalendar gcNow = new GregorianCalendar();
		return gcNow.get(GregorianCalendar.YEAR);
	}

	/**
	 * 返回一个当前的时间，并按格式转换为字符串
	 * 例：17:27:03
	 */
	public static String getNowTime() {
		GregorianCalendar gcNow = new GregorianCalendar();
		Date dNow = gcNow.getTime();
		DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM,
				Locale.SIMPLIFIED_CHINESE);
		return df.format(dNow);
	}

	/**
	 * 返回一个当前的完整时间，并按格式转换为字符串
	 * 例：2009-11-03 13:50:46
	 */
	public static String getFullDate() {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date());
	}

	/**
	 * 返回一个当前的完整时间，并按格式转换为字符串
	 * 例：20091103135046125
	 */
	public static String getFullDateString() {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmssSS");
		return dateFormat.format(new Date());
	}
	
	/**
	 * 返回一个当前的时间，并按格式转换为字符串
	 * 例：20091103
	 */
	public static String getDateString() {
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(new Date());
	}

	/**
	 * 返回一个当前日期，并按格式转换为字符串
	 * 例：2004-4-30
	 */
	public static String getNowDate() {
		return DateUtils.parseDateToString(new Date());
	}

	/**
	 * 返回一个当前日期和时间，并按格式转换为字符串
	 * 例：2004-4-30 17:27:03
	 */
	public static String getNowDateTime() {
		GregorianCalendar gcNow = new GregorianCalendar();
		java.util.Date dNow = gcNow.getTime();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.SIMPLIFIED_CHINESE);
		return df.format(dNow);
	}

	/**
	 * 计算两日期之间的天数
	 * @param sd 起始日期，格式yyyy-MM-dd
	 * @param ed 终止日期，格式yyyy-MM-dd
	 * @return 天数
	 */
	public static long getIntervalDay(String sd, String ed) {
		return ((java.sql.Date.valueOf(ed)).getTime() - (java.sql.Date.valueOf(sd)).getTime()) / (3600 * 24 * 1000);
	}

	/**
	 * 计算两日期之间的月数
	 * @param String startT 开始日期
	 * @param String endT 结束日期
	 * @return int 月数
	 */
	public static int getIntervalMonth(String startT, String endT) {
		startT = formatDate(startT);
		endT = formatDate(endT);
		int i = Integer.parseInt(startT.substring(0, 4));
		int j = Integer.parseInt(endT.substring(0, 4));
		int i1 = Integer.parseInt(startT.substring(5, 7));
		int j1 = Integer.parseInt(endT.substring(5, 7));
		return (j - i) * 12 + (j1 - i1);
	}

	/**
	 * 计算两日期之间的年数
	 * @param startT 开始日期
	 * @param endT 结束日期
	 * @return int 年数
	 */
	public static int getIntervalYear(String startT, String endT) {
		startT = formatDate(startT);
		endT = formatDate(endT);
		int i = Integer.parseInt(startT.substring(0, 4));
		int j = Integer.parseInt(endT.substring(0, 4));
		return j - i;
	}

	/**
	 * 将yyyy-MM-dd类型的字符串转换为Date类型 如果字符串日期不合法
	 * @param str 需要转换的日期字符串
	 * @return 转换后的日期类型
	 */
	public static Date parseStringToDate(String str) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(str);
		}
		catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 将yyyy-MM-dd HH:MM:SS类型的字符串转换为Date类型 如果字符串日期不合法
	 * @param str 需要转换的日期字符串
	 * @return 转换后的日期类型
	 */
	public static Date parseStringToDateTime(String str) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return dateFormat.parse(str);
		} catch (Exception ex) {
			System.out.println("DateUtils.java : " + ex.getMessage());
			return null;
		}
	}
	
	/**
	 * 将MM/dd/yyyy类型的字符串转换为Date类型 如果字符串日期不合法
	 * @param str 需要转换的日期字符串
	 * @return 转换后的日期类型
	 */
	public static Date parseStringToDateA(String str) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			return dateFormat.parse(str);
		}
		catch (Exception ex) {
			return null;
		}
	}

	/**
	 * 将Date类型数据转换为yyyy-MM-dd字符串
	 * @param date 需要转换的日期
	 * @return 转换后的字符串
	 */
	public static String parseDateToString(Date date) {
		return DateFormatUtils.ISO_DATE_FORMAT.format(date);
	}

	/**
	 * 得到指定日期的加，减天数后的字符串日期。
	 * @param str 指定的日期
	 * @param day 加减的天数
	 * @return 计算后的日期
	 */
	public static String getAddDays(String str, int day) {
		Date date = parseStringToDate(str);
		return parseDateToString(org.apache.commons.lang.time.DateUtils.addDays(date, day));
	}

	/**
	 * 得到指定日期的加，减星期数后的字符串日期。
	 * @param str 指定的日期
	 * @param week 加减的星期数
	 * @return 计算后的日期
	 */
	public static String getAddWeeks(String str, int week) {
		Date date = parseStringToDate(str);
		return parseDateToString(org.apache.commons.lang.time.DateUtils.addWeeks(date, week));
	}

	/**
	 * 得到指定日期的加，减月数后的字符串日期。
	 * @param str 指定的日期
	 * @param month 加减的月数
	 * @return 计算后的日期
	 */
	public static String getAddMonths(String str, int month) {
		Date date = parseStringToDate(str);
		return parseDateToString(org.apache.commons.lang.time.DateUtils.addMonths(date, month));
	}

	/**
	 * 得到指定日期加，减年数后的日期字符串。
	 * @param str 指定的日期
	 * @param year 加减的年数
	 * @return 计算后的日期
	 */
	public static String getAddYears(String str, int year) {
		Date date = parseStringToDate(str);
		return parseDateToString(org.apache.commons.lang.time.DateUtils.addYears(date, year));
	}

	/**
	 * 功能：将日期转为标准格式YYYY-MM-DD
	 * @param String dt (YYYY-M-D,YYYY-M-DD,YYYY-MM-D)
	 */
	public static String formatDate(String dt) {
		String retDt = "";
		try {
			if (null == dt || dt.length() == 0) {
				return "";
			}
			else {
				String year = "";
				String month = "";
				String date = "";
				int idx = dt.indexOf("-", 5);
				if (idx == -1)
					return "";
				year = dt.substring(0, 4);
				month = dt.substring(5, idx);
				if (month.length() == 1)
					month = "0" + month;
				date = dt.substring(idx + 1);
				if (date.length() == 1)
					date = "0" + date;
				retDt = year + "-" + month + "-" + date;
			}
			return retDt;
		}
		catch (Exception e) {
			return "";
		}
	}

	/**
	 * 比较两日期字符串的大小
	 * 如果想等返回2，如果d1大于d2返回0，如果小于返回2
	 * @param d1
	 * @param d2
	 * @return (d1>d2)?2:(d1=d2)?1:0
	 */
	public static int compareDate(String d1, String d2) {
		short vl = 1;
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(parseStringToDate(d1));
		int year = gc.get(GregorianCalendar.YEAR);
		int month = gc.get(GregorianCalendar.MONTH);
		int day = gc.get(GregorianCalendar.DAY_OF_MONTH);
		gc.setTime(parseStringToDate(d2));
		int tempYear = gc.get(GregorianCalendar.YEAR);
		int tempMonth = gc.get(GregorianCalendar.MONTH);
		int tempDay = gc.get(GregorianCalendar.DAY_OF_MONTH);
		if (year != tempYear) {
			if (year >= tempYear)
				vl = 2;
			else
				vl = 0;
		} else {
			if (month != tempMonth) {
				if (month >= tempMonth)
					vl = 2;
				else
					vl = 0;
			} else {
				if (day != tempDay) {
					if (day >= tempDay)
						vl = 2;
					else
						vl = 0;
				}
			}
		}
		return vl;
	}

	/**
	 * 判断日期是否在3天内
	 */
	public static boolean isNewDate(String parDate) {
		String now = DateUtils.getNowDate();
		String pre = DateUtils.getAddDays(now, -3);
		return DateUtils.compareDate(parDate, pre) == 2 ? true : false;
	}

	/**
	 * 功能：将Date类型数据转换为YYYY-mm-dd 字符串,如果传入的参数日期是1900-01-01 ,那么返回的字符串为""
	 * @param date  需要转换的日期
	 * @return 转换后的字符串
	 */
	public static String dateToStr(Date date) {
		String retDate = dateToOriStr(date);
		if (retDate.equals("1900-01-01")) {
			retDate = "";
		}
		return retDate;
	}

	/**
	 * 功能：将Date类型数据转换为yyyy-MM-dd字符串
	 * @param date  需要转换的日期
	 * @return 转换后的字符串
	 */
	public static String dateToOriStr(Date date) {
		if (date == null) {
			return null;
		}
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(deaultDateFormat);
		return dateFormat.format(date);
	}

	/**
	 * 功能：将Date类型数据转换为yyyy-MM-dd hh24:mm:ss字符串
	 * @param date  需要转换的日期
	 * @return 转换后的字符串
	 */
	public static String dateToStrFull(Date date) {
		if (date == null) {
			return "1900-01-01";
		}
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(deaultDateTimeFormatFull);
		return dateFormat.format(date);
	}
	
	/**
	 * 日期截取[去除时间部分]
	 * 例如: 将2008-06-10 00:00:00.0 转换为 2008-06-10
	 */
	public static String getSubDateString(String parDateString) {
		String str = "";
		if (StringUtils.isBlank(parDateString)) {
			return str;
		}
		if (parDateString.length() == 10) {
			return parDateString;
		}
		str = parDateString.substring(0, parDateString.indexOf(" "));
		return str;
	}

	/**
	 * 日期截取[去除年份]
	 */
	public static String getSubDateForYear(String parStr) {
		String str = "";
		if (StringUtils.isBlank(parStr)) {
			return str;
		}
		if (parStr.length() == 5) {
			return parStr;
		}
		str = parStr.substring(5, 10);
		return str;
	}

	/**
	 * 日期截取
	 * 例如: 将2009-12-11 16:13:02.480 转换为 2009-12-11 16:13:02
	 */
	public static String getSubDate(String parDateString) {
		String str = "";
		if (StringUtils.isBlank(parDateString)) {
			return str;
		}
		if (parDateString.length() == 19) {
			return parDateString;
		}
		str = parDateString.substring(0, parDateString.lastIndexOf("."));
		return str;
	}

	public static String getNowMonthFirstDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
        return str.toString();
    }

	public static String getNowMonthLastDay() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        String s = df.format(theDate);
        StringBuffer str = new StringBuffer().append(s).append(" 23:59:59");
        return str.toString();
    }

	public static String getMonthFirstDay(String parDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date theDate = DateUtils.parseStringToDate(parDate);
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
        return str.toString();
	}
	/**
	 * 将yyyy-MM-dd格式化yyyy-MM-dd 00:00:00 
	* <p>Title: getStartTime</p>
	* <p>Description: </p>
	* @author cong.sun
	* @param startTime
	* @return
	 */
	public static String getStartTime(String startTime){
		String str = "";
		if (StringUtils.isBlank(startTime)) {
			return str;
		}
		if (startTime.length() == 10) {
			return startTime+" 00:00:00";
		}
		str = startTime.substring(0, startTime.indexOf(" "))+" 00:00:00";
		return str;
	}
	
	public static String getEndTime(String endTime){
		String str = "";
		if (StringUtils.isBlank(endTime)) {
			return str;
		}
		if (endTime.length() == 10) {
			return endTime+" 23:59:59";
		}
		str = endTime.substring(0, endTime.indexOf(" "))+" 23:59:59";
		return str;
	}

	public static String getMonthLastDay(String parDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date theDate = DateUtils.parseStringToDate(parDate);
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        gcLast.add(Calendar.MONTH, 1);
        gcLast.set(Calendar.DATE, 1);
        gcLast.add(Calendar.DATE, -1);
        String day_first = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first).append(" 00:00:00");
        return str.toString();
	}
	
	/**
	 * 时间戳转换成日期
	 * @param timestampString
	 * @return
	 */
	public static String TimeStamp2Date(String timestampString){  
	  Long timestamp = Long.parseLong(timestampString)*1000;  
	  String date = new java.text.SimpleDateFormat(deaultDateTimeFormatFull).format(new java.util.Date(timestamp));  
	  return date;  
	}  
	
	/**
	 * 把yyyymmdd转成yyyy-MM-dd格式
	 * @param str
	 * @return
	 */
	public static String strDate(String str){
	  SimpleDateFormat sf1 = new SimpleDateFormat("yyyyMMdd");
	     SimpleDateFormat sf2 =new SimpleDateFormat("yyyy-MM-dd");
	     String sfstr = "";
	     try {
	      sfstr = sf2.format(sf1.parse(str));
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	  return sfstr;
	 }
	
	 /**
     * 循环便利每个日期
     * @param begDate
     * @param endDate
     * @return
     */
    public static List getDateList(String begDate,String endDate){
    	List list=new ArrayList();
    	 //请注意月份是从0-11
        Calendar start = Calendar.getInstance();
        start.set(Integer.parseInt(begDate.substring(0, 4)),Integer.parseInt(begDate.substring(5, 7))-1,Integer.parseInt(begDate.substring(8, 10)));
        Calendar end = Calendar.getInstance();
        end.set(Integer.parseInt(endDate.substring(0, 4)),Integer.parseInt(endDate.substring(5, 7))-1,Integer.parseInt(endDate.substring(8, 10)));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        while(start.getTime().compareTo(end.getTime()) <= 0) {
            list.add(format.format(start.getTime()));
            start.set(Calendar.DATE, start.get(Calendar.DATE) + 1);
        }
    	return list;
    }
    
    /**
	 * 获取时间戳
	 * @param d
	 *            要获取其时间戳的日期值
	 * @return 时间戳
	 */
	public static final String getTimeStamp(Date d) {
		sdf.applyPattern("yyyyMMddHHmmss");
		return sdf.format(d);
	}
	
	/**
	 * 获取时间戳
	 * 
	 * @param d
	 *            要获取其时间戳的日期秒数值
	 * @return 时间戳
	 */
	public static final String getTimeStamp(long d) {
		return getTimeStamp(new Date(d));
	}

	/**
	 * 根据日期格式字符串解析日期字符串
	 * 
	 * @param str
	 *            日期字符串
	 * @param parsePatterns
	 *            日期格式字符串
	 * @return 解析后日期
	 * @throws ParseException
	 */
	public static Date parseDate(String str, String parsePatterns) throws ParseException {
		return parseDate(str, new String[] { parsePatterns });
	}


	public static void main(String... args) {
		String date = "20130402";
//		date = DateUtils.strDate(date);
//		System.out.println(date);
//		System.out.println(DateUtils.getMonthFirstDay("2013-02-02"));
//		System.out.println(DateUtils.getMonthLastDay("2013-02-02"));
//		System.out.println(DateUtils.TimeStamp2Date("1387877919"));
		//System.out.println(DateUtils.getAddDays(getNowDate(), -1));
		List<String> list = getDateList(DateUtils.getMonthFirstDay("2013-02-01").substring(0,10),DateUtils.getMonthLastDay("2013-02-01").substring(0,10));
		for(String x : list){
			System.out.println("x -- " + x);
		}
		
	}

}

