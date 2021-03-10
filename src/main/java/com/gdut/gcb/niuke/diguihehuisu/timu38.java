package com.gdut.gcb.niuke.diguihehuisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * @Date 2020/10/6 22:32
 * @Version 2.0
 **/
public class timu38 {

    char[] nums;

    List<String> result ;

    LinkedList<Character> list ;

    boolean[] visited ;

    String s;


    

    /**
     * 递归和回溯
     * 这题和timu17的区别就是，此题如果从nums取出一个数字，元素之间会互相影响，需要在nums减去这个数字，
     * 使用visited[] 数组来进行标记
     * 但是timu17中不用
     * @return
     */
    public String[] permutation(String s) {
        result = new ArrayList();
        list = new LinkedList<>();
        this.s  =  s;
        this.nums = s.toCharArray();
        if (nums.length == 0){
            return null;
        }
        visited = new boolean[nums.length];
        for (int i = 0 ;i < nums.length ;i ++){
            visited[i] = false;
        }
        recu(0);
        
        String[] strings = new String[result.size()];
        for (int i = 0 ; i< result.size(); i++){
            System.out.println(result.get(i));
            strings[i] = result.get(i);
        }
        
        return strings;
    }

    /**
     * p中保存了一个有index-1个元素的排列。向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
     */
    private void recu(int index){
        // 这里也可以使用    if (tempList.size() == k){} 进行判断
        if (index == nums.length){
            String string = toString(list);
            if (!result.contains(string)){
                result.add(string);
            }
            return;
        }

        for (int i = 0 ; i< nums.length ; i ++){
            if (visited[i] == false ){
                visited[i] = true;
                list.addLast(nums[i]);
                recu(index + 1);
                visited[i] = false;
                list.removeLast();
            }
        }
    }

    public String toString(LinkedList<Character> str){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.size(); i++){
            sb.append(str.get(i));
        }
        String s = sb.toString();
        return s;
    }
   
    public static void main(String[] args) {
       new timu38().permutation("dkjphedy");
    }
}
