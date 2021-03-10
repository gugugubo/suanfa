package com.gdut.gcb.niuke.zhanheduilie.dandiaozhan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @Author 古春波
 * @Description 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * @Date 2021/2/5 23:19
 * @Version 1.0
 **/
public class timu496 {

    /**
     * 我们首先把第一个元素 nums2[1] 放入栈，随后对于第二个元素 nums2[2]，如果 nums2[2] > nums2[1]，那么
     * 我们就找到了 nums2[1] 的下一个更大元素 nums2[2]，此时就可以把 nums2[1] 出栈并把 nums2[2] 入栈；
     * 如果 nums2[2] <= nums2[1]，我们就仅把 nums2[2] 入栈。对于第三个元素 nums2[3]，此时栈中有若干个元素，
     * 那么所有比 nums2[3] 小的元素都找到了下一个更大元素（即 nums2[3]），因此可以出栈，在
     * 这之后，我们将 nums2[3] 入栈，以此类推
     *
     *
     * 可以发现，我们维护了一个单调栈，栈中的元素从栈顶到栈底是单调不降的。当我们遇到一个新的元素 nums2[i] 时，
     * 我们判断栈顶元素是否小于 nums2[i]，如果是，那么栈顶元素的下一个更大元素即为 nums2[i]，我们将栈顶元素出栈。
     * 重复这一操作，直到栈为空或者栈顶元素大于 nums2[i]。此时我们将 nums2[i] 入栈，保持栈的单调性，
     * 并对接下来的 nums2[i + 1], nums2[i + 2] ... 执行同样的操作
     * 
     * 单调栈，从前往后进行遍历   对于数组nums[0..i] 的单调栈，就是对于每个数[i]的单调栈里面只存了比自己元素大的元素，所以栈顶元素一直就是nums[0..i]的最大元素 
     * 6
     * 2
     * 3
     * 4
     * 5
     *https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode/
     */
     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         Stack<Integer> stack = new Stack();
         HashMap<Integer, Integer> map = new HashMap<>();
         for (int i=0; i<nums2.length ; i++){
             // 注意可以不加等号，因为题目的条件是元素各不相等
             while (!stack.isEmpty() &&  stack.peek() < nums2[i]  ){
                 map.put(stack.pop(), nums2[i]);
             }
             stack.push(nums2[i]);
         }
         while (!stack.empty()){
             map.put(stack.pop(), -1);
         }
         for (int i = 0; i < nums1.length; i++) {
             nums1[i] = map.get(nums1[i]); 
         }
         return nums1;
     }


    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        HashMap<Integer, Integer> map = new HashMap<>();
        // 从后往前遍历
        for (int i=nums2.length -1 ; i>=0 ; i--){
            while (!stack.isEmpty() &&  stack.peek() < nums2[i]  ){
                stack.pop();
            }
            if (!stack.isEmpty()){
                map.put(nums2[i], stack.peek());
            }else {
                map.put(nums2[i], -1);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
     
     
     
    public static void main(String[] args) {
        int[] ints1 = new int[]{4,1,2};
        int[] ints2 = new int[]{1,3,4,2};
        timu496 timu496 = new timu496();
        int[] ints = timu496.nextGreaterElement(ints1, ints2);
        System.out.println(Arrays.toString(ints));
        int[] ints4 = new int[]{4,1,2};
        int[] ints5 = new int[]{1,3,4,2};
        int[] ints3 = timu496.nextGreaterElement2(ints4, ints5);
        System.out.println(Arrays.toString(ints3));
    }
    
}
