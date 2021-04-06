package com.gdut.gcb.likou.diguihehuisu;

/**
 * @Author 古春波
 * @Description 440. 字典序的第K小数字
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 *
 * 注意：1 ≤ k ≤ n ≤ 109。
 *
 * 示例 :
 *
 * 输入:
 * n: 13   k: 2
 *
 * 输出:
 * 10
 *
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/1 16:12
 * @Version 1.0
 **/
public class timu440 {


    public static void main(String[] args) {
        timu440 timu440 = new timu440();
        int kthNumber = timu440.findKthNumber(12, 5);
        System.out.println(kthNumber);
    }


    // https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/solution/ben-ti-shi-shang-zui-wan-zheng-ju-ti-de-shou-mo-sh/
    // 评论区
    public int findKthNumber(int n, int k) {
        int cur=1;//第一字典序小的(就是1)
        int prefix=1;// 前缀从1开始
        while(cur<k) {
            int tmp=count(n,prefix); //当前prefix峰的值
            if(tmp+cur>k) {// 找到了
                prefix*=10; //往下层遍历
                cur++;//一直遍历到第K个推出循环
            }else {
                prefix++;//去下个峰头(前缀)遍历
                cur+=tmp;//跨过了一个峰(前缀) 
            }
        }//退出循环时 cur==k 正好找到
        return prefix;
    }

    private int count(int n, int prefix) {
        //不断向下层遍历可能一个乘10就溢出了, 所以用long
        long cur=prefix;
        long next=cur+1;//下一个前缀峰头
        int count=0;
        while(cur<=n) {
            // 下一个前缀的起点减去当前前缀的起点，那么就是当前前缀下的所有子节点数总和啦。
            count+=Math.min(n+1,next)-cur;//下一峰头减去此峰头
            // 如果说刚刚prefix是1，next是2，那么现在分别变成10和20
            // 1为前缀的子节点增加10个，十叉树增加一层, 变成了两层

            // 如果说现在prefix是10，next是20，那么现在分别变成100和200，
            // 1为前缀的子节点增加100个，十叉树又增加了一层，变成了三层
            cur*=10;
            next*=10; //往下层走
        }
        return count;
    }
}
