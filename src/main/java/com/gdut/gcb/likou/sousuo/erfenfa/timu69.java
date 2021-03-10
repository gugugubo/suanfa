package com.gdut.gcb.likou.sousuo.erfenfa;

/**
 * @Author 古春波
 * @Description 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/11/9 17:27
 * @Version 1.0
 **/
public class timu69 {


    /**
     * 一个数 x 的开方 sqrt 一定在 0 ~ x 之间，并且满足 sqrt == x / sqrt。可以利用二分查找在 0 ~ x 之间查找 sqrt。
     *
     * 对于 x = 8，它的开方是 2.82842...，最后应该返回 2 而不是 3。在循环条件为 l <= h 并且循环退出时，
     * h 总是比 l 小 1，也就是说 h = 2，l = 3，因此最后的返回值应该为 h 而不是 l。
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        
        if (x <= 1){
            return x;
        }
        
        int left = 0 ; int right = x;
        while (left <= right){
            int mid = left + (right - left) / 2;
            int sqrt = x / mid; 
            if (sqrt == mid){
                return sqrt;
            }else if (mid > sqrt){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }


    /**
     * 使用 < 号
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x <= 1){
            return x;
        }

        int left = 0 ; int right = x;
        while (left <right){
            int mid = left + (right - left) / 2;
            int sqrt = x / mid;
            if (sqrt == mid){
                return sqrt;
            }else if (mid > sqrt){
                right = mid ;
            }else {
                left = mid + 1;
            }
        }
        if (left * left == x){
            return left;
        }
        return left-1;
    }

    public static void main(String[] args) {
        int i = new timu69().mySqrt(2);
        System.out.println(i);
    }
}
