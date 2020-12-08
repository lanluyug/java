package com.lanluyug.lanluyug.javaLogic.thread.cooperation;

/**
 * java提供了专门的阻塞队列实现：
 * 1。 接口BlockingQueue和BlockingDeque
 * 2。基于数组的实现类ArrayBlockingQueue
 * 3。基于琏表的实现类LinkedBlockingQueue和LinkedBlockingDeque
 * 4。基于堆的实现类PriorityBlockingQueue
 */
public class testProducerConsumer {

    public static void main(String[] args) {
        MyBlockingQueue<String> queue = new MyBlockingQueue<>(10);
        new Producer(queue).start();
        new Consumer(queue).start();
    }
}
