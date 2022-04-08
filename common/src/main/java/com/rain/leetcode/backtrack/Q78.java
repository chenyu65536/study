package com.rain.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同
//
// Related Topics 位运算 数组 回溯 👍 1569 👎 0
public class Q78 {
    List<List<Integer>> rs = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        rs.add(Collections.EMPTY_LIST);
        backTrack(nums, 0);
        return rs;
    }

    List<Integer> row = new ArrayList<>();

    private void backTrack(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            row.add(nums[i]);
            rs.add(new ArrayList<>(row));
            backTrack(nums, i + 1);
            row.remove(row.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Q78 q78 = new Q78();
        List<List<Integer>> rs  =  q78.subsets(nums);
        System.out.printf("1");
    }
}
