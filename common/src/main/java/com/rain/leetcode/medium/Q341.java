package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Q341 implements Iterator<Integer> {

    private List<Integer> items = new ArrayList<>();
    private int currentIndex = -1;

    public Q341(List<NestedInteger> nestedIntegers) {
        if (nestedIntegers == null || nestedIntegers.size() == 0) {
            return;
        }
        for (NestedInteger nestedInteger : nestedIntegers) {
            addItem(nestedInteger);
        }
    }

    private void addItem(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            items.add(nestedInteger.getInteger());
        } else {
            for (NestedInteger temp : nestedInteger.getList()) {
                addItem(temp);
            }
        }
    }

    @Override
    public Integer next() {
        currentIndex++;
        return items.get(currentIndex);
    }

    @Override
    public boolean hasNext() {
        return items.size() > currentIndex;
    }

    public static class NestedInteger {
        public Integer value;
        public List<NestedInteger> nestedIntegers;


        public boolean isInteger() {
            return this.value != null;
        }

        public Integer getInteger() {
            return this.value;
        }

        public List<NestedInteger> getList() {
            return nestedIntegers;
        }
    }

    public static void main(String[] args) {
         /* 运行成功:
    测试用例:[[1,1],2,[1,1]]
    测试结果:[1,2,1,1]
    期望结果:[1,1,2,1,1]
    */

        NestedInteger nestedInteger11 = new NestedInteger();
        nestedInteger11.value = 1;
        NestedInteger nestedInteger12 = new NestedInteger();
        nestedInteger12.value = 1;


        NestedInteger nestedInteger1 = new NestedInteger();
        nestedInteger1.nestedIntegers = Arrays.asList(nestedInteger11, nestedInteger12);

        NestedInteger nestedInteger2 = new NestedInteger();
        nestedInteger2.value = 2;

        NestedInteger nestedInteger3 = new NestedInteger();
        nestedInteger3.nestedIntegers = Arrays.asList(nestedInteger11, nestedInteger12);

        new Q341(Arrays.asList(nestedInteger1, nestedInteger2, nestedInteger3));
        System.out.printf("111");

    }
}
