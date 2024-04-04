package com.rain.leetcode.easy;

public class Q832 {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length / 2; j++) {
                int temp = image[i][j];
                image[i][j] = (image[i][image.length - j - 1] + 1) % 2;
                image[i][image.length - j - 1] = (temp + 1) % 2;
                /*image[i][j] = image[i][image.length - j - 1];
                image[i][image.length - j - 1] = temp;*/
            }
            if (image.length % 2 == 1) {
                image[i][image.length / 2]= (image[i][image.length / 2] + 1) % 2;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 0},
                {1, 0, 1}, {0, 0, 0}
        };
        Q832 q832 = new Q832();
        int[][] result = q832.flipAndInvertImage(image);
        System.out.println();

    }
}
