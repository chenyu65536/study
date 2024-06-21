package com.rain.leetcode.medium;


public class Q2288 {
 /*   public String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            if (isPrice(str)) {
                long price = Long.parseLong(str.substring(1, str.length()));
                double discountPrice = price/100d * (100 - discount);

                sb.append(" $" +  String.format("%.2f", discountPrice));
            } else {
                sb.append(" " + str);
            }
        }
        return sb.deleteCharAt(0).toString();
    }*/


   /* public String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (isPrice(str)) {
                long price = Long.parseLong(str.substring(1, str.length()));
                double discountPrice = price / 100d * (100 - discount);
                strs[i] = "$" + String.format("%.2f", discountPrice);
            }
        }
        return String.join(" ", strs);
    }

    public boolean isPrice(String str) {
        if (!str.startsWith("$") || str.length() == 1) return false;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }*/


    public String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            long price = isPrice(str);
            if (price > 0) {
                double discountPrice = price / 100d * (100 - discount);
                strs[i] = String.format("$%.2f", discountPrice);
            }
        }
        return String.join(" ", strs);
    }

    public long isPrice(String str) {
        long rs = 0;
        if (!str.startsWith("$") || str.length() == 1) return -1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return -1;
            }
            rs = rs * 10 + str.charAt(i) - '0';
        }
        return rs;
    }

    public static void main(String[] args) {
        Q2288 q2288 = new Q2288();
        String rs = q2288.discountPrices("there are $1 $2 and 5$ candies in the shop", 50);
        // q2288.discountPrices("706hzu76jjh7yufr5x9ot60v149k5 $7651913186 pw2o $6", 28);
        System.out.printf("");

    }
}
