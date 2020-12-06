package com.lanluyug.lanluyug.javaLogic.thread.basic;

import org.junit.jupiter.api.Test;

/**
 * 多线程的优点：
 * 1。充分利用CPU多线程的计算能力
 * 2。充分利用硬件阻塞时间，例如网络请求阻塞
 * 3。对于GUI，不会因为单个线程阻塞导致无响应
 * 4。简化建模及IO处理，每个用户请求单独的线程
 * --** 多线程的缺点 **--
 * 1。多线程的启动、调度和切换都是有时间成本的；
 * 2。CPU的上下文切换，需同步其上下文状态，此过程耗时，且使CPU很多缓存失效
 * 3。 如果是CPU密集型的任务，则创建超过CPU线程数的多线程，则没有必要，
 * 如果任务涉及多个网络请求等，可使用多线程
 */
public class HelloThread extends Thread{
    @Override
    public void run(){
        System.out.println("hello");
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
    }
    @Test
    public  void test() {
        Thread t = new HelloThread();
        t.start();
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
    }
}
