package com.rain.leetcode.medium;
//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
//
//
// 示例 2：
//
//
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
//
// 示例 3：
//
//
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
//
//
// 示例 4：
//
//
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
//
//
// 示例 5：
//
//
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
//
//
//
//
// 提示：
//
//
// 0 <= intervals.length <= 10⁴
// intervals[i].length == 2
// 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵
// intervals 根据 intervals[i][0] 按 升序 排列
// newInterval.length == 2
// 0 <= newInterval[0] <= newInterval[1] <= 10⁵
//
//
// Related Topics 数组 👍 737 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean hasInsert = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] > newInterval[1] ) {
                //insert before
                if (!hasInsert) {
                    hasInsert = true;
                    list.add(newInterval);
                }
                list.add(current);
            } else if (newInterval[0] > current[1]) {
                list.add(current);
            } else {
                hasInsert = true;
                //merge start
                //merge end
                int startVal = Math.min(newInterval[0], current[0]);
                int[] temp = new int[]{startVal, newInterval[1]};
                list.add(temp);
                int j = i;
                for (; j < intervals.length; j++) {
                    if (intervals[j][0] > newInterval[1]) {
                        list.add(intervals[j]);
                        break;
                    } else {
                        temp[1] = Math.max(newInterval[1], intervals[j][1]);
                    }
                }
                i = j;
            }
        }
        if (!hasInsert) {
            list.add(newInterval);
        }
        int[][] rs = new int[list.size()][2];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = list.get(i);
        }
        return rs;
    }

    public static void main(String[] args) {
    /*    测试用例:[[1,5],[6,8]]
			[5,6]
        测试结果:[[1,8],[5,8]]
        期望结果:[[1,8]]*/
        Q57 q57 = new Q57();
        int[][] intervals = new int[][]{{2, 5}, {6, 7}, {8, 9}};
        int[] newInterval = new int[]{0, 1};

        int[][] rs = q57.insert(intervals, newInterval);
        System.out.printf("11");
    }
}
