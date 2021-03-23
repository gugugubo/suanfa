package com.gdut.gcb.likou.mianshi.alibaba;

import java.util.*;

/**
 * @Author 古春波
 * @Description 共有nn个人，每人抽到一个初始序号a[i]。如果某个人的序号是某个数的平方，那么他就会获奖。
 * 现在会发放一些数量的修改券，使用一张修改券可以使自己的序号加一或者减一。现在想知道，如果想要让一半人可以获奖，
 * 至少需要发放多少张修改券？
 * 输入描述:
 * 第一行一个正整数，测试数据保证为偶数，表示人数n；
 * 第二行n个正整数，表示每个人的初始序号a[i]。
 * 输出描述:
 * 一个正整数，表示至少需要发放的修改券。
 * 示例1输入输出示例仅供调试，后台判题数据一般不包含示例
 * 输入
 * 复制
 * 4
 * 4 7 12 13
 * 输出
 * 复制
 * 2
 * @Date 2021/3/19 19:06
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ints = new int[n];
        for(int j = 0; j < n; j++){
            ints[j] = sc.nextInt();
        }
        Main first = new Main();
        int test = first.test(ints);
        System.out.println(test);
    }    
    
    
    public int test(int[] nums){
        int half = nums.length / 2;
        List<Integer> list = new ArrayList();
        for (int i=0; i<nums.length; i++){
            Double sqrt = Math.sqrt(nums[i]);
            int max2 = sqrt.intValue();
            if ((max2 * max2  == nums[i])){
                half--;
                continue;
            }
            int max = getMax(nums[i]);
            list.add(Math.min(max*max - nums[i], Math.abs((max-1)*(max-1)- nums[i]))) ;
        }
        
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int res =0;
        for (int i=0; i<half; i++){
            res+=list.get(i);
        }
        return res;
    }


    public int getMax(int num){
        for (int i=0; i<num; i++){
            if (i * i > num){
                return i;
            }
        }
        return num;
    }
    

    
}
