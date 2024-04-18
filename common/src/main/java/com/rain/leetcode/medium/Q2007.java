package com.rain.leetcode.medium;

import java.util.TreeMap;

public class Q2007 {

    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[]{};
        }

        TreeMap<Integer, Integer> numCount = new TreeMap<>();
        for (int num : changed) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        int[] rs = new int[changed.length / 2];
        for (int i = 0; i < rs.length; i++) {
            int before = numCount.firstKey();
            int beforeCount = numCount.get(before);
            if (beforeCount > 1) {
                numCount.put(before, beforeCount - 1);
            } else {
                numCount.remove(before);
            }

            int afterCount = numCount.getOrDefault(before * 2, 0);
            if (afterCount > 0) {
                rs[i] = before;
                if (afterCount > 1) {
                    numCount.put(before * 2, afterCount - 1);
                } else {
                    numCount.remove(before * 2);
                }
            } else {
                return new int[]{};
            }
        }
        return rs;
    }

}
