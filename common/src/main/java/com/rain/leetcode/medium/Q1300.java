package com.rain.leetcode.medium;

import java.util.*;

public class Q1300 {

    public static int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        long total = 0;
        for (int n : arr) {
            total += n;
        }

        int sum = 0;
        int len = arr.length;
        long min = Integer.MAX_VALUE;
        long res = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += arr[i];
            while (i > 0 && arr[i] == arr[i - 1]) {
                sum += arr[i - 1];
                i--;
            }

            //total-sum +x*(len-i)=target
            long x = (target - total + sum) / (len - i);
            if (Math.abs(total - sum + x * (len - i) - target) < min) {
                min = Math.min(min, Math.abs(total - sum + x * (len - i) - target));
                res = x;
            }
        }
        return (int) res;
    }

    public static int eatenApples(int[] apples, int[] days) {
        if (apples[0] == 0 || days[0] == 0) {
            return 0;
        }

        int idx = 0, length = apples.length, n = length,res =0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        while (n >=0) {
            if (idx < length && apples[idx] > 0 && days[idx] > 0) {
                pq.offer(new int[]{idx + days[idx] - 1, apples[idx]});
            }

            if (pq.isEmpty()) {
                n--;
                idx++;
                continue;
            }
            int[] nextApples = pq.poll();
            //没果子吃
            if (nextApples[0] < idx) {
                n--;
            } else {
                //有果子吃
                res++;
                nextApples[1]--;
                if (nextApples[1] > 0) {
                    pq.offer(nextApples);
                }
                n = length;
            }
            //果子熟了
            idx++;

        }
        return res;
    }

    public Integer[] fillAndSort(int[] cut){
        Integer[] sortCut = new Integer[cut.length];
        for(int i=0;i<cut.length;i++){
            sortCut[i] = i;
        }
        Arrays.sort(sortCut,(a,b)->(cut[b]-cut[a]));
        return sortCut;
    }

    public static void main(String[] args) {
        int[] apples = {3, 0, 0, 0, 0, 2};
        int[] days = {3, 0, 0, 0, 0, 2};
        eatenApples(apples, days);
    }

}
