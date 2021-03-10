package com.gdut.gcb.likou.dfsandbfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 古春波
 * @Description 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/16 18:25
 * @Version 1.0
 **/
public class timu54 {

    // 依次按照向右，向下，向左，向上的次序遍历就可以实现这个螺旋的效果
    int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    
    boolean[][] visited;

    int totalX;

    int totalY;
    
    List<Integer> res;

    int[][] matrix;


    /**
     * 解法参考：https://leetcode-cn.com/problems/spiral-matrix/solution/luo-xuan-ju-zhen-by-leetcode-solution/
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        totalX = matrix.length;
        if(totalX==0){
            return new int[0];
        }
        totalY = matrix[0].length;
        visited  = new boolean[totalX][totalY];
        res = new ArrayList<>();
        int total = totalX * totalY;


        int nextI=0;
        int newStartx =0;
        int newStarty =0;
        for (int i=0; i<total ;i++){
            visited[newStartx][newStarty] = true;
            res.add(matrix[newStartx][newStarty]);
            int nextRow = newStartx + direction[nextI][0], nextColumn = newStarty + direction[nextI][1];
            if (!ifregion(nextRow,nextColumn)  || visited[nextRow][nextColumn]){
                nextI = (nextI+1)%4;
            }
            newStartx = newStartx + direction[nextI][0];
            newStarty = newStarty + direction[nextI][1];
        }
        int[] result = new int[res.size()];
        for (int i=0 ; i<res.size() ;i++){
            result[i] = res.get(i);
        }
        return result;
    }



    private  boolean ifregion(int newStartx , int newStarty){
        if (newStartx >= totalX || newStartx < 0 || newStarty >= totalY || newStarty < 0){
            return false;
        }
        return true;
    }
}
