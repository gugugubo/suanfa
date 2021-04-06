package com.gdut.gcb.niuke.zhanheduilie.dandiaozhan;

/**
 * @Author 古春波
 * @Description  862. 和至少为 K 的最短子数组
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 *
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 1
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：A = [1,2], K = 4
 * 输出：-1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/23 11:01
 * @Version 1.0
 **/
public class  timu862 {

    
    
    
    // 自己做的暴力，会超时
    public int shortestSubarray(int[] A, int K) {
        int res = A.length;
        for(int i=0 ; i<A.length ; i++){
            for(int j=i; j<A.length; j++){
                boolean temp = getSum(A, i, j, K);
                if(temp){
                    res = Math.min(res, j-i+1);
                }
            }
        }
        return res== A.length? -1: res;
    }
    // 返回A数组中 i到 j 是否可以和为k
    public boolean getSum(int[] A, int i, int j, int k){
        int sum =0;
        for(int e=i; e<=j; e++){
            sum +=A[e];
        }
        return sum>=k;
    }

    public static void main(String[] args) {
        timu862 timu862 = new timu862();
        timu862.shortestSubarray(new int[]{1,2},4);
    }
}
