package com.rain.leetcode.easy.e1;


//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
//
//
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。
//
// 示例:
//
// 输入: 3
//输出: [1,3,3,1]
//
//
// 进阶：
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？
// Related Topics 数组
// 👍 210 👎 0

import java.util.*;

public class Q119 {

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> lastRow = new ArrayList<>();
        lastRow.add(1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j >= 1; j--) {
                lastRow.set(j, lastRow.get(j - 1) + lastRow.get(j));
            }
            lastRow.add(1);
        }
        return lastRow;
    }

    public static void main(String[] args) {
        getRow(3);
    }
}
