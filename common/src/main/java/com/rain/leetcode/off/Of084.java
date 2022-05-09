package com.rain.leetcode.off;
//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
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
//
//
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/
// Related Topics 数组 回溯 👍 18 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Of084 {

    List<List<Integer>> rs = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (nums[i] == flag || (i < nums.length - 1 && nums[i] == nums[i + 1])) {
                continue;
            }
            int temp = nums[i];
            nums[i] = flag;
            row.add(temp);
            backTrack(nums);
            row.remove(row.size() - 1);
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};

        Of084 of084 = new Of084();
        List<List<Integer>> rs = of084.permuteUnique(nums);

        System.out.printf("11");
    }
}
