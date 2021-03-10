package com.gdut.gcb.likou.shuxuejiqiao;

/**
 * @Author 古春波
 * @Description 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 *     每行中的整数从左到右按升序排列。
 *     每行的第一个整数大于前一行的最后一个整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/1 9:35
 * @Version 1.0
 **/
public class timu74 {

    /**
     * 参考timu240 做出来的
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=matrix.length-1; int j=0;
        while (i>=0 && j<=matrix[0].length-1){
            if (matrix[i][j]==target){
                return true;
            }else if (matrix[i][j]>target){
                i--;
            }else if (matrix[i][j]<target){
                j++;
            }
        }
        return false;
    }

    /**
     * 二分法
     * 由于该 虚 数组的序号可以由下式方便地转化为原矩阵中的行和列 (我们当然不会真的创建一个新数组) ，该有序数组非常适合二分查找。
     *
     *     row = idx // n ， col = idx % n。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix/solution/sou-suo-er-wei-ju-zhen-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix[0].length;
        int length=matrix.length * matrix[0].length;
        int i=0; int j=length;
        while (i<j){
            int mid = i+(j-i)/2;
            int row = mid/ n;
            int col = mid%n;
            if (matrix[row][col] == target){
                return true;
            }else if (matrix[row][col]>target){
                j=mid-1;
            }else if (matrix[row][col] < target){
                i=mid+1;
            }
        }
        int row = i/ n;
        int col = j%n;
        if (row>=matrix.length || col<0){
            return false;
        }
        return matrix[row][col]==target?true:false;
    }

    public static void main(String[] args) {
        timu74 timu74 = new timu74();
        int[][] ints = new int[][]{
                {1,3,5,7},{10,11,16,20},{23,30,34,60}  
        };
        timu74.searchMatrix2(ints, 10);
    }
}
