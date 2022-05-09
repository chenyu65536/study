package com.rain.leetcode.off;

import java.util.ArrayList;
import java.util.List;

//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
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
//
//
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/
// Related Topics 数组 回溯 👍 19 👎 0
public class Of083 {
    List<List<Integer>> rs = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums);
        return rs;
    }

    List<Integer> row = new ArrayList<>();

    int flag = 11;
    private void backTrack(int[] nums) {
        if (row.size() == nums.length) {
            rs.add(new ArrayList<>(row));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == flag) {
                continue;
            }
            int temp = nums[i];
            nums[i] = flag;
            row.add(temp);
            backTrack(nums);
            nums[i] = temp;
            row.remove(row.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};

        Of083 of083 = new Of083();
        List<List<Integer>> rs = of083.permute(nums);

        System.out.printf("11");
    }
}
