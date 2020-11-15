package com.gdut.gcb.likou.weiyunsuan;

/**
 * @Author 古春波
 * @Description 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 * @Date 2020/10/27 13:55
 * @Version 1.0
 **/
public class timu342 {

    /**
     * 二进制数中只有一个1，并且在奇数位
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & ( num -1 )) == 0  && (num & 0b0101010101010101) == 0;
    }
    
}
