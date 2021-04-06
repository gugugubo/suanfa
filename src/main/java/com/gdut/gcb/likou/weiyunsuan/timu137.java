package com.gdut.gcb.likou.weiyunsuan;

/**
 * @Author 古春波
 * @Description 137. 只出现一次的数字 II
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/2 16:08
 * @Version 1.0
 **/
public class timu137 {


    /**
     *     链接：https://leetcode-cn.com/problems/single-number-ii/solution/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/
     *     
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }


    //    链接：https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetcode/

    /**没看懂
     *
     第一次出现时，once和twice均为0，once^num相当于把num添加到once，表示num出现了一次，~once表示不把num添加到twice；
     第二次出现时，num已经添加到once了，num^num=0，once=0，相当于将num从once中删除，twice^num相当于把num添加到twice中；
     第三次出现时，第二次的twice为1，~twice为0，所以once依然为0，第三次的twice=num^num=0，相当于把num从twice中删除；

     这道题遍历结果：出现一次的num对应的once为1，twice为0；出现三次的num对应的once为0，twice也为0。 最终只需要返回once就行。
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;

        for (int num : nums) {
            // first appearence: 
            // add num to seen_once 
            // don't add to seen_twice because of presence in seen_once

            // second appearance: 
            // remove num from seen_once 
            // add num to seen_twice

            // third appearance: 
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }

        return seenOnce;
    }

 
}
