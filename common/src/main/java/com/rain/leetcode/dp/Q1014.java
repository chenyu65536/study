package com.rain.leetcode.dp;
//给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
//
// 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离
//。
//
// 返回一对观光景点能取得的最高分。
//
//
//
// 示例 1：
//
//
//输入：values = [8,1,5,2,6]
//输出：11
//解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
//
//
// 示例 2：
//
//
//输入：values = [1,2]
//输出：2
//
//
//
//
// 提示：
//
//
// 2 <= values.length <= 5 * 10⁴
// 1 <= values[i] <= 1000
//
// Related Topics 数组 动态规划 👍 274 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * todo first
 */

public class Q1014 {

    public int maxScoreSightseeingPair(int[] values) {
        //values[i] + values[j] + i - j
        //=values[i] + i  + values[j]- j
        //=maxI+maxJ
        int maxI = 0;
        int maxScore = 0;
        for (int i = 0; i < values.length - 1; i++) {
            maxI = Math.max(values[i] + i, maxI);
            maxScore = Math.max(maxScore, values[i + 1] - i - 1 + maxI);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        Q1014 q1014 = new Q1014();
        int score = q1014.maxScoreSightseeingPair(new int[]{8,1,5,2,6});

        System.out.printf(""+score);
    }

}
