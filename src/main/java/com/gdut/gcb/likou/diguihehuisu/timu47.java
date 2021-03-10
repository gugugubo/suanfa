package com.gdut.gcb.likou.diguihehuisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @Date 2020/9/18 20:30
 * @Version 2.0
 * url https://leetcode-cn.com/problems/permutations/
 **/
public class timu47 {

    
    int[] nums;

    List<List<Integer>> result ;

    LinkedList<Integer> list ;
    
    boolean[] visited ;


    /**
     * 递归和回溯
     * 这题和timu17的区别就是，此题如果从nums取出一个数字，元素之间会互相影响，需要在nums减去这个数字，
     * 使用visited[] 数组来进行标记
     * 但是timu17中不用
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList();

        list = new LinkedList<>();
        
        this.nums = nums;
        if (nums.length == 0){
            return result;
        }
        visited = new boolean[nums.length];
        for (int i = 0 ;i < nums.length ;i ++){
            visited[i] = false;
        }
        recu(0);
        return result;
    }

    // list中保存了一个有index-1个元素的排列。
    // 向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
    private void recu(int index){
        // 这里也可以使用    if (tempList.size() == k){} 进行判断
        if (index == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0 ; i< nums.length ; i ++){
            if (visited[i] == false){
                visited[i] = true;
                list.addLast(nums[i]);
                recu(index + 1);
                visited[i] = false;
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        List<List<Integer>> permute = new timu47().permute(ints);
        System.out.println(permute.toString());
    }
}
