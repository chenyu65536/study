package com.rain.leetcode.medium;

import com.rain.leetcode.bean.ListNode;

import java.util.Stack;

public class Q2816 {

    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        int pre = 0;

        while (!stack.isEmpty()){
            cur = stack.pop();
            int val = cur.val * 2 + pre;
            cur.val = val % 10;
            pre = val / 10;
        }
        while (pre > 0) {
            int val = pre % 10;
            pre = pre / 10;
            ListNode node  = new ListNode(val);
            node.next = head;
            head = node;
        }
        return head;
    }
}
