package com.rain.leetcode.medium;
//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：board = [
// ["X","X","X","X"],
// ["X","O","O","X"],
// ["X","X","O","X"],
// ["X","O","X","X"]
// ]
//输出：[
// ["X","X","X","X"],
// ["X","X","X","X"],
// ["X","X","X","X"],
// ["X","O","X","X"]
// ]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//
//
// 示例 2：
//
//
//输入：board = [["X"]]
//输出：[["X"]]
//
//
//
//
// 提示：
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] 为 'X' 或 'O'
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1006 👎 0

import java.util.ArrayList;
import java.util.List;

public class Q130 {


    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == '0' && visit(visited, board, i, j)) {
                    //标记
                    for (int t = 0; t < temp.size(); t++) {
                        board[temp.get(t)[0]][temp.get(t)[1]] = 'X';
                    }
                }
                temp.clear();
            }
        }
    }

    //取反，查找0的
    List<int[]> temp = new ArrayList<>();

    private boolean visit(boolean[][] visited, char[][] board, int i, int j) {
        //碰到边界，zeroList 全部为0
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) {
            return false;
        }
        if (visited[i][j] || board[i][j] == 'X') {
            return true;
        }
        if (board[i][j] == 'O') {
            visited[i][j] = true;
            temp.add(new int[]{i, j});
        }
        boolean rs1 = visit(visited, board, i, j - 1);
        boolean rs2 = visit(visited, board, i, j + 1);
        boolean rs3 = visit(visited, board, i - 1, j);
        boolean rs4 = visit(visited, board, i + 1, j);
        return rs1 && rs2 && rs3 && rs4;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] board2 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        Q130 q130 = new Q130();
        q130.solve(board2);
        System.out.printf("");

    }
}
