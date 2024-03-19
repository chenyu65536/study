package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class I0808 {

    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public String[] permutation(String S) {
        boolean[] used = new boolean[S.length()];
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        backTrack(chars, used);
        return list.toArray(new String[list.size()]);
    }

    public void backTrack(char[] chars, boolean[] used) {
        if (sb.length() == chars.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || (i > 0 && used[i - 1] && chars[i] == chars[i - 1])) {
                continue;
            }
            sb.append(chars[i]);
            used[i] = true;

            backTrack(chars, used);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        I0808 i0808 = new I0808();
        String[] rs = i0808.permutation("IIIo");
        System.out.printf("1");
    }

}
