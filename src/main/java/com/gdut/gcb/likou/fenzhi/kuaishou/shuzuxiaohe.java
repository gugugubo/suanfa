package com.gdut.gcb.likou.fenzhi.kuaishou;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/4/4 12:06
 * @Version 1.0
 **/
public class shuzuxiaohe {

    static int N = 1000;
    static int nums[] = new int[N];
    static int temp[] = new int[N];

    //long long是因为结果可能爆int
    static Long merge(int a[], int l, int mid, int r) {
        int i = l, j = mid + 1, k = 0;
        Long res = Long.valueOf(0);
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {
                res += (r - j + 1) * a[i];
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= r) {
            temp[k++] = a[j++];
        }
        for (i = l, k = 0; i <= r; i++) {
            a[i] = temp[k++];
        }
        return res;
    }

    static Long getSmallSum(int a[], int l, int r) {
        if (l == r) {
            return Long.valueOf(0);
        }
        int mid = (l + r) / 2;
        Long L = getSmallSum(a, l, mid), R = getSmallSum(a, mid + 1, r);
        Long c = merge(a, l, mid, r);
        return L + R + c;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] input = new int[]{};

        for (int i = 0; i < n; i++) {
            nums[i] = input[i];
        }
        System.out.println(getSmallSum(nums, 0, n - 1));
    }
}
