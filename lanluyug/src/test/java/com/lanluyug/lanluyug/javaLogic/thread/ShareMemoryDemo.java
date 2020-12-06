package com.lanluyug.lanluyug.javaLogic.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 共享内存：
 * 运行结果：
 * 2
 * [Thread-0, Thread-1]
 */
public class ShareMemoryDemo {

    private static int shared = 0;
    private static void incrShared(){
        shared++;
    }
    static class ChildThread extends Thread{
        List<String> list;

        public ChildThread(List<String> list){
            this.list = list;
        }
        @Override
        public void run(){
            incrShared();
            list.add(Thread.currentThread().getName());
        }

        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            Thread t1 = new ChildThread(list);
            Thread t2 = new ChildThread(list);
            t1.start();
            t2.start();
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(shared);
            System.out.println(list);
        }
    }
}
