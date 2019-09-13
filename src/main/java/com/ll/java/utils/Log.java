package com.ll.java.utils;

import java.util.Arrays;

public class Log {
    public static void log(String msg) {
        System.out.println(msg);
    }

    public static void logArray(int[] arrary) {
        log("\t" + Arrays.toString(arrary));
    }

    public static void logArray(float[] arrary) {
        log(Arrays.toString(arrary));
    }

    public static void logArray(double[] arrary) {
        log(Arrays.toString(arrary));
    }

    public static void logArray(Object[] arrary) {
        log(Arrays.toString(arrary));
    }
}
