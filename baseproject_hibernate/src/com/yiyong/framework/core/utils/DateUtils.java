package com.yiyong.framework.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;

/**
 * @create.date: 2011-6-21 上午11:02:14
 * @comment: <p>
 *           日期工具类
 *           </p>
 * @see: com.ibm.framework.core.utils
 * @author: Ljp
 * @modify.by: Ljp
 * @modify.by-2: Scx
 * @modify.date: 2012-5-21 上午11:02:14
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils {
	/**
	 * 格式化
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String parseDate(Date date, String parsePatterns) {
		SimpleDateFormat sdf = new SimpleDateFormat(parsePatterns);
		return sdf.format(date);
	}

	/**
	 * 默认格式化(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param date
	 * @return String
	 */
	public static String parseDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 默认格式化(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String str) throws ParseException {
		return DateUtils.parseDate(str, new String[] { "yyyy-MM-dd HH:mm:ss" });
	}

	/**
	 * 得到某个月的第一天
	 * 
	 * @param date
	 * @return Date
	 */
	public static Date getFirstDayOfMonth(Date date) throws ParseException {
		String strdate = DateUtils.parseDate(date, "yyyy-MM-01 00:00:00");
		return DateUtils.parseDate(strdate);
	}

	/**
	 * ===================================================================
	 * @comment: <p>
	 *           得到当前日期是星期几
	 *           </p>
	 * @create.date: 2011-5-5 ( 下午05:53:10 )
	 * @author: Ljp
	 * @return: ===================================================================
	 */
	public static int getDayOfWeek() throws ParseException {
		Calendar c = Calendar.getInstance();
		int dayForWeek = 0;
		if (c.get(Calendar.DAY_OF_WEEK) == 1) {
			dayForWeek = 7;
		} else {
			dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}

	/**
	 * ===================================================================
	 * @comment: <p>
	 *           根据日期获得星期
	 *           </p>
	 *           tag=0:星期几 tag>0:'数字星期几'
	 * @create.date: 2011-6-21 ( 上午11:02:16 )
	 * @author: Ljp
	 * @return: ===================================================================
	 */
	public static String getWeekOfDate(Date date, int tag) {
		String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		String[] weekDaysCode = { "7", "1", "2", "3", "4", "5", "6" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (tag == 0) {
			return weekDaysName[intWeek];
		} else {
			return weekDaysCode[intWeek];
		}
	}

	/**
	 * 默认格式化(yyyy-MM-dd HH:mm:ss)
	 * 
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String str, String parsePatterns) throws ParseException {
		return DateUtils.parseDate(str, new String[] { parsePatterns });
	}

	/**
	 * 取从当月起8个月的月份
	 * 
	 * @return
	 */
	public static String[] getMonths() {
		String[] months = new String[8];
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		months[0] = df.format(cal.getTime()).substring(0, 7);
		for (int i = 1; i <= 7; i++) {
			cal.add(Calendar.MONTH, -1);
			months[i] = df.format(cal.getTime()).substring(0, 7);
		}
		return months;
	}

	/**
	 * 获取一天的开始时刻
	 * 
	 * @return yyyy-MM-dd 00:00:00
	 */
	public static Date getBeginOfDay(Date date) {

		Calendar today = Calendar.getInstance();
		today.setTime(date);
		return truncate(today, Calendar.DATE).getTime();
	}

	/**
	 * 获取一天的结束时刻
	 * 
	 * @return yyyy-MM-dd 23:59:59
	 */
	public static Date getEndOfDay(Date date) {
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.setTime(date);
		tomorrow.add(Calendar.DATE, 1);
		tomorrow = truncate(tomorrow, Calendar.DATE);
		tomorrow.add(Calendar.MILLISECOND, -1);
		return tomorrow.getTime();
	}

	/**
	 * 获取一月的开始时刻
	 * 
	 * @return yyyy-MM-01 00:00:00
	 */
	public static Date getBeginOfMonth(Date date) {

		Calendar today = Calendar.getInstance();
		today.setTime(date);
		return truncate(today, Calendar.MONTH).getTime();
	}

	/**
	 * 获取一月的结束时刻
	 * 
	 * @return yyyy-MM-dd 23:59:59 dd 取值为28,30,31
	 */
	public static Date getEndOfMonth(Date date) {
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.setTime(date);
		tomorrow.add(Calendar.MONTH, 1);
		tomorrow = truncate(tomorrow, Calendar.MONTH);
		tomorrow.add(Calendar.SECOND, -1);
		return tomorrow.getTime();
	}

	/**
	 * 获取一周的开始 yyyy-MM-dd 00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return c.getTime();
	}

	/**
	 * 获取一周的结束 yyyy-MM-dd 23:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return c.getTime();
	}

	/**
	 * 获取从指定日期开始，前后一段时间内的开始时间
	 * 
	 * @param date 指定时间
	 * @param num 正数或者负数的天数，规则同Calendar
	 * @return yyyy-MM-dd 00:00:00
	 */
	public static Date getBeginDateOfPeriod(Date beginDate, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(beginDate);
		c.add(Calendar.DATE, days);
		return getBeginOfDay(c.getTime());
	}

	/**
	 * 获取从指定日期开始，前后一段时间内的结束时间
	 * 
	 * @param date 指定时间
	 * @param num 正数或者负数的天数，规则同Calendar
	 * @return yyyy-MM-dd 23:59:59
	 */
	public static Date getEndDateOfPeriod(Date endDate, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(endDate);
		c.add(Calendar.DATE, days);
		return getEndOfDay(c.getTime());
	}

	/**
	 * 获取日期中的day
	 */
	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 根据出生日期，计算年龄
	 * 
	 * @birthday 出生日期，格式为yyyy-MM-dd HH:mm:ss
	 * @return 年龄，由当前时间减去出生日期计算得出
	 */
	public static int calcAge(String birthday) {
		int age = 0;
		if (StringUtils.isNotBlank(birthday)) {
			int curYear = Calendar.getInstance().get(Calendar.YEAR);
			try {
				Calendar temCal = Calendar.getInstance();
				temCal.setTime(parseDate(birthday));
				age = curYear - temCal.get(Calendar.YEAR);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return age;
	}

	/**
	 * 返回上个月的第一天
	 * 
	 * @return
	 */
	public static Date getBeginOfLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -1);
		return getBeginOfMonth(calendar.getTime());
	}

	/**
	 * 返回上个月的最后一天
	 * 
	 * @return
	 */
	public static Date getEndOfLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -1);
		return getEndOfMonth(calendar.getTime());
	}

	/**
	 * 获得昨天
	 * @return
	 */
	public static Date getYesterday() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return calendar.getTime();
	}

	/**
	 * 获得昨天的结束时间
	 * @return
	 */
	public static Date getEndOfYesterday() {
		return getEndOfDay(getYesterday());
	}

	/**
	 * 获得昨天的起始时间
	 * @return
	 */
	public static Date getBeginOfYesterday() {
		return getBeginOfDay(getYesterday());
	}

	/**
	 * 获得当前的年份
	 * 
	 * @return
	 */
	public static int currentYear() {

		Calendar c = new GregorianCalendar();// 新建日期对象
		int year = c.get(Calendar.YEAR);// 获取年份
		return year;
	}

	/**
	 * 获得当前的月份
	 * 
	 * @return
	 */
	public static int currentMonth() {

		Calendar c = new GregorianCalendar();// 新建日期对象
		int month = c.get(Calendar.MONTH);// 获取月份
		return month;
	}

	/**
	 * 获得当前的日期（天）
	 * 
	 * @return
	 */
	public static int currentDay() {
		Calendar c = new GregorianCalendar();// 新建日期对象
		int day = c.get(Calendar.DATE);// 获取日期
		return day;
	}

	/**
	 * 获得当前的分钟
	 * 
	 * @return
	 */
	public static int currentMinute() {
		Calendar c = new GregorianCalendar();// 新建日期对象
		int minute = c.get(Calendar.MINUTE);// 分
		return minute;
	}

	/**
	 * 获得当前的小时
	 * 
	 * @return
	 */
	public static int currentHour() {
		Calendar c = new GregorianCalendar();// 新建日期对象
		int hour = c.get(Calendar.HOUR);// 小时
		return hour;
	}

	/**
	 * 获得当前的秒
	 * 
	 * @return
	 */
	public static int currentSecond() {
		Calendar c = new GregorianCalendar();// 新建日期对象
		int second = c.get(Calendar.SECOND);// 秒
		return second;
	}

	/**
	 * 获得起始月份的第一天的00:00:00
	 * @param startYM
	 * @return
	 */
	public static Date getStartYM(String startYM) {
		try {
			Date date = DateUtils.parseDate(startYM + "-01", "yyyy-MM-dd");
			return getBeginOfMonth(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return getBeginOfMonth(new Date());
	}

	/**
	 * 获得结束月份的最后一天的23:59:59
	 * @param endYM
	 * @return
	 */
	public static Date getEndYM(String endYM) {
		try {
			Date date = DateUtils.parseDate(endYM + "-01", "yyyy-MM-dd");
			return getEndOfMonth(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return getEndOfMonth(new Date());
	}
public static void main(String[] args) {
	long s = 1288834974657L;
	System.out.println(parseDate(new Date(s)));
}
}
