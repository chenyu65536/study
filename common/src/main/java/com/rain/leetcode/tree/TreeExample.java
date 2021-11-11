package com.rain.leetcode.tree;

import com.rain.leetcode.bean.TreeNode;

public class TreeExample {

    public void example(){
        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;
    }


    public void example2(){

        /**
         * 	[5,4,8,11,null,13,4,7,2,null,null,5,1]
         *            5
         *
         *       4              8
         *
         *   11   null      13       4
         * 7   2                   5   1
         */
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = null;


        TreeNode node6 = new TreeNode(13);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(2);
        TreeNode node10 = null;
        TreeNode node11 = null;
        TreeNode node12 = new TreeNode(5);
        TreeNode node13 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;


        node3.left = node6;
        node3.right = node7;

        node4.left = node8;
        node4.right = node9;

        node7.left = node12;
        node7.right = node13;

    }

    public void example3(){
        /**
         *
         * 解答失败:
         * 			测试用例:[-2,null,-3]
         * 			-5
         * 			测试结果:[]
         * 			期望结果:[[-2,-3]]
         * 			stdout:
         *
         * 	     -2
         *
         * 	 null   -3
         *
         *
         */
        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = null;
        TreeNode node3 = new TreeNode(-3);

        node1.left = node2;
        node1.right = node3;


    }

    public static void main(String[] args) {

    }
}
