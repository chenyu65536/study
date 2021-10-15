package com.rain.leetcode.unclassfy;
//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
//
// 示例 1:
//
//
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是:
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
//
//
// 注意:
//
//
// 数组长度不超过1000。
// 数组里整数的范围为 [0, 1000]。
//
// Related Topics 贪心 数组 双指针 二分查找 排序
// 👍 238 👎 0

import java.util.Arrays;

public class Q611 {

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int c = nums[k];
                    if (matchTriangle(a, b, c)) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }

    private boolean matchTriangle(int a, int b, int c) {
        if (a == 0 || b == 0 || c == 0) {
            return false;
        }
        return (a + b) > c;
    }

    public static void main(String[] args) {
        Q611 q611 = new Q611();
        System.out.printf("" + q611.triangleNumber(new int[]{0,1,1,1}));
    }
}
