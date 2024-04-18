package com.rain.leetcode.medium;

import java.util.*;

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


    public static List findOriginalArray2(int[] changed) {
        if (changed.length % 2 == 1) {
            return null;
        }

        Map<Integer, Integer> numCountMap = new HashMap<>();
        LinkedList<Integer> rs = new LinkedList<>();
        for (int num : changed) {
            int count = numCountMap.getOrDefault(num, 0) + 1;
            if (num == 0 && count % 2 == 0) {//count只能為2
                numCountMap.remove(0);
                rs.add(0);
                continue;
            }
            boolean isMatch = false;
            if (numCountMap.containsKey(num * 2)) {
                rs.add(num);
                isMatch = true;
                int doubleCount = numCountMap.get(num * 2);
                if (doubleCount == 1) {
                    numCountMap.remove(num * 2);
                } else {
                    numCountMap.put(num * 2, doubleCount - 1);
                }
            }
            if (num % 2 == 0 && numCountMap.containsKey(num / 2)) {
                rs.add(num / 2);
                isMatch = true;
                int doubleCount = numCountMap.get(num / 2);
                if (doubleCount == 1) {
                    numCountMap.remove(num / 2);
                } else {
                    numCountMap.put(num / 2, doubleCount - 1);
                }
            }
            if (!isMatch) {
                numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,6,8};
        findOriginalArray2(nums);
    }

}
