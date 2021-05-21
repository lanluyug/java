package com.lanluyug.lanluyug.leetCode.random;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> numberMap =new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            if(numberMap.get(nums[i]) == null){
                numberMap.put(nums[i],1);
            }else{
                return nums[i];
            }
        }
        return -1;
    }
    public int findRepeatNumber2(int[] nums){
        Set<Integer> numberSet = new HashSet<>();
        int repeatNum = -1;
        for (int i = 0; i < nums.length; i++) {
            if(!numberSet.add(nums[i])){
                repeatNum = nums[i];
                break;
            }
        }
        return repeatNum;
    }

    @Test
    public void testHashMap(){
        Map<Integer, Integer> numberMap =new HashMap<>();
        System.out.println(numberMap.get(1));
    }
}
