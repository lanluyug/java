package com.lanluyug.javaLogic.baseDemo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class testArrays {
    /**
     * 拓展：Apache有一个开源包（http://commons.apache.org/proper/commons-lang/），
     * 里面有一个类ArrayUtils（位于包org.apache.commons.lang3），
     * 包含了更多的常用数组操作，这里就不列举了。
     */

    @Test
    void test(){

        int[] arr = {1,2,3, 5, 4};
        System.out.println(Arrays.toString(arr));

        int[][] deepArr = new int[][]{{0,1},{2,3,4},{5,6,7,8}};
        System.out.println(Arrays.deepToString(deepArr));

        int[] arrFill = new int[10];

        Arrays.fill(arrFill,3);
        System.out.println(Arrays.toString(arrFill));

        /**
         * 排序
         */
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        String[] str = {"hello", "Break", "asc"};
        // 忽略大小写
        Arrays.sort(str,String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(str));

        // 倒序
        Arrays.sort(str, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Arrays.toString(str));

        /**
         * 查找
         */

        // BinarySearch只能针对已排序数组
        System.out.println(Arrays.binarySearch(arr,3));
        System.out.println(Arrays.binarySearch(arr,8));//-6 插入点+1取负数


    }
}
