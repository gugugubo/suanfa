package com.gdut.gcb.likou.diguihehuisu;

import java.util.Random;

/**
 * @Author 古春波
 * @Description TODO
 * @Date 2021/3/23 15:45
 * @Version 1.0
 **/
public class test3 {

    int[] feibo ;
    boolean[] visited ;
    int n , k;
    public String getPermutation(int n, int k) {
        feibo = new int[n+1];
        this.visited = new boolean[n+1];
        this.n = n;
        this.k = k;
        StringBuilder res = new StringBuilder();
        getFeiBo();
        recur(0, res);
        return res.toString();
    }

    // index 表示在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
    public void recur(int index, StringBuilder builder){

        if(index == n ){
            return ;
        }
        int count = feibo[n -1 - index];
        for(int i=1; i<=n; i++){
            if(visited[i]){
                continue;
            }
            if(count < k){
                k = k -count;
                continue;
            }
            visited[i] = true;
            builder.append(i);
            recur(index + 1, builder);
            // 不用回溯，到达底部之后直接返回
            return ;
        }
    }


    public void getFeiBo(){
        feibo[0] = 1;
        for(int i=1; i<n+1; i++){
            feibo[i] = feibo[i-1] * i;
        }
    }

    public static void main(String[] args) {
        test3 test3 = new test3();
//        String permutation = test3.getPermutation(3, 3);
//        System.out.println(permutation);
        int[] ints = new int[]{3,1,2,4,5};
        int partition = test3.partition(ints, 0, ints.length - 1);
        System.out.println(partition);
    }

    public int partition(int[] nums , int l , int r){
        swap(nums, l, new Random().nextInt(l+r+1));
        int leftVal = nums[l];
        int i=l+1; int j= r;
        while (i<=j){
            while (i<=j&& nums[i] < leftVal){
                i++;
            }
            while (i<=j && nums[j] > leftVal){
                j--;
            }
            if (i>=j){break;}
            swap(nums, i,j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;
    }
    public void swap(int[]nums, int i, int j){
        int temp=nums[i];
        nums[i]= nums[j];
        nums[j] = temp;
    }
}
