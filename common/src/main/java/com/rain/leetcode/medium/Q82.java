package com.rain.leetcode.medium;

import com.rain.leetcode.bean.ListNode;

public class Q82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHeader = new ListNode(Integer.MIN_VALUE);
        ListNode next = head;
        ListNode pre = newHeader;
        ListNode newNext = newHeader;
        while (next != null) {
            if (next.val != pre.val && (next.next == null || next.next.val != next.val)) {
                newNext.next = next;
                newNext = next;
            }
            pre = next;
            next = next.next;
        }
        newNext.next = null;
        return newHeader.next;
    }


    public static void main(String[] args) {
        ListNode header = new ListNode(1);
        ListNode node2 = new ListNode(2);
        header.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        Q82 q82 = new Q82();
        q82.deleteDuplicates(header);

    }

}
