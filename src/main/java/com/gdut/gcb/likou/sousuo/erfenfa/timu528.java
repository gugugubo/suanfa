package com.gdut.gcb.likou.sousuo.erfenfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author 古春波
 * @Description 528. 按权重随机选择
 * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
 *
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 *
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * 输出：
 * [null,0]
 * 解释：
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-with-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/4 19:08
 * @Version 1.0
 **/
public class timu528 {
    //权重累加数组
    int[] arr;


    /**
     * 对于w[i][1,3,5,6]我们需要根据权重获取随机数，所以需要从头开始将权重值进行逐步累积，累积后数组为：[1,4,9,15]，
     * 然后使用Random产生一个[1,15]之间的随机数，如果随机数落在[1]，对应元素为0，如果随机数落在[2,4]区间，对应元素为1，
     * 如果随机数落在[5,9]区间，对应元素为2，如果随机数落在[10,15]，对应元素为4。
     *
     * 作者：mmmmmJCY
     * 链接：https://leetcode-cn.com/problems/random-pick-with-weight/solution/java-er-fen-fa-by-zxy0917-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param w
     */
    public timu528(int[] w) {
        arr = new int[w.length];
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            arr[i] = sum;
        }
    }

    public int pickIndex() {
        //产生随机数
        Random random = new Random();
        int randomNum = random.nextInt(arr[arr.length - 1]) + 1;
        //二分查找随机数所在的区间
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == randomNum) {
                return mid;
            } else if (arr[mid] > randomNum) {
                // 如果比arr[mid]小，那么右边界不能舍弃
                right = mid;
            } else {
                // 如果比arr[mid]大，那么左边界要舍弃
                left = mid + 1;
            }
        }
        return left;
    }
    

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        timu528 timu528 = new timu528(nums);
        int count0 = 0;
        for (int i=0; i<100; i++){
            int i1 = timu528.pickIndex();
            if (i1==0){count0++;}
            System.out.println(i1);
        }
        System.out.println(count0);
    }
}
