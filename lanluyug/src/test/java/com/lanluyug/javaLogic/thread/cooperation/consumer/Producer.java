package com.lanluyug.javaLogic.thread.cooperation.consumer;

import com.lanluyug.javaLogic.thread.cooperation.beginWithSameTime.MyBlockingQueue;

public class Producer extends Thread{
    MyBlockingQueue<String> queue;
    public Producer(MyBlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int num = 0;
        try{
            while (true){
                String task = String.valueOf(num);
                queue.put(task);
                System.out.println("Produce task " + task);
                num++;
                Thread.sleep((int)(Math.random() * 1000));
            }
        }catch (InterruptedException e){

        }
    }
}
