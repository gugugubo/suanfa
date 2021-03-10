package com.gdut.gcb.likou.huadongchuangkou;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/3/7 15:16
 * @Version 1.0
 **/
public class timu209 {

    
    
    
    public int minSubArrayLen(int target, int[] nums) {

        LinkedList<Integer> win = new LinkedList<>();
        int left=0; int right=0;
        int validSum =0;
        int minLength=Integer.MAX_VALUE;
        while (right < nums.length){
            win.add(nums[right]);
            validSum+=nums[right];
            right++;
            while (validSum >=target&&left<right){
                
                minLength = Math.min(minLength, win.size());
                left++;
                Integer integer = win.removeFirst();
                validSum = validSum-integer;
            }
        }
        return minLength==Integer.MAX_VALUE? 0 : minLength;
    }

    public static void main(String[] args) {
        timu209 timu209 = new timu209();
        int[] ints = new int[]{2,3,1,2,4,3};
        int i = timu209.minSubArrayLen(7, ints);
        System.out.println(i);
    }
    
}
