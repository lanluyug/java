package com.lanluyug.leetCode.leetbook.topInterviewQuestions.easy;

import java.util.HashSet;
import java.util.Set;

public class DuplicateItem {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int count=0;
        for (int right = 1; right < nums.length; right++) {
            if(nums[right-1]== nums[right]){
                count++;
            }else{
                nums[right - count] = nums[right];
            }
        }
        return nums.length - count;
    }
}
