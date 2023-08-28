package com.rain.leetcode.medium;
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 10⁴
// intervals[i].length == 2
// 0 <= starti <= endi <= 10⁴
//
//
// Related Topics 数组 排序 👍 1997 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];

            for (int j = i + 1; j < intervals.length; j++) {
                int[] next = intervals[j];

                if (next[0] > current[1]) {
                    i = j - 1;
                    break;
                } else {
                    //merge
                    current[1] = Math.max(current[1], next[1]);
                    i = j;
                }
            }
            list.add(current);
        }
        int[][] rs = new int[list.size()][2];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = list.get(i);
        }
        return rs;
    }

    public static void main(String[] args) {
        Q56 q56 = new Q56();
        int[][] nums = new int[][]{{1, 4}, {4, 5}};
        int[][] rs = q56.merge(nums);
        System.out.printf("11");
    }
}
