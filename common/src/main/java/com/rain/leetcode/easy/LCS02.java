package com.rain.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LCS02 {
    public int halfQuestions(int[] questions) {
        int n = questions.length / 2;
        Map<Integer, Integer> tree = new HashMap<>();
        for (int question : questions) {
            tree.put(question, tree.getOrDefault(question, 0) + 1);
        }
        //1,5,1,3,4,5,2,5,3,3,8,6
        Integer[] values = tree.values().toArray(new Integer[0]);
        Arrays.sort(values, (o1, o2) ->  o2 - o1);
        int rs = 0;
        for (Integer val : values) {
            n -= val;
            rs++;
            if (n <= 0) {
                break;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        LCS02 lcs02 = new LCS02();
        int rs = lcs02.halfQuestions(new int[]{2, 1, 6, 2});
        System.out.printf("" + rs);
    }
}
