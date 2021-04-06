package com.rain.leetcode.easy.e1;


import org.apache.commons.lang3.StringUtils;


/**
 * @author chenyu
 * @version 1.0.0
 * @date 2020/10/22 11:30 上午
 */
public class Q26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }
        int insertPosition = 1;
        for (int i = 1; i < nums.length; i++) {
            //定位首次重复的数字
            //以后与该位置前一个数字不同则插入这个位置
            //然后插入的位置顺延一个
            if (nums[i] != nums[insertPosition-1]) {
                nums[insertPosition] = nums[i];
                insertPosition++;
            }
        }
        return insertPosition;
    }

    public static void main(String[] args) {
        //运行成功: 测试用例:[1,1,2] 测试结果:[] 期望结果:[1,2]
        int[] param = new int[]{1, 1,2};
        int result = removeDuplicates(param);

        System.out.println("result:" + result);


        System.out.println("param:" + StringUtils.join(param));
    }


}
