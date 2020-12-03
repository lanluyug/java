package com.lanluyug.lanluyug.javaLogic.baseDemo;


import org.junit.jupiter.api.Test;

public class testCharacter {

    @Test
    void test(){
        /**
         * 1. int可以表示任意一个Unicode字符，低21位表示Unicode编号，高11位设为0
         * 2. 整数编号在Unicode中一般称为代码点 （code point），表示一个Unicode字符，与之相对，还有一个词代码单元 （code unit）表示一个char
         * 3. Character在Unicode字符级别（而非char级别）封装了字符的各种操作
         */

        char[] chs = new char[3];
        chs[0] = '马';
        Character.toChars(0x1FFFF,chs, 1);
        System.out.println(Character.codePointCount(chs, 0 ,3));
    }
}
