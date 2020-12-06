package com.lanluyug.lanluyug.javaLogic.thread.basic;

/**
 * ---** 内存可见性 **--
 * 1。 多个线程可以访问同一个变量，但变量被一个线程修改后，另一个线程不一定立即能见到
 * 解决方法：
 *  1。使用volatile关键字,它保证程序读写到最新的值，而非缓存的值
 *  2。使用synchronized关键字或者显式锁同步
 */
public class VisibilityDemo {

    private volatile static boolean shutdown = false;
    static class HelloThread extends Thread{
        int i = 0;
        @Override
        public void run() {
            while (!shutdown){
                System.out.println(i++);
            }
            System.out.println("exit hello");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new HelloThread().start();
        Thread.sleep(1001);
        shutdown = true;
        System.out.println("exit main");
    }
}
