package com.rain.leetcode.medium;

//
// Trie() 初始化前缀树对象。
// void insert(String word) 向前缀树中插入字符串 word 。
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
// 。
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。
//
//
//
//
// 示例：
//
//
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
//
//
//
//
// 提示：
//
//
// 1 <= word.length, prefix.length <= 2000
// word 和 prefix 仅由小写英文字母组成
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
//
// Related Topics 设计 字典树
// 👍 635 👎 0
public class Q208 {

    private TriesNode root = new TriesNode();

    /**
     * Initialize your data structure here.
     */
    public Q208() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TriesNode parentNode = root;
        for (int i = 0; i < chars.length; i++) {
            if (parentNode.child[chars[i] - 'a'] == null) {
                TriesNode currentNode = new TriesNode(chars[i]);
                parentNode.child[chars[i] - 'a'] = currentNode;
                parentNode = currentNode;
            }else {
                parentNode = parentNode.child[chars[i] - 'a'];
            }
        }
        parentNode.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TriesNode parentNode = root;
        for (int i = 0; i < chars.length; i++) {
            if (parentNode.child[chars[i] - 'a'] == null) {
                return false;
            } else {
                parentNode = parentNode.child[chars[i] - 'a'];
            }
        }
        return parentNode.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TriesNode parentNode = root;
        for (int i = 0; i < chars.length; i++) {
            if (parentNode.child[chars[i] - 'a'] == null) {
                return false;
            } else {
                parentNode = parentNode.child[chars[i] - 'a'];
            }
        }
        return true;
    }

    public class TriesNode {

        public char val;
        public TriesNode[] child = new TriesNode[26];
        public boolean isEnd = false;

        public TriesNode() {
        }

        public TriesNode(char val) {
            this.val = val;
        }

    }

    public static void main(String[] args) {
        Q208 trie = new Q208();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True*//*

        trie.insert("abc");
        trie.search("abc");     // 返回 False
        trie.startsWith("ab"); // 返回 True
        trie.insert("ab");
        trie.search("ab");     // 返回 True
    }
}