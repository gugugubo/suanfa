package com.gdut.gcb.likou.shuxuejiqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author 古春波
 * @Description 498. 对角线遍历
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 *
 *
 * 示例:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diagonal-traverse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/6 23:02
 * @Version 1.0
 **/
public class timu498 {


    /**
     *     链接：https://leetcode-cn.com/problems/diagonal-traverse/solution/dui-jiao-xian-bian-li-by-leetcode/
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // The two arrays as explained in the algorithm
        int[] result = new int[N*M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();


        /**
         * 使用一个外层循环遍历所有的对角线。第一行和最后一列的元素都是对角线的起点
         */
        for (int d = 0; d < N + M - 1; d++) {
            
            intermediate.clear();

            // 我们需要找出这个对角线的“头”
            // 第一行和最后一列中的元素是各自的头
            int r = d < M ? 0 : d - M + 1;   // d - M + 1 是指过了对角线的情况，r即横坐标的值为d-M+1
            int c = d < M ? d : M - 1;    // M-1是指过了对角线的情况，c即col坐标的值为M-1

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r < N && c > -1) {   // r < N是指过了对角线的情况的，   c > -1是指没过对角线的情况

                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            // Reverse even numbered diagonals. The
            // article says we have to reverse odd 
            // numbered articles but here, the numbering
            // is starting from 0 :P
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }
    
    
    
    
    /**
     * 自己做的，没做出来，只能输出一半的矩阵
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder2(int[][] matrix) {
        int[] res = new int[matrix.length  * matrix[0].length];
        int count=0;
        boolean turn = false;
        for (int i=0; i<matrix[0].length; i++){
            if (turn){
                for (int j=0 ; j<=i; j++){
                    res[count++] = matrix[j][i-j];
                }
                turn = false;
            }else {
                for (int j=i; j>=0 ; j--){
                    res[count++] = matrix[j][i-j];
                }
                turn = true;
            }
            
        }
        return res;
    }


    public static void main(String[] args) {

        timu498 timu498 = new timu498();
        int[][] ints = new int[][]{
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[] diagonalOrder = timu498.findDiagonalOrder(ints);
        System.out.println(Arrays.toString(diagonalOrder));
    }
}
