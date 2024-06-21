package com.rain.leetcode.medium;

import java.util.*;

public class Q1061 {


    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        List<TreeSet<Character>> list = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            TreeSet<Character> addTree = null;
            for (TreeSet<Character> tree : list) {
                if (tree.contains(s1.charAt(i)) || tree.contains(s2.charAt(i))) {
                    addTree = tree;
                    break;
                }
            }
            if (addTree == null) {
                addTree = new TreeSet<>();
                list.add(addTree);
            }
            addTree.add(s1.charAt(i));
            addTree.add(s2.charAt(i));
        }
        //merge set
        for (int i = 0; i < list.size() - 1; i++) {
            TreeSet<Character> base = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                TreeSet<Character> compare = list.get(j);
                for (Character ch : compare) {
                    if (base.contains(ch)) {
                        base.addAll(compare);
                        compare.clear();
                        break;
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            boolean isAppend = false;
            for (TreeSet<Character> tree : list) {
                if (tree.contains(baseStr.charAt(i))) {
                    sb.append(tree.first());
                    isAppend = true;
                    break;
                }
            }
            if (!isAppend) {
                sb.append(baseStr.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q1061 q1061 = new Q1061();
        //axawaaaaazaaaaaaaaaaaaaxaaaaawaaauxaaauaaayzaauaaa
/*        String str = q1061.smallestEquivalentString(
                "cgokcgerolkgksgbhgmaaealacnsshofjinidiigbjerdnkolc",
                "rjjlkbmnprkslilqmbnlasardrossiogrcboomrbcmgmglsrsj",
                "bxbwjlbdazfejdsaacsjgrlxqhiddwaeguxhqoupicyzfeupcn");*/


        String str = q1061.smallestEquivalentString(
                "parker",
                "morris",
                "parser");
        System.out.printf("" + str);
    }
    //axawaaaaazaaaaaaaaaaaaaxaaaaawaaauxaaauaaayzaauaaa
    //axawaaaaazaaaaaaaaaaaaaxaaaaawaaauxaaauaaayzaauaaa
}
