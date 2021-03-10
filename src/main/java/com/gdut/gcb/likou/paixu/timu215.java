package com.gdut.gcb.likou.paixu;

import java.util.Random;

/**
 * @Author 古春波
 * @Description 215. 数组中的第K个最大元素
 * @Date 2020/9/3 13:15
 * @Version 1.0
 **/
public class timu215 {

    public static int partition2(int[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
//        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        int v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1, j = r;
        while( true ){
            // 注意这里的边界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
            // 思考一下为什么?
            while( i <= r && arr[i] < v )
                i ++;

            // 注意这里的边界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
            // 思考一下为什么?
            while( j >= l+1 && arr[j]> v)
                j --;

            // 对于上面的两个边界的设定, 有的同学在课程的问答区有很好的回答:)
            // 大家可以参考: http://coding.imooc.com/learn/questiondetail/4920.html

            if( i > j )
                break;

            swap( arr, i, j );
            i ++;
            j --;
        }

        swap(arr, l, j);

        return j;
    }

    

    public static int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length-1;
        int partition;
        // K表示按照从小到大排序后目标元素应该所在的index
        k = nums.length - k ;
        while (true){
            partition = partition(nums, l, r);
            if (partition < k){
                l = partition + 1;
            }
            else if (partition > k ){
                r = partition -1;
            }
            else {break;}
        }
        
        return nums[partition];
    }

    /**
     * 双路快排的partition，返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] arr, int l, int r){
        // 优化，防止顺序数组
//        swap(arr,l, (int) (Math.random() * (r-l+1) +l));
        
        int val = arr[l];
        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1;
        int j = r;
        while (true){
            while (i < r &&arr[i] < val){
                i++;
            }
            while(j > l+1 && arr[j] >val){
                j--;
            }
            if (i > j){
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;
    }




  
    public static void swap(int[] arr, int l, int r){
        int node = arr[l];
        arr[l] = arr[r];
        arr[r] = node;
        
    }

    public static void main(String[] args) {
        int[] ints = {
                3,2,1,5,6,4

        };
        for (int i = 0;i<50;i++){
            int kthLargest = findKthLargest(ints, 2);
            System.out.println(kthLargest);
        }
       
        
    }
}
