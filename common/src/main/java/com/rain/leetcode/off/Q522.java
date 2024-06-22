package com.rain.leetcode.off;

public class Q522 {
    public int findLUSlength(String[] strs) {
        int length = strs.length;
        int rs = -1;
        for (int i = 0; i < length; i++) {
            boolean notSubStr = true;
            for (int j = 0; j < length; j++) {
                // 不是子串
                if (i != j && subStr(strs[i], strs[j])) {
                    notSubStr = false;
                    break;
                }
            }
            if (notSubStr) {
                rs = Math.max(rs, strs[i].length());
            }
        }
        return rs;
    }

    public static boolean subStr(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if(str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
                continue;
            }

            while (j < str2.length() && str1.charAt(i) != str2.charAt(j)) {
                j++;
            }

        }
        return i == str1.length();
    }

    public static void main(String[] args) {
        //String[] strs = new String[]{"aabbcc", "aabbcc","bc"};
       // String[] strs = new String[]{"aabbcc", "aabbcc","cb"};
       /* String[] strs = new String[]{"aabbcc", "aabbccc"};
        Q522 q522 = new Q522();
        int rs = q522.findLUSlength(strs);
        System.out.printf(""+rs);
        subStr("cb","aabbcc");*/

        subStr("aabbccc","aabbcc");
    }

}
