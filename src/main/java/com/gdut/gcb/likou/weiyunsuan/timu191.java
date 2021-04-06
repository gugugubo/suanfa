package com.gdut.gcb.likou.weiyunsuan;

/**
 * @Author 古春波
 * @Description 191. 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 *
 *
 * 提示：
 *
 *     请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 *     在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/7 9:45
 * @Version 1.0
 **/
public class timu191 {

    

    /**
     * 掩码
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }


    /**对比  timu338
     * 链接：https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
     * 在二进制表示中，数字 nnn 中最低位的 111 总是对应 n−1n - 1n−1 中的 000 。
     * 因此，将 nnn 和 n−1n - 1n−1 与运算总是能把 nnn 中最低位的 111 变成 000 ，并保持其他位不变。
     * 使用这个小技巧，代码变得非常简单。
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

}
