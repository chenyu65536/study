package com.rain.leetcode.medium;
//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
//
//
// Related Topics 位运算 数组 回溯 👍 1160 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q90 {

    List<List<Integer>> rs = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0, new boolean[nums.length]);
        return rs;
    }

    List<Integer> temp = new ArrayList<>();

    private void backTrack(int[] nums, int start, boolean[] used) {
        rs.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i - 1 >= 0) {
                if (nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }
            }
            temp.add(nums[i]);
            used[i] = true;
            backTrack(nums, i + 1, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        Q90 q90 = new Q90();
        List<List<Integer>> rs = q90.subsetsWithDup(nums);
        System.out.printf("" + rs);
    }
}
