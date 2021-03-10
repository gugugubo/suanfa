package com.gdut.gcb.likou.dongtaiguihua.tanxin.qujian;

import java.util.ArrayList;

/**
 * @Author 古春波
 * @Description public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
 *
 *     }
 * @Date 2021/2/5 18:34
 * @Version 1.0
 **/
public class timu986 {


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
