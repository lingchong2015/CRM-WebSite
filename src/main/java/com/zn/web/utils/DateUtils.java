package com.zn.web.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WuTingTing on 2017/5/11.
 */
public class DateUtils {
    /**
     * 日期转化为字符串
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
