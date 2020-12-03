package com.lanluyug.lanluyug.javaLogic.baseDemo;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

public class testString {
    @Test
    void test(){

        // 创建字符串
        String s1 = "lanluyug";
        String s2 = new String("lanluyug");

        //字符切割
        String[] arr = s1.split("u");
        for (String str:
             arr) {
            System.out.println(str);
        }

        System.out.printf("系统的默认编码 = %s", Charset.defaultCharset().name());



        //循环情况下，应该使用StringBuilder
        String hello = "hello";
        for (int i = 0; i < 3; i++) {
            hello+=",world";
        }
        // ===================>>>等价于每次循环都有新建一个StringBuilder
        for (int i = 0; i < 3; i++) {
            StringBuilder sb = new StringBuilder(hello);
            sb.append(",world");
            hello = sb.toString();
        }
    }
}
