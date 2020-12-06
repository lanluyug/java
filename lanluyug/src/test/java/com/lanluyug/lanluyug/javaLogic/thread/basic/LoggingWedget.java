package com.lanluyug.lanluyug.javaLogic.thread.basic;

/**
 * --** 锁的可重入性 **--
 * 锁是面向线程的，不是面向函数的，即一个线程获得锁之后，可以多次调用此方法
 */
class Widget {
    public synchronized void doSomething() {
        System.out.println("parent");
    }
}

class LoggingWidget extends Widget {
    public synchronized void doSomething() {
        System.out.println(toString() + ": calling doSomething");
        super.doSomething();
    }
}
