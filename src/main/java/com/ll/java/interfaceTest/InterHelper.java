package com.ll.java.interfaceTest;

import com.ll.java.utils.Log;

public class InterHelper {

    public void init(){
        Log.log("InterHelper init");

    }

    public void start(){
        Log.log("InterHelper start");
        Printable printable = new CanonDriver();
        printable.print("abcd");
        if (printable instanceof  CanonDriver){
            Log.log("canon driver");
        }
        printable = new HPDriver();
        printable.print("abcd");
        if (printable instanceof  HPDriver){
            Log.log("hp driver");
        }
        printable = new SongXiaDriver();
        printable.print("abcd");
        if (printable instanceof  SongXiaDriver){
            Log.log("songxia driver");
        }
    }


    /**
     * 佳能打印机
     */
    public class CanonDriver implements Printable{
        private int numberIndex = 1;
        @Override
        public void print(String printMsg) {
            Log.log("Canon print :" + printMsg + "， number:" + (numberIndex + NUMBER));
        }
    }
    /**
     * 惠普打印机
     */
    public class HPDriver implements Printable{
        private int numberIndex = 2;
        @Override
        public void print(String printMsg) {
            Log.log("HP print :" + printMsg + "， number:" + (numberIndex + NUMBER));

        }
    }
    /**
     * 松下打印机
     */
    public class SongXiaDriver implements Printable{
        private int numberIndex = 3;
        @Override
        public void print(String printMsg) {
            Log.log("SongXia print :" + printMsg + "， number:" + (numberIndex + NUMBER));

        }
    }
}
