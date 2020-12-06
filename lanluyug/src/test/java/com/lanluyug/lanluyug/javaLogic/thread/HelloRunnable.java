package com.lanluyug.lanluyug.javaLogic.thread;

public class HelloRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("hello");
        Thread.currentThread().setName("hello");
        //设置优先级
        Thread.currentThread().setPriority(4);


        // 让出CPU，只是个建议
        Thread.yield();
        /**
         * 获取状态
         * 1. NEW
         * 2. RUNNABLE
         * 3. BLOCKED
         * 4. WAITING
         * 5. TIMED_WAITING
         * 6. TERMINATED
         */
        System.out.println(Thread.currentThread().getState());

        //线程是否存活
        System.out.println(Thread.currentThread().isAlive());
        /**
         * 是否是守护进程
         * 当没有其他线程存活时，守护进程会自动退出
         * 垃圾回收就是daemon进程
         */
        System.out.println(Thread.currentThread().isDaemon());
    }

    public static void main(String[] args) throws InterruptedException {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t = new Thread(new HelloRunnable());
        t.start();
        // join如果是0，则表示无限期等待，join（）无参数直接调用join（0）
        t.join();

        t.setName("main1");

    }
}
