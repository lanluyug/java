package com.lanluyug.leetCode.random;

import org.junit.jupiter.api.Test;

public class beautyArray {

    @Test
    public int numberOfSubarrays(int[] nums, int k) {
        /*
         * 1. 滑动窗口
         */
        int left = 0, right = 0;
        int oddCount = 0;
        int res = 0;
        while(right < nums.length){
            if((nums[right] & 1) == 1){
                oddCount++;
            }
            if(oddCount == k){
                int temp = right;

                int countLeftEven = 0;
                while (right < nums.length && (nums[right] & 1) == 0){
                    right++;
                }
                int countRightEven = right - temp;
                while ((nums[left] & 1) == 0){
                    countLeftEven++;
                    left++;
                }
                res += (countLeftEven + 1) * (countRightEven + 1);
                // left移出第一个奇数，奇数个数减去1，重新开始匹配
                left++;
                oddCount--;
            }
        }
        return res;
    }
}
