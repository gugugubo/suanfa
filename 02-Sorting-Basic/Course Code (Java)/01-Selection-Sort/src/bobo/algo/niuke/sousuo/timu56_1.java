package bobo.algo.niuke.sousuo;

/**
 * @Author 古春波
 * @Description 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @Date 2020/10/13 8:45
 * @Version 1.0
 **/
public class timu56_1 {


    /**异或：相同为0，不同才为1
     * 异或满足交换律，第一步异或，相同的数其实都抵消了，剩下两个不同的数。
     * 这两个数异或结果肯定有某一位为1，不然都是0的话就是相同数。找到这个位，
     * 不同的两个数一个在此位为0，另一个为1。按此位将所有数分成两组，分开后各自异或，
     * 相同的两个数异或肯定为0（而且分开的时候，两个数必为一组）。剩下的每组里就是我门要找的数。
     * @param nums 输入的数组
     * @return 返回两个数的下标
     */
    public int[] singleNumbers(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return null;
        }
        
        int k = 0;
        for (int num  : nums ){
            k = num ^ k;
        }
        
        int mask = 1;
        while ((mask & k) == 0){
            mask <<= 1 ;
        }
        
        int a = 0 , b = 0;
        for (int num : nums){
            if ((mask & num) == 0){
                a = a ^ num;
            }else {
                b = b ^ num;
            }
        }
        
        return new int[]{a, b};
    }
    
    
}
