package com.rain.algorithm;

/**
 * 二分查找
 * 输入升序数组（或非降序）
 * 输出 下标
 * 若未找到返回-1
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }

        while (true) {
            int mid = (left + right) / 2;
            if (nums[left] > target || nums[right] < target) {
                return -1;
            }

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                //  往左找
                right = mid;
            } else {
                //  往右找
                left = mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 10, 10, 10, 26};
        //int[] nums = new int[]{1, 2, 3};

        BinarySearch search = new BinarySearch();
        int index = search.search(nums, 27);
        System.out.printf("" + index);

    }


}
