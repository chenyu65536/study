package com.rain.leetcode.medium;
//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
//
//L0 → L1 → … → Ln - 1 → Ln
//
//
// 请将其重新排列后变为：
//
//
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [1,2,3,4]
//输出：[1,4,2,3]
//
// 示例 2：
//
//
//
//
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3]
//
//
//
// 提示：
//
//
// 链表的长度范围为 [1, 5 * 10⁴]
// 1 <= node.val <= 1000
//
//
// Related Topics 栈 递归 链表 双指针 👍 1357 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import com.rain.leetcode.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q143 {

    public void reorderList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode next = head;
        while (next != null) {
            nodes.add(next);
            next = next.next;
        }

        int i = 0, j = nodes.size() - 1;
        while (i < j) {
            nodes.get(i).next = nodes.get(j);
            nodes.get(j).next = null;

            if (i == j - 1) {
                // nodes.get(i + 1).next = null;
            } else if (i == j - 2) {
                nodes.get(j).next = nodes.get(i + 1);
                nodes.get(i + 1).next = null;
            } else {
                nodes.get(j).next = nodes.get(i + 1);
            }
            i++;
            j--;
        }
        System.out.printf("1");
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Q143 q143 = new Q143();
        q143.reorderList(node1);

    }
}
