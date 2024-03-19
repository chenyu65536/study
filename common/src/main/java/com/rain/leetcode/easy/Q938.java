package com.rain.leetcode.easy;

import com.rain.leetcode.bean.TreeNode;

public class Q938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        int val = 0;
        if(root==null){
            return val;
        }
        if(root.val>=low && root.val<=high){
            val = root.val;
        }
        return val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
    }
}
