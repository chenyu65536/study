package com.rain.algorithm;

/**
 * Created by chenyu on 2017/3/13.
 * 字符串 ：  查找子字符串
 */
public class KMP {
    public static int NOT_FOUND=-1;

    public static int start(String[] parentStr,String[] subStr){
        for(int i=0;i<parentStr.length;i++){
            int offset=0;
            if(parentStr.length-i-1<subStr.length){//余下长度不足返回 失败
                return KMP.NOT_FOUND;
            }
            for(int j=0+offset;j<subStr.length;j++){
                if(parentStr[i+j].equals(subStr[j])){
                    if(subStr.length==j+1){//匹配成功
                        return i;
                    }
                    continue;
                }else {//匹配失败 计算偏移量
                    offset=j;
                    i=i+offset;
                    break;
                }
            }
        }
        return NOT_FOUND;
    }

    public static void main(String[] args) {
        String[] parentStr = new String[]{"a", "b" ,"a" ,"c","a","a","b","a", "c", "a", "b","a","c","a","b","a","a","b","b"};
        String[] subStr = new String[]{"a","b","a","c"};//,"a","c","a","b"
        System.out.printf("index : "+ KMP.start(parentStr,subStr));
    }

}
