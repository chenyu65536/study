package com.rain.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1535 {

    public int getWinner2(int[] arr, int k) {
        int len = arr.length;
        if (k >= len - 1) {
            int max = 0;
            for (int num : arr) {
                max = Math.max(num, max);
            }
            return max;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : arr) {
            list.add(num);
        }
        int winTimes = 0;
        for (int i = 1; i < len; i++) {
            if (winTimes == k) {
                return list.get(0);
            }
            if (list.get(0) > list.get(1)) {
                winTimes++;
                list.add(list.remove(1));
            } else {
                winTimes = 1;
                list.add(list.remove(0));
                i = 0;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
      /*  Q1535 q = new Q1535();
        int[] arr = new int[]{2,1,3,5,4,6,7};
        int k = 2;
        System.out.println(q.getWinner(arr, k));

        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.pollLast();*/
        String a;
        /*a.split("-")
        Integer.parseInt()*/
        String str;
    }

}
