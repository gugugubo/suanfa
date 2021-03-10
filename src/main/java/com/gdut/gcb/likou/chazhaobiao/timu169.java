package com.gdut.gcb.likou.chazhaobiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author 古春波
 * @Description 169. 多数元素
 * 假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 *
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/25 23:21
 * @Version 1.0
 **/
public class timu169 {


    /**
     * https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i=0 ;i<nums.length ;i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }

        int res = 0; int key=0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> ele : entries){
            if (ele.getValue()> res){
                res = ele.getValue();
                key = ele.getKey();
            }
        }
        return key;
    }


    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    private int majorityElementRec(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    /**
     *     链接：https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     *     分治法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }


    /**
     *     链接：https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     *     投票法
     *
     如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
     如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


    public static void main(String[] args) {
        timu169 timu169 = new timu169();
        int[] ints = new int[]{3,2,3};
        int i = timu169.majorityElement(ints);
        System.out.println(i);
    }
    
}
