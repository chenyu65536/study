package com.rain.leetcode.backtrack;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯 👍 1885 👎 0

import java.util.ArrayList;
import java.util.List;

public class Q46 {
    List<List<Integer>> rs = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return rs;
    }

    List<Integer> temp = new ArrayList<>();
    private void backtrack(int[] nums) {
        if (temp.size() == nums.length) {
            rs.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])){
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2,3};
        Q46 q46 = new Q46();
        List<List<Integer>> rs = q46.permute(nums);
        System.out.printf("11");
    }
}
