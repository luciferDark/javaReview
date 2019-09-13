package com.ll.java.sort;


import com.ll.java.utils.Log;
import com.ll.java.utils.Util;

/**
 * @author kilin
 * 排序算法复习
 */
public class SortHelper {
    public static enum SortOrder {
        ASC,     //顺序
        DESC    //倒序
    }

    /**
     * 冒泡排序
     * 时间复杂度 O(n2)
     * 空间复杂度O(1)
     * 稳定
     *
     * @param arr
     */
    public int[] bubbleSort(int[] arr, SortOrder order) {
        Log.log("bubble sort start by：" + order.name() + ".");
        if (Util.isEmptyArray(arr)) {
            Log.log("arr is empty.");
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (order.equals(SortOrder.ASC)) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else if (order.equals(SortOrder.DESC)) {
                    if (arr[j] < arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
        Log.logArray(arr);
        Log.log("bubble sort end.");
        return arr;
    }

    /**
     * 选择排序
     * 时间复杂度 O(n2)
     * 空间复杂度O(1)
     * 稳定
     *
     * @param arr
     */
    public int[] selectSort(int[] arr, SortOrder order) {
        Log.log("selectSort sort start by：" + order.name() + ".");
        if (Util.isEmptyArray(arr)) {
            Log.log("arr is empty.");
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int compareIndex = i;//记录下最小(大)值的下角标
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (order.equals(SortOrder.ASC)) {
                    if (arr[j] < arr[compareIndex]) {
                        compareIndex = j;
                    }
                } else if (order.equals(SortOrder.DESC)) {
                    if (arr[j] > arr[compareIndex]) {
                        compareIndex = j;
                    }
                }
            }
            if (compareIndex != i) {
                int temp = arr[i];
                arr[i] = arr[compareIndex];
                arr[compareIndex] = temp;
            }
        }

        Log.logArray(arr);
        Log.log("selectSort sort end.");
        return arr;
    }

    /**
     * 插入排序
     * 时间复杂度 O(n2)
     * 空间复杂度O(1)
     * 稳定
     *
     * @param arr
     */
    public int[] insertSort(int[] arr, SortOrder order) {
        Log.log("insertSort sort start by：" + order.name() + ".");
        if (Util.isEmptyArray(arr)) {
            Log.log("arr is empty.");
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int currentValue = arr[i + 1];
            int positionIndex = i;
            boolean changed = false;
            for (int j = i + 1; j > 0; j--) {
                if (order.equals(SortOrder.ASC)) {
                    if (arr[j - 1] > currentValue) {
                        arr[j] = arr[j - 1];
                        positionIndex = j - 1;
                        changed = true;
                    }
                } else if (order.equals(SortOrder.DESC)) {
                    if (arr[j - 1] < currentValue) {
                        arr[j] = arr[j - 1];
                        positionIndex = j - 1;
                        changed = true;
                    }
                }
            }
            if (changed) {
                arr[positionIndex] = currentValue;
            }
        }
        Log.logArray(arr);
        Log.log("insertSort sort end.");
        return arr;
    }
}
