package com.rain.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q857 {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int length = quality.length;
        Integer[] idx = new Integer[length];
        for (int i = 0; i < length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> wage[i] * quality[j] - wage[j] * quality[i]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> j - i);
        int sumQ = 0;
        for (int i = 0; i < k; i++) {
            pq.offer(quality[idx[i]]);
            sumQ += quality[idx[i]];
        }

        double cost = sumQ * 1.0 * wage[idx[k - 1]] * quality[idx[k - 1]];
        for (int i = k; i < length; i++) {
            int q = quality[idx[i]];
            if (q < pq.peek()) {
                sumQ += q - pq.poll();
                cost = Math.min(cost, sumQ * 1.0 * wage[idx[i]] * quality[idx[i]]);
                pq.offer(q);
            }
        }
    }
}
