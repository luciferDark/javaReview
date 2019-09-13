package com.ll.java.utils;

public class Util {

    public  static boolean isEmptyString(String str){
        if (str == null || str == "" || str.length() <=0){
            return true;
        }
        return false;
    }

    public  static boolean isEmptyArray(int[] arr){
        if (arr == null || arr.length <=0){
            return true;
        }
        return false;
    }
}
