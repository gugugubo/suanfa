package com.gdut.gcb.likou.diguihehuisu;

import java.util.*;

/**
 * @Author 古春波
 * @Description 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 *     所有数字（包括 target）都是正整数。
 *     解集不能包含重复的组合。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/27 16:55
 * @Version 1.0
 **/
public class timu39 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        recu(candidates,target , 0);
        return res;
    }
    
    public void recu(int[] candidates, int target, int index){
        if (index>=candidates.length){
            return;
        }
        if (!path.isEmpty()){
            if (target==0){
                res.add(new ArrayList<>(path));
                return;
            }
        }

        recu(candidates,target, index+1);
        if (target - candidates[index]>=0){
            path.addLast(candidates[index]);
            recu(candidates, target - candidates[index], index);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        timu39 timu39 = new timu39();
        int[] ints = new int[]{1,2,3};
        List<List<Integer>> lists = timu39.combinationSum(ints, 2);
        for (List<Integer> list: lists){
            System.out.println(list);
        }
    }
    
}
