package com.rain.leetcode.easy;
//给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
//
// 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
//
// 请按身高 降序 顺序返回对应的名字数组 names 。
//
//
//
// 示例 1：
//
// 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
//输出：["Mary","Emma","John"]
//解释：Mary 最高，接着是 Emma 和 John 。
//
//
// 示例 2：
//
// 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
//输出：["Bob","Alice","Bob"]
//解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
//
//
//
//
// 提示：
//
//
// n == names.length == heights.length
// 1 <= n <= 10³
// 1 <= names[i].length <= 20
// 1 <= heights[i] <= 10⁵
// names[i] 由大小写英文字母组成
// heights 中的所有值互不相同
//
//
// Related Topics 数组 哈希表 字符串 排序 👍 87 👎 0


import java.util.TreeMap;

public class Q2418 {

    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer, String> treeMap = new TreeMap<>((o1, o2) -> (o2 - o1));
        for (int i = 0; i < names.length; i++) {
            treeMap.put(heights[i], names[i]);
        }
        return treeMap.values().toArray(new String[names.length]);
    }

    public static void main(String[] args) {
        Q2418 q2418 = new Q2418();
        String[] names = new String[]{"Mary", "John", "Emma"};
        int[] heights = new int[]{180, 165, 170};

        String[] rs =  q2418.sortPeople(names, heights);
    }
}
