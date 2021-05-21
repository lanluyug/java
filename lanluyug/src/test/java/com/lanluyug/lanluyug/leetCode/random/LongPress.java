package com.lanluyug.lanluyug.leetCode.random;

public class LongPress {

    public static void main(String[] args) {

    }
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while(j < typed.length()){
            if(i< name.length() && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else if(j> 0 && name.charAt(i)== typed.charAt(j-1)){
                j++;
            }else{
                return false;
            }
        }
        return i == name.length();
    }
    /**
     * 题目： 925.长按键入
     * 难度： 简单
     * 网址：https://leetcode-cn.com/problems/long-pressed-name/
     * 内容：
     * 你的朋友正在使用键盘输入他的名字name。偶尔，在键入字符c时，按键可能会被长按，而字符可能被输入 1 次或多次。
     *
     * 你将会检查键盘输入的字符typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回True。
     *
     *
     * 思路与算法
     *
     * 根据题意能够分析得到：字符串 typed 的每个字符，有且只有两种「用途」：
     *
     * 1. 作为 name 的一部分。此时会「匹配」name 中的一个字符
     *
     * 2. 作为长按键入的一部分。此时它应当与前一个字符相同。
     *
     *
     */
}
