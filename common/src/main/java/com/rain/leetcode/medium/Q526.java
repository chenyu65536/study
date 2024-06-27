package com.rain.leetcode.medium;

public class Q526 {
    int n;
    int mask;
    public int countArrangement(int n) {
        for(int i=0;i< n;i++){
            mask = (mask<<1)^1;
        }

        this.n = n;
        return dfs(1);
    }

    public int dfs(int pos) {
        if (pos == n + 1) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {// nums
            if (((mask>>i-1&1)>0) && (pos % i == 0 || i % pos == 0)) {
                mask = mask^(1<<(i-1));
                res += dfs(pos + 1);
                mask = mask^(1<<(i-1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q526 q526 = new Q526();
        q526.countArrangement(2);
    }

}
