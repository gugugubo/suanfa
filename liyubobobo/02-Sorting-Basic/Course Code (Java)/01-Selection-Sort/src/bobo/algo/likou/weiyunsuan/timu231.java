package bobo.algo.likou.weiyunsuan;

/**
 * @Author 古春波
 * @Description 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * @Date 2020/10/27 13:28
 * @Version 1.0
 **/
public class timu231 {

    /**
     * 二进制表示只有一个1存在就是2的幂次方
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        
        return n > 0 && Integer.bitCount(n) == 1;
    }


    /**
     * 利用 1000 & 0111 == 0 这种性质
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n) {

        return n > 0 && (n & ( n -1 )) == 0;
    }
}
