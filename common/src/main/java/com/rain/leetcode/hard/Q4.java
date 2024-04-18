package com.rain.leetcode.hard;

public class Q4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int rightIndex = 0;
        int leftIndex = 0;
        if (total % 2 == 0) {
            rightIndex = total / 2;
            leftIndex = rightIndex - 1;
        } else {
            rightIndex = total / 2;
            leftIndex = rightIndex;
        }

        int num1StartIndex = Math.max(nums1.length / 4 - 1, 0);
        int num2StartIndex = Math.max(nums2.length / 4 - 1, 0);

        int i = num1StartIndex, j = num2StartIndex;
        int leftVal = 0;
        int rightVal = 0;
        while (i + j < leftIndex) {
            int curVal = 0;
            if (nums1[i] < nums2[j]) {
                curVal = nums1[i];
                i++;
            } else {
                curVal = nums2[j];
                j++;
            }
            if (i + j == rightIndex) {
                rightVal = curVal;
            }
            if (i + j == leftIndex) {
                leftVal = curVal;
            }
        }

        return ((double) rightVal + leftVal) / 2;
    }

    public static void main(String[] args) {
        Q4 q4 = new Q4();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(q4.findMedianSortedArrays(nums1, nums2));

    }
}
