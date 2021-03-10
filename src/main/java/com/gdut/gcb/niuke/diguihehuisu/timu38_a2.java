package com.gdut.gcb.niuke.diguihehuisu;

import java.util.*;

/**
 * @Author 古春波
 * @Description 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * @Date 2020/10/8 11:24
 * @Version 2.0
 **/
public class timu38_a2 {

    int n ;
    List<String> result ;



    
    /**
     * 使用字符交换，可以将空间复杂度降低到O(1)
     */
    public String[] permutation(String s) {
        this.n = s.length();
        this.result = new ArrayList<>();
        List<Character> output = new ArrayList<>();

        for (int i = 0; i<n ; i++){
            output.add(s.charAt(i));
        }
        recur(output, 0);
        String[] strings = new String[result.size()];
        for (int i = 0 ;i < result.size() ;i ++){
            strings[i] = result.get(i);
        }
        return strings;
    }

    public void recur(List<Character> output , int index){

        if (index == n){
            result.add(toString(output));
            return;
        }

        HashSet<Character> set = new HashSet<>();

        for (int i = index ; i < n; i++){
            if (set.contains( output.get(i) )){
                continue;
            }
            set.add(output.get(i));
            
            Collections.swap(output, index , i);

            recur(output, index + 1);

            Collections.swap(output, index , i);
        }
    }


    public String toString(List<Character> str){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.size(); i++){
            sb.append(str.get(i));
        }
        String s = sb.toString();
        return s;
    }
}
