package com.rain.leetcode.easy.e1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//]
// Related Topics 数组
// 👍 431 👎 0
public class Q118 {

    public static List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return Collections.emptyList();
        }

        if (numRows == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Collections.singletonList(1));
            return result;
        }

        List<List<Integer>> result = generate(numRows - 1);
        List<Integer> currentRow = new ArrayList<>(numRows);
        currentRow.add(0, 1);
        currentRow.add(numRows - 1, 1);

        List<Integer> lastRows = result.get(numRows - 2);
        for (int i = 1; i < numRows - 1; i++) {
            currentRow.add(lastRows.get(i - 1) + lastRows.get(i));
        }
        result.add(currentRow);
        return result;
    }


    public static List<List<Integer>> generate2(int numRows) {
        if (numRows == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                }else {
                    row.add(rows.get(i-1).get(j-1)+rows.get(i-1).get(j));
                }
            }
            rows.add(row);
        }
        return rows;
    }

    public static void main(String[] args) {
        generate2(5);
    }
}
