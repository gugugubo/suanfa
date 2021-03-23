package com.gdut.gcb.likou.shuxuejiqiao;

import java.util.Random;

/**
 * @Author 古春波
 * @Description 470. 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 不要使用系统的 Math.random() 方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [7]
 *
 * 示例 2:
 *
 * 输入: 2
 * 输出: [8,4]
 *
 * 示例 3:
 *
 * 输入: 3
 * 输出: [8,1,10]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/17 22:55
 * @Version 1.0
 **/
public class timu470 {

    /**
     *     链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7/solution/xiang-xi-si-lu-ji-you-hua-si-lu-fen-xi-zhu-xing-ji/
     * @return
     */
    public int rand10() {
        // 首先得到一个数
        int num = (rand7() - 1) * 7 + rand7();
        // 只要它还大于40，那你就给我不断生成吧
        while (num > 40)
            num = (rand7() - 1) * 7 + rand7();
        // 返回结果，+1是为了解决 40%10为0的情况
        return 1 + num % 10;
    }
    public int rand7(){return new Random().nextInt(8);
    }


    public int Srand10() {
        while (true){
            int num = (rand7() - 1) * 7 + rand7();
            // 如果在40以内，那就直接返回
            if(num <= 40) return 1 + num % 10;
            // 说明刚才生成的在41-49之间，利用随机数再操作一遍
            num = (num - 40 - 1) * 7 + rand7();
            if(num <= 60) return 1 + num % 10;
            // 说明刚才生成的在61-63之间，利用随机数再操作一遍
            num = (num - 60 - 1) * 7 + rand7();
            if(num <= 20) return 1 + num % 10;

        }
    }

}
