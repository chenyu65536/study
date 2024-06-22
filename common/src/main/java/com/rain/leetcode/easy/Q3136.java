package com.rain.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class Q3136 {

    public static boolean isValid(String word) {
        if(word.length()<4){
            return false;
        }
        int count = 0;//元音数量 'a'、'e'、'i'、'o'、'u'
        int wordCount = 0;//元音数量 'a'、'e'、'i'、'o'、'u'
        Set<Character> chars = new HashSet<Character>();
        chars.add('a');
        chars.add('e');
        chars.add('i');
        chars.add('o');
        chars.add('u');
        chars.add('A');
        chars.add('E');
        chars.add('I');
        chars.add('O');
        chars.add('U');

        Set<Character> allChars = new HashSet<Character>();
        for(char ch:word.toCharArray()){
            if(ch=='@'||ch=='#'||ch=='$'){
                return false;
            }
            if((ch-'a'>=0 && ch-'a'<26)||(ch-'A'>=0 && ch-'A'<26)){
                if(chars.contains(ch)){
                    count++;
                }
                allChars.add(ch);
                wordCount++;
            }

        }

        return count>0 && wordCount-count>0 && allChars.size()>2;

    }

    public static void main(String[] args) {
        isValid("aya");
    }

}
