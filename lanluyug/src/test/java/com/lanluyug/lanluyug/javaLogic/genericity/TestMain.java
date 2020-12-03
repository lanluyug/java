package com.lanluyug.lanluyug.javaLogic.genericity;

import org.junit.jupiter.api.Test;

/**
 * 在Java中，泛型是通过类型擦除来实现的，
 * 它是Java编译器的概念，Java虚拟机运行时对泛型基本一无所知
 * ·基本类型不能用于实例化类型参数。
 * ·运行时类型信息不适用于泛型。
 * ·类型擦除可能会引发一些冲突。
 */
public class TestMain {
    @Test
    public void test(){
        Pair<Integer,Integer> minmax = new Pair<>(1, 100); //JAVA 7可以省略等号右边的泛型
        Integer min = minmax.getFirst();
        Integer max = minmax.getSecond();

        /**
         * ? extends T
         */
        DynamicArray<Number> numbers = new DynamicArray<>();
        DynamicArray<Integer> ints = new DynamicArray<>();
        ints.add(100);
        ints.add(34);
        numbers.addAll(ints);
        /**
         * ? super T
         */
        DynamicArray<Integer> ints1 = new DynamicArray<>();
        ints1.add(100);
        ints1.add(32);
        DynamicArray<Number> numbers1 = new DynamicArray<>();
        ints1.copyTo(numbers1);

        Integer[] arr = ints1.toArray(Integer.class);
    }


}
