package com.rain.leetcode.medium;
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1：
//
//
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
//
//
// 示例 2：
//
//
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2272 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q200 {

    public int numIslands(char[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visit[i][j] && grid[i][j] == '1' && visit(visit, grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean visit(boolean[][] visit, char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
            return false;
        }
        if (grid[i][j] == '0' || visit[i][j]) {
            return false;
        }
        visit[i][j] = true;
        visit(visit, grid, i, j - 1);
        visit(visit, grid, i, j + 1);
        visit(visit, grid, i - 1, j);
        visit(visit, grid, i + 1, j);
        return true;
    }

    public static void main(String[] args) {
        //输入：grid = [
        //  ["1","1","1","1","0"],
        //  ["1","1","0","1","0"],
        //  ["1","1","0","0","0"],
        //  ["0","0","0","0","0"]
        //]
        //输出：1
        char[][] grids = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        grids = new char[][]{
                {'1'},
        };
        Q200 q200 = new Q200();
        int rs = q200.numIslands(grids);
        System.out.printf("11");
    }

}
