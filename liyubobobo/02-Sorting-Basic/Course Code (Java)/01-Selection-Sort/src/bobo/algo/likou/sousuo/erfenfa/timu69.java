package bobo.algo.likou.sousuo.erfenfa;

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

    public static void main(String[] args) {
        int i = new timu69().mySqrt(2);
        System.out.println(i);
    }
}
