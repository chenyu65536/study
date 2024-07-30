package com.rain.leetcode.hard;

import java.util.*;

public class Q140 {
    Set<String> dict;
    List<String> rs;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet(wordDict);
        rs = new ArrayList();

        dfs(s,0,new ArrayList());
        return rs;
    }

    public void dfs(String s, int startIndex, List<String> sentence) {
        if(startIndex==s.length()){
            rs.add(String.join("",sentence));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String word = s.substring(startIndex,i+1);
            if(!dict.contains(word)) continue;
            sentence.add(word);
            dfs(s,i+1,sentence);
            sentence.remove(sentence.size()-1);
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat","cats","and","sand","dog");

        Q140 q140 = new Q140();
        q140.wordBreak(s,wordDict);
    }

}
