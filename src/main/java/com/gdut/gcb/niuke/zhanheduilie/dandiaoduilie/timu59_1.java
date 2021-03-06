package com.gdut.gcb.niuke.zhanheduilie.dandiaoduilie;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author 古 春波
 * @Description 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * @Date 2020/9/15 21:51
 * @Version 2.0
 * url https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 **/
public class timu59_1 {


    /**
     * 迭代法，使用双端队列解决
     * 时间复杂度 O(n) ： 其中 n 为数组 nums 长度；线性遍历 nums 占用 O(N) ；每个元素最多仅入队和出队一次，因此单调队列 deque 占用 O(2N)。
     * 空间复杂度 O(k) ： 双端队列 dequee 中最多同时存储 k 个元素（即窗口大小）。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return new int[0];
        }
        ArrayList<Integer> result = new ArrayList<>();
        // maxQueue中存的是nums索引值，而不是nums具体的数值
        LinkedList<Integer> maxQueue = new LinkedList<>();
        maxQueue.add(0);
        result.add(nums[0]);
        // nums[0..i] 的单调队列， 就是对于每个元素nums[i]的单调队列，只存了比nums[i]大的元素，所以队首元素一直就是nums[0..i]最大值    5 4 3 2 1 6
        for (int i =1 ;i< nums.length ; i ++){
            // 看看滑动窗口有没有滑出去
            if (i - maxQueue.getFirst() >= k){
                maxQueue.removeFirst();
            }
            
//            // 需要维护maxQueue队列中的值
//            int size =  maxQueue.size();
//            for (int j = 0 ;  j < size; j ++){
//                if (nums[maxQueue.get(j)]  < nums[i]){
//                    maxQueue.remove(j);
//                    size --;
//                    j  --;
//                }
//            }
            // 需要删去前面较小的值，因为前面的较小值不可能再成为队列的最大值了
            while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()] < nums[i]){
                maxQueue.removeLast();
            }

         
            maxQueue.addLast(i);
            result.add(nums[maxQueue.getFirst()]);
        }
        int[] res = new int[result.size() - k + 1 ];
        for (int i = 0; i < result.size() - k + 1 ;i ++){
            res[i] = result.get(i + k-1 );
        }
        return res;
    }


    // 自己做的
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0){
            return new int[0];
        }
        // 存最终的结果
        int[] res = new int[nums.length -k +1];
        LinkedList<Integer> list = new LinkedList();
        int i=0;
        while(i<nums.length){
            while(!list.isEmpty() && list.getLast() < nums[i]){
                list.removeLast();
            }
            list.add(nums[i]);
            if(i>=k-1){
                res[i-k+1] = list.getFirst();
                // 可能划出窗口了
                if(nums[i-k+1] == list.getFirst()){
                    list.removeFirst();
                }
            }
            i++;
        }
        return res;
    }
    
    
    
    
    public static void main(String[] args) {
//        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};[1,3,1,2,0,5]

        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] nums2 = new int[]{1,-1};
        int[] ints = new timu59_1().maxSlidingWindow(nums, 3);
        int[] ints2 = new timu59_1().maxSlidingWindow2(nums, 3);
        System.out.println(ints);
        System.out.println(ints2);
        for (int i = 0; i < ints.length; i++){
            System.out.print(ints[i]);
        }
    }
}
