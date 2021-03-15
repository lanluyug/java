package com.lanluyug.lanluyug.leetCode.algorithm.simple;

import java.util.HashMap;
import java.util.Map;

public class Unique {
    public boolean isUnique(String astr) {
        Map map = new HashMap<>();
        boolean flag = true;
        for (int i = 0; i < astr.length(); i++) {
            char s = astr.charAt(i);
            if(map.get(s) == null){
                map.put(s,0);
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }
}
