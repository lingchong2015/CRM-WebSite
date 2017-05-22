package com.zn.web.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Date Utility Class used to convert Strings to Dates and Timestamps
 *
 */
public class DateUtils {

    private static Log log = LogFactory.getLog(DateUtils.class);
    static public SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
    private static final String TIME_PATTERN = "HH:mm";
    

    /**
     * Checkstyle rule: utility classes should not have public constructor
     */
    private DateUtils() {
    }

    /**
     * Return default datePattern (MM/dd/yyyy)
     *
     * @return a string representing the date pattern on the UI
     */
    public static String getDatePattern() {
        return "yyyy-MM-dd";
    }

    public static String getDateTimePattern() {
        return "yyyy-MM-dd HH:mm:ss";
    }
    
    /**
     * 
     * @return
     */
    public static String getDateHourPattern() {
        return "yyyy年MM月dd日 HH时";
    }
    
    /**
     * 返回一个时间的 小时数字
     * @param date Date
     * @return int
     */
    public static int getHourOfDay(Date date){
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	return c.get(Calendar.HOUR_OF_DAY);
    }
    /**
     * This method attempts to convert an Oracle-formatted date in the form
     * dd-MMM-yyyy to mm/dd/yyyy.
     *
     * @param aDate date from database as a string
     * @return formatted string for the ui
     */
    public static String getDate(Date aDate) {
        SimpleDateFormat df;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * 获取某一日期前后第i天的日期
     *
     * @author Chen,Zhao
     *
     * @param strDate a string representation of a date
     * @return formatted string for the ui
     */
    public static Date getAnOtherDate(Date aDate, int i) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(aDate);
        calendar.add(Calendar.DAY_OF_YEAR, i);

        aDate = calendar.getTime();

        return (aDate);
    }

    /**
     * 获取某一日期前后第i天的日期(如输入("2013-11-01"，-3),返回"2013-10-29")
     *
     * @author Chen,Zhao
     *
     * @param strDate a string representation of a date
     * @return formatted string for the ui
     */
    public static String getAnOtherTime(String strTime, int i) throws ParseException {
        String returnValue = "";

        Date aDate = convertStringToDate(strTime);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(aDate);
        calendar.add(Calendar.DAY_OF_YEAR, i);

        aDate = calendar.getTime();

        returnValue = convertDateToString(aDate);

        return (returnValue);
    }

    /**
     * 获取某一时间前后第i天的时间(如输入("2013-11-01 10:30:46"，-3),返回"2013-10-29 10:30:46")
     *
     * @author Chen,Zhao
     *
     * @param strDate a string representation of a date
     * @return formatted string for the ui
     */
    public static String getAnOtherTime2(String strTime, int i) throws ParseException {
        String returnValue = "";

        Date aDate = convertStringToTime(strTime);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(aDate);
        calendar.add(Calendar.DAY_OF_YEAR, i);

        aDate = calendar.getTime();

        returnValue = getDateTime(getDateTimePattern(), aDate);

        return (returnValue);
    }

