package com.rain.leetcode.hard;


public class Q1255 {

    String[] words;
    int[] letterCount;
    int[] score;

    // 按字母得分进行降序，优先使用得分高的
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.score = score;
        letterCount = new int[26];
        for (int i = 0; i < letters.length; i++) {
            int index = letters[i] - 'a';
            letterCount[index]++;
        }
        return backTrack(0, 0);
    }

    public int backTrack(int startIndex, int totalScore) {
        int max = totalScore;
        for (int i = startIndex; i < words.length; i++) {
            int currentSore = check(words[i]);
            if (currentSore == 0) continue;
            int score = backTrack(i + 1, totalScore + currentSore);
            max = Math.max(score, max);
            rollback(words[i], words[i].length());
        }
        return max;
    }

    public int check(String words) {
        int scoreNum = 0;
        for (int i = 0; i < words.length(); i++) {
            int index = words.charAt(i) - 'a';
            if (letterCount[index] > 0) {
                letterCount[index]--;
                scoreNum += score[index];
            } else {
                rollback(words, i);
                return 0;
            }
        }
        return scoreNum;
    }

    public void rollback(String words, int endIndex) {
        for (int i = 0; i < endIndex; i++) {
            letterCount[words.charAt(i) - 'a']++;
        }
    }

    public static void main(String[] args) {
        Q1255 q1255 = new Q1255();
        String[] words = new String[]{"dog", "cat", "dad", "good"};
        char[] letters = new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score = new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int rs = q1255.maxScoreWords(words, letters, score);//=>23*/
    /*    String[] words = new String[]{"azb", "ax", "awb", "ayb", "bpppp"};
        char[] letters = new char[]{'z', 'a', 'w', 'x', 'y', 'b', 'p', 'p', 'p'};
        int[] score = new int[]{10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3, 2, 3, 3};

        int rs = q1255.maxScoreWords(words, letters, score);//=>14*/
        System.out.printf("" + rs);
    }
}