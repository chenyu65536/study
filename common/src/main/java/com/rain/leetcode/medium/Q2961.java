package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q2961 {

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            int[] variable = variables[i];
            // double rs = Math.pow(Math.pow(variable[0], variable[1]) % 10, variable[2]) % variable[3];

            long rs = pow(pow(variable[0], variable[1], 10), variable[2], variable[3]);
            if (rs == target) {
                res.add(i);
            }
        }
        return res;
    }

    public long pow(long x, int n, int mod) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 0) {
                x = x * x % mod;
                n /= 2;
            } else {
                res = res * x % mod;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //15,50,35,41
        Q2961 q2961 = new Q2961();
        long rs = q2961.pow(978, 449, 10);
        //37,1,12,52
        //978,449,597,414   98
        System.out.printf("" + rs);
    }
}
