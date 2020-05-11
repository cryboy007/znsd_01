package com.znsd.sportsbean.util;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static Date format(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        String da = simpleDateFormat.format(date);
        Date d = null;
        try {
            d = simpleDateFormat.parse(da);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }
}
