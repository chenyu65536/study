package com.rain.leetcode.medium;

public class Q1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] unSatisfiedCustome = new int[customers.length + 1];
        int unsatisfiedNum = 0;
        int maxUnsatisfied = Integer.MIN_VALUE;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                unSatisfiedCustome[i + 1] = unSatisfiedCustome[i] + customers[i];
            } else {
                unSatisfiedCustome[i + 1] = unSatisfiedCustome[i];
                unsatisfiedNum += customers[i];
            }
            maxUnsatisfied = i + 1 >= minutes ? unSatisfiedCustome[i + 1] - unSatisfiedCustome[i + 1 - minutes] : unSatisfiedCustome[i];

        }
        return unsatisfiedNum + maxUnsatisfied;
    }

    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy =    {0, 1, 0, 1, 0, 1, 0, 1};
               //           [0, 0, 0, 0, 2, 2, 3, 3, 8]
        int minutes = 3;


        customers = new int[]{1};
        grumpy = new int[]{0};
        //           [0, 0, 0, 0, 2, 2, 3, 3, 8]
        minutes = 1;
        Q1052 q1052 = new Q1052();
        int rs = q1052.maxSatisfied(customers, grumpy, minutes);
        System.out.printf("" + rs);
//输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
//输出：16
//解释：书店老板在最后 3 分钟保持冷静。
//感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
//
//
// 示例 2：
//
//
//输入：customers = [1], grumpy = [0], minutes = 1
//输出：1
//
    }

}
