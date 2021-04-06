package com.gdut.gcb.likou.diguihehuisu;

/**
 * @Author 古春波
 * @Description 306. 累加数
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * <p>
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * <p>
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * <p>
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/4 17:37
 * @Version 1.0
 **/
public class timu306 {

    public static void main(String[] args) {
        timu306 timu306 = new timu306();
        timu306.isAdditiveNumber("112358");
    }


    //    链接：https://leetcode-cn.com/problems/additive-number/solution/xia-biao-zuo-wei-fen-duan-dian-dfs-by-over-lord/
    public boolean isAdditiveNumber(String num) {
        int i = 0;
        //第一个数字的起始下标一定是0，但是第二和第三个数字的起始下标不固定，需要通过两层循环枚举，在拿到起始数字之后，就可以dfs一直到最后验证是否整个字符串符合要求。
        for (int j = i + 1; j <= num.length() - 1; j++) {
            for (int k = j + 1; k <= num.length() - 1; k++) {
                if (dfs(num, i, j, k)) {
                    return true;
                }
            }
        }
        return false;
    }

    //dfs时的i,j,k分别代表第一个、第二个和第三个数字的起始下标，这样好处在于计算各个字符串时都很方便
    boolean dfs(String s, int i, int j, int k) {
        //这道题dfs的递归结束条件和普通稍有不同，要仔细思考。
        // 这里递归成功的标志是一直到字符串最后一个字符都满足要求，即是累加序列，那么我们需要看是否能够递归到最后一个位置正好结束。
        if ((s.charAt(i) == '0' && j - i > 1) || (s.charAt(j) == '0' && k - j > 1)) {
            return false;
        }
        // -----比对答案c++ 语法的修改------ substring
        // 下面是校验是否符合累加序列
        String a = s.substring(i, j );
        String b = s.substring(j, k);
        String sum = add(a, b);
        int n = sum.length();
        // -----比对答案c++ 语法的修改------  equals
        if (k + n - 1 > s.length() - 1 || !sum.equals(s.substring(k, k + n))) {
            return false;
        }
        // 刚好到结尾，那么就是正确的
        if (k + n - 1 == s.length() - 1) {
            return true;
        }
        return dfs(s, j, k, k + n);
    }

    String add(String a, String b) {
        int n1 = a.length() - 1;
        int n2 = b.length() - 1;
        int carry = 0;
        StringBuffer ans = new StringBuffer();
        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            int t1 = n1 >= 0 ? a.charAt(n1--) - '0' : 0;
            int t2 = n2 >= 0 ? b.charAt(n2--) - '0' : 0;
            // -----比对答案c++ 语法的修改------
            ans.append((t1 + t2 + carry) % 10);
            carry = (t1 + t2 + carry) >= 10 ? 1 : 0;
        }
        return ans.reverse().toString();
    }


}
