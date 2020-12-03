package com.lanluyug.lanluyug.javaLogic.annotationDemo;

import org.junit.jupiter.api.Test;

import java.lang.annotation.RetentionPolicy;

/**
 * 注解是声明式编程风格，
 * 在编程界，还有：SQL语言、CSS、正则表达式也是这种风格
 */
class AnnotationDemo {

    @Test
    void test(){
        @SuppressWarnings({})
        int a = 1;
        System.out.println(RetentionPolicy.SOURCE.toString());
    }
}
