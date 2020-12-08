package com.lanluyug.lanluyug.javaLogic.thread.cooperation.beginWithSameTime;

public class FireFlag {

    private volatile boolean fired = false;

    public synchronized void waitForFire() throws InterruptedException {
        while (!fired){
            wait();
        }
    }

    public synchronized void fire(){
        this.fired = true;
        notifyAll();
    }
}
