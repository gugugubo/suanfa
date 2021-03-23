package com.gdut.gcb.likou.dongtaiguihua.tanxin.qujian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author 古春波  56. 合并区间
 * @Description 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 *
 * 返回这 两个区间列表的交集 。
 *
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 *
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interval-list-intersections
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/5 18:34
 * @Version 1.0
 **/
public class timiu56 {


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
     */
    public int[][] merge(int[][] intvs) {
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
        ArrayList<int[]> objects = new ArrayList<>();
        int lastLeft = intvs[0][0], lastRight = intvs[0][1];
        for (int i =1 ; i<intvs.length; i++){
            int left = intvs[i][0], right = intvs[i][1];
            if (left>=lastLeft && lastRight>=right){
                
            }else if (left<=lastRight && lastRight<right){
                lastRight = right;
            }else {
                objects.add(new int[]{lastLeft, lastRight});
                lastLeft = left;
                lastRight = right;
            }
        }
        objects.add(new int[]{lastLeft, lastRight});
        int[][] result = new int[objects.size()][intvs[0].length];
        for (int i=0; i<objects.size();i++){
            result[i] = objects.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]
                {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = new timiu56().merge(ints);
        System.out.println(Arrays.toString(merge[0]));
    }
}
