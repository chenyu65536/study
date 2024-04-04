package com.rain.leetcode.medium;
//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,2,3]
//输出：[3]
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：[1]
//
//
// 示例 3：
//
//
//输入：nums = [1,2]
//输出：[1,2]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5 * 10⁴
// -10⁹ <= nums[i] <= 10⁹
//
//
//
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
//
// Related Topics 数组 哈希表 计数 排序 👍 703 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q229 {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int minCount = nums.length / 3;
        List<Integer> rs = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) > minCount) {
                rs.add(key);
            }
        }
        return rs;
    }

}
