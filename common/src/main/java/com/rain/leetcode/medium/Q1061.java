package com.rain.leetcode.medium;

import java.util.*;

public class Q1061 {



    class Pair {
        Set<Character> set = new HashSet<>();
        Character minChar;

        public Pair() {
        }
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            char min = ch1 < ch2 ? ch1 : ch2;
            Pair pair = null;
            for (Pair tempPair : pairs) {
                Set<Character> set = tempPair.set;
                if (set.contains(ch1) || set.contains(ch2)) {
                    pair = tempPair;
                    min = min < tempPair.minChar ? min : tempPair.minChar;
                    break;
                }
            }

            if (pair == null) {
                pair = new Pair();
                pairs.add(pair);
            }
            pair.minChar = min;
            pair.set.add(ch1);
            pair.set.add(ch2);
        }
        Character[] chars = new Character[26];
        for (Pair tempPair : pairs) {
            for (Character ch : tempPair.set) {
                chars[ch - 'a'] = tempPair.minChar;
            }
        }

        StringBuilder rs = new StringBuilder();
        for (Character ch : baseStr.toCharArray()) {
            rs.append(chars[ch-'a']);
        }
        return rs.toString();
    }

    public String smallestEquivalentString2(String s1, String s2, String baseStr) {
        List<Set<Character>> list = new ArrayList<>();
        List<Character> minChars = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            char min = ch1 < ch2 ? ch1 : ch2;
            Set<Character> tempSet = null;
            for (int j = 0; j < list.size(); j++) {
                Set<Character> set = list.get(j);
                if (set.contains(s1.charAt(i)) || set.contains(s2.charAt(i))) {
                    tempSet = set;
                    min = min < minChars.get(j) ? min : minChars.get(j);
                    break;
                }
            }
            if (tempSet == null) {
                tempSet = new HashSet<>();
                list.add(tempSet);
                minChars.add(min);
            }
            tempSet.add(ch1);
            tempSet.add(ch2);

        }
        Character[] charMaps = new Character[26];

        for (int i = 0; i < list.size(); i++) {
            Set<Character> set = list.get(i);
            for (Character ch : set) {
                charMaps[ch - 'a'] = minChars.get(i);
            }
        }


        StringBuilder rs = new StringBuilder();
        for (Character ch : baseStr.toCharArray()) {
            rs.append(charMaps[ch - 'a'] == null ? ch : charMaps[ch - 'a']);
        }
        return rs.toString();
    }

    public static void main(String[] args) {
        Q1061 q1061 = new Q1061();
        String str =  q1061.smallestEquivalentString2("aabbbabbbbbabbbbaabaabbaaabbbabaababaaaabbbbbabbaa","aabbaabbbabaababaabaababbbababbbaaaabbbbbabbbaabaa","buqpqxmnajphtisernebttymtrydomxnwonfhfjlzzrfhosjct");
        System.out.printf(""+str);
    }
}
