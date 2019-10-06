package com.ll.java;

import com.ll.java.sort.SortHelper;
import com.ll.java.utils.Log;

public class Main {
    private static int[] sortBefore = new int[]{23, 2, 42, 55, 12, 6, 3, 85, 44, 23, 78};


    public static void main(String[] args) {
        SortHelper sortHelper = new SortHelper();
        Log.log("input arr is:");
        Log.logArray(sortBefore);
        sortHelper.bubbleSort(sortBefore, SortHelper.SortOrder.ASC);
        sortHelper.bubbleSort(sortBefore, SortHelper.SortOrder.DESC);
        sortHelper.selectSort(sortBefore, SortHelper.SortOrder.ASC);
        sortHelper.selectSort(sortBefore, SortHelper.SortOrder.DESC);
        sortHelper.insertSort(sortBefore, SortHelper.SortOrder.ASC);
        sortHelper.insertSort(sortBefore, SortHelper.SortOrder.DESC);
    }
}
