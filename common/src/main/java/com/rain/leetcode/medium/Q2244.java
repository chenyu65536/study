package com.rain.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Q2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int times = 0;
        for (Integer cnt : map.values()) {
            if (cnt == 1) {
                return -1;
            }
            times += cnt / 3 + (cnt % 3 == 0 ? 0 : 1);
        }
        return times;
    }
}
