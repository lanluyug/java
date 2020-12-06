package com.lanluyug.lanluyug.javaLogic.thread.basic;

/**
 * --** 死锁 **--
 *  A线程在等待B线程释放锁a
 *  B线程在等待A线程释放锁b
 */
public class DeadLockDemo {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();
    private static void startThreadA(){
        Thread aThread = new Thread(){
            @Override
            public void run() {
                synchronized (lockA){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockB){

                    }
                }
            }
        };
        aThread.start();
    }
    private static void startThreadB(){
        Thread bThread = new Thread(){
            @Override
            public void run() {
                synchronized (lockB){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lockA){

                    }
                }
            }
        };
        bThread.start();
    }

    public static void main(String[] args) {
        startThreadA();
        startThreadB();
    }
}
