package com.lanluyug.java8.ch02;


import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * 1。 Lambda表达式是一个匿名方法，将行为像数据一样传递
 * 2。函数
 */

public class lambdaExpress {

    Runnable noArguments = () -> System.out.println("Hello World");

    ActionListener oneArgument = event -> System.out.println("button clicked");

    // lambda默认只能引用final变量
    String name = "lanluyu";
    Runnable multiStatement = () ->{
        System.out.print( name + "Hello");
        System.out.println(" World");
    };

    //   下面语句可替换：
    BinaryOperator<Long> add1 = (x, y) -> x + y;
    // 推荐使用，若不使用泛型也会报错，此处会进行类型推断
    BinaryOperator<Long> add = Long::sum;

    BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;


}
