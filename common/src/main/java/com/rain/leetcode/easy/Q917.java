package com.rain.leetcode.easy;
//给你一个字符串 s ，根据下述规则反转字符串：
//
//
// 所有非英文字母保留在原有位置。
// 所有英文字母（小写或大写）位置反转。
//
//
// 返回反转后的 s 。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：s = "ab-cd"
//输出："dc-ba"
//
//
//
//
//
// 示例 2：
//
//
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
//
//
//
//
//
// 示例 3：
//
//
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
//
//
//
//
// 提示
//
//
// 1 <= s.length <= 100
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成
// s 不含 '\"' 或 '\\'
//
// Related Topics 双指针 字符串 👍 146 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q917 {

    public String reverseOnlyLetters(String s) {
        int i = 0, j = s.length() - 1;
        char[] ch = s.toCharArray();
        while (i < j) {
            while (i < j && (s.charAt(i) < 65 || (s.charAt(i) > 90 && s.charAt(i) < 97))) {
                ch[i] = s.charAt(i);
                i++;
            }
            while (i < j && (s.charAt(j) < 65 || (s.charAt(j) > 90 && s.charAt(j) < 97))) {
                ch[j] = s.charAt(j);
                j--;
            }
            ch[i] = s.charAt(j);
            ch[j] = s.charAt(i);
            i++;
            j--;
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
//
//
//
//
//
// 示例 3：
//
//
//输入：s = "Test1ng-Leet=code-Q!"
//输出：    "Qedo1ct-eeLg=ntse-T!"


    //    解答失败: 测试用例:"Test1ng-Leet=code-Q!"
      //  测试结果:"Qedo1c=-teeLgntse-T!"
       // 期望结果:"Qedo1ct-eeLg=ntse-T!"



        // 解答失败: 测试用例:"g-Leet="
        //  测试结果:        "=-teeLg"
        // 期望结果:         "t-eeLg="

        String str = "g-Leet=";
        Q917 q917 = new Q917();
        String rs  = q917.reverseOnlyLetters(str);
        System.out.printf(""+rs);
    }
}
