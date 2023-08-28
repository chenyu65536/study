package com.rain.leetcode.medium;
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//
// 示例 2：
//
//
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
//
//
// Related Topics 并查集 数组 哈希表 👍 1771 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //100,4,200,1,3,2
        //1,2,3,4,100,200
        Arrays.sort(nums);
        int rs = 1;
        int startIndex = 0;
        int endIndex = 1;
        int length = 1;
        while (endIndex < nums.length) {
            //判断是否连续
            int gap = nums[endIndex] - nums[endIndex - 1];
            if (gap <= 1) {
                endIndex++;
                if (gap == 1) {
                    length++;
                    rs = Math.max(length, rs);
                }
            } else {
                startIndex = endIndex;
                endIndex = startIndex + 1;
                length = 1;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Q128 q128 = new Q128();
        int rs = q128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.printf("" + rs);
    }
}
