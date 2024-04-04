package com.rain.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q438 {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> pCount = new HashMap<Character,Integer>();
        for(int i=0;i<p.length();i++){
            pCount.put(p.charAt(i),pCount.getOrDefault(p.charAt(i),0)+1);
        }
        List<Integer> rs = new ArrayList<Integer>();
        for(int i=0;i<s.length();i++){
            if(i+p.length()>s.length()){
                break;
            }
            if(isMatch(s,pCount,i,i+p.length())){
                rs.add(i);
                if(p.charAt(i)==p.charAt(p.length()+1)){
                    rs.add(i+1);
                    i++;
                }
            }
        }
        return rs;
    }
    public boolean isMatch(String s,Map<Character,Integer> pCount,int start,int end){
        Map<Character,Integer> tempPCount = new HashMap(pCount);
        for(int i=start;i<end;i++){
            int leftCount = tempPCount.getOrDefault(s.charAt(i),0);
            if(leftCount==0){
                return false;
            }else{
                tempPCount.put(s.charAt(i),leftCount-1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q438 q438 = new Q438();
        List<Integer> rs = q438.findAnagrams("abab","ab");

        System.out.printf(""+rs);

    }
}
