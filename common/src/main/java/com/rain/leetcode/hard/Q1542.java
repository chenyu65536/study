package com.rain.leetcode.hard;


import java.util.Arrays;
import java.util.Map;

public class Q1542 {
    public int longestAwesome(String s) {
        int[] charCount = new int[10];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - '0']++;
        }
        int l = 0, r = s.length() - 1;
        //3 2 4 2 4 1 5
        //2 3 4 1 2 1 4 4 2
        //7 8 1 3 3 1 5 6
        int rs = 1;
        while (l < r) {
            //[l,r]
            int rs1 = 0;
            //[l+1,r]
            int[] temp = Arrays.copyOf(charCount, 10);
            int tempL = l;
            while (tempL < r) {
                rs1 = find(temp);
                if (rs1 > 0) {
                    break;
                }
                temp[s.charAt(tempL) - '0']--;
                tempL++;
            }

            int rs2 = 0;
            int tempR = r;
            temp = Arrays.copyOf(charCount, 10);
            while (l < tempR) {
                rs2 = find(temp);
                if (rs2 > 0) {
                    break;
                }
                temp[s.charAt(tempR) - '0']--;
                tempR--;
            }
            rs = Math.max(rs, Math.max(rs1, rs2));
            charCount[s.charAt(l) - '0']--;
            charCount[s.charAt(r) - '0']--;
            l++;
            r--;
        }
        //双指针
        return rs;
    }


    public int longestAwesome2(String s) {
        int[] charCount = new int[10];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - '0']++;
        }
        int l = 0, r = s.length() - 1;
        //3 2 4 2 4 1 5
        //2 3 4 1 2 1 4 4 2
        //7 8 1 3 3 1 5 6
        int rs = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        //双指针
        return rs;
    }

    public int find(int[] charCount) {
        int sum = 0;
        for (int m = 0; m < 10; m++) {
            if (sum % 2 == 1 && charCount[m] % 2 == 1) {
                return -1;
            }
            sum += charCount[m];
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "234121442";
        s = "78133156";
        //s = "78133156";
        //s="11";
        Q1542 q1542 = new Q1542();
        int rs = q1542.longestAwesome(s);
        System.out.printf("" + rs);
    }
}
