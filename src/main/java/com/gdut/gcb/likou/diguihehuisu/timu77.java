package com.gdut.gcb.likou.diguihehuisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * @Date 2020/9/19 19:26
 * @Version 1.0
 * 
 * https://leetcode-cn.com/problems/combinations/
 **/
public class timu77 {

    int n ;
    int k ;

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> tempList = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        recur(1);
        return  result;
    }
    
    
    private void recur(int index ){
        if (tempList.size() == k){
            result.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index ; i <= n; i++){
            tempList.addLast(i);
            
            recur(i + 1);

            tempList.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new timu77().combine(4, 2);
        System.out.println(combine);
    }
}