    /**
     * 获取某一日期前后第i周的日期
     *
     * @author Chen,Zhao
     *
     * @param strDate a string representation of a date
     * @return formatted string for the ui
     */
    public static Date getAnOtherWeekDate(Date aDate, int i) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(aDate);
        calendar.add(Calendar.WEEK_OF_YEAR, i);
        aDate = calendar.getTime();
        return (aDate);
    }

    /**
     * 获取某一日期前后第i月的日期
     *
     * @author Chen,Zhao
     *
     * @param strDate a string representation of a date
     * @return formatted string for the ui
     */
    public static Date getAnOtherMonthDate(Date aDate, int i) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(aDate);
        calendar.add(Calendar.MONTH, i);
        aDate = calendar.getTime();
        return (aDate);
    }

    /**
     * This method generates a string representation of a date/time in the
     * format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see java.text.SimpleDateFormat
     * @throws ParseException when String doesn't match the expected format
     */
    public static Date convertStringToDate(String aMask, String strDate) throws ParseException {
        SimpleDateFormat df;
        Date date;
        if (strDate.indexOf(":") > 0) {
            aMask = "yyyy-MM-dd HH:mm:ss";
        }
        df = new SimpleDateFormat(aMask);

        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            // log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    /**
     * This method returns the current date time in the format: MM/dd/yyyy HH:MM
     *
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(TIME_PATTERN, theTime);
    }

    /**
     * This method returns the current date in the format: MM/dd/yyyy
     *
     * @return the current date
     * @throws ParseException when String doesn't match the expected format
     */
    public static Calendar getToday() throws ParseException {
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

		// This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));

        return cal;
    }

    /**
     * This method generates a string representation of a date's date/time in
     * the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     *
     * @see java.text.SimpleDateFormat
     */
    public static String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date based on the
     * System Property 'dateFormat' in the format you specify on input
     *
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }

    /**
     * This method generates a string representation of a date based on the
     * System Property 'dateFormat' in the format you specify on input
     *
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static String convertDateToString2(Date aDate) {
        return getDateTime(getDateTimePattern(), aDate);
    }

    /**
     * This method converts a String to a date using the datePattern
     *
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * @throws ParseException when String doesn't match the expected format
     */
    public static Date convertStringToDate(String strDate) throws ParseException {
        Date aDate = null;
        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getDatePattern());
            }

            aDate = convertStringToDate(getDatePattern(), strDate);
        } catch (ParseException pe) {
            log.error("Could not convert '" + strDate + "' to a date, throwing exception");
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return aDate;
    }

    public static Date convertStringToTime(String strDate) throws ParseException {
        Date aDate = null;
        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getDatePattern());
            }

            aDate = convertStringToDate(getDateTimePattern(), strDate);
        } catch (ParseException pe) {
            log.error("Could not convert '" + strDate + "' to a date, throwing exception");
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return aDate;
    }

    
    /**
     * 把年月日 时 转成date 型 
     * @author zhanzhao
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static Date convertStringToDateHour(String strDate) throws ParseException {
        Date aDate = null;
        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getDatePattern());
            }

            aDate = convertStringToDate(getDateHourPattern(), strDate);
        } catch (ParseException pe) {
            log.error("Could not convert '" + strDate + "' to a date, throwing exception");
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return aDate;
    }
    public static String getYearMonth(Date date) { // 获得年和月 0000-00
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        return String.valueOf(year) + month;
    }

    public static String getQuarter(Date date) { // 获得季度
        Integer quarter = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        if (month == 1 || month == 2 || month == 3) {
            quarter = 1;
        }
        if (month == 4 || month == 5 || month == 6) {
            quarter = 2;
        }
        if (month == 7 || month == 8 || month == 9) {
            quarter = 3;
        }
        if (month == 10 || month == 11 || month == 12) {
            quarter = 4;
        }
        return calendar.get(Calendar.YEAR) + "-" + String.valueOf(quarter);
    }

    public static String getYear(Date date) { // 获得年2012
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        return String.valueOf(year);
    }

    /**
     * @author Chen,Zhao
     * @desc This method converts Millisecond to a datetime using the
     * timePattern，将毫秒数转为时分秒（时间段，非日期）
     *
     * @param millisecond
     * @return hh:mm:ss
     * @throws ParseException
     */
    public static String convertMillisecondToTime(Long millisecond) throws ParseException {
        long hour = millisecond / (60 * 60 * 1000);
        long minute = (millisecond - hour * 60 * 60 * 1000) / (60 * 1000);
        long second = (millisecond - hour * 60 * 60 * 1000 - minute * 60 * 1000) / 1000;
        if (second >= 60) {
            second = second % 60;
            minute += second / 60;
        }
        if (minute >= 60) {
            minute = minute % 60;
            hour += minute / 60;
        }
        return hour + "时" + minute + "分" + second + "秒";
    }

    /**
     * @author Wu,Lei
     * @desc 将秒数转为时分秒（时间段，非日期）
     */
    public static String convertSecondToTime(Long second) throws ParseException {
        long hour = second / (60 * 60);
        long minute = (second - hour * 60 * 60) / 60;
        second = (second - hour * 60 * 60 - minute * 60);
        if (second >= 60) {
            second = second % 60;
            minute += second / 60;
        }
        if (minute >= 60) {
            minute = minute % 60;
            hour += minute / 60;
        }
        if(hour>0){
        	return hour + "时" + minute + "分" + second + "秒";
        }else{
        	if(minute>0){
        		return minute + "分" + second + "秒";
        	}else{
        		return second + "秒";
        	}
        }
    }
    
    /**
     * @author Chen,Zhao
     * @desc This method converts Millisecond to a datetime using the
     * timePattern，将毫秒数转为小时（Float型）
     *
     * @param millisecond
     * @return (float)hh
     * @throws ParseException
     */
    public static Float convertMillisecondToHh(Long millisecond) throws ParseException {
        float hour = (float) millisecond / (60 * 60 * 1000);
        return hour;
    }

    /**
     * 将时间转化为yyyy-MM-dd的字符串时间
     *
     * @param date
     */
    public static String getDateStr(java.util.Date date) {
        if (date == null) {
            return "";
        }
        try {
            return yyyyMMdd.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 毫秒转日期字符串
     *
     * @param str
     * @return
     */
    public static String getDateTimeByMillisecond(String str) {
        Date date = new Date(Long.valueOf(str));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        return time;
    }

	/**
	 * 日期转化为字符串
	 * @param Date
	 * @return String
	 */
	public static String dateConvertToStr(Date date){
		 return dateConvertToStr(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	public static String dateConvertToStr(Date date,String pattern){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf = new SimpleDateFormat(pattern);
		if(date!=null){
			return sdf.format(date);
		}
		return sdf.format(new Date());
	}
    
    
    
}
