package com.gdut.gcb.likou.dfsandbfs;

/**
 * @Author 古春波
 * @Description 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例 1：
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 *
 * 示例 2：
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/20 9:31
 * @Version 1.0
 **/
public class timu64 {


    boolean[][] visited;
    int res ;
    int m , n;
    int[][] grid ;

    /**
     * 参考timu62改的，也是复杂度太高了，无法通过全部测试示例
     * @return
     */
    public int minPathSum2(int[][] grid) {
        this.grid = grid;
        int m=grid.length; int n = grid[0].length;
        visited = new boolean[m][n];
        res = Integer.MAX_VALUE;
        this.m = m;
        this.n = n;
        recur(0,0,0);
        return res;
    }
    public void recur(int x, int y, int preSum){
        if (x == m-1 && y == n-1){
            res = Math.min(res, preSum);
            return;
        }
        if (x == m || y == n || visited[x][y]){
            return;
        }
        preSum += grid[x][y];
        recur(x+1, y, preSum);
        recur(x, y+1, preSum);
    }


    /**
     * 链接：https://leetcode-cn.com/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/
     * 动态规划
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m=grid.length; int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        // 最后一列
        for (int i=m-2; i>=0;i--){
            dp[i][n-1] =grid[i][n-1] + dp[i+1][n-1];
        }
        // 最后一行
        for (int i=n-2; i>=0;i--){
            dp[m-1][i] = grid[m-1][i] + dp[m-1][i+1];
        }
        for (int i=m-2; i>=0; i--){
            for (int j=n-2; j>=0; j--){
                dp[i][j]  = grid[i][j]+Math.min(dp[i+1][j] , dp[i][j+1]);
            }
        }
        return dp[0][0];
    }

    public int minPathSum3(int[][] grid) {
        int m=grid.length; int n = grid[0].length;
        // 最后一列
        for (int i=m-2; i>=0;i--){
            grid[i][n-1] =grid[i][n-1] + grid[i+1][n-1];
        }
        // 最后一行
        for (int i=n-2; i>=0;i--){
            grid[m-1][i] = grid[m-1][i] + grid[m-1][i+1];
        }
        for (int i=m-2; i>=0; i--){
            for (int j=n-2; j>=0; j--){
                grid[i][j]  = grid[i][j]+Math.min(grid[i+1][j] , grid[i][j+1]);
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {1,2,3},{4,5,6}
        };
        timu64 timu64 = new timu64();
        int i = timu64.minPathSum(ints);
        System.out.println(i);
    }
    
    
}
