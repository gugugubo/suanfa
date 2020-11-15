package bobo.algo.likou.dongtaiguihua;

/**
 * @Author 古春波
 * @Description 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2020/10/29 10:14
 * @Version 1.0
 **/
public class timu338 {

    
    public int[] countBits(int num) {
        int[] memo = new int[num + 1 ];
        memo[0] = 0;
        for (int i = 1; i <= num; i ++){
            memo[i] = memo[i & (i -1 )]  + 1;
        }
        return memo;
    }
    
}
