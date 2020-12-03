package com.lanluyug.lanluyug.javaLogic.baseDemo;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class testDate {

    @Test
    void test() throws ParseException {

        /**
         * Date
         *
         */
        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz.getID());
        System.out.println(System.getProperty("user.timezone"));

        //Date错误用法
        Date d1 = new Date(2020,9,25);
        System.out.println(DateFormat.getDateInstance().format(d1));//输出3920-10-25

        /**
         * Calendar
         */

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 59);
        // 只加上当前单位，不进位 59 + 5  = 4
        calendar.roll(Calendar.MILLISECOND, 5);

        String timeS1 = DateFormat.getDateTimeInstance().format(calendar.getTime());
        String timeS2 = DateFormat.getDateInstance().format(calendar.getTime());
        String timeS3 = DateFormat.getTimeInstance().format(calendar.getTime());
        System.out.println(timeS1);
        System.out.println(timeS2);
        System.out.println(timeS3);
        String s4 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT, Locale.CHINESE).format(calendar.getTime());
        System.out.println(s4);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 E HH时mm分ss秒");
        System.out.println(sdf.format(calendar.getTime()));

        // 将字符串转为Date
        String str = "2020-09-25 20:53:20.123";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        Date date = sdf2.parse(str);
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S a");
        System.out.println(sdf3.format(date));



    }
}
