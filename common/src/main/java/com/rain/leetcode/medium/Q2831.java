package com.rain.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2831 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int maxCount = 0;
        int length = nums.size();
        int start = 0;
        int differentCount = 0;
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < length; ) {
            int baseNum = nums.get(start);

            while (i < length && (differentCount < k || (differentCount == k && nums.get(i) == baseNum))) {
                int curVal = nums.get(i);
                if (curVal != baseNum) {
                    differentCount++;
                }
                numCount.put(curVal, numCount.getOrDefault(curVal, 0) + 1);
                i++;
            }
            maxCount = Math.max(maxCount, i - start - differentCount);
            //查找第一个与i不同的值
            int skipCount = 0;
            while (start < length && baseNum == nums.get(start)) {
                start++;
                skipCount++;
            }
            //total - skipCount - numCount.get(nums.get(start))
            //i-newstart - numCount.get(nums.get(start))
            //4,4,2,2,4
            if (start < length) {
                differentCount = i - start - numCount.getOrDefault(nums.get(start),0);
                //remobew
                numCount.put(baseNum, numCount.get(baseNum) - skipCount);
            }
        }


        for (Integer key : numCount.keySet()) {
            maxCount = Math.max(maxCount, numCount.get(key));
        }
        return maxCount;
    }

    public static void main(String[] args) {
      /*  List<Integer> nums = Arrays.asList(1, 3, 2, 3, 1, 3);//3
        int k = 3;*/


    /*   List<Integer> nums = Arrays.asList(3, 1, 1);
        int k = 2;//2*/

      List<Integer> nums = Arrays.asList(2,1);//3
        int k = 0;

/*
        List<Integer> nums = Arrays.asList(4,4,2,2,4);//3
        int k = 1;*/
        Q2831 q2831 = new Q2831();
        int rs = q2831.longestEqualSubarray(nums, k);
        System.out.printf("" + rs);
    }

}
