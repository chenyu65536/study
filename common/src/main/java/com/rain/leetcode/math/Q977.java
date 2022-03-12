package com.rain.leetcode.math;
//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//
// 示例 2：
//
//
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 已按 非递减顺序 排序
//
//
//
//
// 进阶：
//
//
// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
// Related Topics 数组 双指针 排序 👍 460 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q977 {

    public int[] sortedSquares(int[] nums) {
        int[] rs = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        int index = nums.length - 1;
        while (index>=0) {
            int leftValue = nums[left] * nums[left];
            int rightValue = nums[right] * nums[right];

            if (leftValue > rightValue) {
                rs[index] = leftValue;
                left++;
            } else {
                rs[index] = rightValue;
                right--;
            }
            index--;
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-7,-3,2,3,11};

        Q977 q977 = new Q977();
        int[] rs = q977.sortedSquares(nums);


        System.out.printf("11");
    }
}
