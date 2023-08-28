package com.rain.leetcode.medium;//
// 请你设计并实现一个满足 
// LRU (最近最少使用) 缓存 约束的数据结构。
// 
//
// 
// 实现 
// LRUCache 类：
// 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
// 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
//
// Related Topics 设计 哈希表 链表 双向链表 👍 2830 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q146 {


    LinkedHashMap<Integer, Integer> dicts;
    int capacity;

    public Q146(int capacity) {
        dicts = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!dicts.containsKey(key)) {
            return -1;
        }
        int val = dicts.remove(key);
        dicts.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        if (dicts.containsKey(key)) {
            dicts.remove(key);
        } else if (dicts.size() >= capacity) {
            Iterator<Integer> keyIter = dicts.keySet().iterator();
            dicts.remove(keyIter.next());
        }
        dicts.put(key, value);
    }

    public static void main(String[] args) {
      /*
        测试用例:["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
                [[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
        测试结果:[null,null,null,null,null,4,3,2,-1,null,-1,-1,3,4,5]
        期望结果:[null,null,null,null,null,4,3,2,-1,null,-1,2,3,-1,5]
        */
        Q146 q146 = new Q146(3);
        q146.put(1, 1);
        q146.put(2, 2);
        q146.put(3, 3);
        q146.put(4, 4);
        int rs1 = q146.get(4);//4
        int rs2 = q146.get(3);//3
        int rs3 = q146.get(2);//2
        int rs4 = q146.get(1);//-1
        q146.put(5, 5);
        int rs5 = q146.get(1);//-1
        int rs6 = q146.get(2);//2
        int rs7 = q146.get(3);//3
        int rs8 = q146.get(4);//-1
        int rs9 = q146.get(5);//5

        System.out.printf("11");

    }
}