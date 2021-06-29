package com.lanluyug.javaLogic.exceptionDemo;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;

/**
 * 异常分为受检异常与非受检异常；
 * 异常的作用：
 * 1. 使程序避免因异常因素退出
 * 2. 探寻错误原因
 * 异常来源：
 * 1. 用户： 输入问题
 * 2. 程序员： 编码逻辑问题
 * 3. 第三方： I/O错误、网络、数据库、第三方服务
 */
public class TestMain {
    @Test
    void testNullException(){
        String n = null;
        try {
            n.indexOf("a");
        }catch (NullPointerException e){
            // 打印异常栈标准信息
            System.out.println("e.printStackTrace(): ");
            e.printStackTrace();
            System.out.println("e.getMessage(): " + e.getMessage());

            System.out.println("e.getCause(): " + e.getCause());

        }catch (Exception e){
            // 打印异常栈标准信息
            System.out.println("Exception e..................");
            System.out.println("e.printStackTrace(): ");
            e.printStackTrace();
            System.out.println("e.getMessage(): " + e.getMessage());

            System.out.println("e.getCause(): " + e.getCause());
        }finally {
            System.out.println("end................");
        }

    }

    /**
     * 文件中使用，可自动调用close()方法
     * @throws Exception
     */
    @Test
    void testTryWithResource() throws Exception,AppException{//throws跟在方法后面
        try(AutoCloseable r = new FileInputStream("TestMain.java")){
            System.out.println("do something.................");
        }
    }
}
