package com.gdut.gcb.likou.shujujiegou;

import java.util.Random;

/**
 * @Author 古春波
 * @Description 非递归 迭代实现树的遍历   非递归实现快排
 * @Date 2021/4/5 20:01
 * @Version 1.0
 **/
public class feidiguiQuickSort {
    
    
    
    public void quick(int[] nums){
        // 假设递归不超过1000层
        int[] mystack = new int[1000];
        // 栈中保存下次需要排次序的子数组的开始位置和结束位置
        int top = -1;
        
        mystack[++top] = 0;
        mystack[++top] = nums.length -1;
        while (top>0){  // 栈非空
            int high = mystack[top--], low = mystack[top--];
            int middle = partition(nums, low, high);
            if (middle+1 < high){  // 大于一个元素，右边子数组如站
                mystack[++top] = middle +1;
                mystack[++top] = high;
            }
            if (low < middle-1){  // 左边子数组入栈
                mystack[++top] = low;
                mystack[++top] = middle -1;
            }
        }
        
    }

    private int partition(int[] nums, int low, int high) {
        int l = low+1; int r = high;
        int leftVal = nums[l];
        while (true){
            while (l <= high && nums[l] < leftVal ){
                l++;
            }
            while (r >= low +1 && nums[r] > leftVal){
                r--;
            }
            
            if (r < l){
                break;
            }
            swap(nums, l, r);
            r--;l++;
        }
        swap(nums, low, r);
        return r;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


}
