package com.rain.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Q935 {
    public static int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }
        Map<Integer, Integer[]> maps = new HashMap<Integer, Integer[]>() {{
            put(0, new Integer[]{4, 6});
            put(1, new Integer[]{6, 8});
            put(2, new Integer[]{7, 9});
            put(3, new Integer[]{4, 8});
            put(4, new Integer[]{0, 3, 9});
            put(5, new Integer[]{});
            put(6, new Integer[]{0, 1, 7});
            put(7, new Integer[]{2, 6});
            put(8, new Integer[]{1, 3});
            put(9, new Integer[]{2, 4});
        }};
        //[, , , , , , , , , , , , , , , , , , , ]
        //40 60   0=>4  404,406 604,606  4*2 6*2
        //61 81   1=>4  616 618 816 818  6*2 8*2
        //72 92   2=>4  727 729 927 929  7*2 9*2
        //43 83   3=>4  434 834 438 838  4*2 8*2
        //04 34 94 4=>9                  0*3 3*3 9*3
        //06 16 76 6=>9                  0*3 1*3 7*3
        //27 67    7=>4                  2*2 6*2
        //18 38    8=>4                  1*2 3*2
        //29 49    9=>4                  2*2 4*2
        int[] preEndNumCount = new int[10];
        int[] currentEndNumCount = new int[10];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < preEndNumCount.length; j++) {
                Integer[] nums = maps.get(j);
                for (Integer num : nums) {
                    currentEndNumCount[num] = currentEndNumCount[num] + preEndNumCount[j] + 1;
                }
            }
            preEndNumCount = currentEndNumCount;
            currentEndNumCount = new int[10];
        }
        int rs = 0;
        for (int i = 0; i < preEndNumCount.length; i++) {
            rs += preEndNumCount[i];
        }
        return rs;
    }

    public static void main(String[] args) {
        int rs = knightDialer(3);
        System.out.printf("" + rs);
    }
}
