package com.rain.leetcode.hard;

public class Q85 {

    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length, width = matrix[0].length;
        int[][][] dp = new int[height][width][2];//长，高
        dp[0][0] = new int[]{matrix[0][0] - '0', matrix[0][0] - '0'};
        int res = dp[0][0][0];
        for (int i = 1; i < width; i++) {
            if (matrix[0][i] == '0') {
                dp[0][i] = new int[]{0, 0};
            } else {
                dp[0][i] = new int[]{dp[0][i - 1][0] + 1, 1};
                res = Math.max(res, dp[0][i][0]);
            }
        }
        for (int i = 1; i < height; i++) {
            if (matrix[i][0] == '0') {
                dp[i][0] = new int[]{0, 0};
            } else {
                dp[i][0] = new int[]{1, dp[i - 1][0][1] + 1};
                res = Math.max(res, dp[i][0][1]);
            }
        }


        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                int[] left = dp[i][j - 1];
                int[] top = dp[i - 1][j];
                int[] leftTop = dp[i - 1][j - 1];

                if (matrix[i][j] == '0') {
                    dp[i][j] = new int[]{0, 0};
                } else if (left[0] == 0) {

                    dp[i][j] = new int[]{1, top[1] + 1};

                } else if (top[0] == 0) {
                    dp[i][j] = new int[]{left[0] + 1, 1};
                } else if (leftTop[0] == 0) {
                    int w = left[0];
                    int h = top[1];

                    dp[i][j] = new int[]{w > h ? w + 1 : 1, w > h ? 1 : h + 1};

                } else {
                    dp[i][j] = new int[]{
                            Math.min(left[0], left[0]-1) + 1,
                            Math.min(left[1]-1, top[1])+ 1
                    };
                }

                res = Math.max(res, dp[i][j][0] * dp[i][j][1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q85 q85 = new Q85();
   /*    q85.maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        });//6
        q85.maximalRectangle(new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
        });//6*/
       /* q85.maximalRectangle(new char[][]{
                {'1'}
        });//1*/

 /*    q85.maximalRectangle(new char[][]{
                {'1','0'},
                {'1','0'},
        });*/

    /*  q85.maximalRectangle(new char[][]{
                {'1','1'},
                {'1','1'},
        });*/

     /*   q85.maximalRectangle(new char[][]{
                {'0', '0', '1'},
                {'1', '1', '1'},
        });*/

        q85.maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','1','0','1','1'},
                {'1','1','1','1','1'},
        });




    }



}
