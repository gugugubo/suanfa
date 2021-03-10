package com.gdut.gcb.likou.sousuo.erfenfa.labuladong;

import java.util.Hashtable;

/**
 * @Author 古春波
 * @Description 875. 爱吃香蕉的珂珂
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 *
 *
 * 示例 1：
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/2/21 22:28
 * @Version 1.0
 **/
public class timu875 {


    /**
     * 二分法，因为求的是最小边界，所以返回得是左边界
     * 参考题解：https://labuladong.gitee.io/algo/%E9%AB%98%E9%A2%91%E9%9D%A2%E8%AF%95%E7%B3%BB%E5%88%97/koko%E5%81%B7%E9%A6%99%E8%95%89.html
     * @param piles
     * @param H
     * @return
     */
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1; int right = getMax(piles) +1;  // 可能的最大值加1
//        int left = 1; int right = getMax(piles);  这样也行
        
        while (left < right){
            int mid = left + (right-left) /2;
            if (canFinish(piles, mid) <=H){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

//        下面这样也行
//        while (left <= right){   改动一
//            int mid = left + (right-left) /2;
//            if (canFinish(piles, mid) <=H){
//                right = mid-1;  改动二
//            }else {
//                left = mid + 1;
//            }
//        }
        return left;
    }
    
    public int canFinish(int[] piles, int speed){
        int total =0;
        for (int i=0; i<piles.length ;i++){
            int num = piles[i];
            total += num / speed;
            total +=  (num % speed)>0? 1: 0;
        }
        return total;
    }
    
    public int getMax(int[] piles){
        int max = 0;
        for (int pile: piles){
            max = Math.max(max, pile);
        }
        return max;
    }

    public static void main(String[] args) {
        timu875 timu875 = new timu875();
        int[] ints = new int[]{3,6,7,11};
        int i = timu875.minEatingSpeed(ints, 8);

        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();
        objectObjectHashtable.put(2,222);
        objectObjectHashtable.put(1,23);
        objectObjectHashtable.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });
        objectObjectHashtable.keySet().stream();
        System.out.println(i);
    }
}
