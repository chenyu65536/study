package com.rain.leetcode.math;

import java.util.Stack;

//给定一个整数数组 asteroids，表示在同一行的行星。
//
// 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
//
// 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞
//。
//
//
//
// 示例 1：
//
//
//输入：asteroids = [5,10,-5]
//输出：[5,10]
//解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
//
// 示例 2：
//
//
//输入：asteroids = [8,-8]
//输出：[]
//解释：8 和 -8 碰撞后，两者都发生爆炸。
//
// 示例 3：
//
//
//输入：asteroids = [10,2,-5]
//输出：[10]
//解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
//
//
//
// 提示：
//
//
// 2 <= asteroids.length <= 10⁴
// -1000 <= asteroids[i] <= 1000
// asteroids[i] != 0
//
// Related Topics 栈 数组 👍 342 👎 0
public class Q735_opt {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty()) {
                    if (asteroids[i] < 0 && stack.peek() > 0) {
                        if (asteroids[i] + stack.peek() > 0) {
                            break;
                        }
                        if (asteroids[i] + stack.peek() == 0) {
                            stack.pop();
                            break;
                        }
                        if (asteroids[i] + stack.peek() < 0) {
                            stack.pop();
                            if (stack.isEmpty()) {
                                stack.push(asteroids[i]);
                                break;
                            }
                        }
                    } else {
                        stack.push(asteroids[i]);
                        break;
                    }
                }
            }
        }
        int[] ans = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            ans[i] = stack.pop();
            i--;
        }
        return ans;
    }


    public int[] asteroidCollision2(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0 || stack.peek() < 0) {
                stack.push(asteroids[i]);
            } else {
                while (!stack.isEmpty()) {
                    int sum = asteroids[i] + stack.peek();

                    if (stack.peek() < 0 && asteroids[i] < 0) {
                        stack.push(asteroids[i]);
                        break;
                    } else if (sum < 0) {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(asteroids[i]);
                            break;
                        }
                    } else if (sum == 0) {
                        stack.pop();
                        break;
                    } else {
                        break;
                    }
                }

            }
        }

        int[] ans = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            ans[i] = stack.pop();
            i--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q735_opt q735Opt = new Q735_opt();
        int[] asteroids = new int[]{-2, -2, 1, -2};
        int[] ans = q735Opt.asteroidCollision2(asteroids);
        System.out.printf("111");
    }
}
