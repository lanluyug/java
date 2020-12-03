package com.lanluyug.lanluyug.javaLogic.list;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 1）按需分配空间，不需要预先分配很多空间。
 * 2）不可以随机访问，按照索引位置访问效率比较低，必须从头或尾顺着链接找，效率为O（N/2）。
 * 3）不管列表是否已排序，只要是按照内容查找元素，效率都比较低，必须逐个比较，效率为O（N）。
 * 4）在两端添加、删除元素的效率很高，为O（1）。
 * 5）在中间插入、删除元素，要先定位，效率比较低，为O（N），但修改本身的效率很高，效率为O（1）。
 */

/**
 * 如果列表长度未知，添加、删除操作比较多，
 * 尤其经常从两端进行操作，而按照索引位置访问相对比较少，
 * 则LinkedList是比较理想的选择。
 */
public class LinkedListDemo {
    @Test
    public void test(){


        // 初始化
        List<String> list = new LinkedList<>();
        List<String> list2 = new LinkedList<>(
                Arrays.asList("a","b","c")
        );
        // Collection <-- Queue <-- Deque <-- LinkedList
        //LinkedList 实现了Queue
        Queue<String> queue = new LinkedList<>();
        queue.offer("a"); // 在尾部添加元素
        queue.offer("b");
        queue.offer("c");
        while (queue.peek() != null){
            System.out.println(queue.poll()); //删除头部元素，并返回头部元素
        }

        Deque<String> deque = new LinkedList<>(
                Arrays.asList("a","b","c")
        );
        Iterator<String>  it = deque.descendingIterator();
        while(it.hasNext()){
            System.out.println(it.next() + "\t");
        }
    }
}
