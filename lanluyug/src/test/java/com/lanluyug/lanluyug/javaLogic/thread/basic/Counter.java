package com.lanluyug.lanluyug.javaLogic.thread.basic;

/**
 * --** 执行synchronized实例方法过程 **--
 * 1。尝试获得锁；如果获得锁，则下一步；否则加入等待队列，阻塞并等待唤醒
 * 2。执行实例方法体代码
 * 3。释放锁，在等待队列的线程中，取一个并唤醒，不保证唤醒的公平性
 * 实际上synchronized的执行过程比这复杂，上述只是简单说明
 * 当前线程不能获得锁的时候，会加入等待队列，线程状态会变为BLOCKED
 * synchronized保护对象，即被申明的不同的方法，也不会同时执行，
 * 若其中一个方法不带synchronized关键字，则不保证同步，
 * 若synchronized修饰静态方法，则保护的是xxx.class,动态方法则是对象（this）
 */
public class Counter {

    private int count;
    public void incr(){
        // synchronized申明代码块
        synchronized (this){
            count++;
        }

    }
    public synchronized int getCount(){
        return count;
    }
}
