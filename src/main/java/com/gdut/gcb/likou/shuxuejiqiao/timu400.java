package com.gdut.gcb.likou.shuxuejiqiao;

/**
 * @Author 古春波
 * @Description 400. 第 N 位数字
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
 *
 *
 *
 * 注意：n 是正数且在 32 位整数范围内（n < 231）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：3
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/9 13:07
 * @Version 1.0
 **/
public class timu400 {


    /**
     * 1经过第一步计算我们可以得到第 365 个数字表示的数是三位数，n=365−9−90×2=176，digtis = 3。这时 n=176 表示目标数字是三位数中的第 176176176 个数字。
     *
     * 2我们设目标数字所在的数为 number，计算得到 number=100+176/3=158，idx 是目标数字在 number 中的索引，如果 idx = 0，表示目标数字是 number - 1 中的最后一个数字。
     *
     * 3根据步骤2，我们可以计算得到 idx = n % digits = 176 % 3 = 2，说明目标数字应该是 number = 158 中的第二个数字，即输出为 5。
     *
     * 作者：z1m
     * 链接：https://leetcode-cn.com/problems/nth-digit/solution/xiang-jie-zhao-gui-lu-by-z1m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        long num=n;

        long size=1;
        long max=9;

        while(n>0){
            //判断不在当前位数内
            if(num-max*size>0){
                num=num-max*size;
                size++;
                max=max*10;
            }else{
                long count=num/size;
                long left=num%size;
                if(left==0){
                    // 目标数字number为 ((long)Math.pow(10, size-1)+count)
                    // 如果 left = 0，表示目标数字是 number - 1 中的最后一个数字
                    System.out.println(((long)Math.pow(10, size-1)+count-1) );
                    return (int) (((long)Math.pow(10, size-1)+count-1)  %10);
                }else{
                    // 如果 left ！= 0，表示目标数字number为 ((long)Math.pow(10, size-1)+count)
                    System.out.println(((long)Math.pow(10, size-1)+count) );
                    System.out.println( ((long)Math.pow(10, (size-left))));
                    // ((long)Math.pow(10, (size-left))) 这个是为了去掉右边的数字
                    // %是为了去数字的最后一个数字
                    return (int) (  ((long)Math.pow(10, size-1)+count)  /  ((long)Math.pow(10, (size-left)))  %10);
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        timu400 timu400 = new timu400();
        System.out.println(timu400.findNthDigit(363));
    }
    
}
