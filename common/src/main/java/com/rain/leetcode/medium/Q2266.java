package com.rain.leetcode.medium;

public class Q2266 {
    public static int countTexts(String pressedKeys) {
        int mod = (int) (1e9 + 7);
        // 数字按键和字母数量的关系
        int[] nums = new int[] {0,
                0, 3, 3,
                3, 3, 3,
                4, 3, 4
        };
        long res = 1;
        int length = pressedKeys.length();
        for (int i = 0; i < length;) {
            char ch = pressedKeys.charAt(i);
            int cnt = 0;
            int j = i;
            while (j < length && ch == pressedKeys.charAt(j) && cnt < nums[ch - '0']) {
                cnt++;
                j++;
            }
            i = j;
            if (cnt > 2) {
                res = res * (cnt + 1) % mod;
            } else {
                res = res * cnt % mod;
            }
        }
        return (int) res;
    }

    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int[] mods = new int[2];
        for(int i=0;i<len;i++){
            int mod = i&1;
            if((nums[i]&1)==mod) continue;

            int idx = Math.max(i+1,mods[mod]);
            while(idx<len&&(nums[idx]&1)!=mod){
                idx++;
            }

            mods[mod] = idx;
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }

        return nums;
    }
    public static void main(String[] args) {
        countTexts("222333");
        System.out.printf("");
    }
}
