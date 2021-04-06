package com.gdut.gcb.niuke.sousuo;

/**
 * @Author 古春波
 * @Description 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/2 21:26
 * @Version 1.0
 **/
public class timu62 {

    /**
     * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }


    /**
     * 然后我们从最后剩下的 3 倒着看，我们可以反向推出这个数字在之前每个轮次的位置。
     *
     * 最后剩下的 3 的下标是 0。
     *
     * 第四轮反推，补上 mmm 个位置，然后模上当时的数组大小 222，位置是(0 + 3) % 2 = 1。
     *
     * 第三轮反推，补上 mmm 个位置，然后模上当时的数组大小 333，位置是(1 + 3) % 3 = 1。
     *
     * 第二轮反推，补上 mmm 个位置，然后模上当时的数组大小 444，位置是(1 + 3) % 4 = 0。
     *
     * 第一轮反推，补上 mmm 个位置，然后模上当时的数组大小 555，位置是(0 + 3) % 5 = 3。
     *
     * 所以最终剩下的数字的下标就是3。因为数组是从0开始的，所以最终的答案就是3。
     *
     * 总结一下反推的过程，就是 (当前index + m) % 上一轮剩余数字的个数。
     *
     * 作者：sweetieeyi
     * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 
     */
    public int lastRemaining2(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

}
