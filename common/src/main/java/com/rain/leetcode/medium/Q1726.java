package com.rain.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Q1726 {
    public static int tupleSameProduct(int[] nums) {
        boolean[] sortNums = new boolean[10001];
        for (int num : nums) {
            sortNums[num] = true;
        }
        int rs = 0;
        for (int i = 0; i < sortNums.length; i++) {
            for (int j = sortNums.length - 1; j > i; j--) {
                while (i < j && !sortNums[i]) {
                    i++;
                }
                while (i < j && !sortNums[j]) {
                    j--;
                }
                if (i == j) {
                    break;
                }
                int product = i * j;
                for (int m = i + 1; m < j; m++) {
                    if (!sortNums[m]) {
                        continue;
                    }
                    if (product % m == 0 && sortNums[product / m]) {
                        if (product / m <= m) {
                            break;
                        }
                        rs++;
                    }
                }
            }
        }
        return rs * 8;
    }


    public static int tupleSameProduct2(int[] nums) {
        Map<Integer, Integer> products = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                products.put(product, products.getOrDefault(product, 0) + 1);
            }
        }
        int rs = 0;
        for (Integer count : products.values()) {
            rs += count * (count - 1) * 4;
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 6, 8, 12};
        int rs = tupleSameProduct2(nums);
        System.out.printf("" + rs);
    }
}
