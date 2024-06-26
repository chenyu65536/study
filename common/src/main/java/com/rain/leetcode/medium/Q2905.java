package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2905 {
    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int r = 0;
        int length = nums.length;
        int[][] map = new int[length][2];
        map[length - 1][0] = length - 1;// 最小值
        map[length - 1][1] = length - 1;// 最大值
        for (int i = length - 2; i >= 0; i--) {
            map[i][0] = map[i + 1][0];
            map[i][1] = map[i + 1][1];
            if (nums[i] > nums[map[i + 1][1]]) {
                map[i][1] = i;
            } else if (nums[i] < nums[map[i + 1][0]]) {
                map[i][0] = i;
            }
        }

        while (r < length - indexDifference) {
            int l = r + indexDifference;
            if (Math.abs(nums[r] - nums[map[l][1]]) >= valueDifference) {
                return new int[] { r, map[l][1] };
            } else if (Math.abs(nums[r] - nums[map[l][0]]) >= valueDifference) {
                return new int[] { r, map[l][0] };
            }
            r++;
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        findIndices(new int[]{9,5,4},1,0);

    }
}
