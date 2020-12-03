package com.lanluyug.lanluyug.javaLogic.thread;

import org.junit.jupiter.api.Test;

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
