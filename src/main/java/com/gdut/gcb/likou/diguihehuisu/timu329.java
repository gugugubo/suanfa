package com.gdut.gcb.likou.diguihehuisu;

/**
 * @Author 古春波
 * @Description 329. 矩阵中的最长递增路径
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4 
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/4 19:41
 * @Version 1.0
 **/
public class timu329 {

    // https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/solution/ju-zhen-zhong-de-zui-chang-di-zeng-lu-jing-by-le-2/
    public static void main(String[] args) {
        timu329 timu329 = new timu329();
        int[][] nums = new int[][]{
                {9,9,4},{6,6,8},{2,1,1}
        };
        int[][] nums2 = new int[][]{{1,2}};
//        int i = timu329.longestIncreasingPath(nums);
//        System.out.println(i);
        int i2 = timu329.longestIncreasingPath(nums2);
        System.out.println(i2);
    }
    
    
    

    int[][] dir = new int[][]{
            {0,1},{1,0},{-1,0},{0,-1}
    };
    int maxCount = 0;
    boolean[][] visited ;

    // 下面是自己做的，有几个测试用例超时无法通过
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        this.visited = new boolean[m][n];
        for (int i=0; i<m ;i++){
            for (int j=0; j<n; j++){
                recur(matrix, m, n, i, j, 1);
            }
        }
        
        return maxCount;
    }
    
    public void recur(int[][] matrix, int m , int n, int i, int j,  int tempCount){
        
        if (tempCount > maxCount){
            maxCount = tempCount;
        }
        
        for (int k=0; k<4; k++){
            int i1 = dir[k][0] + i;
            int j1 = dir[k][1] + j;
            if (ifRegion(i1 ,j1, m, n) && !visited[i1][j1] && matrix[i1][j1] > matrix[i][j]){
                visited[i1][j1] = true;
                recur(matrix, m, n, i1, j1, tempCount +1);
                visited[i1][j1] = false;
            }
        }
    }
    
    
    public boolean ifRegion(int i, int j, int m, int n){
        if (i<0 || j>= n || i>=m || j<0){
            return false;
        }     
        return true;
    }
    
}
