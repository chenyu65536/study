package com.rain.leetcode.medium;
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
//
//
// 示例 2：
//
//
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//
//
//
// 提示：
//
//
// n == matrix.length == matrix[i].length
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000
//
//
//
//
// Related Topics 数组 数学 矩阵 👍 1705 👎 0

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
//
//
// 示例 2：
//
//
//输入：head = [5], left = 1, right = 1
//输出：[5]
//
//
//
//
// 提示：
//
//
// 链表中节点数目为 n
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
//
//
//
//
// 进阶： 你可以使用一趟扫描完成反转吗？
//
// Related Topics 链表 👍 1632 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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

import com.rain.leetcode.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode next = head;
        List<ListNode> reverseNodes = new ArrayList<>();
        int i = 1;
        while (i <= right) {
            if (i == left - 1) {
                leftNode = next;
            }
            if (i == right) {
                rightNode = next.next;
            }
            if (i >= left && i <= right) {
                reverseNodes.add(next);
            }
            next = next.next;
            i++;
        }

        for (int j = reverseNodes.size() - 1; j >= 1; j--) {
            reverseNodes.get(j).next = reverseNodes.get(j - 1);
        }
        if (leftNode != null) {
            leftNode.next = reverseNodes.get(reverseNodes.size() - 1);
        }
        reverseNodes.get(0).next = rightNode;
        return leftNode == null ? reverseNodes.get(reverseNodes.size() - 1) : head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(5);
        head.next = node2;
        Q92 q92 = new Q92();
        ListNode rs = q92.reverseBetween(head, 1, 2);
        System.out.printf("1");
    }
}
