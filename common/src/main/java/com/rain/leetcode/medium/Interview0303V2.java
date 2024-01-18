
package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Interview0303V2 {
    List<Stack<Integer>> stacks = new ArrayList<>();
    int stackSize;

    public Interview0303V2(int cap) {
        this.stackSize = cap;
    }

    public void push(int val) {
        if (stackSize == 0) {
            return;
        }
        Stack<Integer> current = null;
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == stackSize) {
            current = new Stack<>();
            stacks.add(current);
        } else {
            current = stacks.get(stacks.size() - 1);
        }
        current.push(val);
    }

    public int pop() {
        if (!stacks.isEmpty()) {
            Stack<Integer> current = stacks.get(stacks.size() - 1);
            int rs = current.pop();
            if (current.isEmpty()) {
                stacks.remove(current);
            }
            return rs;
        }
        return -1;
    }

    public int popAt(int index) {
        if (stacks.size() <= index) {
            return -1;
        }
        Stack<Integer> current = stacks.get(index);
        int rs = current.pop();
        if (current.isEmpty()) {
            stacks.remove(current);
        }
        return rs;
    }

}
