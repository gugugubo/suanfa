package com.gdut.gcb.likou.shuxuejiqiao;

/**
 * @Author 古春波
 * @Description 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 *     每行的元素从左到右升序排列。
 *     每列的元素从上到下升序排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/18 15:12
 * @Version 1.0
 **/
public class timu240 {

    /**https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/
     * 方法4
     * 这个二维数组就类似一棵排序二叉树，对于每一个数来说，上方的数都小于它，右边的数都大于它，所以把左下角作为根节点开始查找！
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int x = row-1 ; int y = 0;
        while (x>=0 && y<col){
            if (matrix[x][y] > target){
                x--;
            }else if (matrix[x][y] == target){
                return true;
            }else {
                y++;
            }
        }
        return false;
    }


    /**
     * 二分法搜索
     * 在对角线上迭代，二分搜索行和列，直到对角线的迭代元素用完为止（意味着我们可以返回 false ）或者找到目标（意味着我们可以返回 true ）。binary search 函数的工作原理和普通的二分搜索一样,但需要同时搜索二维数组的行和列。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-by-leetcode-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // iterate over matrix diagonals
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix[0].length-1 : matrix.length-1;

        while (hi >= lo) {
            int mid = (lo + hi)/2;
            if (vertical) { // searching a column
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            } else { // searching a row
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

}
