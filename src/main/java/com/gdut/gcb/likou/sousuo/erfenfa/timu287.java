package com.gdut.gcb.likou.sousuo.erfenfa;

/**
 * @Author 古春波
 * @Description 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/6 22:10
 * @Version 1.0
 **/
public class timu287 {


    /**
     * 可以使用二分法
     * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/xun-zhao-zhong-fu-shu-by-leetcode-solution/
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int left = 0; int right = nums.length;
        while (left<right){
            int mid = left + (right-left)/2;
            if (canFinish(nums, mid)){
                left = mid+1;
            }else {
                right= mid;
            }
        }
        return left;
    }
    public boolean canFinish(int[] nums , int mid){
        int count=0;
        for (int i=0; i<nums.length ;i++){
            if (nums[i]<=mid){
                count++;
            }
        }
        return count <=mid;
    }


    /**
     * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/kuai-man-zhi-zhen-de-jie-shi-cong-damien_undoxie-d/
     * 重复的元素就是环的入口：环的入口就是有两个指针指向它的
     * 其实，快慢指针法，就是一种 映射 操作， 链表 里面的 一次映射操作，就是 求 next，且 将位置 更新到 这里； 
     * 数组 这里，就是 根据 下标 i 求 nums[i] 这个元素值，且 将 下标 更新到这里。
     *
     * 链表里面 有环，即 一个节点 被不同的 节点指向（映射）；
     * 而 这里说的 数组 有环，即 数组中的一个元素值 被不同的 index 指向（映射）； 所以，求解方法 一样可以 使用 快慢指针法。
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    /**
     * 方法3比较巧妙，以至于把这题和”判圈“联系起来，floyd判圈反而要简单多了。正常情况下方法1应该算是短时间内能得到的解法。但其实方法2也很有趣，
     * 看不明白的小伙伴可以联想一下寻找多数元素时会使用的“bit voting”算法（当然比不上boyer-moore的O(n)），
     * 其实就是对每个比特去计数，当某元素占多数的时候，细化到每一个比特位而言去计算01出现次数，也会自然偏向这个元素对应的比特位。
     * 其实方法二正是voting算法。
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {
        int n = nums.length, ans = 0;
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }
        for (int bit = 0; bit <= bit_max; ++bit) {
            int x = 0, y = 0;
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y += 1;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }
        return ans;
    }
    
    
    
    public static void main(String[] args) {
        timu287 timu287 = new timu287();
        int[] ints = new int[]{1,3,4,2,2};
        int duplicate = timu287.findDuplicate(ints);
        System.out.println(duplicate);
    }
}
