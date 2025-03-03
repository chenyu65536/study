package com.rain.leetcode.medium;

import java.util.*;

public class Q211 {


    TreeNode root;
    TreeNode NULL_NODE = new TreeNode(-1);
    Map<String, Boolean> cache = new HashMap<>();
    int dotsVal = 0;

    public Q211() {
        this.root = new TreeNode();
        this.dotsVal = '.' - 'a';
    }

    public void addWord(String word) {
        TreeNode next = root;
        int i = 0;
        //相同前缀节点
        while (next != null && i < word.length() && next.childs[word.charAt(i) - 'a'] != null) {
            next = next.childs[word.charAt(i) - 'a'];
            i++;
        }
        //追加节点
        while (i < word.length()) {
            int charVal = word.charAt(i) - 'a';
            next.childs[charVal] = new TreeNode(charVal);
            next = next.childs[charVal];
            i++;
        }
        next.childs[26] = NULL_NODE;
        cache.put(word, true);
    }

    public boolean search(String word) {
        if (cache.containsKey(word)) {
            return cache.get(word);
        }
        int i = 0;
        List<TreeNode> nexts = Arrays.asList(root.childs);
        while (!nexts.isEmpty() && i <= word.length()) {
            if (i == word.length()) {
                cache.put(word, nexts.contains(NULL_NODE));
                return cache.get(word);
            }
            int charVal = word.charAt(i) - 'a';
            List<TreeNode> newNexts = new ArrayList<>();
            for (TreeNode next : nexts) {
                if (next == null) continue;
                if (charVal == dotsVal) {
                    newNexts.addAll(Arrays.asList(next.childs));
                } else if (next.val == charVal) {
                    newNexts.addAll(Arrays.asList(next.childs));
                }
            }
            nexts = newNexts;
            i++;
        }
        cache.put(word, false);
        return false;
    }


    class TreeNode {
        public int val;
        public TreeNode[] childs;

        public TreeNode() {
            this.childs = new TreeNode[27];
        }

        public TreeNode(int val) {
            this.childs = new TreeNode[27];
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Q211 q211 = new Q211();
      /*  q211.addWord("bad");
        q211.addWord("dad");
        q211.addWord("mad");
        q211.search("pad");//false
        q211.search("bad");//true
        q211.search(".ad");
        q211.search("b..");*/


     /*   测试用例:["WordDictionary"
                ,"addWord","addWord","addWord","addWord",   "search","search","addWord","search","search","search","search","search","search"]
			[[],["at"],["and"],["an"],["add"],

        ["a"],[".at"],

        ["bat"],

        [".at"],["an."],["a.d."],["b."],["a.d"],["."]]
        测试结果:[null,null,null,null,null,false,false,null,false,true,false,false,true,false]
        期望结果:[null,null,null,null,null,false,false,null,true,true,false,false,true,false]*/


        q211.addWord("at");
        //q211.addWord("and");
       // q211.addWord("an");
       // q211.addWord("add");
        q211.search(".at");
        q211.addWord("bat");
        q211.search(".at");
       // q211.search("a");//false
 /*       q211.search(".at");//true
        q211.search("bat");
        q211.search("b..");*/
       // System.out.printf("1");

        int rs = 5^3&1;
        System.out.printf(""+rs);
    }
}
