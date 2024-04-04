package com.rain.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Q454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map1 = buildMap(nums1,nums2);
        Map<Integer, Integer> map2 = buildMap(nums3,nums4);
        int rs = 0;
        for (Integer key : map1.keySet()) {
            rs += map1.get(key) * map2.getOrDefault(0 - key,0);
        }
        return rs;
    }

    public Map<Integer, Integer> buildMap(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                map.put(n1 + n2, map.getOrDefault(n1 + n2, 0) + 1);
            }
        }
        return map;
    }
}
