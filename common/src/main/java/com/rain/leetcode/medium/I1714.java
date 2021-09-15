package com.rain.leetcode.medium;

//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
//
// 示例：
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
//
//
// 提示：
//
//
// 0 <= len(arr) <= 100000
// 0 <= k <= min(100000, len(arr))
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列）
// 👍 109 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
public class I1714 {

    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        int[] result = new int[k];
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
            maxIndex = arr[maxIndex] > result[i] ? maxIndex : i;
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < result[maxIndex]) {
                result[maxIndex] = arr[i];
                maxIndex = maxIndex(result);
            }
        }
        return result;
    }

    private int maxIndex(int[] result) {
        int maxIndex = 0;
        for (int i = 0; i < result.length; i++) {
            maxIndex = result[maxIndex] > result[i] ? maxIndex : i;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,2,4,6,8};
        int k = 4;
        I1714 i1714 = new I1714();
        int[] result = i1714.smallestK(arr,4);

        System.out.printf("11");

    }
}
