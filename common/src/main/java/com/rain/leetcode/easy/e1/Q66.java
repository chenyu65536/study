package com.rain.leetcode.easy.e1;

/**
 * @author chenyu
 * @version 1.0.0
 * @date 2020/11/16 5:37 下午
 */
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//
//
// 示例 1：
//
//
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//
//
// 示例 2：
//
//
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//
//
// 示例 3：
//
//
//输入：digits = [0]
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics 数组
// 👍 577 👎 0


//进位后,后面数字全是0
//a={digits[0],digits[1],xxx,digist[i]+1,0,0,0}
public class Q66 {

    public static int[] plusOne2(int[] digits) {
        //a={digits[0],digits[1],xxx,digist[i]+1,0,0,0}
        int plusOneIndex = -1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 == 10) {
                //进位
            } else {
                plusOneIndex = i;
                break;
            }
        }

        int[] result = new int[plusOneIndex == -1 ? digits.length + 1 : digits.length];

        int startIndex = 0;
        if (plusOneIndex == -1) {
            result[0] = 1;
            startIndex = 1;
        }

        for (int i = startIndex; i < result.length; i++) {
            if (plusOneIndex > i) {
                result[i] = digits[i];
            } else if (plusOneIndex == i) {
                result[i] = digits[i] + 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }


    public static int[] plusOne(int[] digits) {
        //a={digits[0],digits[1],xxx,digist[i]+1,0,0,0}
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 == 10) {
                //当首位数进位则长度+1,位数均为0
                if (i == 0) {
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    return result;
                }
                //进位，当前位为0
                digits[i] = 0;
            } else {
                //当前位加1，并返回结果
                digits[i]++;
                return digits;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 9};
        plusOne2(a);
    }

}
