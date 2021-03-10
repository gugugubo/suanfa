package com.gdut.gcb.likou.dfsandbfs;

/**
 * @Author 古春波
 * @Description 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/16 21:29
 * @Version 1.0
 **/
public class timu59 {

    int totalX;
    int totalY;

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        totalX = n;
        totalY = n;
        boolean [][] visited = new boolean[totalX][totalY];
        int total = totalX * totalY;
        // 依次按照向右，向下，向左，向上的次序遍历就可以实现这个螺旋的效果
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        int nextI=0;
        int newStartx =0;
        int newStarty =0;
        for (int i=1; i<=total ;i++){
            visited[newStartx][newStarty] = true;
            res[newStartx][newStarty] = i ;
            int nextRow = newStartx + direction[nextI][0], nextColumn = newStarty + direction[nextI][1];
            if (!ifregion(nextRow,nextColumn)  || visited[nextRow][nextColumn]){
                nextI = (nextI+1)%4;
            }
            newStartx = newStartx + direction[nextI][0];
            newStarty = newStarty + direction[nextI][1];
        }
        return res;
    }

    private  boolean ifregion(int newStartx , int newStarty){
        if (newStartx >= totalX || newStartx < 0 || newStarty >= totalY || newStarty < 0){
            return false;
        }
        return true;
    }
}
