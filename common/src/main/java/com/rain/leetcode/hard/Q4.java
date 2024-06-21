package com.rain.leetcode.hard;

public class Q4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int mid = (len1 + len2) / 2;//奇数
        if (len1 == 0 || len2 == 0) {
            int mid1 = mid;
            if ((len1 + len2) % 2 == 0) {
                mid1 = mid - 1;
            }
            return len1 == 0 ? (nums2[mid1] + nums2[mid]) / 2D : (nums1[mid1] + nums1[mid]) / 2D;
        }
        //偶数 mid-1,mid
        int i = 0, j = 0;
        int[] nums = new int[2];
        while (i + j <= mid) {
            if (i < len1 && (j >= len2 || nums1[i] <= nums2[j])) {
                nums[(i + j) % 2] = nums1[i];
                i++;
            } else if (j < len2) {
                nums[(i + j) % 2] = nums2[j];
                j++;
            }
        }
        if ((len1 + len2) % 2 == 1) {
            return (double) Math.max(nums[0], nums[1]);
        }

        return (nums[0] + nums[1]) / 2D;
    }

    public static void main(String[] args) {
        Q4 q4 = new Q4();
        int[] nums1 = {3};
        int[] nums2 = {-2,-1};
        System.out.println(q4.findMedianSortedArrays(nums1, nums2));

    }
}
