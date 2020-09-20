package bobo.algo.likou.diguihehuisu;

import java.util.List;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2020/9/20 9:42
 * @Version 1.0
 * url https://leetcode-cn.com/problems/number-of-islands/
 **/
public class timu200 {
        
        int[][] direction = {{0,1} , {1,0} , {0,-1} , {-1, 0}} ;
        char[][] grid ;
        int totalx ;
        int totaly ;
        boolean[][] visited ;
        int temp ;
        int result =0;

    /**
     * 
     * 做完79题之后自己做出来的
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
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
                    if (!visited[i][j] &&grid[i][j] == '1'){
                        recur(i,j);
                    }
                    if (temp != 0){
                        result ++;
                    }
                }
            }
            return result;
        }
    
        private void recur(int startx, int starty){
            temp ++;
            visited[startx][starty] = true;
            for(int i = 0 ;i< 4;i++){
                int newStartx = startx + direction[i][0];
                int newStarty = starty + direction[i][1];
                if (ifregion(newStartx,newStarty) && !visited[newStartx][newStarty] &&grid[newStartx][newStarty] == '1'){
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

    public static void main(String[] args) {
        char[][] board2 ={{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int abcced2 = new timu200().numIslands(board2);
        System.out.println(abcced2);
    }
}
