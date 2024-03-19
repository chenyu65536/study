package com.rain.leetcode.easy;

public class Interview0301 {

    int[] stacks;
    int[] stackLengths;
    int stackSize;

    public Interview0301(int stackSize) {
        this.stacks = new int[stackSize * 3];
        this.stackSize = stackSize;
        this.stackLengths = new int[3];
    }

    public void push(int stackNum, int value) {
        if (stackLengths[stackNum] >= stackSize) {
            return;
        }
        stacks[getIndex(stackNum) + 3] = value;
        stackLengths[stackNum]++;
    }

    public int pop(int stackNum) {
        if (stackLengths[stackNum] == 0) {
            return -1;
        }
        int index = getIndex(stackNum);
        int rs = stacks[index];
        stackLengths[stackNum]--;
        return rs;
    }

    public int getIndex(int stackNum) {
        return (stackLengths[stackNum] - 1) * 3 + stackNum;
    }

    public int peek(int stackNum) {
        if (stackLengths[stackNum] == 0) {
            return -1;
        }
        return stacks[getIndex(stackNum)];
    }

    public boolean isEmpty(int stackNum) {
        return stackLengths[stackNum] == 0;
    }


    public static void main(String[] args) {
        Interview0301 interview0301 = new Interview0301(2);
        interview0301.push(0, 1);
        interview0301.push(0, 2);
        interview0301.push(0, 3);
        int rs1 = interview0301.pop(0);
        int rs2 = interview0301.pop(0);
        int rs3 = interview0301.pop(0);
        int rs4 = interview0301.peek(0);
        System.out.printf("11");
    }
}
