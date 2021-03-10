package com.gdut.gcb.likou.shuxuejiqiao;

/**
 * @Author 古春波
 * @Description 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/9 11:30
 * @Version 1.0
 **/
public class timu670 {


    /**    链接：https://leetcode-cn.com/problems/maximum-swap/solution/zui-da-jiao-huan-by-leetcode/
     * 对比timu31,timu402
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        char[] charArray = s.toCharArray();

        // 记录每个数字出现的最后一次出现的下标
        int[] last = new int[10];
        for (int i = 0; i < len; i++) {
            last[charArray[i] - '0'] = i;
        }

        // 从左向右扫描，找到当前位置右边的最大的数字并交换
        for (int i = 0; i < len - 1; i++) {
            // 找最大，所以倒着找
            for (int d = 9; d > charArray[i] - '0'; d--) {
                if (last[d] > i) {
                    swap(charArray, i, last[d]);
                    // 只允许交换一次，因此直接返回
                    return Integer.parseInt(new String(charArray));
                }
            }
        }
        return num;
    }

    private void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }
    

   
    public static void main(String[] args) {
        timu670 timu670 = new timu670();
        int i = timu670.maximumSwap(42);
        System.out.println(i);
    }
}
