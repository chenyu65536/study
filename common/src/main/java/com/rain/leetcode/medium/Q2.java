package com.rain.leetcode.medium;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学
// 👍 5642 👎 0

import com.rain.leetcode.bean.ListNode;

public class Q2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode next1 = l1;
        ListNode next2 = l2;

        ListNode l3 = null;
        ListNode pre3 = null;
        boolean up = false;
        for (int i = 0; i < 100; i++) {
            int val1 = next1 == null ? 0 : next1.val;
            int val2 = next2 == null ? 0 : next2.val;

            int result = val1 + val2 + (up ? 1 : 0);
            int val3 = result % 10;
            if (result < 10) {
                up = false;
            } else {
                up = true;
            }

            ListNode currentNode = new ListNode(val3);
            if (i == 0) {
                l3 = currentNode;
                pre3 = currentNode;
            } else {
                pre3.next = currentNode;
                pre3 = currentNode;
            }

            next1 = next1 == null ? null : next1.next;
            next2 = next2 == null ? null : next2.next;

            if (next1 == null && next2 == null && !up) {
                break;
            }
        }
        return l3;
    }
}
