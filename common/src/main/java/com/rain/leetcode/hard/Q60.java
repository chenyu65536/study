package com.rain.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Q60 {
    public static String getPermutation(int n, int k) {
        // "123"
        // "132"
        // "213"
        // "231"
        // "312"
        // "321"
        int[] count = new int[n];//每行的数量
        count[0] = 1;
        for (int i = 1; i < n; i++) {
            count[i] = (i + 1) * count[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        List<Character> nums = new ArrayList<>();
        k--;
        for (int i = 0; i < n; i++) nums.add((char) ('0' + i + 1));
        for (int i = n - 1; i > 0; i--) {
            // 循环次数 k / cnt +1
            int cnt = count[i - 1];
            int idx = k / cnt;
            sb.append(nums.get(idx % nums.size()));
            nums.remove(idx % nums.size());

            k = k % cnt;

        }
        sb.append(nums.get(0));
        return sb.toString();
    }

    public static void main(String[] args) {
        Q60.getPermutation(4, 9);
    }
}
