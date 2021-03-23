package com.gdut.gcb.likou.dongtaiguihua.tanxin.qujian;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author 古春波
 * @Description  给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 * @Date 2020/9/26 20:38
 * @Version 2.0
 **/
public class timu435 {

    /**
     * 这题跟最长子序列很相似 likou.timu300 
     * 
     * 将问题转化为要保留的区间，再使用动态规划进行解题
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if (intervals.length < 2){
            return 0;
        }
        
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] != o2[0]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        // memo[i]表示以intervals[i]为结尾的区间能构成的最长不重叠区间序列
        int[] memo = new int[intervals.length];
        Arrays.fill(memo , 1);
        
        for (int i = 1 ; i< intervals.length ; i++){
            for (int j = 0; j < i ; j++){
                if ( intervals[i][0] >= intervals[j][1] && memo[i] < memo[j] + 1){
                    memo[i] = memo[j] + 1;
                }
            }
        }
        return intervals.length - memo[intervals.length -1 ];
    }


    /**
     * 使用贪心算法，按照区间的结尾排序，每次选择结尾最小的，且和前一个区间不重叠的区间
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals2(int[][] intervals) {
        if (intervals.length < 2){
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        // 表示第一个区间默认别选入了
        int res = 1;
        int pre = 0;
        for (int i = 1 ; i< intervals.length; i ++ ){
            if (intervals[i][0] >= intervals[pre][1]){
                pre = i;
                res ++;
            }
        }
        return intervals.length - res;
    }


    /**
     * 再次练习贪心解法
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals3(int[][] intervals) {
        if (intervals.length < 2){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        
        int result = 1;
        int pre = 0;
        for (int i=1; i<intervals.length ; i++){
            if (intervals[i][0] >= intervals[pre][1]){
                result++;
                pre = i;
            }
        }
        return intervals.length - result;
    }

        public static void main(String[] args) {
        int[][] ints = {{1,100}, {11,22}, {1,11}, {2,12}};
        int i1 = new timu435().eraseOverlapIntervals2(ints);
        System.out.println(i1);
    }
    
}
