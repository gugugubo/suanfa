package com.gdut.gcb.likou.dongtaiguihua.tanxin.qujian;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author 古春波
 * @Description 1288. 删除被覆盖区间
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 *
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 *
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 *
 *
 * 示例：
 *
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 *
 * https://leetcode-cn.com/problems/remove-covered-intervals/solution/shan-chu-bei-fu-gai-qu-jian-by-leetcode-2/
 * @Date 2021/2/5 18:07
 * @Version 1.0
 **/
public class timu1288 {


    /**
     * 参考下面链接的解法，将区间之间可能的情况画出来，然后发现按一下算法是可以计算出需要删除的区间，从而返回剩余的区间
     * 
     * -----  此区间和其它区间的可能情况如下，我们需要关注的就是需要被覆盖的区间
     *  ---
     *   ----
     *       ----
     *  
     *  -----  此区间和其它区间的可能情况如下
     *   ----
     *   ---
     *        ----      
     * https://leetcode-cn.com/problems/remove-covered-intervals/solution/shan-chu-bei-fu-gai-qu-jian-by-leetcode-2/
     * @param intvs
     * @return
     */
    int removeCoveredIntervals(int[][] intvs) {
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    // 注意这里是倒叙
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        
        int lastLeft = intvs[0][0], lastRight = intvs[0][1];
        int count = 0;
        for (int i =1 ; i<intvs.length; i++){
            int left = intvs[i][0], right = intvs[i][1];
            if (left>=lastLeft && lastRight>=right){
                count++;
            }else {
                lastLeft = left;
                lastRight = right;
            }
        }
        return intvs.length-count;
    }

    /**
     * 贪心，labuladong的解法
     * @param intvs
     * @return
     */
    int removeCoveredIntervals2(int[][] intvs) {
        // 按照起点升序排列，起点相同时降序排列
        Arrays.sort(intvs, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // 记录合并区间的起点和终点
        int left = intvs[0][0];
        int right = intvs[0][1];

        int res = 0;
        for (int i = 1; i < intvs.length; i++) {
            int[] intv = intvs[i];
            // 情况一，找到覆盖区间
            if (left <= intv[0] && right >= intv[1]) {
                res++;
            }
            // 情况二，找到相交区间，合并
            if (right >= intv[0] && right <= intv[1]) {
                left = intv[0];
                right = intv[1];
            }
            // 情况三，完全不相交，更新起点和终点
            if (right < intv[0]) {
                left = intv[0];
                right = intv[1];
            }
        }

        return intvs.length - res;
    }
}
