package com.gdut.gcb.likou.diguihehuisu;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/3/15 19:33
 * @Version 1.0
 **/
public class test {

        public static int minFlips(int a, int b, int c) {
            int ans = 0;
            while (c != 0 || a != 0 || b != 0) {
                // 二进制的第一位数字
                int cv = c & 1, av = a & 1, bv = b & 1;
                c >>= 1;
                a >>= 1;
                b >>= 1;
                // 不需要进行翻转
                if ((av | bv) == cv) {
                    continue;
                }
                // 需要进行翻转
                if (cv == 1) {
                    ans += 1;
                } else {
                    if (av == 1) {
                        ans += 1;
                    }
                    if (bv == 1) {
                        ans += 1;
                    }
                }
            }
            return ans;
        }


    public static void main(String[] args) {
        System.out.println(minFlips(2,265,123));
    }
}
