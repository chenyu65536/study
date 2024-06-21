package com.rain.leetcode.medium;

import java.util.PriorityQueue;

public class Q2981 {
    public int maximumLength(String s) {
        PriorityQueue<Integer>[] counts = new PriorityQueue[26];
        for (int i = 0; i < 26; i++) {
            counts[i] = new PriorityQueue<>((a, b) -> b - a);
        }
        for (int i = 0; i < s.length(); i++) {
            int len = 1;//最大特殊串长度
            while (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) {
                i++;
                len++;
            }
            counts[s.charAt(i) - 'a'].add(len);
        }

        int maxLength = -1;
        for (int i = 0; i < 26; i++) {
            PriorityQueue<Integer> queue = counts[i];
            if (queue.isEmpty() || (queue.size() == 1 && queue.peek() < 3)) {
                continue;
            }
            if (queue.size() == 1) {
                maxLength = Math.max(maxLength, queue.peek() - 2);
                continue;
            }

            if (queue.size() == 2) {
                int c1 = queue.poll();
                int c2 = queue.poll();
                if (c1 + c2 < 3) {
                    continue;
                }
                if (c1 - c2 >= 2) {
                    maxLength = Math.max(maxLength, c1 - 2);
                } else {//c1 - c2 >= 0
                    maxLength = Math.max(maxLength, c1 - 1);
                }
            } else {

                int c1 = queue.poll();
                int c2 = queue.poll();
                int c3 = queue.poll();

                if (c1 - c2 >= 2) {
                    maxLength = Math.max(maxLength, c1 - 2);//c1-2
                } else if (c1 > c2) {//c1 - c2 >= 1
                    maxLength = Math.max(maxLength, c1 - 1);//c2
                } else {//c1=c2
                    maxLength = Math.max(maxLength, Math.max(c1 - 1, c3));
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcaba";
        // str="ababa";
        Q2981 q2981 = new Q2981();
        int rs = q2981.maximumLength(str);
        System.out.printf("" + rs);
    }
}
