package com.gdut.gcb.likou.shaungzhizhen;

/**
 * @Author 古春波
 * @Description 定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/11/8 23:35
 * @Version 1.0
 **/
public class timu633 {

    public boolean judgeSquareSum(int c) {
        int i = 0 ; int j = (int) Math.sqrt(c);
        
        while (i <= j ){
            if (i*i + j*j ==c){
                return true;
            }else if (i*i + j*j < c){
                i ++;
            }else {
                j--;
            }
        }
        
        return false;
        
    }
    
}
