package com.rain.leetcode.math;
//由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
//
//
// 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
// 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
//
//
// 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
//
//
//
// 示例 1：
//
//
//输入：s = "IDID"
//输出：[0,4,1,3,2]
//
//
// 示例 2：
//
//
//输入：s = "III"
//输出：[0,1,2,3]
//
//
// 示例 3：
//
//
//输入：s = "DDI"
//输出：[3,2,0,1]
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 只包含字符 "I" 或 "D"
//
// Related Topics 贪心 数组 数学 双指针 字符串 👍 302 👎 0

public class Q942 {

    //TODO
    public int[] diStringMatch(String s) {
        int[] nums = new int[s.length() + 1];

        nums[0] = 0;

        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            nums[i + 1] = s.charAt(i) == 'I' ? nums[i] + 1 : nums[i] - 1;
            min = Math.min(min, nums[i + 1]);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - min;
        }
        return nums;
    }

}
