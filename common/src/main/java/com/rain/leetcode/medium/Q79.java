package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例 1：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCCED"
//输出：true
//
//
// 示例 2：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"SEE"
//输出：true
//
//
// 示例 3：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCB"
//输出：false
//
//
//
//
// 提示：
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成
//
//
//
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
//
// Related Topics 数组 回溯 矩阵 👍 1665 👎 0
public class Q79 {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                if (board[m][n] == word.charAt(0)) {
                    boolean rs = visit(board, visited, word, m, n, 0);
                    if (rs) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    List<int[]> currentPath = new ArrayList<>();

    private boolean visit(char[][] board, boolean[][] visited, String word, int i, int j, int startIndex) {
        if (startIndex >= word.length()) {
            //找到了哇
            return true;
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
            //未找到，回溯
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] == word.charAt(startIndex)) {
            visited[i][j] = true;
            currentPath.add(new int[]{i, j});
            //访问下个节点
            int nextIndex = startIndex + 1;

            boolean rs1 = visit(board, visited, word, i, j - 1, nextIndex);
            if (rs1) {
                return true;
            }
            boolean rs2 = visit(board, visited, word, i, j + 1, nextIndex);
            if (rs2) {
                return true;
            }
            boolean rs3 = visit(board, visited, word, i - 1, j, nextIndex);
            if (rs3) {
                return true;
            }
            boolean rs4 = visit(board, visited, word, i + 1, j, nextIndex);
            if (rs4) {
                return true;
            }
            visited[i][j] = false;
            currentPath.remove(currentPath.size() - 1);
            return false;
        } else {
            //回溯
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] boards = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "CCEE";
        Q79 q79 = new Q79();
        boolean rs = q79.exist(boards, word);
        System.out.printf("11");
    }
}
