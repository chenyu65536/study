package com.rain.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
//给定一个 无重复元素 的 有序 整数数组 nums 。
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于
//nums 的数字 x 。
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出：
//
//
// "a->b" ，如果 a != b
// "a" ，如果 a == b
//
//
//
//
// 示例 1：
//
//
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
//
//
// 示例 2：
//
//
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 20
// -2³¹ <= nums[i] <= 2³¹ - 1
// nums 中的所有值都 互不相同
// nums 按升序排列
//
//
// Related Topics 数组 👍 276 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> rs = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return rs;
        }
        int startIndex = 0;
        int endIndex = 1;
        while (endIndex < nums.length) {
            if (nums[endIndex] - nums[endIndex - 1] == 1) {
                endIndex++;
            } else {
                if (startIndex == endIndex - 1) {
                    rs.add(nums[startIndex] + "");
                } else {
                    rs.add(nums[startIndex] + "->" + nums[endIndex - 1]);
                }
                //4,5
                startIndex = endIndex;
                endIndex = startIndex + 1;
            }
        }
        if (startIndex == endIndex - 1) {
            rs.add(nums[startIndex] + "");
        } else {
            rs.add(nums[startIndex] + "->" + nums[endIndex - 1]);
        }
        return rs;
    }

    public static void main(String[] args) {
        //0,2,3,4,6,8,9

        Q228 q228 = new Q228();
        List<String> rs = q228.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
    }
}
