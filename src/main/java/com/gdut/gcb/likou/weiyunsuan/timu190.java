package com.gdut.gcb.likou.weiyunsuan;

import java.util.HashMap;

/**
 * @Author 古春波
 * @Description 颠倒给定的 32 位无符号整数的二进制位。
 *
 *
 *
 * 示例 1：
 *
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/10/26 20:08
 * @Version 1.0
 **/
public class timu190 {

    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0 ; i < 32 ;  i ++){
            ret <<= 1;
            ret |= (n & 1);
            n >>>= 1;
        }
        return  ret;
    }

    private  static HashMap<Byte, Integer> cache = new HashMap<>();
    
    // 每8位 8位这样就行翻转
    public int reverseBits2(int n) {
        int ret = 0;
        for (int i = 0 ; i < 4 ;  i ++){
            ret <<= 8;
            ret |= subReverse((byte) (n & 0b11111111));
            n >>>= 8;
        }
        return  ret;
    }
    
    private int subReverse(byte bits){
        if (cache.containsKey(bits)){
            return cache.get(bits);
        }else {
            int ret = 0 ;
            byte t = bits;
            for (int i = 0 ; i < 8 ;  i ++){
                ret <<= 1;
                ret |= (bits & 1);
                bits >>>= 1;
            }
            cache.put(t, ret);
            return ret;
        }
    }

    public static void main(String[] args) {
//        int i = new timu190().reverseBits2(43261596);
//        System.out.println(i);
        
        int a = 14; 
        int b = 16;
        
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        
        System.out.println("a = " + a + "----" + "b = " + b);
    }
}
