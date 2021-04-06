package com.rain.leetcode.easy.e1;

//编写一个程序，找到两个单链表相交的起始节点。
//
// 如下面的两个链表：
//
//
//
// 在节点 c1 开始相交。
//
//
//
// 示例 1：
//
//
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//
//
//
//
// 示例 2：
//
//
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
//
//
//
//
// 示例 3：
//
//
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
//
//
//
//
// 注意：
//
//
// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
//
// Related Topics 链表
// 👍 978 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.rain.leetcode.bean.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Q160 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        ListNode nextA = lengthA - lengthB > 0 ? forward(headA, lengthA - lengthB) : headA;
        ListNode nextB = lengthA - lengthB < 0 ? forward(headB, lengthB - lengthA) : headB;

        while (nextA != null) {
            if (nextA == nextB) {
                return nextA;
            }
            nextA = nextA.next;
            nextB = nextB.next;
        }
        return null;
    }

    private static ListNode forward(ListNode head, int step) {
        for (int i = 1; i <= step; i++) {
            head = head.next;
        }
        return head;
    }

    private static int getLength(ListNode head) {
        int length = 0;
        ListNode next = head;
        while (next != null) {
            length++;
            next = next.next;
        }
        return length;
    }


    public static void main(String[] args) {
        //[4,1,8,4,5]

        ListNode node4 = new ListNode(5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(8, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(4, node1);

        //[5,6,1,8,4,5]


        ListNode node15 = new ListNode(5);
        ListNode node14 = new ListNode(4, node15);
        ListNode node13 = new ListNode(8, node14);
        ListNode node12 = new ListNode(1, node13);
        ListNode node11 = new ListNode(6, node12);
        ListNode head2 = new ListNode(5, node11);

       ListNode crossNode =  getIntersectionNode(head,head2);

        System.out.printf("");

    }
}
