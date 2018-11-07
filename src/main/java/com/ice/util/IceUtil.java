package com.ice.util;


/**
 * Created by vamshikirangullapelly on 07/11/2018.
 */
public class IceUtil {


    public static long daysToMilliSeconds(int day)
    {
        return (long) (day * 24 * 60 * 60 * 1000);
    }

    public static long currentTime()
    {
        return System.currentTimeMillis();
    }


    public static long daysAgo(int days)
    {
        return System.currentTimeMillis() - daysToMilliSeconds(days);
    }




}
