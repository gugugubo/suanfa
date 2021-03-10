package com.gdut.gcb.likou.dfsandbfs;

/**
 * @Author 古春波
 * @Description 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * 示例 1：
 * 输入：m = 3, n = 7
 * 输出：28
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/18 16:01
 * @Version 1.0
 **/
public class timu62 {

    
    int res ;
    int m , n;

    /**
     * 自己做的递归，是正确的，就是复杂度太高了
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        recur(0,0);
        return res;
    }
    
    public void recur(int x, int y){
        if (x == m-1 && y == n-1){
            res++;
            return;
        }
        if (x == m || y == n){
            return;
        }
        recur(x+1, y);
        recur(x, y+1);
    }


    /**
     * 链接：https://leetcode-cn.com/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        // dp[i][j] 表示从左上角走到坐标i，j的路径数
        int[][] dp = new int[m][n];
        // base case
        for (int i=0; i<m;i++){
            dp[i][0] =1;
        }
        for (int i=0; i<n;i++){
            dp[0][i] = 1;
        }
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                dp[i][j]  = dp[i-1][j] + dp[i][j-1]; 
            }
        }
        return dp[m-1][n-1];
    }


    /**https://leetcode-cn.com/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/
     * 从左上角到右下角的过程中，我们需要移动 m+n−2m+n-2m+n−2 次，其中有 m−1m-1m−1 次向下移动，n−1n-1n−1 次向右移动。因此路径的总数，就等于从 m+n−2m+n-2m+n−2 次移动中选择 m−1m-1m−1 次向下移动的方案数，即组合数
     *
     * 组合数学
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths3(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            System.out.println(x);
            System.out.println(x-n);
            ans = ans * x / y;
        }
        return (int) ans;
    }

    
    public static void main(String[] args) {
        timu62 timu62 = new timu62();
//        int i = timu62.uniquePaths(23, 12);
//        System.out.println(i);

        int i2 = timu62.uniquePaths2(23, 12);
        int i3 = timu62.uniquePaths3(23, 12);
        System.out.println(i2);
    }
}
