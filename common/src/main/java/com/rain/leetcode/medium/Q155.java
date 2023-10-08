package com.rain.leetcode.medium;
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
// 实现 MinStack 类:
//
//
// MinStack() 初始化堆栈对象。
// void push(int val) 将元素val推入堆栈。
// void pop() 删除堆栈顶部的元素。
// int top() 获取堆栈顶部的元素。
// int getMin() 获取堆栈中的最小元素。
//
//
//
//
// 示例 1:
//
//
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// -2³¹ <= val <= 2³¹ - 1
// pop、top 和 getMin 操作总是在 非空栈 上调用
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次
//
//
// Related Topics 栈 设计 👍 1664 👎 0


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q155 {

    private List<Integer> stack;
    private List<Integer> minStack;

    public Q155() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty()) {
            minStack.add(val);
        } else {
            minStack.add(Math.min(val, minStack.get(minStack.size() - 1)));
        }
    }

    public void pop() {
        stack.remove(minStack.size() - 1);
        minStack.remove(minStack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }

    public static void main(String[] args) {
        Q155 q155 = new Q155();
      /*  q155.push(-2);
        q155.push(0);
        q155.push(-3);
        q155.getMin();
        q155.pop();
        q155.top();
        q155.getMin();*/

        q155.push(2);
        q155.push(0);
        q155.push(3);
        q155.push(0);
        q155.getMin();
        q155.pop();
        q155.getMin();
        q155.pop();
        q155.getMin();
        q155.pop();
        q155.getMin();
    }
}
