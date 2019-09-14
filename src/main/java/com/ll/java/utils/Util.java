package com.ll.java.utils;

public class Util {

    public  static boolean isEmptyString(String str){
        if (null == str || "".equals(str)|| str.length() <=0){
            return true;
        }
        return false;
    }

    public  static boolean isEmptyArray(int[] arr){
        if (null == arr || arr.length <=0){
            return true;
        }
        return false;
    }
}
