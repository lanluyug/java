package com.lanluyug.lanluyug.javaLogic.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {
    /**
     * ArrayDeque实现了双端队列，内部使用循环数组实现，这决定了它有如下特点。
     * 1）在两端添加、删除元素的效率很高，动态扩展需要的内存分配以及数组复制开销可以被平摊，具体来说，添加N个元素的效率为O（N）。
     * 2）根据元素内容查找和删除的效率比较低，为O（N）。
     * 3）与ArrayList和LinkedList不同，没有索引位置的概念，不能根据索引位置进行操作。
     */

    @Test
    public void test(){

        Deque<String> deque = new ArrayDeque<>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addLast("c");
        deque.removeFirst();
        deque.pollFirst();
        System.out.println(deque.toString());


    }
}
