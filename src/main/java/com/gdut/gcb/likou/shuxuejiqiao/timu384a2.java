package com.gdut.gcb.likou.shuxuejiqiao;

import java.util.Random;

/**
 * @Author 古春波
 * @Description timu384
 * @Date 2021/4/3 10:49
 * @Version 1.0
 **/
public class timu384a2 {

    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public timu384a2(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    // 洗牌算法简单证明可以参考这个：https://leetcode-cn.com/problems/shuffle-an-array/solution/da-luan-shu-zu-yi-ding-gong-ping-de-xi-p-21iy/
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }


}
