package com.rain.leetcode.medium;
//给你两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和
//负面的。
//
// 一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减 1 分。
//
// 给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中
//student_id[i] 表示这名学生的 ID ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
//
// 给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。
//
//
//
// 示例 1：
//
// 输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback =
//["not"], report = ["this student is studious","the student is smart"], student_
//id = [1,2], k = 2
//输出：[1,2]
//解释：
//两名学生都有 1 个正面词汇，都得到 3 分，学生 1 的 ID 更小所以排名更前。
//
//
// 示例 2：
//
// 输入：positive_feedback = ["smart","brilliant","studious"], negative_feedback =
//["not"], report = ["this student is not studious","the student is smart"],
//student_id = [1,2], k = 2
//输出：[2,1]
//解释：
//- ID 为 1 的学生有 1 个正面词汇和 1 个负面词汇，所以得分为 3-1=2 分。
//- ID 为 2 的学生有 1 个正面词汇，得分为 3 分。
//学生 2 分数更高，所以返回 [2,1] 。
//
//
//
//
// 提示：
//
//
// 1 <= positive_feedback.length, negative_feedback.length <= 10⁴
// 1 <= positive_feedback[i].length, negative_feedback[j].length <= 100
// positive_feedback[i] 和 negative_feedback[j] 都只包含小写英文字母。
// positive_feedback 和 negative_feedback 中不会有相同单词。
// n == report.length == student_id.length
// 1 <= n <= 10⁴
// report[i] 只包含小写英文字母和空格 ' ' 。
// report[i] 中连续单词之间有单个空格隔开。
// 1 <= report[i].length <= 100
// 1 <= student_id[i] <= 10⁹
// student_id[i] 的值 互不相同 。
// 1 <= k <= n
//
//
// Related Topics 数组 哈希表 字符串 排序 堆（优先队列） 👍 36 👎 0


import java.util.*;
import java.util.stream.Collectors;

public class Q2512 {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {

       /* Map<String, Integer> feedback = new HashMap<>();
        Arrays.stream(positive_feedback).forEach(key -> feedback.put(key, 3));
        Arrays.stream(negative_feedback).forEach(key -> feedback.put(key, -1));

        TreeSet<Pair<Integer, Integer>> pairs = new TreeSet<Pair<Integer, Integer>>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (!Objects.equals(o2.getValue(), o1.getValue())) {
                    return o2.getValue() - o1.getValue();
                } else {
                    return o1.getKey() - o2.getKey();
                }
            }
        });
        for (int i = 0; i < report.length; i++) {
            int score = 0;
            String[] words = report[i].split(" ");
            for (String word : words) {
                score += feedback.getOrDefault(word, 0);
            }
            pairs.add(new Pair<>(student_id[i], score));
        }

        List<Integer> rs = new ArrayList<>();
        int i = 0;
        Iterator<Pair<Integer, Integer>> iterator = pairs.iterator();
        while (i < k) {
            rs.add(iterator.next().getKey());
            i++;
        }*/
        return null;
    }

    public static void main(String[] args) {
        String[] positive_feedback = new String[]{"fkeofjpc", "qq", "iio"};
        String[] negative_feedback = new String[]{"jdh", "khj", "eget", "rjstbhe", "yzyoatfyx", "wlinrrgcm"};
        String[] report = new String[]{"rjstbhe eget kctxcoub urrmkhlmi yniqafy fkeofjpc iio yzyoatfyx khj iio", "gpnhgabl qq qq fkeofjpc dflidshdb qq iio khj qq yzyoatfyx", "tizpzhlbyb eget z rjstbhe iio jdh jdh iptxh qq rjstbhe", "jtlghe wlinrrgcm jnkdbd k iio et rjstbhe iio qq jdh", "yp fkeofjpc lkhypcebox rjstbhe ewwykishv egzhne jdh y qq qq", "fu ql iio fkeofjpc jdh luspuy yzyoatfyx li qq v", "wlinrrgcm iio qq omnc sgkt tzgev iio iio qq qq", "d vhg qlj khj wlinrrgcm qq f jp zsmhkjokmb rjstbhe"};
        int[] student_id = new int[]{96537918, 589204657, 765963609, 613766496, 43871615, 189209587, 239084671, 908938263};
        int k = 3;
        Q2512 q2512 = new Q2512();
        List<Integer> rs = q2512.topStudents(positive_feedback, negative_feedback, report, student_id, k);
        System.out.printf("" + rs);
    }
}
