package com.gdut.gcb.likou.diguihehuisu;

/**
 * @Author 古春波
 * @Description 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 *
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/18 23:37
 * @Version 1.0
 **/
public class timu695 {




    int[][] direction = {{0,1} , {1,0} , {0,-1} , {-1, 0}} ;
    int[][] grid ;
    int totalx ;
    int totaly ;
    boolean[][] visited ;
    int temp ;
    int result =0;

    /**
     *
     * 参考题目200
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;

        totalx = grid.length;
        if (totalx == 0){
            return 0;
        }
        totaly = grid[0].length;
        visited = new boolean[totalx][totaly];
        for (int i =0 ;i< totalx; i++){
            for (int j = 0; j< totaly;j ++){
                visited[i][j] =  false;
            }
        }

        for (int i =0 ;i< totalx; i++){
            for (int j = 0; j< totaly;j ++){
                temp = 0;
                if (!visited[i][j] &&grid[i][j] == 1){
                    recur(i,j);
                }
                if (temp != 0){
                    // 对比200，仅仅修改了此处代码
                    result = Math.max(result, temp);
                }
            }
        }
        return result;
    }

    // 标记从坐标（startx，starty）的点出发所能到达的所有点
    private void recur(int startx, int starty){
        temp ++;
        visited[startx][starty] = true;
        for(int i = 0 ;i< 4;i++){
            int newStartx = startx + direction[i][0];
            int newStarty = starty + direction[i][1];
            if (ifregion(newStartx,newStarty) && !visited[newStartx][newStarty] && grid[newStartx][newStarty] == 1){
                recur(newStartx,newStarty);
            }
        }
    }

    private  boolean ifregion(int newStartx , int newStarty){
        if (newStartx >= totalx || newStartx < 0 || newStarty >= totaly || newStarty < 0){
            return false;
        }
        return true;
    }
}
