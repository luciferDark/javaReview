package com.ll.java.threads;

import com.ll.java.utils.Log;

public class Threads {
    static class BoyFriend extends  Thread{
        @Override
        public void run() {
            super.run();
            Log.log(Thread.currentThread().getName() + "start BoyFriend");
            Log.log(Thread.currentThread().getName() + "end BoyFriend");
        }
    }
    static class GirdlFriend extends  Thread{
        Thread boyFriend = null;

        public GirdlFriend() {
        }

        public GirdlFriend(Thread boyFriend) {
            this.boyFriend = boyFriend;
        }

        @Override
        public void run() {
            super.run();
            Log.log(Thread.currentThread().getName() + "start GirdlFriend");
            if (boyFriend!=null){
                boyFriend.start();
                try {
                    boyFriend.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Log.log(Thread.currentThread().getName() + "end GirdlFriend");
        }
    }

    private GirdlFriend girdlFriend ;
    private BoyFriend boyFriend ;

    public void init(){
        boyFriend = new BoyFriend();
        girdlFriend = new GirdlFriend(boyFriend);
    }


    public void start(){
        Log.log(Thread.currentThread().getName() + "start");
        girdlFriend.start();
        try {
            girdlFriend.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        boyFriend.start();
        Log.log(Thread.currentThread().getName() + "end");
    }
}
