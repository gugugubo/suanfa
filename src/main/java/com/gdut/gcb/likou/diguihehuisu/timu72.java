package com.gdut.gcb.likou.diguihehuisu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/1/31 20:01
 * @Version 1.0
 **/
public class timu72 {

    int[] nums;

    List<List<Integer>> result;

    LinkedList<Integer> list;


    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        list = new LinkedList<>();
        this.nums = nums;
        if (nums.length == 0) {
            return result;
        }
        recu(0);
        return result;
    }

    private void recu(int index) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.addLast(nums[i]);
            recu(i + 1);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3};
        List<List<Integer>> subsets = new timu72().subsets(ints);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

}
