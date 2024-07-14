package com.rain.leetcode.medium;

public class Q3115 {
    boolean[] memo;

    public int maximumPrimeDifference(int[] nums) {
        memo = new boolean[101];
        memo[2] = true;
        for (int i = 3; i < 101; i++) {
            memo[i] = isPrime(i);
        }

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            while (i <= j && !memo[nums[i]]) {
                i++;
            }
            while (i <= j && !memo[nums[j]]) {
                j--;
            }
            break;
        }
        return j - i;
    }

    public boolean isPrime(int number) {
       /* if (number == 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }*/
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q3115 q3115 = new Q3115();
        q3115.maximumPrimeDifference(new int[]{4,2,9,5,3});
    }
}
