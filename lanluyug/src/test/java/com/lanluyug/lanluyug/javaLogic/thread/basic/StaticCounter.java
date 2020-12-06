package com.lanluyug.lanluyug.javaLogic.thread.basic;

public class StaticCounter {
    private static int count = 0;

    private Object lock = new Object();
    public static int getCount() {
        // 静态方法代码块
        synchronized (StaticCounter.class){
            return count;
        }
    }
    public synchronized static void incr(){
        count++;
    }
    public void decr(){
        // 使用单独的对象作为锁
        synchronized (lock){
            count--;
        }
    }
}
