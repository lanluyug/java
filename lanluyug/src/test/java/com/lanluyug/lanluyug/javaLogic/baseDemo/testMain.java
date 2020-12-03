package com.lanluyug.lanluyug.javaLogic.baseDemo;

import org.junit.jupiter.api.Test;

public class testMain {
    @Test
    void testBase(){
        // 拆箱
        Integer a = 100;
        int b = a;
        // 相当于
        Integer a1 = Integer.valueOf(100);
        int b1 = a1.intValue();

        // 通过new创建
        // 除去Float和Double，其他基本对象都会缓存，所以避免使用new创建一个新的基本对象
        Integer a2 = new Integer(100);

        // 各基本类型valueOf(String); char为字符
        Boolean b4 = Boolean.valueOf("true");
        Float f = Float.valueOf("3.12");
        Double d = Double.valueOf("3.12");
        Integer i = Integer.valueOf("123");
        Long l = Long.valueOf("1234");
        Short s= Short.valueOf("12");
        Character c = Character.valueOf('1');


        // parseXXX(String)
        boolean b5 = Boolean.parseBoolean("true");


        // toString()
        String b6 = Boolean.toString(true);
        String s1 = Float.toString(3.12f);
    }

    @Test
    void testFloat(){
        //浮点运算结果不精确
        Float f1 = 0.01f;
        Float f2 = 0.1f * 0.1f;
        Float f3 = 0.2f * 0.5f;
        System.out.printf("Float.floatToIntBits(f1) = %d\n",Float.floatToIntBits(f1));
        System.out.printf("Float.floatToIntBits(f2) = %d\n",Float.floatToIntBits(f2));
        System.out.printf("Float.floatToIntBits(f3) = %d\n",Float.floatToIntBits(f3));
        System.out.printf("f1.equals(f2) = %s\n",Boolean.toString(f1.equals(f2)));
        System.out.printf("f3.equals(f2) = %s\n",Boolean.toString(f3.equals(f2)));
    }

    @Test
    void testHashCode(){
        // hashCode是一个int型数字
        /**
         * 1. 有可能对象不同，hashCode相同
         * 2. 如果equals返回true，hashCode必须一样
         * 3. 子类重写了equals，也必须重写hashCode
         */
        System.out.printf("hashCode(32.0) = %d",hashCode(32.0));

    }
    // Double计算hashCode代码
    //与equals方法类似，将double的二进制表示看作long，然后再按long计算hashCode。
    public int hashCode(Double value){
        long bits = Double.doubleToLongBits(value);
        return (int)(bits ^ (bits >>> 32)); // >>> 无符号右移
    }


}
