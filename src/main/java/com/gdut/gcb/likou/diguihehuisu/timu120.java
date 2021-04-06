package com.gdut.gcb.likou.diguihehuisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 古春波
 * @Description   120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/23 9:45
 * @Version 1.0
 **/
public class  timu120 {
    int minVal = Integer.MAX_VALUE;
    LinkedList<Integer> path = new LinkedList<>();
    // 递归和回溯，会超时
    public int minimumTotal(List<List<Integer>> triangle) {
        path.add(triangle.get(0).get(0));
        recur(triangle, 1, 0);
        return minVal;
    }
    public void recur(List<List<Integer>> triangle, int n, int k){
        if( n== triangle.size() ){
            minVal = Math.min(getSum(path), minVal);
            return;
        }
        for(int i=k; i<=k+1; i++){
            path.add(triangle.get(n).get(i));
            recur(triangle, n+1, i );
            path.removeLast();
        }
    }

    public int getSum(List<Integer> path){
        int sum =0;
        for(int i=0; i<path.size(); i++){
            sum += path.get(i);
        }
        return sum;
    }


    int[][] dp ;
    public int minimumTotal2(List<List<Integer>> triangle) {
        dp= new int[triangle.size()][triangle.size()];
        for (int i=0; i<triangle.size();i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return  recur2(triangle, 0, 0);
    }
    // 返回第i层的第j个元素往下的最小路径和
    public int recur2(List<List<Integer>> triangle, int i, int j){
        if( i== triangle.size() ){
            return 0;
        }
        if (dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }
        dp[i][j] = Math.min(recur2(triangle, i+1, j), recur2(triangle, i+1, j+1)) + triangle.get(i).get(j);
        return  dp[i][j];
    }


    // dp
    public int minimumTotal3(List<List<Integer>> triangle) {
        // dp[i][j]表示 i 层 第j个以下的最小路径和
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];
        
        // dp[i][j] 可以从 dp[i+1][j] 或者 dp[i+1][j+1] 转移过来
        for (int i=triangle.size()-1; i>=0; i--){
            for (int j=i ; j>=0; j--){
                dp[i][j] = Math.min(dp[i+1][j] , dp[i+1][j+1] ) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    
    

    public static void main(String[] args) {
        timu120 timu120 = new timu120();
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(3);
        arrayList2.add(4);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(6);
        arrayList3.add(5);
        arrayList3.add(7);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(4);
        arrayList4.add(1);
        arrayList4.add(8);
        arrayList4.add(3);
        List<List<Integer>> ints = new ArrayList();
        ints.add(arrayList);
        ints.add(arrayList2);
//        ints.add(arrayList3);
//        ints.add(arrayList4);
        int i = timu120.minimumTotal3(ints);
        System.out.println(i);
    }
}
