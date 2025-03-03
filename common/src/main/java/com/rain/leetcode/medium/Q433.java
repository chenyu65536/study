package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q433 {

    public int minMutation(String startGene, String endGene, String[] bank) {
        boolean[] used = new boolean[bank.length];
        Stack<String> stack = new Stack();
        stack.push(startGene);
        int step = 0;
        while(!stack.isEmpty()){
            Stack<String> next = new Stack();
            while(!stack.isEmpty()){
                String str = stack.pop();
                if(str.equals(endGene)){
                    return step;
                }
                next.addAll(addAll(str,bank,used));
            }
            stack = next;
            step++;
        }
        return -1;
    }

    public List<String> addAll(String str1, String[] bank, boolean[] used){
        List<String> rs = new ArrayList();
        for(int i=0;i<bank.length;i++){
            if(used[i])continue;
            if(match(str1,bank[i])){
                used[i] = true;
                rs.add(bank[i]);
            }
        }
        return rs;
    }

    public boolean match(String str1,String str2){
        int difCnt = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                difCnt++;
            }
        }
        return difCnt==1;
    }

    public static void main(String[] args) {
        Q433 q= new Q433();
        q.minMutation("AACCGGTT","AACCGGTA",new String[]{"AACCGGTA"});
    }
}
