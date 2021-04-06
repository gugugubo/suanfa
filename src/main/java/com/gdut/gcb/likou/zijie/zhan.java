package com.gdut.gcb.likou.zijie;

import java.util.Stack;

import static java.lang.Math.max;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/4/4 16:19
 * @Version 1.0
 **/
public class zhan {


    static int N = 5000 + 10;
    static int[] a = new int[N];
    static int[] dp = new int[N];
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) {
        int res = 0;
        int n = 3;
        int[] nums = new int[]{6,2,3};

        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
        }
        //前缀和便于快速求区间和，例如求[l,r]区间和=dp[r+1]-dp[l]。l和r的取值范围是[0,n)
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + a[i - 1];
        }
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && a[i] <= a[s.peek()]) {
                int peak = a[s.peek()];
                s.pop();
                int l = s.empty() ? -1 : s.peek();
                int r = i;
                //l和r是边界，因此区间是[l+1,r-1]，其区间和dp[r+1]-dp[l]
                int dist = dp[r] - dp[l + 1];
                res = max(res, peak * dist);
            }
            s.push(i);
        }
        while (!s.empty()) {
            int peak = a[s.peek()];
            s.pop();
            int l = s.empty() ? -1 : s.peek();
            int r = n;

            int dist = dp[r] - dp[l + 1];
            res = max(res, peak * dist);
        }
        System.out.println(res);
    }
}
