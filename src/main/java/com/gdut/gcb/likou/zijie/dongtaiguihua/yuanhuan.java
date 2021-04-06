package com.gdut.gcb.likou.zijie.dongtaiguihua;

/**
 * @Author 古春波
 * @Description 圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。
 *
 * 输入: 2
 * 输出: 2
 * 解释：有2种方案。分别是0->1->0和0->9->0
 * @Date 2021/4/4 11:39
 * @Version 1.0
 **/
public class yuanhuan {

    public static void main(String[] args) {
        // n 表示n步
        int n =2;
         //点的个数为10
        int length = 2;
        
        // dp[i][j]表示从0出发，走i步回到j的方案数
        int[][] dp = new int[n+1][length];
        
        dp[0][0] = 1;
        
        for (int i=1; i< n+1; i++){
            for (int j =0; j<length; j++){
                int tempI = j-1+length;
                int tempJ = (j+1);
                dp[i][j] =  dp[i-1][(j-1+length)%length] + dp[i-1][(j+1)%length];
            }
        }
        
        System.out.println(dp[n][0]);
    }
    
           
}
