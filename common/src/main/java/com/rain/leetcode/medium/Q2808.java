package com.rain.leetcode.medium;

import java.util.*;

public class Q2808 {
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);

        }
        int rs = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            List<Integer> indexs = map.get(key);
            int maxDistance = nums.size() - (indexs.get(indexs.size() - 1) - indexs.get(0));
            for (int i = 1; i < indexs.size(); i++) {
                maxDistance = Math.max(maxDistance, indexs.get(i) - indexs.get(i-1));
            }
            rs = Math.min(rs, maxDistance);
        }
        return rs / 2;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 1, 3, 3, 2);
        Q2808 q2808 = new Q2808();
        int rs = q2808.minimumSeconds(nums);
        System.out.printf("" + rs);
    }
}
