package com.rain.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

        LinkedList<String> row = new LinkedList<>();
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (row.isEmpty()) {
                row.add(word);
                len += word.length();
            } else if (len + word.length() + row.size() - 1 <= maxWidth) {
                row.add(word);
                len += word.length();
            }

            if (i == words.length - 1) {//开始填充空格
                res.add(String.join(" ", row) + getBlank(maxWidth - row.size() + 1 - len));
                row.clear();
                len = 0;
            } else if (len + words[i + 1].length() + row.size() > maxWidth) {
                res.add(fillBlank(row, len, maxWidth));

                row.clear();
                len = 0;
            }
        }
        return res;
    }

    public String getBlank(int cnt) {
        StringBuilder sb = new StringBuilder(cnt);
        while (cnt > 0) {
            sb.append(' ');
            cnt--;
        }
        return sb.toString();
    }

    public String fillBlank(List<String> row, int len, int maxWidth) {
        if (row.size() == 1) {
            return row.get(0) + getBlank(maxWidth - len);
        }

        int baseCount = (maxWidth - len) / (row.size() - 1);
        int addIdx = (maxWidth - len) % (row.size() - 1);

        StringBuilder res = new StringBuilder();
        String blank = getBlank(baseCount);
        for (int i = 0; i < row.size() - 1; i++) {
            res.append(row.get(i)).append(blank);
            if (i < addIdx) {
                res.append(' ');
            }
        }
        res.append(row.getLast());
        return res.toString();
    }
}
