package com.rain.leetcode.hard;

public class Q37 {

    char[][] board;
    boolean[][] rowUsed = new boolean[9][9];
    boolean[][] columnUsed = new boolean[9][9];
    boolean[][][] used33 = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                use(i, j, board[i][j], true);
            }
        }
        backTrace(0);
    }

    public boolean backTrace(int pos) {
        if (pos == 81) {
            return true;
        }
        int i = pos / 9, j = pos % 9;
        if (board[i][j] != '.') {
            return backTrace(pos + 1);
        }
        for (char val = '1'; val <= '9'; val++) {
            if (!check(i, j, val)) continue;
            board[i][j] = val;
            use(i, j, val, true);
            if (backTrace(pos + 1)) {
                return true;
            }
            use(i, j, val, false);
            board[i][j] = '.';
        }
        return false;
    }

    public void use(int i, int j, char val, boolean isUse) {
        int idx = val -'1';
        rowUsed[i][idx] = isUse;
        columnUsed[j][idx] = isUse;
        used33[i / 3][j / 3][idx] = isUse;
    }


    public boolean check(int i, int j, char val) {
        int idx = val -'1';
        return !(rowUsed[i][idx] || columnUsed[j][idx] || used33[i / 3] [j / 3][idx]);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.' },
                {'6', '.', '.', '1', '9', '5', '.', '.', '.' },
                {'.', '9', '8', '.', '.', '.', '.', '6', '.' },
                {'8', '.', '.', '.', '6', '.', '.', '.', '3' },
                {'4', '.', '.', '8', '.', '3', '.', '.', '1' },
                {'7', '.', '.', '.', '2', '.', '.', '.', '6' },
                {'.', '6', '.', '.', '.', '.', '2', '8', '.' },
                {'.', '.', '.', '4', '1', '9', '.', '.', '5' },
                {'.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        Q37 q37 = new Q37();
        q37.solveSudoku(board);
    }
}

