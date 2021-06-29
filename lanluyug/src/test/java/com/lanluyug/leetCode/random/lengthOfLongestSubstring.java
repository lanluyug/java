package com.lanluyug.leetCode.random;

import java.util.HashMap;

public class lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int left = 0;
        // 字符--> 长度
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(hashMap.containsKey(temp)){
                left = Math.max(left, hashMap.get(temp)+ 1);
            }
            hashMap.put(temp, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
    /**
     * 分析：
     *3. 无重复字符的最长子串
     */
}
