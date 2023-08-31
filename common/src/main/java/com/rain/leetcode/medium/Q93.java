package com.rain.leetcode.medium;
//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
//
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
//和 "192.168@1.1" 是 无效 IP 地址。
//
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
//
//
// 示例 2：
//
//
//输入：s = "0000"
//输出：["0.0.0.0"]
//
//
// 示例 3：
//
//
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 20
// s 仅由数字组成
//
//
// Related Topics 字符串 回溯 👍 1294 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q93 {

    List<String> rs = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backTrack(s, 0);
        return rs;
    }

    List<String> temp = new ArrayList<>();

    private void backTrack(String s, int startIndex) {
        if (startIndex == s.length() - 1) {
            rs.add(String.join(".", temp));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isOk(s, startIndex, 1)) {
                temp.add(s.substring(startIndex, startIndex + 1));
                backTrack(s, startIndex + 1);
                temp.remove(temp.size() - 1);
            }

            if (isOk(s, startIndex, 2)) {
                temp.add(s.substring(startIndex, startIndex + 2));
                backTrack(s, startIndex + 2);
                temp.remove(temp.size() - 1);
            }

            if (isOk(s, startIndex, 3)) {
                temp.add(s.substring(startIndex, startIndex + 3));
                backTrack(s, startIndex + 3);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isOk(String str, int startIndex, int length) {
        if (str.length() < startIndex + length + 1) {
            return false;
        }
        str = str.substring(startIndex, startIndex + length + 1);
        if (str.startsWith("0") && str.length() > 1) {
            return false;
        }

        int num = Integer.parseInt(str);
        if (num < 0 || num > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "25525511135";
//输出：["255.255.11.135","255.255.111.35"]

        Q93 q93 = new Q93();
        List<String> rs = q93.restoreIpAddresses(s);
        System.out.printf("11");
    }
}
