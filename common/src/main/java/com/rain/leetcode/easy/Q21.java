package com.rain.leetcode.easy;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
//输入：l1 = [], l2 = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：l1 = [], l2 = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
// 👍 1666 👎 0

import com.rain.leetcode.bean.ListNode;

public class Q21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode next1 = l1;
        ListNode next2 = l2;
        ListNode l3 = null;

        ListNode next3 = null;

        if (l1.val > l2.val) {
            next3 = l2;
            l3 = l2;
            next2 = l2.next;
        } else {
            next3 = l1;
            next1 = l1.next;
            l3 = l1;
        }
        while (next1 != null && next2 != null) {
            if (next1.val > next2.val) {
                next3.next = next2;
                next3 = next2;
                next2 = next2.next;
            } else {
                next3.next = next1;
                next3 = next1;
                next1 = next1.next;
            }
        }

        if (next2 != null) {
            next3.next = next2;
        }
        if (next1 != null) {
            next3.next = next1;
        }
        return l3;
    }

    public static void main(String[] args) {
        //输入：l1 = [1,2,4], l2 = [1,3,4]
        //输出：[1,1,2,3,4,4]

        ListNode l11 = new ListNode();
        l11.val = 1;
        ListNode l12 = new ListNode();
        l12.val = 2;
        ListNode l13 = new ListNode();
        l13.val = 4;

        l11.next = l12;
        l12.next = l13;


        ListNode l21 = new ListNode();
        l21.val = 1;
        ListNode l22 = new ListNode();
        l22.val = 3;
        ListNode l23 = new ListNode();
        l23.val = 4;

        ListNode l24 = new ListNode();
        l24.val = 5;

        l21.next = l22;
        l22.next = l23;
        l23.next = l24;

        Q21 q21 = new Q21();
        ListNode l3 = q21.mergeTwoLists(l11, l22);

        System.out.printf("111");
    }
}
