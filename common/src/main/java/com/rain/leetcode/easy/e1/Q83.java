package com.rain.leetcode.easy.e1;

import com.rain.leetcode.bean.ListNode;

public class Q83 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            if (preNode.val != nextNode.val) {
                preNode.next = nextNode;
                preNode = nextNode;
            } else {//尾数相同，去尾
                if (nextNode.next == null) {
                    preNode.next = null;
                }
                nextNode = nextNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        deleteDuplicates(head);

    }
}
