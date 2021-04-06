package com.gdut.gcb.likou.shuxuejiqiao;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 古春波
 * @Description 523. 连续的子数组和
 * 给定一个包含 非负数 的数组和一个目标 整数 k ，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n * k ，其中 n 也是一个整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[23,2,4,6,7], k = 6
 * 输出：True
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/4 20:24
 * @Version 1.0
 **/
public class timu523 {

    public static void main(String[] args) {
        timu523 timu523 = new timu523();
        int[] nums = new int[]{23,2,4,6,7};
        timu523.checkSubarraySum(nums, 55);
    }


    /**
     *     链接：https://leetcode-cn.com/problems/continuous-subarray-sum/solution/lian-xu-de-zi-shu-zu-he-by-leetcode/
     * 
     * 具体解释参考另一个连接https://leetcode-cn.com/problems/continuous-subarray-sum/solution/qian-zhui-he-yu-intmapde-zai-ci-ying-yong-by-chris/
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;

        // key：区间 [0..i] 里所有元素的和 % k
        // value：下标 i
        Map<Integer, Integer> map = new HashMap<>();
        // 理解初始化的意义
        map.put(0, -1);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            // (preSum[i]−preSum[j])modk==0⟺preSum[i]modk==preSum[j]modk
            //
            //因此我们可以认为如果preSum[i]和preSum[j]在intMap中映射到了同一余数，即表示这样的子数组存在
            //
            //作者：christmas_wang
            //链接：https://leetcode-cn.com/problems/continuous-subarray-sum/solution/qian-zhui-he-yu-intmapde-zai-ci-ying-yong-by-chris/
            //来源：力扣（LeetCode）
            //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }

        }
        return false;
    }

    

    // 自己写的前缀和，两个测试示例超出时间限制
    public boolean checkSubarraySum2(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        // hashMap的key value 表示 前key个元素的前缀和为 value
        hashMap.put(0, 0);
        // i表示nums中的第i个数字
        for (int i=1; i<=nums.length; i++){
            sum += nums[i-1];
            for (int j=i-2; j>=0; j--){
                int i1 = sum - hashMap.get(j);
                if (i1 % k == 0){
                    return true;
                }
            }
            hashMap.put(i, sum);
        }
        return false;
    }
    
    
}
