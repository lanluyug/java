package com.lanluyug.javaLogic.thread.cooperation.beginWithSameTime;

/**
 * 同时开始线程
 */
public class testStarterAtSameTime {
    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        FireFlag fireFlag = new FireFlag();
        Thread[] racers = new Thread[num];
        for (int i = 0; i < num; i++) {
            racers[i] = new Racer(fireFlag);
            racers[i].start();
        }
        Thread.sleep(1000);
        fireFlag.fire();
    }
}
