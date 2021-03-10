package com.gdut.gcb.likou.shaungzhizhen;

/**
 * @Author 古春波
 * @Description 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/28 11:30
 * @Version 1.0
 **/
public  class timu4 <A>{

   

    /**
     * 自己想的双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int mid = totalLength/2;
        // 如果两个数组总长度为奇数那么中位数应该加1
        if (totalLength%2==1){  
            mid++;
        }
        int i=0 , j=0, count=mid;
        while (i<nums1.length || j<nums2.length){
            int num1 = i>=nums1.length? Integer.MAX_VALUE : nums1[i];
            int num2 = j>=nums2.length? Integer.MAX_VALUE : nums2[j];
            int min = Math.min(num1, num2);
            if (num1>num2){
                j++;
            }else {
                i++;
            }
            count--;
            if (count==0){
                // 处理两个数组总长度为偶数的情况
                if (totalLength%2==0){
                    double res =0;
                    res += min;
                    num1 = i>=nums1.length? Integer.MAX_VALUE : nums1[i];
                    num2 = j>=nums2.length? Integer.MAX_VALUE : nums2[j];
                    min = Math.min(num1, num2);
                    res += min;
                    return res/2;
                }else {// 奇数直接返回
                    return min;
                }
            }
        }
        return 0;
    }

    /**
     * 使用二分法
     * 时间复杂度：每进行一次循环，我们就减少 k/2 个元素，所以时间复杂度是 O(log(k)，而 k=(m+n)/2，所以最终的复杂也就是 O(log(m+n）O(log(m+n）O(log(m+n）。
     * 空间复杂度：虽然我们用到了递归，但是可以看到这个递归属于尾递归，所以编译器不需要不停地堆栈，所以空间复杂度为 O(1)O(1)O(1)。
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + 
                getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }
    
    /**
     * 函数定义，在两个数组中找到第k小的数
     * @return
     */
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1 
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        /**
         * 上面两行代码可以改为：
         * if (len1 == 0) return nums2[start2 + k - 1];
         * if (len2 == 0) return nums1[start1 + k - 1];
         */
        
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
    
    
    
    public static void main(String[] args) {
        int[] ints1 = new int[]{};
        int[] ints2 = new int[]{1};
        timu4 timu4 = new timu4();
        double medianSortedArrays = timu4.findMedianSortedArrays(ints1, ints2);
        System.out.println(medianSortedArrays);
    }
    
}
