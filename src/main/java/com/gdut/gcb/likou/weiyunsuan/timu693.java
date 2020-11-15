package com.gdut.gcb.likou.weiyunsuan;

/**
 * @Author 古春波
 * @Description 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/10/27 11:51
 * @Version 1.0
 **/
public class timu693 {


    /**
     * 移位运算和异或运算
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        // n =         0101   1010
        // 移位之后变为 0010   1101
        // 异或之后变为 0111   0111
        // 这里是算术右移，其实逻辑右移也可以
        int a = n ^ (n >> 1);
        // 判断a 是否为 1111
        return (a & ( a + 1)) == 0;
    }

    public boolean hasAlternatingBits2(int n) {
        // n =         0101   1010
        // 移位之后变为 0010   0101
        // 异或之后变为 0111   1111
        // 这里是逻辑右移
        int a = n ^ (n >>> 1);
        // 判断a 是否为 1111
        return (a & ( a + 1)) == 0;
    }

    public static void main(String[] args) {
        
    }
}
