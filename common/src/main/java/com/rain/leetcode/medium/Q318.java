package com.rain.leetcode.medium;

public class Q318 {

    public static int maxProduct(String[] words) {
        boolean[][] wordChars = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                wordChars[i][words[i].charAt(j) - 'a'] = true;
            }
        }

        int rs = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                boolean isOk = true;
                for (int m = 0; m < 26; m++) {
                    if (wordChars[i][m] && wordChars[j][m]) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    rs = Math.max(rs, words[i].length() * words[j].length());
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Q318 q318 = new Q318();
        int rs = q318.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"});
        System.out.printf(""+rs);
    }
}
