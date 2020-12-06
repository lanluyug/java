package com.lanluyug.lanluyug.javaLogic.thread.cooperation;

/**
 * wait/notify方法只能在synchronized代码块调用，
 * 其他情况下调用会抛出异常
 * 它们围绕一个共享条件进行协作
 */
public class WaitThread extends Thread{

    private volatile boolean fire = false;

    @Override
    public void run() {
        try {
            synchronized (this){
                while (!fire){
                    wait();
                }
            }
            System.out.println("fired!");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void fire(){
        this.fire = true;
        notify();
    }

    public static void main(String[] args) {
        WaitThread waitThread = new WaitThread();
        waitThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("fire");
        // 收到指令后才能执行
        waitThread.fire();
    }
}
