package com.rain.leetcode.medium;

import java.util.*;

public class Q935 {
    public static int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }
        //1,2,3
        //4,5,6
        //7,8,9
        //*,0,*
        //[04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72,76, 81, 83, 92, 94]
        List<Integer>[] numMap = new List[10];
        numMap[0] = Arrays.asList(4, 6);
        numMap[1] = Arrays.asList(6, 8);
        numMap[2] = Arrays.asList(7, 9);
        numMap[3] = Arrays.asList(4, 8);
        numMap[4] = Arrays.asList(0, 3, 9);

        numMap[5] = Collections.EMPTY_LIST;

        numMap[6] = Arrays.asList(0, 1, 7);
        numMap[7] = Arrays.asList(2, 6);
        numMap[8] = Arrays.asList(1, 3);
        numMap[9] = Arrays.asList(2, 4);
        int[] nums = new int[]{2, 2, 2, 2, 3, 0, 3, 2, 2, 2};//尾号个数
        //最后一次允许 拨号到5
        for (int i = 3; i <= n; i++) {
            //0,3,9->4    0,1,7->6
            int[] newNums = new int[10];//尾号个数
            for (int j = 0; j < 10; j++) {
                if (nums[j] == 0) {
                    continue;
                }
                for (int num : numMap[j]) {
                    newNums[num] = (newNums[num] + nums[j]) % 1000000007;
                }
            }
            nums = newNums;
        }
        int rs = 0;
        for (int num : nums) {
            rs += num;
        }
        return rs;
    }

    public static void main(String[] args) {
        int rs = knightDialer(3131);
        System.out.printf("" + rs);
    }

}

