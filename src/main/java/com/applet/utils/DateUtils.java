package com.applet.utils;

import com.applet.common.KnownException;
import com.applet.enums.ExceptionEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  时间工具类
 * @author gsj
 */
public class DateUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     *  字符串转date
     */
    public static Date strToDate(String str){

        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            throw new KnownException(ExceptionEnum.DATE_CONVERT_ERROR);
        }
    }

    /**
     *  date转字符串
     */
    public static String dateToStr(Date date){
        return sdf.format(date);
    }

    /**
     *  得到时间段
     */
    public static String getTimeRange(Integer timeRangeId) {
        switch (timeRangeId) {
            case 1:
                return "9.00-9.30";
            case 2:
                return "9.30-10.00";
            case 3:
                return "10.00-10.30";
            case 4:
                return "10.30-11.00";
            case 5:
                return "14.30-15.00";
            case 6:
                return "15.00-15.30";
            case 7:
                return "15.30-16.00";
            case 8:
                return "16.00-16.30";
        }
        return "未知时间";
    }

}
