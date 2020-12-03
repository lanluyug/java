package com.lanluyug.lanluyug.javaLogic.list;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListDemo {
    @Test
    public void testArrayList(){
        /**
         * ArrayList是一个泛型容器，新建ArrayList需要实例化泛型参数
         * 1）可以随机访问，按照索引位置进行访问效率很高，用算法描述中的术语，效率是O（1），简单说就是可以一步到位。
         * 2）除非数组已排序，否则按照内容查找元素效率比较低，具体是O（N），N为数组内容长度，也就是说，性能与数组长度成正比。
         * 3）添加元素的效率还可以，重新分配和复制数组的开销被平摊了，具体来说，添加N个元素的效率为O（N）。
         * 4）插入和删除元素的效率比较低，因为需要移动元素，具体为O（N）。
         */
        ArrayList<Integer> intList = new ArrayList<>();


        /**
         * 初始化list的几种方法
         */
        // 1. 常规方法
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        System.out.println("getList1: " + list1);

        // 2. Arrays 工具类
        // 生成的list不可变
        List<String> list2 = Arrays.asList("1", "2", "3");
        System.out.println("getList2: " + list2);
        // 如果要可变需要用ArrayList包装一下
        List<String> list3 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        list3.add("4");
        System.out.println("getList3: " + list3);


        // 3. Collections 工具类
        // 生成的list不可变
        List<String> list4 = Collections.nCopies(3, "1");
        System.out.println("getList4: " + list4);
        // 如果要可变需要用ArrayList包装一下
        List<String> list5 = new ArrayList<>(Collections.nCopies(3, "dog"));
        list5.add("getList5");
        System.out.println("getList5: " + list5);

        // 4、Lists 工具类
        List<String> list6 = Lists.newArrayList("1", "2", "3");
        System.out.println("getList4: " + list6);

        // 5、匿名内部类
        List<String> list7 = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
        }};//该方法用了双弧号语法，可以参考双大括号初始化的理解和使用
        System.out.println("getList7: " + list7);

        // 6、ImmutableList
//        List<String> list = ImmutableList.of("1", "2", "3");
//        System.out.println("getList6: " + list);

        // 7、Java8 Stream
        List<String> list9 = Stream.of("1", "2", "3").collect(Collectors.toList());
        System.out.println("getList7: " + list9);


        /**
         * 循环
         */
        Iterator<String> it = list7.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }


    }
}
