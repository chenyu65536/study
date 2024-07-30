package com.rain.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class Q2766 {
    public static List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < moveFrom.length; i++) {
            set.remove(moveFrom[i]);
            set.add(moveTo[i]);
        }
        return set.stream().sorted(Integer::compareTo).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Q2766.relocateMarbles(new int[]{1, 6, 7, 8}, new int[]{1, 7, 2}, new int[]{2, 9, 5});
    }
}
