package com.gdut.gcb.niuke.weiyunsuan;

/**
 * @Author 古春波
 * @Description 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/11/3 0:15
 * @Version 1.0
 **/
public class timu16 {

    /**
     * 利用二分法的思想进行计算
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x == 0) {
            return 0;
        }
        // 初始化 res=1
        double ret = 1.0;
        // Java 代码中 int32 变量 n∈[−2147483648,2147483647]
        // ，因此当 n=−2147483648 时执行 n=−n 会因越界而赋值出错。
        // 解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
        long b = n ;

        // 当 n<0 时：把问题转化至 n≥0的范围内，即执行 x=1/x ，n=−n 。
        if (b < 0){
            x = 1 /x ;
            b = -b;
        }
    

        //循环计算：当 n=0 时跳出。
        //
        //当 n&1=1时：将当前 x 乘入 res （即 res∗=x）。
        //执行 x=x2（即 x∗=x ）。
        //执行 n右移一位（即 n>>=1）。
        //
        //举例代入：x=3，b=5，那么b就是101，
        // 进入之后最后一个为1，然后x也为3-----合理
        // 循环之后之后一个变为了0，x变为3的平方
        // 循环之后之后一个变为了1，x变为3的立方
        while( b > 0 ){
            if (b % 2 == 1){
                ret *= x;
            }
            x *= x;
            b = b / 2;
        }
        
        return ret;
    }

    public static void main(String[] args) {
        double v = new timu16().myPow(2, 4);
        System.out.println(v);
    }
    
    
}
