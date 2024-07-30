package com.rain.leetcode.medium;

import java.util.*;

public class Q721 {
    HashSet<String> usedEmail;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int length = accounts.size();
        this.usedEmail = new HashSet<>();
        Map<String, List<HashSet<String>>> accountMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            List<String> emails = accounts.get(i);
            String accountName = emails.get(0);
            HashSet<String> set = new HashSet<>();
            for (int j = 1; j < emails.size(); j++) {
                set.add(emails.get(j));
            }
            if (!accountMap.containsKey(accountName)) {
                accountMap.put(accountName, new ArrayList<>());
            }
            accountMap.get(accountName).add(set);
        }

        List<List<String>> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String accountName : accountMap.keySet()) {
            List<HashSet<String>> setList = accountMap.get(accountName);
            boolean[] used = new boolean[setList.size()];
            for (int i = 0; i < setList.size(); i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                appendToStack(stack, setList.get(i));
                Set<String> set = new HashSet<>();

                while (!stack.isEmpty()) {
                    String email = stack.pop();
                    set.add(email);
                    for (int m = 0; m < setList.size(); m++) {
                        HashSet<String> account = setList.get(m);
                        if (used[m] || !account.contains(email)) {
                            continue;
                        }
                        appendToStack(stack, account);
                        used[m] = true;
                    }
                }
                LinkedList<String> row = new LinkedList<>(set);
                Collections.sort(row, Comparator.comparing(String::toString));
                row.add(0, accountName);
                res.add(row);
            }
        }
        return res;
    }


    public void appendToStack(Stack<String> stack, HashSet<String> items) {
        for (String item : items)
            if (!usedEmail.contains(item)) {
                stack.push(item);
            }
    }

    public static void main(String[] args) {
        Q721 q721 = new Q721();
        List<List<String>> parms = List.of(
             /*   List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
                List.of("John","johnsmith@mail.com","john00@mail.com"),*/
                List.of("Mary","mary@mail.com"),
                List.of("John","johnnybravo@mail.com")
        );

        q721.accountsMerge(parms);
    }
}
