package com.gdut.gcb.niuke.zifuchuan;

/**
 * @Author 古春波 
 * @Description 字符串转换整数 (atoi)
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * @Date 2020/9/17 22:22
 * @Version 1.0、
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 **/
public class timu67 {

    /**
     * 使用迭代就可以解决问题了
     * MAX_VALUE： 2147483647
     * MIN_VALUE： -2147483648
     * @param str
     * @return
     */
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0){
            return 0;
        }
        
        int index = 1;
        int sign = 1;
        if (str.charAt(0) == '-'){
            sign = -1;
        }else if (str.charAt(0) != '+'){    
            index = 0;
        }
        int result = 0;
        int binary = Integer.MAX_VALUE / 10;
        for (; index < str.length(); index ++ ){
            if (str.charAt(index) > '9' || str.charAt(index) < '0'){
                break;
            }
            
            if (result > binary || result == binary && str.charAt(index) > '7' ){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(index) - '0');

        }
        return result * sign;
    }
    


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int i = new timu67().strToInt("2147483642");
        System.out.println(i);
    }

}
