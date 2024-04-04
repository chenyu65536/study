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
        if (startIndex == s.length()) {
            String ip = String.join(".", temp);
            if (ip.length() == s.length() + 3) {
                rs.add(ip);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (temp.size() > 3 || (s.length() - i) > (4 - temp.size()) * 3) {
                return;
            }
            for (int j = i; j < i + 3 && j < s.length(); j++) {
                String subAddress = s.substring(i, j + 1);
                if (isOk(subAddress)) {
                    temp.add(subAddress);
                    backTrack(s, j + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    private boolean isOk(String str) {
        if (str.isEmpty() || (str.charAt(0) == '0' && str.length() > 1)) {
            return false;
        }
        int subAddress = Integer.parseInt(str);
        return subAddress <= 255;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        //输出：["255.255.11.135","255.255.111.35"]

        Q93 q93 = new Q93();
        List<String> rs = q93.restoreIpAddresses(s);
        System.out.printf("" + rs);
    }
}
