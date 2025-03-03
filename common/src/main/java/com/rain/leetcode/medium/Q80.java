package com.rain.leetcode.medium;
//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
//
// 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//
//
//
// 说明：
//
// 为什么返回数值是整数，但输出的答案是数组呢？
//
// 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
//
// 你可以想象内部操作如下:
//
//
//// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
//int len = removeDuplicates(nums);
//
//// 在函数里修改输入数组对于调用者是可见的。
//// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
//for (int i = 0; i < len; i++) {
//    print(nums[i]);
//}
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,1,2,2,3]
//输出：5, nums = [1,1,2,2,3]
//解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
//
//
// 示例 2：
//
//
//输入：nums = [0,0,1,1,1,1,2,3,3]
//输出：7, nums = [0,0,1,1,2,3,3]
//解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的
//元素。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -104 <= nums[i] <= 104
// nums 已按升序排列
//
// Related Topics 数组 双指针
// 👍 445 👎 0

import java.util.List;

public class Q80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 0;
        int stepLength = 0;
        for (int j = 1; j < nums.length - stepLength; j++) {
            if (nums[i] != nums[j]) {
                i = j;
            } else if (j - i > 1 && nums[i] == nums[j]) {
                for (int z = j; z < nums.length; z++) {
                    if (nums[z] != nums[i]) {
                        move(nums, j, z - j);
                        stepLength += z - j;
                        i = j;
                        j = i;
                        break;

                    } else if (z == nums.length - 1) {
                        return j;
                    }
                }
            }
        }
        return nums.length - stepLength;
    }


    public int removeDuplicates2(int[] nums) {
        int length = nums.length;
        int j = 0;
        for (int i = 0; i < length; ) {
            nums[j] = nums[i];

            int cnt = 1;
            while (i + 1 < length && nums[i + 1] == nums[j]) {
                cnt++;
                i++;
            }
            if (cnt > 1) {
                nums[j + 1] = nums[j];
                j++;
            }
            i++;
            j++;

        }
        return j;
    }


    public int removeDuplicates3(int[] nums) {
        int i = 0, j = 0, length = nums.length;
        while (i < length) {
            nums[j] = nums[i];
            int cnt = 0;
            while (i < length && nums[i] == nums[j]) {
                i++;
                cnt++;
            }
            if (cnt >= 2) {
                nums[j + 1] = nums[j];//出现多次，只保留2次
                j++;
            }
            j++;
        }
        return j;
    }

    public void move(int[] nums, int startIndex, int moveLength) {
        for (int i = startIndex; i < nums.length - moveLength; i++) {
            nums[i] = nums[i + moveLength];
        }
    }


    public static void main(String[] args) {
        /**
         * 解答失败:
         * 			测试用例:[1,1,1,2,2,3]
         * 			测试结果:[1,1,2,3,3]
         * 			期望结果:[1,1,2,2,3]
         * 			stdout:
         */
        //int[] a = {1, 1, 1, 2, 2, 3};
        //int[] a = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] a = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        //int[] a = {1, 1, 1};
        //int[] a = {1, 1, 1, 1};
        Q80 q80 = new Q80();
        //  q80.move(a, 1, 2);
        int length = q80.removeDuplicates3(a);
        System.out.printf("" + length);
    }

}
