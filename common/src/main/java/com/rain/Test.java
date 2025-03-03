package com.rain;


import com.rain.leetcode.bean.ListNode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author chenyu
 * @version 1.0.0
 * @date 2020/5/15 4:50 下午
 */
public class Test {

    public static int maximumLength(int[] nums) {
        //全偶数 or 奇数 %=0

        int oddStartCount = 0;
        int evenStartCount = 0;
        int oddEvenStartCount = 1;

        boolean oddEvenStartStartFlag = (nums[0] % 2 == 0);


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenStartCount++;
            } else {
                oddStartCount++;
            }
            if (i > 0 && oddEvenStartStartFlag != (nums[i] % 2 == 0)) {
                oddEvenStartCount++;
                oddEvenStartStartFlag = !oddEvenStartStartFlag;
            }
        }

        int rs1 = Math.max(evenStartCount, oddStartCount);
        return Math.max(rs1, oddEvenStartCount);
        //奇数+偶数
    }


    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode newHead = new ListNode();
        ListNode newNext = newHead;

        ListNode next = head;
        ListNode[] nodes = new ListNode[k];
        while (next != null) {
            int i = 0;
            while (i != k && next != null) {
                nodes[i] = next;
                next = next.next;
                i++;
            }
            //说明数组满了，reverse
            if (i == k) {
                for (int j = k - 1; j >= 0; j--) {
                    newNext.next = nodes[j];
                    newNext = nodes[j];
                }
            } else {
                for (int j = 0; j < i; j++) {
                    newNext.next = nodes[j];
                    newNext = nodes[j];
                }
                newNext.next = null;
            }
        }
        return newHead.next;
    }

    public int maxWidthRamp(int[] nums) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        int res = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                res = Math.max(res,i - stack.pop());
            }
        }
        return res;
    }

    public static int minimumLevels(int[] possible) {
        int length = possible.length;
        possible[0]=possible[0]==1?1:-1;
        for(int i=1;i<length;i++){
            int score = possible[i]==1?1:-1;
            possible[i] = possible[i-1]+score;
        }
        for(int i=0;i<length-1;i++){
            if(possible[i]*2>possible[length-1]){
                return i+1;
            }
        }
        return -1;
    }

    public static long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int length = energyDrinkA.length;
        long[][] dp = new long[2][2];

        dp[1][0]= energyDrinkA[0];
        dp[1][1]= energyDrinkB[0];

        for(int i=2;i<length+1;i++){
            long preVal = dp[(i-2)%2][0];

            dp[i%2][0] = Math.max(dp[(i-1)%2][0],dp[(i-2)%2][1])+energyDrinkA[i-1];//A+A or B+A

            dp[i%2][1] = Math.max(dp[(i-1)%2][1],preVal)+energyDrinkB[i-1];//B+B or A+B
        }
        return Math.max(dp[length%2][0],dp[length%2][1]);
    }


    public static int[] resultsArray(int[] nums, int k) {
        if(k==1){
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Arrays.fill(res, -1);

        int cnt = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i+1]-nums[i]==1){
                cnt++;
            } else {
                cnt=1;
            }
            if(cnt==k){
                res[i-k+2] = nums[i+1];
                cnt--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //resultsArray(new int[]{1,3,4},2);
        resultsArray(new int[]{2,3,4},3);

        int d = (int) Math.sqrt(2147483600);
        System.out.printf("");
        //[[1,4,5],[1,3,4],[2,6]]
//        ListNode list1 = new ListNode(1,
//                new ListNode(2,
//                        new ListNode(3,
//                                new ListNode(4,
//                                        new ListNode(5)))));
//
//        reverseKGroup(list1, 2);
//        String s = null;
        maxEnergyBoost(
                new int[]{1,3,1},
                new int[]{3,1,1}
        );

    }
}
