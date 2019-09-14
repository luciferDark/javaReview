package com.ll.java.utils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Log {
    private static final String COMMON_DATE = "yyyy-MM-dd HH:mm:ss:SSSS";

    public static void log(String msg) {
        SimpleDateFormat format = new SimpleDateFormat(COMMON_DATE);
        String logMsg = format.format(new Date(System.currentTimeMillis())) + " :\t";
        System.out.println(logMsg + msg);
    }

    public static void logArray(int[] arrary) {
        Log.log("\t" + Arrays.toString(arrary));
    }

    public static void logArray(float[] arrary) {
        Log.log(Arrays.toString(arrary));
    }

    public static void logArray(double[] arrary) {
        Log.log(Arrays.toString(arrary));
    }

    public static void logArray(Object[] arrary) {
        Log.log(Arrays.toString(arrary));
    }
}
