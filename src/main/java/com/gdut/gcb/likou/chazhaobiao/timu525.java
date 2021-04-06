package com.gdut.gcb.likou.chazhaobiao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 古春波
 * @Description 525. 连续数组
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/3 9:15
 * @Version 1.0
 **/
public class timu525 {

    public static void main(String[] args) {
        timu525 timu525 = new timu525();
        int[] nums = new int[]{0,0,1,1,0,0};
        int maxLength = timu525.findMaxLength(nums);
        System.out.println(maxLength);
    }


    /**
     * 前缀和的套路   
     * 可以把 (cnt, index) 看作是对的 nums[index] 的一种状态表示。
     * 比如 nums[3] 的状态是 (-2, 3)，它表示该元素以及它前面的所有元素中，0 比 1 多 2 个。
     * 那么你是否注意到 nums[7] 的状态是 (-2, 7)，它也表示该元素以及它前面的所有元素中，0 比 1 多 2 个呢？
     * 从中可以看出什么？
     * 这说明从第 index = 3 到 index = 7 的过程中，有相同个数的 0 和 1，才能让 cnt 保持为 -2！
     *
     * 作者：zwjago
     * 链接：https://leetcode-cn.com/problems/contiguous-array/solution/lian-xu-shu-zu-qian-zhui-he-ha-xi-biao-b-srnp/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int findMaxLength2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int cnt = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(cnt)) {
                maxLen = Math.max(maxLen, i - map.get(cnt));
            } else {
                map.put(cnt, i);
            }
        }

        return maxLen;
    }
    

    /**
     * 链接：https://leetcode-cn.com/problems/contiguous-array/solution/lian-xu-shu-zu-by-leetcode/
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int[] arr = new int[2 * nums.length + 1];
        // arr[i]=-2表示还没有出现count为i的位置 arr[nums.length]=-1是因为数组下标是从0开始的
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (arr[count + nums.length] >= -1) {
                maxlen = Math.max(maxlen, i - arr[count + nums.length]);
            } else {
                arr[count + nums.length] = i;
            }

        }
        return maxlen;
    }
    
    
}
