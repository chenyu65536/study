package com.rain.leetcode.easy;

public class Q1652 {
    public static int[] decrypt(int[] code, int k) {
        int length = code.length;
        if (k == 0) {
            return new int[length];
        }
        //计算开始结束的下标，每次遍历+1，类似前缀和
        int[] sum = new int[length];
        int startIndex = k > 0 ? 1 : length + k;
        int endIndex = startIndex + Math.abs(k);
        for (int i = startIndex; i < endIndex; i++) {
            sum[0] += code[i % length];
        }
        for (int i = 1; i < length; i++) {
            sum[i] = sum[i - 1] - code[(startIndex) % length] + code[endIndex % length];
            startIndex++;
            endIndex++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        int k = 3;
        code = new int[]{2,4,9,3};
         k =-2;
        decrypt(code,k);
    }
}
