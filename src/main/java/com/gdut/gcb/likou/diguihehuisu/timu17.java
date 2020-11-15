package com.gdut.gcb.likou.diguihehuisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * @Date 2020/9/18 22:18
 * @Version 1.0
 * url https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 
 **/
public class timu17 {
    
    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    
    List<String> result = new ArrayList();

    String digits;
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return result;
        }
        this.digits = digits;
        String stringBuffer = new String("");
        recur(0,stringBuffer);
        return result;
    }
    
    
    public void recur(int index , String tempString){
        // 这里也可以使用    if (tempString.length() == digits.length()){} 进行判断
        if (index == digits.length()){
            result.add(tempString);
            return;
        }
        Character c = digits.charAt(index);
        if (c.compareTo('0') >= 0 &&
                c.compareTo('9') <= 0 &&
                c.compareTo('1') != 0){
            String s = letterMap[digits.charAt(index) - '0'];
            for (int i = 0 ; i< s.length() ; i ++){
                char ch = s.charAt(i);
//                tempString = tempString + ch;这样是不行的，结果错误； tempString应该保存本层递归的路径
                recur(index + 1, tempString + ch);
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = new timu17().letterCombinations("23");
        System.out.println(list);
    }
}
