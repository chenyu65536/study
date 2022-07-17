package com.rain.leetcode.math;
//给你个整数数组 arr，其中每个元素都 不相同。
//
// 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
//
//
//
// 示例 1：
//
// 输入：arr = [4,2,1,3]
//输出：[[1,2],[2,3],[3,4]]
//
//
// 示例 2：
//
// 输入：arr = [1,3,6,10,15]
//输出：[[1,3]]
//
//
// 示例 3：
//
// 输入：arr = [3,8,-10,23,19,-4,-14,27]
//输出：[[-14,-10],[19,23],[23,27]]
//
//
//
//
// 提示：
//
//
// 2 <= arr.length <= 10^5
// -10^6 <= arr[i] <= 10^6
//
// Related Topics 数组 排序 👍 107 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> rs = null;

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int currentDiff = arr[i] - arr[i - 1];
            if (minDiff == currentDiff) {
                rs.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (minDiff > currentDiff) {
                rs = new ArrayList<>();
                rs.add(Arrays.asList(arr[i - 1], arr[i]));
                minDiff =  currentDiff;
            }
        }
        return rs;
    }
    // 0,1 2,3

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 6, 10, 15};
        Q1200 q1200 = new Q1200();
        q1200.minimumAbsDifference(arr);
    }
}
