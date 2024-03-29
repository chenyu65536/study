package com.rain.leetcode.dp;
//如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
//
//
// 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
//
//
//
//
// 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
//
// 子数组 是数组中的一个连续序列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3,4]
//输出：3
//解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -1000 <= nums[i] <= 1000
//
//
//
// Related Topics 数组 动态规划 👍 408 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q413 {


    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int step = nums[i + 1] - nums[i];
            for (int j = i + 2; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] == step) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Q413 q413 = new Q413();
        int rs = q413.numberOfArithmeticSlices(nums);
        System.out.printf("" + rs);
    }

}
