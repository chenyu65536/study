package com.rain.leetcode;

//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
//
//
//
// 示例 1：
//
//
//输入：nums = [10,2]
//输出："210"
//
// 示例 2：
//
//
//输入：nums = [3,30,34,5,9]
//输出："9534330"
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出："1"
//
//
// 示例 4：
//
//
//输入：nums = [10]
//输出："10"
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 109
//
// Related Topics 排序
// 👍 542 👎 0
public class Q179_X {


    public String largestNumber(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        //sort
        StringBuilder sb = new StringBuilder();
        for (int i = nums.length - 1; i >= 1; i--) {
            boolean bigger = compare(nums[i], nums[i - 1]);
            if (bigger) {
                sb.append(nums[i]);
            } else {
                sb.append(nums[i - 1]);
                nums[i - 1] = nums[i];
            }
        }
        sb.append(nums[0]);
        return sb.toString();
    }

    //按位比较->int 比较
    public boolean compare(int a, int b) {
        return a % 10 != 0 || b == 0 || a / b < 10;
    }

    public static void main(String[] args) {
        //  nums = [10,2]
        //int[] nums = new int[]{10,2};
        //3, 30, 34, 5, 9
        // int[] nums = new int[]{3, 30, 34, 5, 9};
         //10
        //int[] nums = new int[]{10};
        //0
        int[] nums = new int[]{0};

        Q179_X q179 = new Q179_X();

        /**
         * 	解答失败:
         * 			测试用例:[10,2,9,39,17]->10,17,2,39,9
         * 			测试结果:"17399210"
         * 			期望结果:"93921710"
         */
        System.out.printf(q179.largestNumber(nums));
    }

}
