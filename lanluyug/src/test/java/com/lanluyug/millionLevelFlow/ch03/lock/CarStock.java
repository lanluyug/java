package com.lanluyug.millionLevelFlow.ch03.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CarStock {
   int cars;
   private Lock lock = new ReentrantLock();
   private Condition condition = lock.newCondition();

   //生产车
   public void productCar() {
      lock.lock();
      try {
         if (cars <20) {
            System.out.println("生产车...."+ cars);
            cars++;
            condition.signalAll();//唤醒
         } else {
                condition.wait();
         }
      } catch (InterruptedException e) {
          e.printStackTrace();
      } finally {
            lock.unlock();
      }
    }
//消费车
    public void resumeCar() {
        lock.lock();
        try {
            if (cars >0) {
                System.out.println("销售车...."+ cars);
                cars--;
                condition.signalAll();//唤醒
            } else {
                condition.wait();//等待
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}