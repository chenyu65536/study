package com.rain.leetcode.easy.e1;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明：
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例：
//
//
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6]
//
//
//
// 提示：
//
//
// -10^9 <= nums1[i], nums2[i] <= 10^9
// nums1.length == m + n
// nums2.length == n
//
// Related Topics 数组 双指针
// 👍 705 👎 0


public class Q88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mIndex = m - 1;
        int nIndex = n - 1;
        for (int i = 0; i < m + n; i++) {
            if (nIndex < 0) {
                return;
            }
            if (mIndex >= 0 ) {
                if (nums2[nIndex] >= nums1[mIndex]) {
                    nums1[m + n - i - 1] = nums2[nIndex];
                    nIndex--;
                } else {
                    nums1[m + n - i - 1] = nums1[mIndex];
                    mIndex--;
                }
            } else {
                nums1[m + n - i - 1] = nums2[nIndex];
                nIndex--;
            }
        }
    }

    public static void main(String[] args) {
         int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
         int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);

      /*  int[] nums1 = new int[]{2, 0};
        int[] nums2 = new int[]{1};
        merge(nums1, 1, nums2, 1);*/
        System.out.printf("111");
    }

}
