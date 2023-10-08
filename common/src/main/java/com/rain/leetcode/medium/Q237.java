package com.rain.leetcode.medium;

import com.rain.leetcode.bean.ListNode;

public class Q237 {

    public void deleteNode(ListNode node) {
        ListNode prePre = null;
        ListNode pre = node;
        while (pre.next != null) {
            prePre = pre;
            pre.val = pre.next.val;
            pre = pre.next;
        }
        prePre.next = null;
    }
}
