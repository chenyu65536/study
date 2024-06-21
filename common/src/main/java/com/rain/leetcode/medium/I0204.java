package com.rain.leetcode.medium;

import com.rain.leetcode.bean.ListNode;

public class I0204 {
    public ListNode partition(ListNode head, int x) {
        ListNode lowList = new ListNode();
        ListNode lowNextNode = lowList;

        ListNode bigList = new ListNode();
        ListNode bigNextNode = bigList;

        ListNode next = head;
        while (next != null) {
            if (next.val < x) {
                lowNextNode.next = next;
                while (next != null && next.val < x) {
                    lowNextNode = next;
                    next = next.next;
                }
            }

            if (next != null) {
                bigNextNode.next = next;
                while (next != null && next.val >= x) {
                    bigNextNode = next;
                    next = next.next;
                }
            }
        }
        bigNextNode.next = null;
        lowNextNode.next = bigList.next;
        return lowList.next;
    }

    public static void main(String[] args) {
        //1,4,3,2,5,2
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        I0204 o = new I0204();
        o.partition(node1,3);

    }

}
