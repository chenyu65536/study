package com.rain.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q135 {
    public static int candy(int[] ratings) {
        // 图形 查找极值（低点）
        int length = ratings.length;
        if (length == 1) {
            return 1;
        }
        int i = 0;
        //List<int[]> extremum = new ArrayList();
        int[] counts = new int[length];
        while (i < length - 1) {
            // 递减 局部最小值
            if (ratings[i + 1] >= ratings[i]) {
                while (i < length - 1 && ratings[i] >= ratings[i + 1]) {
                    i++;
                }
                counts[i] = 1;
            }
            if (i < length - 1 &&  ratings[i] <= ratings[i + 1]) {
                // 递增 局部最大值
                while (i < length - 1 && ratings[i] <= ratings[i + 1]) {
                    i++;
                }
                counts[i] = Integer.MAX_VALUE;
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        candy(new int[]{2,1,1});

    }
}
