package com.rain.algorithm.stack;

import java.util.Stack;

/**
 * Created by chenyu on 2017/4/19.
 * 括号消除
 *
 * 给定一个字符串，设计一个算法消除其中成对的括号，如果括号不成对，提示异常（error）

 如（1，（2，3），（4，（5，6），7））转化为1，2，3，4，5，6，7
 如（1，）2，3），（4，（5，6（，7））提示error。
 */
public class ClearBrackets {

    public static  void clearBrackets(String input){
        Stack<String> stack = new Stack<>();
        for(int i=0;i<input.length();i++){
            String temp = String.valueOf(input.charAt(i));
            if(temp.equals("(")){
                stack.push(temp);
            }else if(temp.equals(")")){
                if(stack.isEmpty()){
                    throw new RuntimeException("格式错误");
                }else {
                    stack.pop();
                }
            }else {
                System.out.printf(temp);
            }
        }
    }

    public static void main(String[] args) {
       // clearBrackets("(1，(2，3)，(4，(5，6(，7))");
        clearBrackets("(1，)2，3)，(4，(5，6(，7))");
    }
}
