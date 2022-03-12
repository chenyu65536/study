package com.rain.leetcode.math;
//
// 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误
//的版本。你应该尽量减少对调用 API 的次数。
//
//
// 示例 1：
//
//
//输入：n = 5, bad = 4
//输出：4
//解释：
//调用 isBadVersion(3) -> false
//调用 isBadVersion(5) -> true
//调用 isBadVersion(4) -> true
//所以，4 是第一个错误的版本。
//
//
// 示例 2：
//
//
//输入：n = 1, bad = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= bad <= n <= 2³¹ - 1
//
// Related Topics 二分查找 交互 👍 616 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Q278 {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        boolean isBad = isBadVersion(1);
        if (isBad) {
            return 1;
        }
        while (n >= left) {
            int mid = right + (left - right) / 2;
            if (right - left <= 1) {
                return right;
            }
            isBad = isBadVersion(mid);
            if (isBad) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }

    private boolean isBadVersion(int n) {

        return n >= 1702766719L;
    }

    public static void main(String[] args) {
        Q278 q = new Q278();
        int rs = q.firstBadVersion(2126753390);
        System.out.printf("" + rs);
    }
}
