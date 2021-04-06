package com.gdut.gcb.likou.zijie.erfenfa;

/**
 * @Author 古春波
 * @Description 给定长度为n的数组，每个元素代表一个木头的长度，木头可以任意截断，从这堆木头中截出至少k个相同长度为m的木块。已知k，求max(m)。
 *
 * 输入两行，第一行n, k，第二行为数组序列。输出最大值。
 *
 *     输入
 *     5 5
 *     4 7 2 10 5
 *     输出
 *     4
 *     解释：如图，最多可以把它分成5段长度为4的木头
 * @Date 2021/4/4 11:23
 * @Version 1.0
 **/
public class mutouqiege {


    static int N = 100010;
    static int a[] = new int[N];
    static int n, k;

    static int check(int mid) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += a[i] / mid;
        }
        return res;
    }

    public static void main(String[] args) {
        n = 5;
        k = 5;
        int[] nums = new int[]{4 ,7 ,2 ,10 ,5};


        int l = 1, r = -1;

        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
            r = Math.max(r, a[i]);
        }

        while (l < r) {
            // 注意一下这里，改了一下labuladong的代码
            int mid = l+(r - l + 1)/2 ;
            if (check(mid) >= k) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(l);
        System.out.println(r);
    }
}
