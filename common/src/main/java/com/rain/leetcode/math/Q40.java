package com.rain.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。
//
// 注意：解集不能包含重复的组合。
//
//
//
// 示例 1:
//
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
// 示例 2:
//
//
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
//
//
//
// 提示:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
// Related Topics 数组 回溯 👍 898 👎 0
public class Q40 {
    List<List<Integer>> rs = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return rs;
    }

    List<Integer> ans = new ArrayList<>();

    private void backTracking(int[] candidates, int target, int startIndex) {
        if (target == 0) {
            rs.add(new ArrayList<>(ans));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > target || (i > startIndex && (candidates[i] == candidates[i - 1]))) {
                continue;
            } else {
                ans.add(candidates[i]);
                backTracking(candidates, target - candidates[i], i + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        //输入: candidates = [10,1,2,7,6,1,5], target = 8,
        //输出:
        //[
        //[1,1,6],
        //[1,2,5],
        //[1,7],
        //[2,6]
        //]
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        Q40 q40 = new Q40();
        List<List<Integer>> rs =  q40.combinationSum2(candidates,target);

        System.out.printf("111");
    }
}
