package com.rain.leetcode.medium;

public class Q275 {

    public static int hIndex(int[] citations) {
        int i = 0, j = citations.length - 1;
        int rs = 0;
        while (i < j) {
            int mid = (i + j) / 2;
            if (citations[mid] >= citations.length - mid) {
                rs = Math.max(rs, citations.length - mid);
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3, 5, 6};
        int rs = Q275.hIndex(nums);
        System.out.printf("" + rs);
    }
}
