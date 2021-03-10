package com.gdut.gcb.likou.diguihehuisu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author 古春波
 * @Description 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @Date 2020/10/8 10:08
 * @Version 2.0
 * 
 * 解题参考：https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
 **/
public class timu47_a2 {

    int n ;

    List<List<Integer>> result ;

    /**
     * 使用字符交换，可以将空间复杂度降低到O(1)
     */
    public List<List<Integer>> permute(int[] nums) {
        this.n = nums.length;
        this.result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        
        for (int i = 0; i<n ; i++){
            output.add(nums[i]);
        }
        recur(output, 0);
        return this.result;
    }
    
    public void recur(List<Integer> output , int index){
        
        if (index == n){
            result.add(new ArrayList<>(output));
            return;
        }
        
        for (int i = index ; i < n; i++){

            Collections.swap(output, index , i);
            
            recur(output, index + 1);

            Collections.swap(output, index , i);
        }
        
        
    }

    public static void main(String[] args) {
        new timu47_a2().permute(new int[]{1, 2, 3});
    }
    
}
