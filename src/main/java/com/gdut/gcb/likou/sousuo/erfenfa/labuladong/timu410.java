package com.gdut.gcb.likou.sousuo.erfenfa.labuladong;

/**
 * @Author 古春波
 * @Description 410. 分割数组的最大值
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 *
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [7,2,5,10,8], m = 2
 * 输出：18
 * 解释：
 * 一共有四种方法将 nums 分割为 2 个子数组。 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/25 9:20
 * @Version 1.0
 **/
public class timu410 {


    /**
     * 二分法
     * 参考题解： https://labuladong.gitee.io/algo/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/%E4%BA%8C%E5%88%86%E5%88%86%E5%89%B2%E5%AD%90%E6%95%B0%E7%BB%84.md
     * @param nums
     * @param m
     * @return
     */
    int splitArray(int[] nums, int m) {
        // 一般搜索区间是左开右闭的，所以 hi 要额外加一
        int lo = getMax(nums), hi = getSum(nums) + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // 根据分割子数组的个数收缩搜索区间
            int n = split(nums, mid);
            if (n == m) {
                // 收缩右边界，达到搜索左边界的目的
                hi = mid;
            } else if (n < m) {
                // 最大子数组和上限高了，减小一些
                hi = mid;
            } else if (n > m) {
                // 最大子数组和上限低了，增加一些
                lo = mid + 1;
            }
        }
        return lo;
    }

    /* 辅助函数，若限制最大子数组和为 max，
    计算 nums 至少可以被分割成几个子数组 */
    int split(int[] nums, int max) {
        // 至少可以分割的子数组数量
        int count = 1;
        // 记录每个子数组的元素和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > max) {
                // 如果当前子数组和大于 max 限制
                // 则这个子数组不能再添加元素了
                count++;
                sum = nums[i];
            } else {
                // 当前子数组和还没达到 max 限制
                // 还可以添加元素
                sum += nums[i];
            }
        }
        return count;
    }

    // 计算数组中的最大值
    int getMax(int[] nums) {
        int res = 0;
        for (int n : nums)
            res = Math.max(n, res);
        return res;
    }

    // 计算数组元素和
    int getSum(int[] nums) {
        int res = 0;
        for (int n : nums)
            res += n;
        return res;
    }
    
}
