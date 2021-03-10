package com.gdut.gcb.niuke.zhanheduilie.dandiaozhan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @Author 古春波
 * @Description 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数； 
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/6 9:15
 * @Version 1.0
 **/
public class timu503 {


    /**
     * 2,1,2,4,3
     * 对于这种需求，常用套路就是将数组长度翻倍：
     * 这样，元素 3 就可以找到元素 4 作为 Next Greater Number 了，而且其他的元素都可以被正确地计算。
     *
     * 有了思路，最简单的实现方式当然可以把这个双倍长度的数组构造出来，然后套用算法模板。
     * 但是，我们可以不用构造新数组，而是利用循环数组的技巧来模拟数组长度翻倍的效果。
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums2) {
        Stack<Integer> stack = new Stack();
        int length = nums2.length;
        int[] res = new int[length];
        // 从后往前遍历
        for (int i=2 * length -1 ; i>=0 ; i--){
            // 注意加了等号
            while (!stack.isEmpty() &&  stack.peek() <= nums2[i%length]  ){
                stack.pop();
            }
            if (!stack.isEmpty()){
                res[i%length]  = stack.peek();
            }else {
                res[i%length] = -1;
            }
            stack.push(nums2[i%length]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] ints1 = new int[]{1,2,1};
        timu503 timu503 = new timu503();
        int[] ints = timu503.nextGreaterElement(ints1);
        System.out.println(Arrays.toString(ints));
    }
}
