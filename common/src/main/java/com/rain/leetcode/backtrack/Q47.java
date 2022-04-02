package com.rain.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 数组 回溯 👍 1001 👎 0
public class Q47 {
    List<List<Integer>> rs = new ArrayList<>();
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        backTracking(nums);
        return rs;
    }

    List<Integer> ans = new ArrayList<>();

    private void backTracking(int[] nums) {
        if (ans.size() == nums.length) {
            rs.add(new ArrayList<>(ans));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i - 1] && !vis[i-1]) || vis[i]) {
                continue;
            }
            ans.add(nums[i]);
            vis[i] = true;
            backTracking(nums);
            ans.remove(ans.size() - 1);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        Q47 q47 = new Q47();
        List<List<Integer>> rs = q47.permuteUnique(nums);
        System.out.printf("11");
    }
}
