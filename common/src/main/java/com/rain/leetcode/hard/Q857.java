package com.rain.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q857 {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // double[] res  = new double[k];
        int length = quality.length;
        Integer[] idx = new Integer[length];
        for (int i = 0; i < length; i++) {
            idx[i] = i;
        }
        //单价由低到高
        // Arrays.sort(idx, (i, j) -> wage[i] / quality[i] - wage[j] / quality[j]);
        Arrays.sort(idx, (i, j) -> wage[i] * quality[j] - wage[j] * quality[i]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> j - i);

        double sumQuality = 0;
        for (int i = 0; i < k; i++) {
            pq.offer(quality[idx[i]]);
            sumQuality += quality[idx[i]];
        }

        double rs = sumQuality * 1.0 * wage[idx[k - 1]] / quality[idx[k - 1]];
  /*      for (int i = k; i < length; i++) {
            if (pq.peek() > quality[idx[i]]) {
                sumQuality -= pq.poll() - quality[idx[i]];
                pq.offer(quality[idx[i]]);
                rs = Math.min(rs, sumQuality * 1.0 * wage[idx[i]] / quality[idx[i]]);
            }
        }*/

        for (int i = k; i < length; i++) {
            if (pq.peek() > quality[idx[i]]) {
                sumQuality -= pq.poll() - quality[idx[i]];
                pq.offer(quality[idx[i]]);
                rs = Math.min(rs, sumQuality * 1.0 * wage[idx[i]] / quality[idx[i]]);
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Q857 q857 = new Q857();
        int[] quality = {10,20,5};
        int[]  wage = {70,50,30};
        int k = 2;
        double rs = q857.mincostToHireWorkers(quality,wage,k);
        System.out.printf("111");
    }
}
