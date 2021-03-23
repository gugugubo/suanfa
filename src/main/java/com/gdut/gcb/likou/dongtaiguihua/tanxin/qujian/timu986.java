package com.gdut.gcb.likou.dongtaiguihua.tanxin.qujian;

import java.util.ArrayList;

/**
 * @Author 古春波
 * @Description 986. 区间列表的交集
 *给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 *
 * 返回这 两个区间列表的交集 。
 *
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 *
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/5 18:34
 * @Version 1.0
 **/
public class  timu986 {


    /**
     * 我们用[a1,a2]和[b1,b2]表示在A和B中的两个区间
     * if b2 < a1 or a2 < b1:
     *     [a1,a2] 和 [b1,b2] 无交集
     *     # 不等号取反，or 也要变成 and
     * if b2 >= a1 and a2 >= b1:
     *     [a1,a2] 和 [b1,b2] 存在交集
     * @param firstList
     * @param secondList
     * @return
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;

        ArrayList<int[]> result = new ArrayList<>();
        while (i<firstList.length && j<secondList.length){
            int a1 = firstList[i][0], a2 = firstList[i][1];
            int b1 = secondList[j][0], b2 = secondList[j][1];
            
            if (b2>=a1&&a2>=b1){
                result.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            if (a2>b2){
                j++;
            }else {
                i++;
            }
        }
        int[][] res = new int[result.size()][2];
        for (int k=0;k<result.size();k++){
            res[k] = result.get(k);
        }
        return res;
    }

    public static void main(String[] args) {
        timu986 timu986 = new timu986();
        int[][] ints1 = new int[][]{
                {0,2},{5,10},{13,23},{24,25}
        };
        int[][] ints2 = new int[][]{
                {1,5},{8,12},{15,24},{25,26}
        };
        timu986.intervalIntersection(ints1, ints2);
    }
    
}
