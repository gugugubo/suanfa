package com.gdut.gcb.niuke.weiyunsuan;

/**
 * @Author 古春波
 * @Description 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/3 17:30
 * @Version 1.0
 **/
public class timu65 {

    public static void main(String[] args) {
        timu65 timu65 = new timu65();
        timu65.add(3,-8);
        timu65.add2(3,5);
    }


    /**
     * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
     * 
     * 解析：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/di-gui-he-fei-di-gui-liang-chong-fang-sh-as4v/
     * 上面这个讲得比较清楚
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        // b==0 表示所有二进制位都为0
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }


    /**
     * * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
     * 来自评论区，其实跟上面的一样，多写了几个变量而已
     * @param a
     * @param b
     * @return
     */
    public int add2(int a, int b) {
        int sum=a^b;
        int carry=(a&b)<<1;
        while(carry!=0){
            a=sum;
            b=carry;
            sum=a^b;
            carry=(a&b)<<1;
        }
        return sum;
    }
}
