package com.gdut.gcb.niuke.dfsandbfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 古春波
 * @Description 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/10/3 23:15
 * @Version 1.0
 **/
public class timu13 {
    int[][] direction = {{0,1} , {1,0} , {0,-1} , {-1, 0}} ;
    boolean[][] visited ;
    int result ;
    
    int totalX;
    int totalY;
    int k ;

    // bfs
    public int movingCount3(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ;j < n ; j ++){
                visited[i][j] = false;
            }
        }

        Queue<int[]> queue = new LinkedList();
        int[] ints = {0, 0};
        queue.add(ints);
        int result = 0;
        while (queue.size() > 0){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            if (x >= m  ||   y >= n || visited[x][y] || !getNumSum(x , y, k) ){
                continue;
            }
            visited[x][y] = true;
            result++;
            queue.add( new int[]{x+ 1, y});
            queue.add( new int[]{x, y+ 1});
        }
        return result;
    }
    

    /**
     * dfs， 根据可达解的结构，易推出机器人可 仅通过向右和向下移动，访问所有可达解 
     */
    public int movingCount2(int m, int n, int k) {
        this.totalX = m;
        this.totalY = n;
        this.k = k;
        this.visited = new boolean[m][n];
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ;j < n ; j ++){
                this.visited[i][j] = false;
            }
        }
        return recur2(0, 0);
    }
    private int recur2(int startX, int startY){
        if (startX >= totalX || startY >= totalY || !getNumSum(startX , startY , k) || visited[startX][startY]){
            return 0;
        }
        visited[startX][startY] = true;
        return 1 + recur2(startX +1, startY ) + recur2(startX , startY +1 );
    }



    
    
    // dfs，自己做的递归
    public int movingCount(int m, int n, int k) {
        this.totalX = m;
        this.totalY = n;
        this.k = k;
        this.visited = new boolean[m][n];
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ;j < n ; j ++){
                this.visited[i][j] = false;
            }
        }
        
        recur(0,0);
        return result;
    }
    private void recur(int startX, int startY){
        if (!visited[startX][startY]  ){
            System.out.println(startX + "," + startY);
            result ++ ;
            visited[startX][startY] = true;
        }
        for (int i = 0 ; i < 4; i++){
            int newStartx = direction[i][0] + startX;
            int newStarty = direction[i][1] + startY;
            if (getNumSum(newStartx, newStarty, k) && ifregion(newStartx, newStarty) && !visited[newStartx][newStarty]){
                recur(newStartx, newStarty);
            }
        }
    }
    private boolean getNumSum(int newStartx , int newStarty , int k){
        int total = 0 ;
    
        while (newStartx != 0){
            total += newStartx % 10 ;
            newStartx = newStartx / 10;
        }
        while (newStarty != 0){
            total += newStarty % 10;
            newStarty = newStarty / 10;
        }
        return total <= k;
    }
    private  boolean ifregion(int newStartx , int newStarty){
        return newStartx < totalX && newStartx >= 0 && newStarty < totalY && newStarty >= 0;
    }

    public static void main(String[] args) {
        int i = new timu13().movingCount3(3, 2 , 17);
        System.out.println(i);
    }
}
