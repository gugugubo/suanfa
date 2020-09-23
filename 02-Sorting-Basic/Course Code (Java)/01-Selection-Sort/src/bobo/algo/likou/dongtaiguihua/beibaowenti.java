package bobo.algo.likou.dongtaiguihua;

import java.util.Arrays;

/**
 * @Author 古春波
 * @Description 
 * 有一个背包,它的容量为C( Capacity),。现在有n种不同的物品,编号为0, n-1,
 * 其中每一件物品的重量为w(),价值为v()。问可以向这个背包中盛放哪些物品,
 * 使得在不超过背包容量的基础上,物品的总价值最大。
 * @Date 2020/9/22 21:15
 * @Version 1.0
 **/
public class beibaowenti {

    int[] w; int[] v ;

    /**
     * 用 [0...index]的物品,填充容积为c的背包的最大价值
     * index 为 行
     * c为 列
     */
    int[][] memo;
    
    /**
     * 自顶向下，记忆化搜索
     * 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
     * 空间复杂度: O(n * C)
     * @param w  每个物品的重量
     * @param v  每个物品的价值
     * @param c  背包的容量
     * @return
     */
    public int knapspack(int[] w, int[] v , int c) {
        if (w == null || v == null || w.length == 0 || v.length == 0 || w.length != v.length){
            return 0;
        }
        this.w = w;
        this.v = v;
        memo = new int[w.length][c + 1];
        for(int i = 0; i < w.length; i ++){
            for(int j = 0; j <= c; j ++){
                memo[i][j] = -1;
            }
        }
        System.out.println(memo);
        return recur(c, v.length -1);
    }
    /**
     * 用 [0...index]的物品,填充容积为c的背包的最大价值
     * @param c  背包的容量
     * @param index 
     * @return
     */
    private int recur(int c, int index ){
        if (c <= 0 || index < 0){
            return 0;
        }
        if (memo[index][c] != -1){
            return memo[index][c];
        }
        // 如果选择不放入这个index的物品
        int maxVal = recur(c , index -1);
        if (w[index] < c ){
            maxVal = Math.max(maxVal, v[index] +  recur(c - w[index], index-1 ));
        }
        memo[index][c] = maxVal;
        return memo[index][c];
    }

    public int knapspack2(int[] w, int[] v , int c) {
        if (w == null || v == null || w.length == 0 || v.length == 0 || w.length != v.length){
            return 0;
        }
        this.w = w;
        this.v = v;
        memo = new int[w.length][c + 1];
        
        memo[0][0] =  0;
        
        for (int i = 0 ; i<= c ; i ++){
            if (c > w[i]){
                memo[0][i] = v[i]; 
            }else {
                memo[0][i] = 0;
            }
        }
        
        for(int i = 1; i < w.length; i ++){
            for (int j = 0 ; j <= c ; j ++){
                int maxValue = memo[i -1 ][j];
                if (w[i] <= j){
                    maxValue = Math.max(maxValue, v[j] + memo[i - 1][j - w[j]]);
                }
                memo[i][j] = maxValue;
            }
        }
        
        return memo[w.length-1][c];
    }


}
