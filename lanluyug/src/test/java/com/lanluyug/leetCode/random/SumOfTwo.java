package com.lanluyug.leetCode.random;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwo {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 1;
        while(nums.length > i){
            if(i!=j && nums[i] + nums[j] == target){
                break;
            }else if(j< nums.length-1){
                j++;
            }else{
                i++;
                j = 1;
            }
        }
        return new int[]{i,j};
    }

    /**
     * 速度快
     * @param nums
     * @param target
     * @return new int[]{i,hashMap.get(another)};
     */
    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>(len - 1);
        hashMap.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            int another = target - nums[i];
            if(hashMap.containsKey(another)){
                return new int[]{i,hashMap.get(another)};
            }
            hashMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum");
    }
    /**
     * 题目：1. 两数之和
     * 内容：
     * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 解题思路：
     * 1. target为固定的，则target - 其中-个数 = 另一个数
     * 将nums中的元素与下标依次存入hash表中，target - 其中-个数在hash表中存在，则返回其下标
     */

}
