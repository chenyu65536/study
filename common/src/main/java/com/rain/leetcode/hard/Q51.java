package com.rain.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q51 {

    boolean[][] table;
    List<List<String>> rs;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.table = new boolean[n][n];
        this.rs = new ArrayList<>();
        this.n = n;
        backTrace(0);
        return rs;
    }

    List<String> temp = new ArrayList<>();

    public void backTrace(int rows) {
        if (temp.size() == n) {
            rs.add(new ArrayList<>(temp));
            return;
        }

        char[] ch = new char[n];
        Arrays.fill(ch, '.');
        for (int i = 0; i < n; i++) {
            if (!check(rows, i)) continue;
            table[rows][i] = true;
            ch[i] = 'Q';
            temp.add(new String(ch));

            backTrace(rows + 1);

            table[rows][i] = false;
            ch[i] = '.';
            temp.remove(temp.size() - 1);
        }
    }

    public boolean check(int rows, int column) {
        for (int i = 0; i < table.length; i++) {
            //十字型
            if (table[rows][i] || table[i][column]) {
                return false;
            }

            //X字型
            if (rows + i < n) {
                if (column + i < n && table[rows + i][column + i]) {
                    return false;
                }

                if (column >= i && table[rows + i][column - i]) {
                    return false;
                }
            }

            if (rows - i >= 0) {
                if (column + i < n && table[rows - i][column + i]) {
                    return false;
                }

                if (column >= i && table[rows - i][column - i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q51 q51 = new Q51();
        List<List<String>> rs = q51.solveNQueens(4);
        System.out.printf("11");
    }
}
