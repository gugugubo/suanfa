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
        double ret = 1.0;
        // Java 代码中 int32 变量 n∈[−2147483648,2147483647]
        // ，因此当 n=−2147483648 时执行 n=−n 会因越界而赋值出错。
        // 解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
        long b = n ;

        if (b < 0){
            x = 1 /x ;
            b = -b;
        }
    

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
