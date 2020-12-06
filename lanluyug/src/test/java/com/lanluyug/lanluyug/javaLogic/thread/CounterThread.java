package com.lanluyug.lanluyug.javaLogic.thread;

/**
 * 竞态条件
 * 多个线程可能执行同一个重复操作，
 * 导致处理重复，结果偏小
 * counter理想是1000万，实际一般都是999万多
 * 处理此问题的办法有：
 * 1. 使用synchronized
 * 2. 使用显式锁
 * 3. 使用原子变量
 */
public class CounterThread extends Thread{

    Counter count;

    static int counter;

    public CounterThread(Counter count){
        this.count = count;
    }

    @Override
    public void run(){
        for (int i = 0; i < 1000; i++) {
            counter++;
            count.incr();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 10000;
        Thread[] threads = new Thread[num];
        Counter counter1 = new Counter();
        for (int i = 0; i < num; i++) {
            threads[i] = new CounterThread(counter1);
            threads[i].start();
        }
        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter);//竞态
        System.out.println(counter1.getCount());//synchronized
    }
}
