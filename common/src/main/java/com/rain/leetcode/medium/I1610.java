package com.rain.leetcode.medium;
//给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。
//
// 你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一
//年的统计中。例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
//
// 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
//
//
//
// 示例：
//
//
//输入：
//birth = [1900, 1901, 1950]
//death = [1948, 1951, 2000]
//输出： 1901
//
//
//
//
// 提示：
//
//
// 0 < birth.length == death.length <= 10000
// birth[i] <= death[i]
//
//
// Related Topics 数组 计数 👍 67 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class I1610 {

    public int maxAliveYear(int[] birth, int[] death) {
        int[] birthNum = new int[101];
        int[] deathNum = new int[101];
        for (int i = 0; i < birth.length; i++) {
            birthNum[birth[i] - 1900] = birthNum[birth[i] - 1900] + 1;
        }
        int maxAlive = 0;
        for (int i = 0; i < death.length; i++) {
            deathNum[death[i] - 1900] = deathNum[death[i] - 1900] + 1;
        }
        int preBirth = 0;
        int preDeath = 0;
        int year = 0;
        for (int i = 0; i < birthNum.length; i++) {
            preBirth += birthNum[i];
            if (preBirth - preDeath > maxAlive) {
                year = 1900 + i;
                maxAlive = preBirth - preDeath;
            }
            preDeath += deathNum[i];
        }
        return year;
    }

    public static void main(String[] args) {
        int[] birth = new int[]{1927,1954,1903,1928,1956,1929,1929,1928,1958,1902,1953,1912,1923,1937,1915,1942,1964,1954,1924,1936,1963,1950,1904,1931,1951,1953,1922,1970,1986,1947,1911,1965,1913,1920,1947,1962,1903,1905,1978,1974,1950,1921,1929,1901,1925,1929,1951,1944,1945};
        int[] death = new int[]{1987,1992,1967,1997,1963,1970,1944,1986,1997,1937,1971,1982,1980,1992,1995,1992,1991,1964,1985,1938,1975,1964,1975,1961,1995,1985,1946,1989,1999,1994,1956,1984,1999,1966,1950,1993,1960,1939,1990,1975,1982,1921,1964,1998,1969,1970,1965,1973,1958};
        //	测试结果:1954
        //	期望结果:1956
        I1610 i1610 = new I1610();
        int rs = i1610.maxAliveYear(birth, death);
        System.out.printf("" + rs);
    }
}
