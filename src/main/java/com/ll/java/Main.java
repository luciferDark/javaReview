package com.ll.java;

import com.ll.java.annotationTest.AnnotationHelper;
import com.ll.java.interfaceTest.InterHelper;
import com.ll.java.sort.SortHelper;
import com.ll.java.threads.Threads;
import com.ll.java.trees.TreeHelp;
import com.ll.java.utils.Log;

public class Main {


    public static void main(String[] args) {
//        testSort();
//        testInter();
//        testAnnotation();

        int a = 1233;
        int b = 12322;

        a = a^b;
        Log.log("a is:" + a);
        b = a^b;
        Log.log("b is:" + b);
        a = a^b;

        Log.log("a is:" + a);
        Log.log("b is:" + b);
//        testThread();
        testTree();
    }

    public static void testSort(){
        int[] sortBefore = new int[]{23, 2, 42, 55, 12, 6, 3, 85, 44, 23, 78};
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
    public static void testAnnotation(){
        AnnotationHelper annotationHelper = new AnnotationHelper();
        annotationHelper.start();
    }
    public static void testThread(){
        Threads threads = new Threads();
        threads.init();
        threads.start();
    }
    public static void testInter(){
        InterHelper interHelper = new InterHelper();
        interHelper.init();
        interHelper.start();
    }

    public static void testTree(){
        TreeHelp treeHelp = new TreeHelp();
        treeHelp.init();
        treeHelp.start();
    }
}
