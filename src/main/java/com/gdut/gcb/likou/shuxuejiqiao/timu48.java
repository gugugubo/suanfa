package com.gdut.gcb.likou.shuxuejiqiao;

/**
 * @Author 古春波
 * @Description 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/18 9:24
 * @Version 1.0
 **/
public class timu48 {


    /**先将其通过水平轴翻转，再根据主对角线翻转得到
     * 参考解法：https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m/
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 进行水平翻转
        for (int i=0; i<row/2; i++){
            for (int j =0; j<col; j++){
                swap(matrix, i, j, row-i-1, j);
            }
        }
        
        // 进行根据主对角线翻转
        for (int i=0; i<row; i++){
            for (int j=i+1; j<col; j++){
                swap(matrix, i,j, j, i);
            }
        }
        
    }
    
    public void swap(int[][] matrix , int i ,int j , int toI , int toJ){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[toI][toJ];
        matrix[toI][toJ] = temp;
    }
    
}
