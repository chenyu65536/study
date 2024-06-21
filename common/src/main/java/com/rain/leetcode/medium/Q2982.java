package com.rain.leetcode.medium;

import java.util.PriorityQueue;

public class Q2982 {
    public int maximumLength(String s) {
        PriorityQueue<Integer>[] list = new PriorityQueue[26];
        for (int i = 0; i < list.length; i++) {
            list[i] = new PriorityQueue<>((a, b) -> b - a);
        }

        int len = s.length();
        for (int i = 0; i < len; i++) {
            int temLen = 1;
            while (i + 1 < len && s.charAt(i + 1) == s.charAt(i)) {
                i++;
                temLen++;
            }
            list[s.charAt(i) - 'a'].offer(temLen);
        }

        int max = -1;
        for (int i = 0; i < list.length; i++) {
            PriorityQueue<Integer> queue = list[i];
            if (queue.isEmpty() || (queue.size() == 1 && queue.peek() < 3)) {
                continue;
            }

            if (queue.size() == 1) {
                max = Math.max(max, queue.poll() - 2);
            } else if (queue.size() == 2) {
                int c1 = queue.poll();
                int c2 = queue.poll();
                if (c1 + c1 < 3) {
                    continue;
                }

                if (c1 - c2 >= 2) {//可以匀出3个大于等于c2
                    max = Math.max(max, c1 - 2);
               /* } else if (c1 - c2 == 1) {//c1可以匀出2个等于c2
                    max = Math.max(max, c1 - 1);*/
                } else {//相等
                    max = Math.max(max, c1 - 1);
                }
                continue;
            } else {
                int c1 = queue.poll();
                int c2 = queue.poll();
                int c3 = queue.poll();

                if (c1 - c2 >= 2) {//可以匀出3个大于等于c2
                    max = Math.max(max, c1 - 2);
                } else if (c1 - c2 == 1) {//c1可以匀出2个等于c2
                    max = Math.max(max, c1 - 1);
                } else {//c1=c2
                    max = Math.max(max, Math.max(c1 - 1, c3));
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "ereerrrererrrererre";
        // str="ababa";
        Q2982 q2982 = new Q2982();
        int rs = q2982.maximumLength(str);
        System.out.printf("" + rs);
    }
}
